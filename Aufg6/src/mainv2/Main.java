package mainv2;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        int[] input = new int[32];
        int length = 0;
        
        System.out.println("Bitte geben Sie eine Zeile Text ein.");
        System.out.print("> ");
        
        int inputChar = System.in.read();
        
        // Einlesen der Zeile
        while (inputChar != '\n' && inputChar != '\r') {
            
            // Falls das Array, das neue Zeichen nicht halten kann, machen wir ein größeres
            if (length + 1 >= input.length) {
                int[] input2 = new int[input.length * 2];
                
                for (int i = 0; i < input.length; i++) {
                    input2[i] = input[i];
                }
                input = input2;
                
            }
            
            input[length] = inputChar;
            length++;
            inputChar = System.in.read();
        }
        
        // Um die Leerzeichen am Ende weg zu kriegen, gehen wir rückwärts durch bis wir auf
        // ein normales Zeichen stoßen und machen length immer eins kleiner
        for (int i = length - 1; i >= 0; i--) {
            if (input[i] == ' ')
                length--;
            else
                break;
        }
        
        // Dass das Array die perfekte Länge besitzt wird hier ein neues mit length erstellt
        // und die Daten übertragen von dem größerem Array
        if (input.length != length) {
            int[] input2 = new int[length];
            
            for (int i = 0; i < length; i++) {
                input2[i] = input[i];
            }
            input = input2;
        }
        
        // Ausgabe des Arrays
        for (int i : input) {
            System.out.print((char) i);
        }
        System.out.println();
        
        
        /*
         * TEILAUFGABE 1
         */
        
        System.out.println("Welches Zeichen soll durch welches ersetzt werden? Eingabeformat: \"x->y\"");
        System.out.print("> ");
        int fromChar;
        
        // Einlesen des ersten Zeichens
        do {
            fromChar = System.in.read();
        } while (fromChar == '\n' || fromChar == '\r');
        
        if (System.in.read() != '-') {
            System.out.println("Falsche Eingabe, an zweiter Stelle sollte ein '-' sein!");
            return;
        }
        
        if (System.in.read() != '>') {
            System.out.println("Falsche Eingabe, an dritter Stelle sollte ein '>' sein!");
            return;
        }
        
        int toChar = System.in.read();
        if (toChar == '\r' || toChar == '\n') {
            System.out.println("Falsche Eingabe, das Zeichen zum Ersetzen fehlt!");
            return;
        }
        
        for (int i = 0; i < input.length; i++) {
            if (input[i] == fromChar)
                input[i] = toChar;
        }
        
        // Ausgabe des Arrays
        for (int i : input) {
            System.out.print((char) i);
        }
        System.out.println();
        
        /*
         * TEILAUFGABE 2
         */
        
        System.out.println("Das wievielte Zeichen soll gelöscht werden (0-index)? Es werden nur Zahlen von 0 - 9 angenommen!");
        System.out.print("> ");
        int toDelete;
        do {
            toDelete = System.in.read();
        } while (toDelete == '\n' || toDelete == '\r');
        
        inputChar = System.in.read();
        if (toDelete < '0' || toDelete > '9' || !(inputChar == '\n' || inputChar == '\r') ) {
            System.out.println("Falsche Eingabe, das eingegebene Zeichen ist keine Zahl!");
            return;
        }
        
        toDelete -= '0';
        
        if (toDelete < input.length) {
            int[] input2 = new int[input.length -1];
            
            for (int i = 0; i < input.length; i++) {
                if (i == toDelete)
                    continue;
                
                input2[(i > toDelete ? i - 1 : i)] = input[i];
            }
            
            input = input2;
        } else {
            System.out.println("Falsche Eingabe, die angegebene Zahl ist zu groß!");
            return;
        }
        
        // Ausgabe des Arrays
        for (int i : input) {
            System.out.print((char) i);
        }
        System.out.println();
        
        /*
         * TEILAUFGABE 3
         */
        
        System.out.println("Welches Zeichen soll gelöscht werden? z. B.: \"> a\"");
        System.out.print("> ");
        
        do {
            toDelete = System.in.read();
        } while (toDelete == '\n' || toDelete == '\r');
        
        int amount = 0;
        
        for (int i : input) {
            if (i == toDelete)
                amount++;
        }
        
        int catched = 0;
        
        if (amount > 0) {
            int[] input2 = new int[input.length - amount];
            
            for (int i = 0; i < input.length; i++) {
                if (input[i] == toDelete) {
                    catched++;
                    continue;
                }
                
                input2[i-catched] = input[i];
            }
            
            input = input2;
            
        }
        
        // Ausgabe des Arrays
        for (int i : input) {
            System.out.print((char) i);
        }
        System.out.println();
        
        /*
         * TEILAUFGABE 4
         */
        
        
        
        
        
        
    }
    
}
