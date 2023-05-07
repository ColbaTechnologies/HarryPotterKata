namespace HPKata;

public class Parser
{
    public int[] ParseAmounts(int[] enumeratedAmounts)
    {
        var amounts = new[]
        {
            enumeratedAmounts.Count(x => x == 0),
            enumeratedAmounts.Count(x => x == 1),
            enumeratedAmounts.Count(x => x == 2),
            enumeratedAmounts.Count(x => x == 3),
            enumeratedAmounts.Count(x => x == 4)
        };
        return amounts;
    }
    
}