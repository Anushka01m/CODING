import java.util.*;

class PostfixEvaluator {
    public static int evaluate(String expr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            } else if (ch == ' ') {
                // Ignore spaces
                continue;
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int res = 0;
                switch (ch) {
                    case '+': res = a + b; break;
                    case '-': res = a - b; break;
                    case '*': res = a * b; break;
                    case '/': res = a / b; break;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter postfix expression (use single digit operands):");
        String expr = sc.nextLine();
        int result = evaluate(expr);
        System.out.println("Result: " + result);
    }
}
