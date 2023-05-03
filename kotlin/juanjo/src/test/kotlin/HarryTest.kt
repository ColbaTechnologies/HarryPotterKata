import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HarryTest {

    @Test
    fun priceWithOneBook() {
        // GIVEN
        val expectedPrice = 8.0

        // WHEN
        val priceWithOneBook = totalMoney(listOf(Books.BOOK_1))

        // THEN
        assertEquals(expectedPrice, priceWithOneBook)
    }

    @Test
    fun priceWithTwoBook() {
        // GIVEN
        val expectedPrice = 15.2

        // WHEN
        val priceWithTwoBook = totalMoney(listOf(Books.BOOK_1, Books.BOOK_2))

        // THEN
        assertEquals(expectedPrice, priceWithTwoBook)
    }

    @Test
    fun priceWithTwoBookSimilar() {
        // GIVEN
        val expectedPrice = 16.0

        // WHEN
        val priceWithTwoBook = totalMoney(listOf(Books.BOOK_1, Books.BOOK_1))

        // THEN
        assertEquals(expectedPrice, priceWithTwoBook)
    }

    @Test
    fun priceWithThreeBook() {
        // GIVEN
        val expectedPrice = 21.6

        // WHEN
        val priceWithTwoBook = totalMoney(listOf(Books.BOOK_1, Books.BOOK_2, Books.BOOK_3))

        // THEN
        assertEquals(expectedPrice, priceWithTwoBook)
    }

    @Test
    fun priceWithThreeBookSimilar() {
        // GIVEN
        val expectedPrice = 24.0

        // WHEN
        val priceWithTwoBook = totalMoney(listOf(Books.BOOK_1, Books.BOOK_1, Books.BOOK_1))

        // THEN
        assertEquals(expectedPrice, priceWithTwoBook)
    }

    @Test
    fun priceWithTwoDifferent() {
        // GIVEN
        val expectedPrice = 23.2

        // WHEN
        val priceWithTwoBook = totalMoney(listOf(Books.BOOK_1, Books.BOOK_1, Books.BOOK_2))
        val priceWithOtherTwoBook = totalMoney(listOf(Books.BOOK_1, Books.BOOK_2, Books.BOOK_2))
        val priceMiddleDifferent = totalMoney(listOf(Books.BOOK_1, Books.BOOK_2, Books.BOOK_1))

        // THEN
        assertEquals(expectedPrice, priceWithTwoBook)
        assertEquals(expectedPrice, priceWithOtherTwoBook)
        assertEquals(expectedPrice, priceMiddleDifferent)
    }

    @Test
    fun checkDifferentListItems(){
        // GIVEN
        val total = 3
        // WHEN
        val list = listOf(Books.BOOK_1, Books.BOOK_2, Books.BOOK_3)
        // THEN
        assertEquals(total, howManyDistinctItems(list).size)
    }

    @Test
    fun simpleDiscount(){
        val total = 8 * 2 * 0.95
        val list = listOf(Books.BOOK_1, Books.BOOK_2)
        assertEquals(total, totalMoney(list))

        //assertEquals(8 * 2 * 0.9, listOf(Books.BOOK_1, Books.BOOK_3, Books.BOOK_5))


//        assert_equal(8 * 4 * 0.8, price([0, 1, 2, 4]))
//        assert_equal(8 * 5 * 0.75, price([0, 1, 2, 3, 4]))
    }
}