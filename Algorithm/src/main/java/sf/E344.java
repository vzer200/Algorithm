package sf;

public class E344 {
    public static void main(String[] args) {
        char[] s = {'a','b','c','d','e'};
        reverseString(s);

    }
    //反转字符串

    public static void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        for (int i = 0; i < s.length; i++) {

            while(left<right){
               char temp =s[left];
               s[left] = s[right];
               s[right] =  temp;
               right--;
               left++;
            }

        }

    }

}
