package sf;

import java.util.Stack;

public class E156 {
    public static void main(String[] args) {

        //ba
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
                stack.push(array[c]);
                //当栈为空或者元素不相同时，直接压入栈
            }
            else {
                //如果栈顶元素和现在遍历的元素相同就进行删除，将栈顶元素弹出
                stack.pop();
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
    public static String removeDuplicates2(String s){

        //快慢指针法
        char[] array = s.toCharArray();
        int slow = -1;
        for (int i = 0; i < array.length; i++) {
            if (slow==-1||array[slow]!=array[i]){
                //数组为空或者数组元素不重复
                array[++slow] = array[i];
            }else {
                //数组相邻元素相同,进行删除
                slow--;

            }

        }
        return String.valueOf(array, 0, slow + 1);

    }
}
