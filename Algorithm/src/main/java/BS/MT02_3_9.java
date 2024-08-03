package BS;

import java.util.Scanner;

public class MT02_3_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
            int sum = 0;
            int count=0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i]==0){
                    //未知元素
                    count++;
                }else {
                    sum+=a[i];
                }
            }
            while (q-->0){
                int l = sc.nextInt();
                int r = sc.nextInt();
                int min = sum + l * count;
                int max = sum + r * count;
                System.out.println(min+" "+max);
            }


    }






}
