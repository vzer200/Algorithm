package sf;

import java.util.*;

public class E93 {

    private int len;
    public List<String> restoreIpAddresses(String s) {
        len = s.length();
        List<String> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>(4);
        reverse(s,0,4,res,path); // index表示切割线
        return res;
    }


    //由于 ip 段最多就 4 个段
    private void reverse(String s ,int begin, int residue, List<String> res, Deque<String> path) {

        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }


        for (int i = begin; i < begin + 3; i++) {

            if (i>=len){
                break;
            }

            if (check(s,begin,i)){
                String substring = s.substring(begin, i + 1);
                path.addLast(substring);
                reverse(s,i+1,residue-1,res,path);
                path.removeLast();
            }

        }


    }

    //表示接受一个字符串，判断他是否符合规定
    public boolean check(String s,int left,int right){
        //开头不能为0
        int len = right - left+1;
        if (len>1&&s.charAt(left)=='0'){
            return false;
        }

        int res = 0;
        while(left<right){
            //将字符转化为数字
            res = res*10+s.charAt(left) - '0';
            left++;
        }

        return res>=0&&res<=255;
    }
}
