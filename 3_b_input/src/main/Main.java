package main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        int input;
        
        // Buchstaben einlesen
        try {
            input = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        // Kleinschreibung zu Groﬂschreibung konvertieren
        if ('z' <= input && input >= 'a') {
            input -= 'a' - 'A';
        }
        
        boolean op1 = false;
        // Input verarbeiten
        switch (input) {
        case 'T':
            op1 = true;
            break;
        case 'F':
            op1 = false;
            break;
        default:
            System.out.println("Invalid input! It has to be a 'T' or 'F'!");
            return;
        }
        
        // Zeichen einlesen
        try {
            input = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        char op;
        switch (input) {
        case '|':
            op = '|';
            break;
        case '&':
            op = '&';
            break;
        case '^':
            op = '^';
            break;
        default:
            System.out.println("Invalid input! It has to be a '|', '^' or '&'!");
            return;
        }

        // Buchstaben einlesen
        try {
            input = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        // Kleinschreibung zu Groﬂschreibung konvertieren
        if ('z' <= input && input >= 'a') {
            input -= 'a' - 'A';
        }
        
        boolean op2 = false;
        boolean flag = false;
        // Input verarbeiten
        switch (input) {
        case 'T':
            op2 = true;
            break;
        case 'F':
            op2 = false;
            break;
        case '&':
            if (op == '&') { op = 'a'; flag = true; } else {
                System.out.println("Invalid input! It has to be a '&', 'T' or 'F'!");
                return;
            }
            break;
        case '|':
            if (op == '|') { op = 'b'; flag = true; } else {
                System.out.println("Invalid input! It has to be a '|', 'T' or 'F'!");
                return;
            }
            break;
        default:
            System.out.println("Invalid input! It has to be a 'T' or 'F'!");
            return;
        }
        
        if ( flag ) {
         // Buchstaben einlesen
            try {
                input = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            // Kleinschreibung zu Groﬂschreibung konvertieren
            if ('z' <= input && input >= 'a') {
                input -= 'a' - 'A';
            }
            
            // Input verarbeiten
            switch (input) {
            case 'T':
                op2 = true;
                break;
            case 'F':
                op2 = false;
                break;
            default:
                System.out.println("Invalid input! It has to be a 'T' or 'F'!");
                return;
            }
                
            
            
        }
        
        
        boolean result;
        String operation = "" + op;
        switch (op) {
        case '|':
            result = op1 | op2;
            break;
        case '&':
            result = op1 & op2;
            break;
        case '^':
            result = op1 ^ op2;
            break;
        case 'a':
            result = op1 && op2;
            operation = "&&";
            break;
        case 'b':
            result = op1 || op2;
            operation = "||";
            break;
        default:
            System.out.println("Invalid input! It has to be a '|', '^' or '&'!");
            return;
        }

        System.out.printf("%b %s %b = %b%n", op1, operation, op2, result);
    }

}
