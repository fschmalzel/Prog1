package main;

public class Main {
    
    public static void main (String[] args) {
        boolean op1 = false, op2 = false;
        
        // && ist nur wahr, wenn beide variablen wahr sind
        System.out.println(" &&   | " + op2 + " | " + !op2);
        System.out.println("------|-------|------");
        System.out.println(op1 + " | " + (op1 && op2) + " | " + (op1 && !op2));
        op1 = !op1;
        System.out.println(op1 + "  | " + (op1 && op2) + " | " + (op1 && !op2));
        
        System.out.println();
        op1 = false;
        System.out.println("  &   | " + op2 + " | " + !op2);
        System.out.println("------|-------|------");
        System.out.println(op1 + " | " + (op1 & op2) + " | " + (op1 & !op2));
        op1 = !op1;
        System.out.println(op1 + "  | " + (op1 & op2) + " | " + (op1 & !op2));
                
        System.out.println();
        op1 = false;
        System.out.println(" ||   | " + op2 + " | " + !op2);
        System.out.println("------|-------|------");
        System.out.println(op1 + " | " + (op1 || op2) + " | " + (op1 || !op2));
        op1 = !op1;
        System.out.println(op1 + "  | " + (op1 || op2) + " | " + (op1 || !op2));

        System.out.println();
        op1 = false;
        System.out.println("  |   | " + op2 + " | " + !op2);
        System.out.println("------|-------|------");
        System.out.println(op1 + " | " + (op1 | op2) + " | " + (op1 | !op2));
        op1 = !op1;
        System.out.println(op1 + "  | " + (op1 | op2) + " | " + (op1 | !op2));

        System.out.println();
        op1 = false;
        System.out.println("  ^   | " + op2 + " | " + !op2);
        System.out.println("------|-------|------");
        System.out.println(op1 + " | " + (op1 ^ op2) + " | " + (op1 ^ !op2));
        op1 = !op1;
        System.out.println(op1 + "  | " + (op1 ^ op2) + " | " + (op1 ^ !op2));
        
        
    }
    
}
