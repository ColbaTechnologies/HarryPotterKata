fun main(args: Array<String>) {
    val result = totalMoney(listOf(Books.BOOK_1))
    println("Total to pay: $result")
}

fun totalMoney(booksList: List<Books>): Double? {
    if (booksList.size == 1) {
        return 8.0
    }
    if (booksList.size == 2) {
        if (booksList[0] == booksList[1]) {
            return 16.0
        } else {
            val price = 8 * 2 * 5
            val totalPrice: Double = price.toDouble() / 100
            return 16 - totalPrice
        }
    }
    if (booksList.size == 3) {
        when(howManuDistinctItems(booksList).size) {
            3 -> {
                val price = 8 * 3 * 10
                val totalPrice: Double = price.toDouble() / 100
                return 24 - totalPrice
            }
            2 -> {
                val price = 8 * 2 * 5
                val totalPrice: Double = price.toDouble() / 100
                return (16 - totalPrice) + 8
            }
            1-> {
                return 24.0
            }
        }
/*        if (booksList[0] !== booksList[1] && booksList[0] !== booksList[2] && booksList[1] !== booksList[2]) {
            val price = 8 * 3 * 10
            val totalPrice: Double = price.toDouble() / 100
            return 24 - totalPrice
        } else if (booksList[0] == booksList[1] && booksList[0] !== booksList[2]) {
            val price = 8 * 2 * 5
            val totalPrice: Double = price.toDouble() / 100
            return (16 - totalPrice) + 8
        } else if (booksList[0] != booksList[1] && booksList[0] == booksList[2]) {
            val price = 8 * 2 * 5
            val totalPrice: Double = price.toDouble() / 100
            return (16 - totalPrice) + 8
        } else if (booksList[0] != booksList[1] && booksList[1] == booksList[2]) {
            val price = 8 * 2 * 5
            val totalPrice: Double = price.toDouble() / 100
            return (16 - totalPrice) + 8
        } else {
            return 24.0
        }*/

    }
    return null
}

fun howManuDistinctItems(booksList: List<Books>): List<Books> {
    return booksList.distinct()
}


enum class Books {
    BOOK_1,
    BOOK_2,
    BOOK_3,
    BOOK_4,
    BOOK_5,
}