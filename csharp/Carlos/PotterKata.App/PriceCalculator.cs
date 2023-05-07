namespace PotterKata.App;

public static class PriceCalculator
{
    private static readonly List<List<Book>> GroupingsInitialState = new() {new List<Book>()};

    public static double CalculatePrice(params Book[] books) => books
        .OrderBy(x => x)
        .CreateGroupings()
        .CalculateGroupsPrice();

    private static IEnumerable<List<Book>> CreateGroupings(this IEnumerable<Book> books) =>
        books.Aggregate(GroupingsInitialState, AddBookToGroup);

    private static List<List<Book>> AddBookToGroup(List<List<Book>> currentGrouping, Book bookToAdd) =>
        currentGrouping.All(group => group.Contains(bookToAdd))
            ? currentGrouping.Append(new List<Book> {bookToAdd}).ToList()
            : AddBookToExistingGroup(currentGrouping, bookToAdd).ToList();

    private static IEnumerable<List<Book>> AddBookToExistingGroup(IReadOnlyCollection<List<Book>> groupings, Book bookToAdd)
    {
        var group = FindGroupWhichMinimizesTotalPrice(groupings, bookToAdd);
        return groupings.Replace(group, group.Append(bookToAdd).ToList());
    }

    private static List<Book> FindGroupWhichMinimizesTotalPrice(IReadOnlyCollection<List<Book>> groupings, Book bookToAdd) =>
        groupings
            .Where(group => !group.Contains(bookToAdd))
            .MinBy(group =>
                CalculateGroupsPrice(
                    groupings.Replace(group, group.Append(bookToAdd).ToList())))
        ?? throw new InvalidOperationException();

    private static double CalculateGroupsPrice(this IEnumerable<List<Book>> groups) =>
        groups.Sum(group => 8 * group.Count * GetDiscount(group.Count));

    private static double GetDiscount(int groupCount) => groupCount switch
    {
        0 => 0,
        <= 3 => 1 - 0.05 * (groupCount - 1),
        >= 4 => 1 - groupCount * 0.05,
    };

    private static IEnumerable<T> Replace<T>(this IEnumerable<T> elements, T oldValue, T newValue) where T : class =>
        elements
            .Where(y => y != oldValue)
            .Append(newValue);
}
