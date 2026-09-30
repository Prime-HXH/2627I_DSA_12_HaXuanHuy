package week3;

import java.util.Stack;

public class InfixToPostfix {

    private static int priority(char ch){
        if (ch=='+' || ch=='-'){
            return 1;
        }
        else if (ch=='*' || ch=='/'){
            return 2;
        }
        else if (ch=='^' ){
            return 3;
        }
        else{
            return -1;
        }
    }

    public static String convertInfixToPostfix(String infix) {

        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (char ch : infix.toCharArray()) {

        //Nếu là số thì đưa thẳng vào result
            if (Character.isLetterOrDigit(ch)) {
                res.append(ch).append(' ');
            }
            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {
                /*Khi stack ko rỗng và top ko phải dấu ngoặc mở,pop
                hết các toán tử cho đến khi gặp "("
                 */
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res.append(stack.pop()).append(" ");
                }
                //pop dấu mở ngoặc
                stack.pop();
            }

            else if (ch == '+' || ch == '-'
            || ch == '*' || ch == '/') {

                /*Khi toán tử đang xét đến có độ
                   ưu tiên <= toán tử ở top stack
                   pop toán tử top stack ra và cho vào result
                 */
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && priority(ch) <= priority(stack.peek())) {

                    res.append(stack.pop()).append(" ");
                }
                //Nếu ko thì push toán tử đó vào stack
                stack.push(ch);
            }
        }

        //Khi đã duyệt hết,pop hết các toán tử còn lại trong stack ra
        while (!stack.isEmpty()) {
            res.append(stack.pop()).append(" ");
        }
        return res.toString().trim();

    }

    static void main(String[] args) {
        String infix1 = "(9-(4+2)/3)-8*(5+1)";
        String infix2 = "5*(2+4)-9/3";
        System.out.println(convertInfixToPostfix(infix1));
        System.out.println(convertInfixToPostfix(infix2));
    }

}
