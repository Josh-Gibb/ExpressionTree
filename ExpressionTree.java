/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Josh Gibb
 * ExpressionTree.java
 */

import java.util.Scanner;
import java.util.Stack;
public class ExpressionTree {
    Node root;
    
    // A class to build a Tree using the expression
    public void buildTree(String expression){
        Scanner scLine = new Scanner(expression);
        Stack stack = new Stack<Node>();
        while(scLine.hasNext()){
            String temp = scLine.next();
            Node node;
            // If the character is a digit then push node into stack
            if(Character.isDigit(temp.charAt(0))){
                node = new Node(temp);
                stack.push(node);
            }
            // If the character is an operator then push node with a left and right child into the stack
            else{
                node = new Node(temp, (Node) stack.pop(), (Node) stack.pop());
                stack.push(node);
            }
        }
        root = (Node) stack.pop();
    }
    
    // Calls out a default expression from root
    public void printExpression(){
        printExpression(root);
        System.out.println();
    }
    
    // Prints out expression in-order traversal
    public void printExpression(Node n){
        if(n.left != null){
            System.out.print("(");
            printExpression(n.left);
        }
        System.out.print(n);
        if(n.right != null){
            printExpression(n.right);
            System.out.print(")");
        }
    }
    
    // Calls the default evaluate expression from root
    public int evaluateExpression(){
        return evaluateExpression(root);
    }
    
    // Recurively calculates each node to calculate solution
    public int evaluateExpression(Node n){
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if(n.left != null)
            left = evaluateExpression(n.left);      
        if(n.right != null)
            right = evaluateExpression(n.right);
        if(Character.isDigit(n.data.charAt(0)))
        {
            return Integer.parseInt(n.data);
        }
        char operator = n.data.charAt(0);
        return calculate(n, left, right, operator);
   }
    
   // A method to use children and the operator to calculate a value
   private int calculate(Node n, int left, int right, char operator){
       if(operator == '+')
           return left + right;
       if(operator == '-')
           return left - right;
       if(operator == '*')
           return left*right;
       return left/right;
   }
}
