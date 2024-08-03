package sf;

import java.util.Arrays;

public class E322 {
    //零钱兑换
    public int coinChange(int[] coins, int amount) {
        int[] array = new int[amount+1];
        Arrays.fill(array,amount+1);
        array[0]=0;
        for (int coin : coins) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coin) {
                    //放得下
                    array[j] = Integer.min(array[j] , array[j - coin] + 1);
                }
            }
        }
        return array[amount]>amount?-1:array[amount];
    }
}
