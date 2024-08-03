package sf;

import java.util.HashSet;
import java.util.LinkedList;

public class E394 {



    public String decodeString(String s) {

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        LinkedList<String> stack_res = new LinkedList<>();
        LinkedList<Integer> stack_sum = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c>='a'&&c<='z'||c>='A'&&c<='Z'){
                //表示当前为字母
                sb.append(c);
            }else if (c=='['){
                stack_sum.push(sum);
                stack_res.push(sb.toString());
                sum = 0;
                sb = new StringBuilder();
            }else if (c==']'){
                StringBuilder temp = new StringBuilder();
                int count = stack_sum.pop();
                for (int j = 0; j < count; j++) {
                    temp.append(sb);
                }
                sb = new StringBuilder(stack_res.pop()+temp);

            } else {
                //当前为数字
                sum = sum * 10 + Integer.parseInt(String.valueOf(c));
            }

        }

        return sb.toString();
    }
}
