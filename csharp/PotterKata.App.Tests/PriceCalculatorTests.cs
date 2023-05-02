using Xunit;
using static Xunit.Assert;
using static PotterKata.App.Book;
using static PotterKata.App.PriceCalculator;

namespace PotterKata.App.Tests;

public class PriceCalculatorTests
{
    [Fact]
    public void Basics()
    {
        Equal(0, CalculatePrice());
        Equal(8, CalculatePrice(First));
        Equal(8, CalculatePrice(Second));
        Equal(8, CalculatePrice(Third));
        Equal(8, CalculatePrice(Fourth));
        Equal(8 * 3, CalculatePrice(First, First, First));
    }

    [Fact]
    public void SimpleDiscounts()
    {
        Equal(8 * 2 * 0.95, CalculatePrice(First, Second));
        Equal(8 * 3 * 0.9, CalculatePrice(First, Third, Fifth));
        Equal(8 * 4 * 0.8, CalculatePrice(First, Second, Third, Fifth));
        Equal(8 * 5 * 0.75, CalculatePrice(First, Second, Third, Fourth, Fifth));
    }

    [Fact]
    public void SeveralDiscounts()
    {
        Equal(8 + (8 * 2 * 0.95), CalculatePrice(First, First, Second));
        Equal(2 * (8 * 2 * 0.95), CalculatePrice(First, First, Second, Second));
        Equal((8 * 4 * 0.8) + (8 * 2 * 0.95), CalculatePrice(First, First, Second, Third, Third, Fourth));
        Equal(8 + (8 * 5 * 0.75), CalculatePrice(First, Second, Second, Third, Fourth, Fifth));
    }

    [Fact]
    public void EdgeCases()
    {
        Equal(
            2 * (8 * 4 * 0.8),
            CalculatePrice(
                First, First,
                Second, Second,
                Third, Third,
                Fourth,
                Fifth));
        Equal(
            3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8),
            CalculatePrice(
                First, First, First, First, First,
                Second, Second, Second, Second, Second,
                Third, Third, Third, Third,
                Fourth, Fourth, Fourth, Fourth, Fourth,
                Fifth, Fifth, Fifth, Fifth));
    }
}
