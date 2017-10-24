package main;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {
        
        // Deklarieren der Variablen
        int operand1, operand2, operator;
        boolean doubleOperator = false;
        
        try {
            // Einlesen der Operanden und des Operators
            operand1 = System.in.read();
            operator = System.in.read();
            operand2 = System.in.read();
            // Falls der Operator und das darauffolgende Zeichen dasselbe ist, ist es entweder ein '&&' bzw. '||' oder eine falsche Eingabe.
            if (operator == operand2) {
                // Deswegen ist das 4te eingelesene Zeichen in diesem Fall der 2te Operand
                operand2 = System.in.read();
                doubleOperator = true;
            }
        } catch (IOException e){
            // Falls ein Fehler vorliegt, wird dieser ausgegeben und das Programm abgebrochen
            System.err.println(e.getMessage());
            return;
        }
        
        // Deklarieren der boolean Werte für die Operanden
        boolean op1, op2;
        if (operand1 == 'T' || operand1 == 't') {
            // Falls es ein T ist, ist der boolean Wert wahr.
            op1 = true;
        } else if (operand1 == 'F' || operand1 == 'f') {
            // Falls es ein F ist, ist boolean Wert falsch.
            op1 = false;
        } else {
            // Falls es kein F oder T ist, dann ist es eine falsche Eingabe, also Fehler und Abbruch.
            System.err.println("Expected an 'F' or 'T'!");
            return;
        }
        
        // Analog für den 2ten Operanden
        if (operand2 == 'T' || operand2 == 't') {
            op2 = true;
        } else if (operand2 == 'F' || operand2 == 'f') {
            op2 = false;
        } else {
            System.err.println("Expected an 'F' or 'T'!");
            return;
        }
        
        // Deklarieren der Variable für den resultierenden Wert
        boolean result;
        
        if (operator == '&') {
            if (!doubleOperator) {
                // Falls es ein & ist und wir keinen doppelten Operator haben (&&)
                result = op1 & op2;
            } else {
                // Falls es ein doppelter Operator ist
                result = op1 && op2;
            }
        } else if (operator == '|') {
            if (!doubleOperator) {
                // Analog zum vorherigen Teil
                result = op1 | op2;
            } else {
                result = op1 || op2;
            }
        } else if (operator == '^' && !doubleOperator) {
            // Falls es ein ^ ist und kein doppelter Operator, da ^^ nicht existiert.
            result = op1 ^ op2;
        } else {
            // Falls es keiner der vorherigen Zeichen ist, ist es ein ungültiger Operator, also Fehler und Abbruch.
            System.err.println("Unknown operator!");
            return;
        }
        
        // Ausgabe des Resultats.
        System.out.println(result);
        
    }
    
}
