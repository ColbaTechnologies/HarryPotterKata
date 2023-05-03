fun main(args: Array<String>) {
    val result = totalMoney(listOf(Books.BOOK_1))
    println("Total to pay: $result")
}

private const val FIXED_PRICE = 8.0

fun totalMoney(booksList: List<Books>): Double? {

    when (booksList.size) {
        1 -> return FIXED_PRICE
        2 -> {
            if (booksList[0] == booksList[1]) {
                return FIXED_PRICE * booksList.size
            } else {
                val price = FIXED_PRICE * 2 * 5
                val totalPrice: Double = price / 100
                return 16 - totalPrice
            }
        }

        3 -> {
            when (howManyDistinctItems(booksList).size) {
                3 -> {
                    val price = FIXED_PRICE * 3 * 10
                    val totalPrice: Double = price / 100
                    return 24 - totalPrice
                }

                2 -> {
                    val price = FIXED_PRICE * 2 * 5
                    val totalPrice: Double = price / 100
                    return (16 - totalPrice) + FIXED_PRICE
                }

                1 -> {
                    return 24.0
                }
            }
        }
    }

    return null
}

fun howManyDistinctItems(booksList: List<Books>): List<Books> {
    return booksList.distinct()
}


enum class Books {
    BOOK_1,
    BOOK_2,
    BOOK_3,
    BOOK_4,
    BOOK_5,
}