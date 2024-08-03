package sf;

import java.util.Arrays;

public class E188 {
    //买卖股票的最佳时机4

    public int maxProfit(int[] prices) {
        int i =0;
        int j =1;
        int sum = 0;
        while(j<prices.length){
            if (prices[j]>prices[i]){
                sum += prices[j] - prices[i];
            }
            i++;
            j++;
        }

        return sum;
    }

    public int maxProfit(int k, int[] prices) {

        if (k>prices.length/2){
            return maxProfit(prices);
        }

        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy,Integer.MIN_VALUE);


        for (int price : prices) {
            buy[0] = Math.max(buy[0], -price);
            sell[0] = Math.max(sell[0], buy[0] + price);
            for (int i = 1; i < k; i++) {
                buy[i] = Math.max(buy[i], sell[i-1]-price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k-1];

    }

}
