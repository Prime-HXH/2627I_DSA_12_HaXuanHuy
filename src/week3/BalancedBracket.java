package week3;

import java.util.Stack;

public class BalancedBracket {

    private static boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')')
                || (opening == '[' && closing == ']')
                || (opening == '{' && closing == '}');
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char openingBracket = stack.pop();

                if (!isMatching(openingBracket, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static void main(String[] args) {
        System.out.println(isBalanced("([)]"));
        System.out.println(isBalanced("{(([]))}[]"));
    }
}
