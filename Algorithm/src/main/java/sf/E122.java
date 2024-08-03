package sf;

public class E122 {
    //买股票二
    //贪心思想
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
}
