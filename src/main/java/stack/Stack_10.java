package stack;

import java.util.Stack;

/**
 * Created by GAURAV on 6/26/2018.
 */
public class Stack_10 {
    public static void main(String[] args) {
        String str = "[()]{}{[()()]()}";
        str = "[(])";
        str = "()";
        str = "(]]{]{}";
        str = "}[])]";
        System.out.println(str);
        System.out.println(checkBalancedParentheses(str));
    }

    private static String checkBalancedParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        Character ch;
        boolean isMatch = true;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.empty()) {
                    return "not balanced";
                }
                switch (stack.pop()) {
                    case '(':
                        isMatch = ch == ')';
                        break;
                    case '{':
                        isMatch = ch == '}';
                        break;
                    case '[':
                        isMatch = ch == ']';
                        break;
                }
            }
            if (!isMatch) {
                return "not balanced";
            }
        }
        if (!stack.empty()) {
            return "not balanced";
        }
        return "balanced";
    }
}
