package odoo_hackkerank;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

// Credentials : https://codereview.stackexchange.com/questions/120451/reverse-polish-notation-calculator-in-java
// Alternatives : https://www.geeksforgeeks.org/evaluate-the-value-of-an-arithmetic-expression-in-reverse-polish-notation-in-java/
//                https://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/

public class ReversePolishNotationCalculator {

	public static void computeRPN(String expr) throws ArithmeticException,EmptyStackException {
		Stack<Double> stack = new Stack<>();

        System.out.println(expr);
        System.out.println("Input\tOperation\tStack after");

        for (String token : expr.split("\\s+")) {
            System.out.print(token + "\t");
            switch (token) {
                case "+":
                    System.out.print("Operate\t\t");
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    System.out.print("Operate\t\t");
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    System.out.print("Operate\t\t");
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    System.out.print("Operate\t\t");
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                case "^":
                    System.out.print("Operate\t\t");
                    double exponent = stack.pop();
                    stack.push(Math.pow(stack.pop(), exponent));
                    break;
                default:
                    System.out.print("Push\t\t");
                    stack.push(Double.parseDouble(token));
                    break;
            }

            System.out.println(stack);
        }

        System.out.println("Final Answer: " + stack.pop());
        
	} // computeRPN

	
	public static void main(String[] args) {
		try {
            String expr = "3 5 +";
            String expr2 = "4 13 5 / +";
            System.out.println(expr2);
            computeRPN(expr2);
        } catch (Throwable err) {
            System.out.println(err.getMessage());
        }

	}

}
