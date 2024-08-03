package sf;

import java.util.Stack;

public class E1047 {
    public static void main(String[] args) {


        String s ="abbaca";
        String newString = removeDuplicates(s);
        System.out.println(newString);
    }

    //删除字符串中所有相邻重复项
    public static String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (int c=0 ;c< array.length;c++) {
            if (stack.isEmpty()||stack.peek()!=array[c]){
                stack.push((char) c);
                //当栈为空或者元素不相同时,直接压入栈
            }
            if (stack.peek()==array[c]){
                //如果栈顶元素和现在遍历的元素相同就进行删除,将栈顶元素弹出
                stack.pop();
                // 将当前字符压入栈中
                stack.push((char) c);

            }
        }
        // 使用StringBuilder类把栈转换为字符串
        StringBuilder sb = new StringBuilder();
        for (char num : stack) {
            sb.append(num);
            sb.append(" ");
        }

        // 删除最后一个空格
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

}
