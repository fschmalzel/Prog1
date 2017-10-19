package main;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {
        
        int operand1, operand2, operator;
        boolean doubleOperator = false;
        
        try {
            operand1 = System.in.read();
            operator = System.in.read();
            operand2 = System.in.read();
            if (operator == operand2) {
                operand2 = System.in.read();
                doubleOperator = true;
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
            return;
        }
        
        boolean op1, op2;
        if (operand1 == 'T' || operand1 == 't') {
            op1 = true;
        } else if (operand1 == 'F' || operand1 == 'f') {
            op1 = false;
        } else {
            System.err.println("Expected an 'F' or 'T'!");
            return;
        }
        
        if (operand2 == 'T' || operand2 == 't') {
            op2 = true;
        } else if (operand2 == 'F' || operand2 == 'f') {
            op2 = false;
        } else {
            System.err.println("Expected an 'F' or 'T'!");
            return;
        }
        
        boolean result;
        
        if (operator == '&') {
            if (!doubleOperator) {
                result = op1 & op2;
            } else {
                result = op1 && op2;
            }
        } else if (operator == '|') {
            if (!doubleOperator) {
                result = op1 | op2;
            } else {
                result = op1 || op2;
            }
        } else if (operator == '^' && !doubleOperator) {
            result = op1 ^ op2;
        } else {
            System.err.println("Unknown operator!");
            return;
        }
        
        System.out.println(result);
        
    }
    
}
