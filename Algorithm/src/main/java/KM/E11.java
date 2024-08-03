package KM;

import java.util.HashMap;
import java.util.Scanner;

public class E11 {
   /* public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int preB = 0;
        int preA = 0;
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int countM = 0;
            int countY = 0;
            while(n-->0){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (preB == b){
                    //找到相同 表示当前的ab是同一个辈分 a6 b7 preA5 tempA6 tempPreA5 a5
                    int tempA = a;
                    a = a%2==1?a:preA;
                    preA = preA%2==1?tempA:preA;
                    while(a!=1&&a>0){
                        a= a-2;
                        countM++;
                    }

                    while(preA!=2&&preA>0){
                        preA= preA-2;
                        countY++;
                    }
                    if(countY==countM){
                        System.out.println("You are my brother");
                    }else if(countY<countM){
                        System.out.println("You are my elder");
                    }else{
                        System.out.println("You are my younger");
                    }

                }
                preB = b;
                preA = a;
            }

        }

    }*/

    public static void main (String[] args) {


    }



}
