package sf;

public class E443 {
    public static int compress(char[] chars) {
        int count = 1;
        char pre = chars[0];
        char[] pres = new char[chars.length];
        int index = 0;
        for(int i = 1; i<chars.length;i++){
            if(chars[i]==pre&&count==1){
                pres[index++] = pre;
            }
            if(chars[i]!=pre){
                pres[index++] = (char) (count+'0');
            }
            count++;
            pre = chars[i];

        }
        System.arraycopy(chars, 0, pres, 0, chars.length);
        return pres.length;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b'};
        compress(chars);
    }
}
