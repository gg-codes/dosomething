package stack;

import java.util.Stack;

/**
 * Created by GAURAV on 6/26/2018.
 */
public class Stack_11 {
    public static void main(String[] args) {
        String str = "{{}}}}";
        str = "}}}{{}}{{{";
        countMinReversals(str);
//        bracketReversalsRequired(str);
    }

    private static int bracketReversalsRequired(String str) {
        Stack<Character> stack = new Stack<>();
        Character ch;
        if (str.length() % 2 != 0) {
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == '{') {
                stack.push(ch);
                System.out.println(stack.toString());
            } else if (!stack.empty()) {
                stack.pop();
            }
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        return 0;
    }

    static int countMinReversals(String expr) {
        int len = expr.length();

        // length of expression must be even to make
        // it balanced by using reversals.
        if (len % 2 != 0)
            return -1;

        // After this loop, stack contains unbalanced
        // part of expression, i.e., expression of the
        // form "}}..}{{..{"
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = expr.charAt(i);
            if (c == '}' && !s.empty()) {
                if (s.peek() == '{')
                    s.pop();
                else
                    s.push(c);
            } else
                s.push(c);
        }

        // Length of the reduced expression
        // red_len = (m+n)
        int red_len = s.size();

        // count opening brackets at the end of
        // stack
        int n = 0;
        System.out.println(s.toString());
        while (!s.empty() && s.peek() == '{') {
            s.pop();
            n++;
        }

        // return ceil(m/2) + ceil(n/2) which is
        // actually equal to (m+n)/2 + n%2 when
        // m+n is even.
        return (red_len / 2 + n % 2);
    }
}
