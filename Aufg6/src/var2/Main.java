package var2;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        boolean teil1 = true;
        boolean teil2 = true;
        boolean teil3 = true;
        boolean teil4 = true;
        boolean teil5 = true;
        
        System.out.println("Bitte geben Sie eine Zeile Text ein.");
        System.out.print("> ");
        
        int[] input = getArray();
        
        printArray(input);
        
        /*
         * TEILAUFGABE 1
         */
        
        if (teil1) {
            
            System.out.println("Welches Zeichen soll durch welches ersetzt werden? Eingabeformat: \"x->y\"");
            System.out.print("> ");
            
            int fromChar;
            
            // Einlesen des ersten Zeichens
            do {
                fromChar = System.in.read();
            } while (fromChar == '\n' || fromChar == '\r');
            
            // Überprüfung ob die nächsten beiden Zeichen ein - und ein > sind.
            if (System.in.read() != '-') {
                System.out.println("Falsche Eingabe, an zweiter Stelle sollte ein '-' sein!");
                return;
            }
            
            if (System.in.read() != '>') {
                System.out.println("Falsche Eingabe, an dritter Stelle sollte ein '>' sein!");
                return;
            }
            
            // Einlesen des zweiten Zeichens
            
            int toChar = System.in.read();
            
            if (toChar == '\r' || toChar == '\n') {
                System.out.println("Falsche Eingabe, das Zeichen zum Ersetzen fehlt!");
                return;
            }
            
            // Ersetzen des Zeichens
            for (int i = 0; i < input.length; i++) {
                if (input[i] == fromChar)
                    input[i] = toChar;
            }
            
            // Ausgabe des Arrays
            printArray(input);
            
        }
        
        
        /*
         * TEILAUFGABE 2
         */
        
        
        if (teil2) {
            
            System.out.println("Das wievielte Zeichen soll gelöscht werden (0-index)? " + 
                    "Es werden nur Zahlen von 0 - 9 angenommen!");
            
            for (int i = 0; i <= 9 && i < input.length; i++)
                System.out.print(i);
            System.out.println();
            printArray(input);
            
            System.out.print("> ");
            
            int toDelete;
            
            // Einlesen der zu löschenden Stelle
            do {
                toDelete = System.in.read();
            } while (toDelete == '\n' || toDelete == '\r');
            
            // Überprüfen ob es eine Zahl und ob nur ein Zeichen eingegeben wurde
            int checkInt = System.in.read();
            
            if (toDelete < '0' || toDelete > '9' || !(checkInt == '\n' || checkInt == '\r')) {
                System.out.println("Falsche Eingabe, das eingegebene Zeichen ist keine Zahl!");
                return;
            }
            
            // Konvertieren der Ordinalzahl
            toDelete -= '0';
            
            // Prüfen ob die angegebene Stelle überhaupt im Array vorhanden ist
            if (toDelete < input.length) {
                // Erstellen eines neuen Arrays das 1 kleiner ist
                int[] input2 = new int[input.length - 1];
                
                // Dem neuen Array werden die alten Werte zu gewissen außer es ist an der zu löschenden Stelle
                // dann werden keine Daten übertragen und anschließend weiter Werte in das neue Array eingetragen
                for (int i = 0; i < input.length; i++) {
                    if (i == toDelete)
                        continue;

                    input2[(i > toDelete ? i - 1 : i)] = input[i];
                }
                
                // Aktualisieren der Referenz
                input = input2;
            } else {
                System.out.println("Falsche Eingabe, die angegebene Zahl ist zu groß!");
                return;
            }
            
            printArray(input);
            
        }
        
        
        /*
         * TEILAUFGABE 3
         */
        
        if (teil3) {
            System.out.println("Welches Zeichen soll gelöscht werden? z. B.: \"> a\"");
            System.out.print("> ");
            
            int toDelete;
            
            // Einlesen des zu löschenden Zeichens.
            do {
                toDelete = System.in.read();
            } while (toDelete == '\n' || toDelete == '\r');
            
            int amount = 0;
            
            // Zählen wie oft das Zeichen vor kommt
            for (int i : input) {
                if (i == toDelete)
                    amount++;
            }
            
            int catched = 0;
            
            // Prüfen ob das Zeichen überhaupt vorkam
            if (amount > 0) {
                // Erstellen eines neuen Arrays mit der richtigen Größe
                int[] input2 = new int[input.length - amount];
                
                for (int i = 0; i < input.length; i++) {
                    
                    // Falls das zu übertragende Zeichen das zu löschende ist, wird es übersprungen
                    // und das offset namens catched um eins erhöht
                    if (input[i] == toDelete) {
                        catched++;
                        continue;
                    }
                    
                    // Übertragen der Daten mit Offset
                    input2[i - catched] = input[i];
                }

                input = input2;

            }
            
            printArray(input);
            
        }
        
        
        /*
         * TEILAUFGABE 4
         */
        
        if (teil4) {
            System.out.println("An welcher Stelle soll ein Bindezeichen eingefügt werden (0-index)?" + 
                    "Es werden nur Zahlen von 0 - 9 angenommen!");
            
            for (int i = 0; i <= 9 && i < input.length; i++)
                System.out.print(i);
            System.out.println();
            printArray(input);
            
            System.out.print("> ");
            
            int insertIndex;
            
            // Einlesen der Stelle an der das Bindezeichen eingefügt werden soll
            do {
                insertIndex = System.in.read();
            } while (insertIndex == '\n' || insertIndex == '\r');
            
            int checkInt = System.in.read();
            
            // Prüfen ob es eine Zahl ist und auch wirklich nur 1 rein kam
            if (insertIndex < '0' || insertIndex > '9' || !(checkInt == '\n' || checkInt == '\r')) {
                System.out.println("Falsche Eingabe, das eingegebene Zeichen ist keine Zahl!");
                return;
            }
            
            // Konvertieren der Ordinalzahl
            insertIndex -= '0';
            
            // Schauen ob das Bindezeichen überhaupt im Array liegt
            if (insertIndex < input.length + 1) {
                // Erstellen eines größeren Arrays
                int[] input2 = new int[input.length + 1];
                
                for (int i = 0; i < input2.length; i++) {
                    // Falls die der index = insertIndex ist wird das Bindezeichen eingefügt und danach
                    // die restlichen Daten übertragen
                    if (i == insertIndex) {
                        input2[i] = '-';
                        continue;
                    }
                    
                    input2[i] = input[i > insertIndex ? i - 1 : i];
                }
                
                // Aktualisieren der Referenz
                input = input2;
                
            } else {
                System.out.println("Falsche Eingabe, die Zahl ist zu groß!");
            }
            
            printArray(input);
            
        }
        
        
        /*
         * TEILAUFGABE 5
         */
        
        if (teil5) {
            System.out.println("Bitte geben Sie einen Text ein, nachdem im vorherigen gesucht werden soll.");
            System.out.print("> ");
            
            int[] newInput = getArray();
            
            printArray(newInput);
            
            // Suchen der Zeichenkette in der ersten Zeichenkette
            for (int i = 0; i < input.length - newInput.length + 1; i++) {

                for (int j = 0; j < newInput.length; j++) {
                    
                    // Falls die Zeichen nicht gleich sind, kann die Suche von dieser Startstelle abgebrochen werden
                    // Falls nicht, wird weiter geschaut, wenn das letzte Zeichen auch passt, dann ist der Text
                    // an der jeweiligen Stelle vorhanden und es wird dementsprechend eine Nachricht ausgegeben
                    
                    if (input[i + j] != newInput[j])
                        break;
                    else if (j == newInput.length - 1) {
                        System.out.println("Der String kommt an der Stelle " + (i + 1) + " vor.");
                    }
                    
                }

            }
            
            
        }
        
    }
    

    public static void printArray(int[] input) {
        for (int i : input) {
            System.out.print((char) i);
        }
        System.out.println();
    }

    public static int[] getArray() throws IOException {
        
        int inputChar;
        do {
            inputChar = System.in.read();
        } while (inputChar == '\n' || inputChar == '\r');

        int length = 0;
        int[] input = new int[32];
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

        // Um die Leerzeichen am Ende weg zu kriegen, gehen wir rückwärts durch bis wir
        // auf
        // ein normales Zeichen stoßen und machen length immer eins kleiner
        for (int i = length - 1; i >= 0; i--) {
            if (input[i] == ' ')
                length--;
            else
                break;
        }

        // Dass das Array die perfekte Länge besitzt wird hier ein neues mit length
        // erstellt
        // und die Daten übertragen von dem größerem Array
        if (input.length != length) {
            int[] input2 = new int[length];

            for (int i = 0; i < length; i++) {
                input2[i] = input[i];
            }
            input = input2;
        }

        return input;
    }
    
    
}
