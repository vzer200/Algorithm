package sf;

public class E121 {
    //买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int max= 0;
        while(j<prices.length){
            if (prices[j]-prices[i]>0){
                max= Math.max(max,prices[j] - prices[i]);
                //涨
            }else {
                //跌
                i = j ;
            }
            j++;
        }
        return max;
    }
}
