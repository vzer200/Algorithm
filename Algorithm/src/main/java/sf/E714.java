package sf;

public class E714 {
    //买卖股票的最佳时机，含手续费
    //考虑手续费，用动态规划
    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <prices.length ; i++) {
            buy[i] = Math.max(buy[i-1],sell[i-1]-prices[i]);
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]-fee);
        }
        return sell[prices.length-1];
    }

    //优化
    public int maxProfit1(int[] prices, int fee) {

        int buy =Integer.MIN_VALUE;
        int sell = 0;
        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy+price - fee);

        }
        return sell;
    }

}
