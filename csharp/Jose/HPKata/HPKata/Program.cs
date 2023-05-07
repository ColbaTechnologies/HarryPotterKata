using HPKata;


// Input
Console.WriteLine("What books do you want to buy?");
var stringAmounts = Console.ReadLine();

var amounts = new[]{0};

// Build Sagas
var sagger = new Sagger();
var sagas = sagger.BuildSagas(amounts);

// Calculate
var calculator = new Calculator();
var basketPrice = calculator.Calculate(sagas);

// Return
Console.WriteLine("I have found the price to be " + basketPrice);

Console.Write($"{Environment.NewLine}Press any key to exit...");
Console.ReadKey(true);