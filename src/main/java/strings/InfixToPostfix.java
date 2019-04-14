package math;

import java.util.*;

/**
  Algorithm:
   1. If char is operand, append it.
   2. If char is '(' push to stack.
   3. If char is ')'
      (a) Pop all operators until char '('
      (b) else its a invalid expression
   4. If char is a operator:
      (a) If prec(op) is greater than the precedence of the operator in the stack then push it
      (b) else pop the operator and append it until 4(a)

 */
public class InfixToPostfix {

    public static int prec(char op) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('^', 3);
        return map.getOrDefault(op, -1);
    }

    public static String infixToPostfix(String exp) {
        StringBuilder s = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < exp.length()) {
            if (Character.isLetterOrDigit(exp.charAt(i))) {
                s.append(exp.charAt(i));
            } else if (exp.charAt(i) == '(') {
                stack.push(exp.charAt(i));
            } else if (exp.charAt(i) == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    s.append(stack.pop());
                }
                if(!stack.isEmpty() && stack.peek() != ')'){
                    stack.pop();
                }else{
                    return "Invalid Expression";
                }
            } else {
                while (!stack.isEmpty() && (prec(stack.peek()) >= prec(exp.charAt(i)))) {
                    s.append(stack.pop());
                }
                stack.push(exp.charAt(i));
            }
            i++;
        }

        while (!stack.isEmpty()) {
            s.append(stack.pop());
        }
        return s.toString();
    }

    public static void main(String[] s) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
}
