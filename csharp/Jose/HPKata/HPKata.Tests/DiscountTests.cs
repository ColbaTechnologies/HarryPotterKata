using FluentAssertions;

namespace HPKata.Tests;

public class UnitTest1
{
    private Parser Parser { get; } = new();
    private Sagger Sagger { get; } = new();
    private Calculator Calculator { get; } = new();
    
    [Fact]
    public void TestBasics()
    {
        FindPriceOf(null).Should().Be(0);
        FindPriceOf(new []{1}).Should().Be(8);
        FindPriceOf(new []{2}).Should().Be(8);
        FindPriceOf(new []{3}).Should().Be(8);
        FindPriceOf(new []{4}).Should().Be(8);
        FindPriceOf(new []{1,1,1}).Should().Be(3 * 8);
    }
    
    [Fact]
    public void TestSimpleDiscounts()
    {
        FindPriceOf(new []{0, 1}).Should().Be(8*2*0.95);
        FindPriceOf(new []{0, 2, 4}).Should().Be(8*3*0.9);
        FindPriceOf(new []{0, 1, 2, 4}).Should().Be(8*4*0.8);
        FindPriceOf(new []{0, 1, 2, 3, 4}).Should().Be(8*5*0.75);
    }
    
    [Fact]
    public void TestSeveralDiscounts()
    {
        FindPriceOf(new []{0, 0, 1}).Should().Be(8 + (8 * 2 * 0.95));
        FindPriceOf(new []{0, 0, 1, 1}).Should().Be(2 * (8 * 2 * 0.95));
        FindPriceOf(new []{0, 0, 1, 2, 2, 3}).Should().Be((8 * 4 * 0.8) + (8 * 2 * 0.95));
        FindPriceOf(new []{0, 1, 1, 2, 3, 4}).Should().Be(8 + (8 * 5 * 0.75));
    }
    
    [Fact]
    public void TestEdgeCases()
    {
        FindPriceOf(new []{0, 0, 1, 1, 2, 2, 3, 4}).Should().Be(2 * (8 * 4 * 0.8));
        FindPriceOf(new []{0, 0, 0, 0, 0, 
            1, 1, 1, 1, 1, 
            2, 2, 2, 2, 
            3, 3, 3, 3, 3, 
            4, 4, 4, 4}).Should().Be(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8));
    }

    private double FindPriceOf(int[]? numbers)
    {
        if (numbers == null)
        {
            return 0;
        }
        
        var amounts = Parser.ParseAmounts(numbers);
        var sagas = Sagger.BuildSagas(amounts);
        var price = Calculator.Calculate(sagas);
        return price;
    }
}