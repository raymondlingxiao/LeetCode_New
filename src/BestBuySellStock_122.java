public class BestBuySellStock_122 {
    class Solution1 {
        //greedy
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            for (int i = 0;i<prices.length-1;i++){
                if (prices[i+1] > prices[i])
                    maxProfit += prices[i+1] - prices[i];
            }
            return maxProfit;
        }
    }
    // find min and max in one piece of array
    public int maxProfit(int[] prices) {
        int profit = 0, i = 0;
        while (i < prices.length) {
            // find next local minimum
            while (i < prices.length-1 && prices[i+1] <= prices[i]) i++;
            int min = prices[i++]; // need increment to avoid infinite loop for "[1]"
            // find next local maximum
            while (i < prices.length-1 && prices[i+1] >= prices[i]) i++;
            profit += i < prices.length ? prices[i++] - min : 0;
        }
        return profit;
    }
}
