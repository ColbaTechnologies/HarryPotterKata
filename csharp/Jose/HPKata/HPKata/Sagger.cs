namespace HPKata;

public class Sagger
{
    public IEnumerable<Saga> BuildSagas(int[] amounts)
    {
        var totalSagas = amounts.Max();
        var sagas = new List<Saga>(totalSagas);

        for (var i = 1; i < totalSagas + 1; i++)
        {
            var saga = new Saga();
            foreach (var value in amounts)
                if (value > 0)
                    saga.Number++;

            amounts = amounts.MinusOneWhenPositive();
            sagas.Add(saga);
        }

        return sagas;
    }


}