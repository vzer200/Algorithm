package sf;

public class E123 {
    //买卖股票的最佳时机3
    //动态规划
    public int maxProfit(int[] prices) {

        int[] buy1 = new int[prices.length];
        int[] buy2 = new int[prices.length];
        int[] sell1 = new int[prices.length];
        int[] sell2 = new int[prices.length];
        //第0天特殊处理
        buy1[0] = -prices[0];
        sell1[0] =0;
        buy2[0] = -prices[0];
        sell2[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1[i] = Math.max(buy1[i-1],-prices[i]);
            sell1[i] = Math.max(sell1[i-1],buy1[i-1]+prices[i]);
            buy2[i] = Math.max(buy2[i-1],sell1[i-1]-prices[i]);
            sell2[i] = Math.max(sell2[i-1],buy2[i-1]+prices[i]);
        }
        return sell2[prices.length-1];

    }

    public int maxProfit1(int[] prices) {


        //第0天特殊处理
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;

    }
}
