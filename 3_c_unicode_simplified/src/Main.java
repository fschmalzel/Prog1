import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {
        // Variablen für die einzulesenden Hexadezimalzahlen
        int code1, code2, code3, code4;
        
        // Einlesen der Zeichen
        try {
            
            int in1 = System.in.read();
            // Prüfen ob das erste Zeichen ein \\ ist
            if (in1 != '\\') {
                // Falls nicht wird ein Fehler ausgegeben und das Programm abgebrochen
                System.err.println("The first symbol has to be a '\\'!");
                return;
            }
            
            int in2 = System.in.read();
            // Prüfen ob das zweite Zeichen ein u ist.
            if (in2 != 'u') {
                // Falls nicht wird ein Fehler ausgegeben und das Programm abgebrochen
                System.err.println("The second symbol has to be a 'u'!");
                return;
            }
            
            code1 = System.in.read();
            // Konvertierung zu Großbuchstaben
            if ( code1 >= 'a' && code1 <= 'z')
                code1 += 'A' - 'a';
            
            // Prüfung ob das eingelesene Zeichen eine Hexadezimalzahl ist
            if ( !(code1 >= 'A' && code1 <= 'Z' || code1 >= '0' && code1 <= '9')) {
                // Falls nicht wird ein Fehler ausgegeben und das Programm abgebrochen
                System.err.println("The third symbol has to be a hexadecimal number!");
                return;
            }
                
            code2 = System.in.read();
            // Konvertierung zu Großbuchstaben
            if ( code2 >= 'a' && code2 <= 'z')
                code2 += 'A' - 'a';
            
            // Prüfung ob das eingelesene Zeichen eine Hexadezimalzahl ist
            if ( !(code2 >= 'A' && code2 <= 'Z' || code2 >= '0' && code2 <= '9')) {
                // Falls nicht wird ein Fehler ausgegeben und das Programm abgebrochen
                System.err.println("The third symbol has to be a hexadecimal number!");
                return;
            }
            
            code3 = System.in.read();
            // Konvertierung zu Großbuchstaben
            if ( code3 >= 'a' && code3 <= 'z')
                code3 += 'A' - 'a';
            
            // Prüfung ob das eingelesene Zeichen eine Hexadezimalzahl ist
            if ( !(code3 >= 'A' && code3 <= 'Z' || code3 >= '0' && code3 <= '9')) {
                // Falls nicht wird ein Fehler ausgegeben und das Programm abgebrochen
                System.err.println("The third symbol has to be a hexadecimal number!");
                return;
            }
            
            code4 = System.in.read();
            // Konvertierung zu Großbuchstaben
            if ( code4 >= 'a' && code4 <= 'z')
                code4 += 'A' - 'a';
            
            // Prüfung ob das eingelesene Zeichen eine Hexadezimalzahl ist
            if ( !(code4 >= 'A' && code4 <= 'Z' || code4 >= '0' && code4 <= '9')) {
                // Falls nicht wird ein Fehler ausgegeben und das Programm abgebrochen
                System.err.println("The third symbol has to be a hexadecimal number!");
                return;
            }
            
            int in3 = System.in.read();
            // Prüfen ob das nächste eingegebene Zeichen eine Leertaste, ein Zeilenumbruch (\n) oder
            // ein Enter (\r) ist, um zu schauen ob die Eingabe zu lang ist.
            if (!(in3 == '\r' || in3 == '\n' || in3 == ' ')) {
                // Falls nicht wird ein Fehler ausgegeben und das Programm abgebrochen
                System.err.println("The input has to be exactly 6 symbols long!");
                return;
            }
            
        } catch (IOException e) {
            // Falls ein Fehler vorliegt, wird ein Fehler ausgegeben und das Programm beendet
            System.err.println(e.getMessage());
            return;
        }
        
        int code = 0;
        
        // Konvertieren des Symbols zur Hexzahl;
        if (code1 >= 'A' && code1 <= 'Z') {
            code1 = code1 - 'A' + 10;
        } else if ( code1 >= '0' && code1 <= '9') {
            code1 = code1 - '0';
        }
        
        // Die Hexzahl wird jetzt mal 16^3 genommen da sie an der 4ten Stelle ist und damit 16^(4-1) wert ist.
        // Siehe Stellenwertsysteme
        code += code1 * 16 * 16 * 16;
        
        // Konvertieren des Symbols zur Hexzahl;
        if (code2 >= 'A' && code2 <= 'Z') {
            code2 = code2 - 'A' + 10;
        } else if ( code2 >= '0' && code2 <= '9') {
            code2 = code2 - '0';
        }
        
        // Die Hexzahl wird jetzt mal 16^2 genommen da sie an der 3ten Stelle ist und damit 16^(3-1) wert ist.
        // Siehe Stellenwertsysteme
        code += code2 * 16 * 16;
         
        // Konvertieren des Symbols zur Hexzahl;
        if (code3 >= 'A' && code3 <= 'F') {
            code3 = code3 - 'A' + 10;
        } else if ( code3 >= '0' && code3 <= '9') {
            code3 = code3 - '0';
        }
        
        // Die Hexzahl wird jetzt mal 16^1 genommen da sie an der 2ten Stelle ist und damit 16^(2-1) wert ist.
        // Siehe Stellenwertsysteme
        code += code3 * 16;
        
        // Konvertieren des Symbols zur Hexzahl;
        if (code4 >= 'A' && code4 <= 'Z') {
            code4 = code4 - 'A' + 10;
        } else if ( code4 >= '0' && code4 <= '9') {
            code4 = code4 - '0';
        }
        
        // Die Hexzahl wird jetzt mal 16^0 (1) genommen da sie an der 1ten Stelle ist und damit 16^(1-1) wert ist.
        // Siehe Stellenwertsysteme
        code += code4;
        
        // Damit ist code die fertige Ordinalzahl des gewünschten Zeichens
        
        // Ausgeben der dezimal Zahl und des jeweilige zugehörigen Zeichens
        // Man beachte die Zeichenkodierung der Datei, falls man alle Zeichen im UTF16 Standard ausgeben möchte
        System.out.println("dec.: " + code + ", char: " + (char) code);
        
    }
    
}