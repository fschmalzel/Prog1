package main;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {
        // Deklarieren der Variablen zum einlesen.
        // Variablen für die ersten beiden Zeichen ('\\u')
        int in1, in2;
        // Variablen für die Hexzahl
        int code1, code2, code3, code4;
        // Variable für die letztendliche Dezimal Zahl
        int code = 0;
        
        // Einlesen der Zeichen
        try {
            in1 = System.in.read();
            in2 = System.in.read();
            code1 = System.in.read();
            code2 = System.in.read();
            code3 = System.in.read();
            code4 = System.in.read();
        } catch (IOException e) {
            // Falls ein Fehler vorliegt, wird ein Fehler ausgegeben und das Programm beendet
            System.err.println(e.getMessage());
            return;
        }
        
        // Falls die ersten beiden Zeichen nicht '\\u' sind, wird ein Fehler ausgeben und abbrechen
        if ( in1 != '\\' || in2 != 'u') {
            System.err.println("Invalid input!");
            return;
        }
        
        // Konvertieren des Zeichens in die zugehörige Dezimalzahl bezogen auf die Stelle
        if (code1 >= '0' && code1 <= '9') {
        	/*
        	 * Zeichencode - Zeichencode des ersten Zeichens der Ansammlung ergibt die eigentliche Zahl,
        	 * bei den Buchstaben muss man das ganze dann noch um 10 erhöhen da A nicht 0 ist sondern "10".
        	 * code1 ist die 3te Stelle (0-index) damit 16^3 (4096) Wert und
        	 * muss deswegen mal 4096 genommen werden.
        	 * Dies wird dann zum letzt endlichen code hinzugefügt und
        	 * anschließend werden die weiteren Stellen addiert.
        	 */
            code += (code1 - '0') * 4096;
        } else if (code1 >= 'A' && code1 <= 'F') {
            code += (code1 - 'A' + 10) * 4096;
        } else if (code1 >= 'a' && code1 <= 'f') {
            code += (code1 - 'a' + 10) * 4096;
        } else {
            // Falls es keine Hexzahl ist, Fehler ausgeben und abbrechen
            System.err.println("Invalid input, expected a hex number!");
            return;
        }
        
        // Analog zum vorherigen Codeblock
        if (code2 >= '0' && code2 <= '9') {
            code += (code2 - '0') * 256;
        } else if (code2 >= 'A' && code2 <= 'F') {
            code += (code2 - 'A' + 10) * 256;
        } else if (code2 >= 'a' && code2 <= 'f') {
            code += (code2 - 'a' + 10) * 256;
        } else {
            System.err.println("Invalid input, expected a hex number!");
            return;
        }
        
        // Analog zum vorherigen Codeblock
        if (code3 >= '0' && code3 <= '9') {
            code += (code3 - '0') * 16;
        } else if (code3 >= 'A' && code3 <= 'F') {
            code += (code3 - 'A' + 10) * 16;
        } else if (code3 >= 'a' && code3 <= 'f') {
            code += (code3 - 'a' + 10) * 16;
        } else {
            System.err.println("Invalid input, expected a hex number!");
            return;
        }
        
        // Analog zum vorherigen Codeblock
        if (code4 >= '0' && code4 <= '9') {
            code += code4 - '0';
        } else if (code4 >= 'A' && code4 <= 'F') {
            code += code4 - 'A' + 10;
        } else if (code4 >= 'a' && code4 <= 'f') {
            code += code4 - 'a' + 10;
        } else {
            System.err.println("Invalid input, expected a hex number!");
            return;
        }
        
        // Ausgeben der dezimal Zahl und des jeweilig zugehörigen Zeichens (Man beachte die Zeichenkodierung der Datei)
        System.out.printf("dez.: %03d, char: %c", code, (char) code);
        
    }
    
}
