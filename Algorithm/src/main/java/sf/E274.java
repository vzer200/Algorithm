package sf;

import java.util.Arrays;

public class E274 {
    public static int hIndex(int[] citations) {

        int left = 0;
        int right = citations.length;
        int cnt = 0;
        while (left<right){
            int mid = left+(right-left+1)/2;
            for (int i = 0; i < citations.length; i++) {
                if (mid>citations[i]) cnt++;
            }
            if (cnt>mid){
                left = mid;
            }else {
                right = mid;
            }

        }

        return left;
    }

    public static void main(String[] args) {
        int[] s = {3,0,6,1,5};
        System.out.println(hIndex(s));
    }

}
