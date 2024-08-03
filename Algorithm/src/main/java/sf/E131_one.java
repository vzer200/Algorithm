package sf;

import java.util.ArrayList;
import java.util.List;

public class E131_one {

    //分割回文串
    //aab
    //  /aab
    //  /a/ab
    //  /a/a/b
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        char[] array = s.toCharArray();
        reverse(0,res,array,new ArrayList<>());
        return res;
    }

    private void reverse(int index, List<List<String>> res, char[] array, ArrayList<String> list) {
        if (index==array.length){
            res.add(new ArrayList<>(list));
            return;
        }

        //index表示切割的位置
        //整体使用回溯方法解决

        for (int i = index; i < array.length; i++) {
            if (!hw(array,index,i)){
                continue;
            }
            //表示是回文子串
            //进行下一轮回溯
            list.add(new String(array, index, i-index+1));
            reverse(i+1,res,array,list);
            list.remove(list.size()-1);

        }

    }

    private boolean hw(char[] array, int i, int j) {

        //双指针法判断是否是回文字符串
        while(i<j){
            if (array[i]!=array[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
