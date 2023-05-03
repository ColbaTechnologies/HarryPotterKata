const INPUT_BOOKS = [2, 2, 2, 1, 1];
const DISCOUNTED_PRICE_BY_COUNT = [0, 0.95, 0.9, 0.8, 0.75];
const PRICE_BY_COUNT = [8, 15.2, 21.6, 25.6, 30];

const getPrice = (books) => {

    combinations = [[]]
    currentCombination = 0;
    let bestPrice = 10000000000000000;
    let combos = getAllCombinations(books)
    
    combos = combos.filter(x => x.length > 0)
    
    combos.forEach((c) => {
        let currentPrice = 0
        c.forEach(x => {
            currentPrice = currentPrice + PRICE_BY_COUNT[x - 1]
        })
        if (currentPrice < bestPrice) {
            bestPrice = currentPrice
        }
    })
    console.log(bestPrice)
    return bestPrice
}


let combinations = [[]]
let currentCombination = 0;

const getAllCombinations = (books) => {
    for (let i = 0; i < books.length; i++)  {
        getAllCombinationsFromSize(books, i + 1)
    }
    
    return combinations;
}

const removeEmptyBooks = (books) => {
    return books.filter(b => b !== 0);
    
}

const sortByDescending = (books) => {   
    return books.sort((a, b) => b - a)
}

const getAllCombinationsFromSize = (books, size) => {
    let iterationBooks = [...books]
    
    while(iterationBooks.length >= size && iterationBooks[0] > 0) {
        
        for (let i = 0; i < size && i < iterationBooks.length; i++) {
            iterationBooks[i] -= 1;
        }
        
        combinations[currentCombination].push(size)

        iterationBooks = removeEmptyBooks(iterationBooks)
        iterationBooks = sortByDescending(iterationBooks)

    }
    
    
    if(iterationBooks.length === 0) {

        currentCombination++
        combinations.push([])
        return
    }
    
    if(iterationBooks.length < size) {

        getAllCombinationsFromSize(iterationBooks, size - 1)
    }
    
}

function assertEqual(expected, actual) {
    if (expected === actual) {
        console.log('Test passed');
    } else {
        console.error(`Test failed. Expected ${expected}, but got ${actual}`);
    }
}

function testSimpleDiscounts() {
    assertEqual((8 * 2 * 0.95), getPrice([1, 1]));
    assertEqual((8 * 3* 0.9), getPrice([1,1,1]));
    assertEqual((8 * 4 * 0.8) , getPrice([1,1,1,1]));
    assertEqual((8 * 5 * 0.75), getPrice([1, 1, 1, 1, 1]));
}


function testSeveralDiscounts() {
    assertEqual(8 + (8 * 2 * 0.95), getPrice([2, 1]));
    assertEqual(2 * (8 * 2 * 0.95), getPrice([2, 2]));
    assertEqual((8 * 4 * 0.8) + (8 * 2 * 0.95), getPrice([2, 1, 2, 1]));
    assertEqual(8 + (8 * 5 * 0.75), getPrice([1, 2, 1, 1, 1]));
}

function testEdgeCases() {
    assertEqual(2 * (8 * 4 * 0.8), getPrice([2, 2, 2, 1, 1]));
    assertEqual(
        3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8),
        getPrice([
            5,
            5,
            4,
            5,
            4
        ])
    );
}

testSimpleDiscounts()
testSeveralDiscounts()
testEdgeCases()
getPrice(INPUT_BOOKS)
