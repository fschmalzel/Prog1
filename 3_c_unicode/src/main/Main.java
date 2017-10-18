package main;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {
        
        int input;
        try {
            input = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        if (input != '\\') {
            System.out.println("'\\' expected.");
            return;
        }
        
        try {
            input = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        if (input != 'u') {
            System.out.println("'u' expected.");
            return;
        }
        
        int hex1, hex2, hex3, hex4;
        try {
            hex4 = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Kleinschreibung zu Groﬂschreibung konvertieren
        if ('z' <= hex4 && hex4 >= 'a') {
            hex4 -= 'a' - 'A';
        }
        
        if ( !(hex4 >= '0' && hex4 <= '9' || hex4 >= 'A' && hex4 <= 'F') ) {
            System.out.println("Expected a hexcode.");
            return;
        }
        
        try {
            hex3 = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Kleinschreibung zu Groﬂschreibung konvertieren
        if ('z' <= hex3 && hex3 >= 'a') {
            hex3 -= 'a' - 'A';
        }
        
        if ( !(hex3 >= '0' && hex3 <= '9' || hex3 >= 'A' && hex3 <= 'F') ) {
            System.out.println("Expected a hexcode.");
            return;
        }
        
        try {
            hex2 = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Kleinschreibung zu Groﬂschreibung konvertieren
        if ('z' <= hex2 && hex2 >= 'a') {
            hex2 -= 'a' - 'A';
        }
        
        if ( !(hex2 >= '0' && hex2 <= '9' || hex2 >= 'A' && hex2 <= 'F') ) {
            System.out.println("Expected a hexcode.");
            return;
        }
        
        try {
            hex1 = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Kleinschreibung zu Groﬂschreibung konvertieren
        if ('z' <= hex1 && hex1 >= 'a') {
            hex1 -= 'a' - 'A';
        }
        
        if ( !(hex1 >= '0' && hex1 <= '9' || hex1 >= 'A' && hex1 <= 'F') ) {
            System.out.println("Expected a hexcode.");
            return;
        }
        
        hex1 = convert(hex1);
        hex2 = convert(hex2);
        hex3 = convert(hex3);
        hex4 = convert(hex4);
        
        short code = (short) (hex4 * 4096 + hex3 * 256 + hex2 * 16 + hex1);
        
        System.out.printf("dez.: %03d, char: %c", code, (char) code);
    }
    
    private static int convert(int num) {
        int result;
        if (num >= '0' && num <= '9') {
            result = num - '0';
        } else if (num >= 'A' && num <= 'Z') {
            result = num - 'A' + 10;
        } else {
            result = 0;
        }
        return result;
    }
    
}
