public class BestProfit {

    /**
     *
     * The function keeps track of the maximum profit that can be made for each minute
     * until that minute by traversing from start to end of the array. It also keeps track
     * of the minimum amount up until so that the maximum profit can be
     * updated as every trading minute goes by. Thus by the end of the array we
     * have the maximum profit that can be made
     *
     * @param stockPrices array containing stock prices for the previous day,
     * should be a non null or non empty array
     *
     * @return <code>maximum profit that can be made, 0 if length of stockPrices is 1</code>
     * @throws IllegalArgumentException if stockPrices is null or empty
     */
    public int getMaxProfit(int [] stockPrices) throws IllegalArgumentException
    {
        if (stockPrices == null || stockPrices.length == 0)
            throw new IllegalArgumentException("Stock prices array cannot be null or empty");

        // if there is only a single stock price, no profit can be made as buying and selling
        // cannot occur at the same time
        if (stockPrices.length == 1)
            return 0;

        int maxProfit = 0;
        int min = stockPrices[0];

        // start from 2nd element here because we already captured the first element as min
        for (int i = 1; i < stockPrices.length; i++)
        {
            maxProfit = Math.max(maxProfit, stockPrices[i] - min);
            min = Math.min(min, stockPrices[i]);
        }

        return maxProfit;
    }
}
