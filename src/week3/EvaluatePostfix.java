package week3;

import java.util.Stack;

public class EvaluatePostfix {

    public static boolean isOperator(String token){
        return token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/");
    }

    public static int evaluatePostfix(String exp){

        Stack<Integer> stack = new Stack<>();
        String[] tokens = exp.trim().split("\\s+");

        int res = 0;

        for(String token : tokens){

            if(!isOperator(token)){

                int num = Integer.parseInt(token);
                stack.push(num);
            }
            else{
                int b = stack.pop();
                int a = stack.pop();

                if (token.equals("+")){
                    res = a + b;
                }
                else if (token.equals("-")){
                    res = a - b;
                }
                else if (token.equals("*")){
                    res = a * b;
                }
                else if (token.equals("/")){
                    res = a / b;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

    static void main(String[] args) {
        String exp = "5 2 4 + *";
        System.out.println(evaluatePostfix(exp));
    }
}
