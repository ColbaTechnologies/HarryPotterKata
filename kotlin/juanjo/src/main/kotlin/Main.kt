fun main(args: Array<String>) {
    val result = totalMoney(listOf(Books.BOOK_1))
    println("Total to pay: $result")
}

private const val FIXED_PRICE = 8.0

fun totalMoney(booksList: List<Books>): Double {

    val shoppingCart: MutableList<MutableList<Books>> = mutableListOf()

    booksList.forEach { bookItem ->
        if (shoppingCart.isEmpty()) {
            shoppingCart.add(mutableListOf(bookItem))
        } else {
            val all = shoppingCart.all { group -> group.contains(bookItem) }
            if (all) {
                shoppingCart.add(mutableListOf(bookItem))
            } else {
                shoppingCart.find { !it.contains(bookItem) }?.add(bookItem)
            }
        }
    }

    var totalPrice = 0.0

    shoppingCart.forEach() {
        when (it.size) {
            1 -> {
                totalPrice += FIXED_PRICE
            }

            2 -> {
                totalPrice += 8 * 2 * 0.95
            }

            3 -> {
                totalPrice += 8 * 3 * 0.9
            }

            4 -> {
                totalPrice += 8 * 4 * 0.8
            }

            5 -> {
                totalPrice += 8 * 5 * 0.75
            }
        }
    }

    return totalPrice
}

enum class Books {
    BOOK_1,
    BOOK_2,
    BOOK_3,
    BOOK_4,
    BOOK_5,
}