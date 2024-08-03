package sf;

public class E793 {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];

        for (int i = temperatures.length-2; i >=0 ; i--) {
            for (int j = i+1; j < temperatures.length; j+=res[j]) {
                if (temperatures[j]>temperatures[i]){
                    res[i] = j - i;
                    break;
                }else if (res[j]==0){
                    res[i] = 0;
                    break;
                }


            }
        }

        return res;

    }

}
