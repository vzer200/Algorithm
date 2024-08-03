package sf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E131 {
    //分割回文串
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        char[] array = s.toCharArray();
        reverse(0,array,res,new LinkedList<>());
        return res;
    }

    private static void reverse(int index, char[] array, List<List<String>> res, List<String> result) {

        if (index==array.length){
            res.add(new ArrayList<>(result));
            return;
        }

        for (int i = index; i < array.length; i++) {
            //判断是否是回文字符串

            if (!hw(array,index,i)) {
                //不是回文字符串
                continue;
            }
            result.add(new String(array, index, i-index+1));
            reverse(i+1,array,res,result);
            result.remove(result.size()-1);
        }

    }

    private static boolean hw(char[] array, int i, int j) {
        //双指针法
        while(i<j){
            if (array[i]!=array[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s ="aab";
        partition(s);

    }


}
