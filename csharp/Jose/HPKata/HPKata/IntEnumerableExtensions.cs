namespace HPKata;

public static class IntEnumerableExtensions
{
    public static int[] MinusOneWhenPositive(this IEnumerable<int> elements)
    {
        return  elements.Select(x => x > 0
            ? x - 1
            : x).ToArray();
    }
}