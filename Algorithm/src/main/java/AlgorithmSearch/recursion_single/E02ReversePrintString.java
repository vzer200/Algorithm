package AlgorithmSearch.recursion_single;

/**
 * 递归反向打印字符串
 */
public class E02ReversePrintString {

    public static void f(int n, String str) {
        if (n == str.length()) {
            return;
        }
        f(n + 1, str);
        System.out.println(str.charAt(n));
    }

    public static void main(String[] args) {
        z(0, "abcd");
    }

    public static void z(int n ,String s){
     if (n == s.length()){
         return;
     }
     z(n+1,s);
        System.out.println(s.charAt(n));
    }


}
