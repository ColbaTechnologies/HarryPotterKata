namespace HPKata;

public class Calculator
{
    private readonly Dictionary<int, double> discountGuide = new()
    {
        {
            1, 1
        },
        {
            2, 0.95
        },
        {
            3, 0.9
        },
        {
            4, 0.8
        },
        {
            5, 0.75
        },
    };
        
        
    public double Calculate(IEnumerable<Saga> sagas)
    {
        var price = 0.0;
        foreach (var saga in sagas)
        {
            var sagaPrice = 8.0 * saga.Number;
            sagaPrice = sagaPrice * discountGuide[saga.Number];

            price += sagaPrice;
        }

        return price;
    }
}