package TXT;

import java.util.Stack;
public class Interpreter {

    public static void Interpre(String tString) {
        var stack = new Stack<Expression>();
        var tList = tString.split(" ");
        for (var s : tList) {
            if (isOperator(s)) {
                var rightExpression = stack.pop();
                var leftExpression = stack.pop();
                
                var operator = getOperatorInstance(s, leftExpression, rightExpression);
                var result = operator.interpret();
                
                var resultExpression = new NumberExpression(result);
                stack.push(resultExpression);
            } else {
                var i = new NumberExpression(s);
                stack.push(i);
            }
        }
        var result=stack.pop().interpret();
    }

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }

    public static Expression getOperatorInstance(String s, Expression left, Expression right) {
        switch (s) {
            case "+":
                return new PlusExpression(left, right);
            case "-":
                return new MinusExpression(left, right);
            default:
                return new MultiplyExpression(left, right);
        }
    }
}
