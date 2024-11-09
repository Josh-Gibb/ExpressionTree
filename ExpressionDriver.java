/**
 * @author Josh Gibb
 * ExpressionDriver.java
 */
public class ExpressionDriver {
    public static void main(String[] args){
        ExpressionTree et = new ExpressionTree();
        et.buildTree("3 4 +");
        et.printExpression();
        System.out.println(et.evaluateExpression());
        System.out.println();
        
        et.buildTree("3 4 2 * 1 5 - / +");
        et.printExpression();
        System.out.println(et.evaluateExpression());
        System.out.println();
        
        et.buildTree("3 4 5 * 2 / +");
        et.printExpression();
        System.out.println(et.evaluateExpression());
        System.out.println();
        
        et.buildTree("12 8 + 6 5 - * 3 2 - 2 3 + * /");
        et.printExpression();
        System.out.println(et.evaluateExpression());
        System.out.println();
    }
}
