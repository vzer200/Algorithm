package sf;

import java.util.LinkedList;

public class E20 {
    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] array = s.toCharArray();
        for(char c : array){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')'){
                if(stack.peek() != c) return false;
                else stack.pop();
            }else if(c == '}'){
                if(stack.peek() != c) return false;
                else stack.pop();
            }else if(c == ']'){
                if(stack.peek() != c) return false;
                else stack.pop();
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        isValid("()");
    }
}
