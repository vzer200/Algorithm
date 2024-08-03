package stack;

import java.util.Arrays;

/**
 * 有效的括号
 */
public class E01Leetcode20 {

    public boolean isValid(String s) {
        ArrayStack<Character> as = new ArrayStack<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('){
                as.push(')');
            } else if (c=='{') {
                as.push('}');
            } else if (c=='[') {
                as.push(']');
            }else {
                if (!as.isEmpty()&&c == as.peek())
                    as.pop();
                else {
                    return false;
                }

            }
        }
        return as.isEmpty();
    }

    /*
        (   [   ]

        底 - 栈 - 顶
        )

        遇到左括号, 把要配对的右括号放入栈顶
        遇到右括号, 把它与栈顶元素对比
            若相等, 栈顶元素弹出, 继续对比下一组
            若不等, 无效括号直接返回 false
     */

    public static void main(String[] args) {
        E01Leetcode20 s = new E01Leetcode20();
        System.out.println(s.isValid("([{}])"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("()"));
        System.out.println("---------------------");

        System.out.println(s.isValid("[)"));
        // ]
        System.out.println(s.isValid("([)]"));
        // ) ]
        System.out.println(s.isValid("([]"));
        // )
        System.out.println(s.isValid("("));

        System.out.println("---------------------");
        System.out.println(s.isValid(")("));
        System.out.println(s.isValid("]"));
    }

}
