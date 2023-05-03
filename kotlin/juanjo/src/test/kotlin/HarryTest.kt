import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HarryTest {
    @Test
    fun testBasics() {
        assertEquals(0.0, totalMoney(emptyList()))
        assertEquals(8.0, totalMoney(listOf(Books.BOOK_1)))
        assertEquals(8.0, totalMoney(listOf(Books.BOOK_2)))
        assertEquals(8.0, totalMoney(listOf(Books.BOOK_3)))
        assertEquals(8.0, totalMoney(listOf(Books.BOOK_4)))
        assertEquals(8.0 * 3, totalMoney(listOf(Books.BOOK_1, Books.BOOK_1, Books.BOOK_1)))
    }

    @Test
    fun testSimpleDiscounts() {
        assertEquals(8 * 2 * 0.95, totalMoney(listOf(Books.BOOK_1, Books.BOOK_2)))
        assertEquals(8 * 3 * 0.9, totalMoney(listOf(Books.BOOK_1, Books.BOOK_3, Books.BOOK_5)))
        assertEquals(8 * 4 * 0.8, totalMoney(listOf(Books.BOOK_1, Books.BOOK_2, Books.BOOK_3, Books.BOOK_4)))
        assertEquals(
            8 * 5 * 0.75,
            totalMoney(listOf(Books.BOOK_1, Books.BOOK_2, Books.BOOK_3, Books.BOOK_4, Books.BOOK_5))
        )
    }

    @Test
    fun testSeveralDiscounts() {
        assertEquals(8 + (8 * 2 * 0.95), totalMoney(listOf(Books.BOOK_1, Books.BOOK_1, Books.BOOK_2)))
        assertEquals(2 * (8 * 2 * 0.95), totalMoney(listOf(Books.BOOK_1, Books.BOOK_1, Books.BOOK_2, Books.BOOK_2)))
        assertEquals(
            (8 * 4 * 0.8) + (8 * 2 * 0.95),
            totalMoney(listOf(Books.BOOK_1, Books.BOOK_1, Books.BOOK_2, Books.BOOK_3, Books.BOOK_3, Books.BOOK_4))
        )
        assertEquals(
            8 + (8 * 5 * 0.75),
            totalMoney(listOf(Books.BOOK_1, Books.BOOK_2, Books.BOOK_2, Books.BOOK_3, Books.BOOK_4, Books.BOOK_5))
        )
    }

    @Test
    fun testEdgeCases() {
        assertEquals(
            2 * (8 * 4 * 0.8),
            totalMoney(
                listOf(
                    Books.BOOK_1,
                    Books.BOOK_1,
                    Books.BOOK_2,
                    Books.BOOK_2,
                    Books.BOOK_3,
                    Books.BOOK_3,
                    Books.BOOK_4,
                    Books.BOOK_5
                )
            )
        )
        assertEquals(
            3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8),
            totalMoney(
                listOf(
                    Books.BOOK_1,
                    Books.BOOK_1,
                    Books.BOOK_1,
                    Books.BOOK_1,
                    Books.BOOK_1,
                    Books.BOOK_2,
                    Books.BOOK_2,
                    Books.BOOK_2,
                    Books.BOOK_2,
                    Books.BOOK_2,
                    Books.BOOK_3,
                    Books.BOOK_3,
                    Books.BOOK_3,
                    Books.BOOK_3,
                    Books.BOOK_4,
                    Books.BOOK_4,
                    Books.BOOK_4,
                    Books.BOOK_4,
                    Books.BOOK_4,
                    Books.BOOK_5,
                    Books.BOOK_5,
                    Books.BOOK_5,
                    Books.BOOK_5
                )
            )
        )
    }
}