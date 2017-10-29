package main;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {
        // Deklarieren der Variablen zum einlesen.
        // Variablen für die ersten beiden Zeichen ('\\u')
        int in1, in2, in3;
        // Variablen für die Hexadezimalzahl
        int code1, code2, code3, code4;
        // Variable für die letztendliche Dezimal Zahl
        int code = 0;
        
        // Einlesen der Zeichen
        try {
            in1 = System.in.read();
            if (in1 != '\\') 
                throw new IOException("The first symbol has to be a \\!");
            
            in2 = System.in.read();
            if (in2 != 'u') 
                throw new IOException("The second symbol has to be a u!");
            
            code1 = toUppercase(System.in.read());
            if (!isHex(code1))
                throw new IOException("The third symbol has to be hexadecimal!");
            
            code2 = toUppercase(System.in.read());
            if (!isHex(code2))
                throw new IOException("The fourth symbol has to be hexadecimal!");
            
            code3 = toUppercase(System.in.read());
            if (!isHex(code3))
                throw new IOException("The fifth symbol has to be hexadecimal!");
            
            code4 = toUppercase(System.in.read());
            if (!isHex(code4))
                throw new IOException("The sixth symbol has to be hexadecimal!");
            
            in3 = System.in.read();
            if (!(in3 == '\r' || in3 == '\n' || in3 == ' '))
                throw new IOException("The input has to be 6 symbols long!");
        } catch (IOException e) {
            // Falls ein Fehler vorliegt, wird ein Fehler ausgegeben und das Programm beendet
            System.err.println(e.getMessage());
            return;
        }
        
        code += toNumberFromHex(code1);
        code = code << 4;
        
        code += toNumberFromHex(code2);
        code = code << 4;
        
        code += toNumberFromHex(code3);
        code = code << 4;
        
        code += toNumberFromHex(code4);
        
        // Ausgeben der dezimal Zahl und des jeweilige zugehörigen Zeichens (Man beachte die Zeichenkodierung der Datei)
        System.out.printf("dec.: %03d, char: %c", code, (char) code);
        
    }
    
    private static boolean isHex(int code) {
        if (code >= 'A' && code <= 'Z' || code >= '0' && code <= '9')
            return true;
        return false;
    }
    
    private static int toNumberFromHex(int code) {
        if (code >= 'A' && code <= 'Z')
            return code - 'A' + 10;
        else if (code >= '0' && code <= '9')
            return code - '0';
        return 0;
    }
    
    private static int toUppercase(int code) {
        if (code >= 'a' && code <= 'z')
            return code += 'A' - 'a';
        return code;
    }
    
}