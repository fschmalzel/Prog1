package main;

import java.io.IOException;

public class CharArrayOps {

    public static void main(String[] args) throws IOException {
        
        int[] input = getLine("Bitte geben Sie eine Zeile Text ein!");
        print(input);
        
        replace(input, 'a', 'b');
        print(input);
        
        int pos = find(input, getLine("Bitte geben Sie Text ein nach dem gesucht werden soll!"));
        System.out.println("Das gesuchte befindet sich an Stelle " + pos + ".");
        
        input = deleteAtPos(input, 3);
        print(input);
        
        input = delete(input, 'c');
        print(input);
        
        input = insert(input, 'd', 2);
        print(input);
        
        input = insert(input, new int[]{'T', 'e', 's', 't'}, 1);
        print(input);
        
    }
    
    /**
     * Gets one line of input from the console, with a question
     * 
     * @param quest The question the user is being asked
     * @return input as an array of integers
     * @throws IOException
     */
    public static int[] getLine(String quest) throws IOException {
        // Print out the question
        System.out.println(quest);
        System.out.print("> ");
        // Get the input
        return getLine();
    }
    
    /**
     * Gets one line of input from the console
     * 
     * @return input as an array of integers
     * @throws IOException
     */
    public static int[] getLine() throws IOException {
        
        int inputChar;
        
        // Read in as many characters as needed until real input is here
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
            
            // Speichern des Zeichens im array
            input[length] = inputChar;
            // Erhöhen des counters
            length++;
            // Einlesen des nächsten Zeichens
            inputChar = System.in.read();
        }

        // Um die Leerzeichen am Ende weg zu kriegen, gehen wir rückwärts durch bis wir
        // auf ein normales Zeichen stoßen und machen length immer eins kleiner
        for (int i = length - 1; i >= 0; i--) {
            if (input[i] == ' ')
                length--;
            else
                break;
        }

        // Dass das Array die perfekte Länge besitzt wird hier ein neues mit Größe length
        // erstellt und die Daten übertragen von dem größerem Array
        if (input.length != length) {
            int[] input2 = new int[length];

            for (int i = 0; i < length; i++) {
                input2[i] = input[i];
            }
            return input2;
        }

        return input;
    }
    
    /**
     * Prints an array of integers as characters out with a line break
     * 
     * @param array to be printed
     */
    public static void print(int[] array) {
        // Jedes einzelne Element des Arrays konvertieren und ausgeben
        for (int i : array)
            System.out.print((char) i);
        // Anschließend den Zeilenumbruch nicht vergessen
        System.out.println();
    }
    
    /**
     * Replaces a integer in an array with another
     * 
     * @param array The array which will be modified
     * @param fromInt The int to replace
     * @param toInt The replacing int
     */
    public static void replace(int[] array, int fromInt, int toInt) {
        // Falls das Zeichen im Array das gesuchte ist wird es ersetzt
        for (int i = 0; i < array.length; i++)
            if (array[i] == fromInt)
                array[i] = toInt;
        // Ein return ist nicht nötig, da die Speicherreferenz nicht geändert wurde,
        // es wird immer noch auf das selbe Array zu gegriffen.
    }

    /**
     * Gives the first position at which it finds the second array in the first array.
     * If there's no match a -1 will be returned
     * 
     * @param array The array which will be searched in
     * @param toSearch The array it searches in the first
     * @return The position of the first Match or -1
     */
    public static int find(int[] array, int[] toSearch) {
        
        // Durchgehen aller validen Startstellen
        for (int i = 0; i < array.length - toSearch.length + 1; i++) {

            for (int j = 0; j < toSearch.length; j++) {

                // Falls die Zeichen nicht gleich sind, kann die Suche von dieser Startstelle
                // abgebrochen werden
                // Falls nicht, wird weiter geschaut, wenn das letzte Zeichen auch passt, dann
                // ist der Text
                // an der jeweiligen Stelle vorhanden und es wird dementsprechend der Wert
                // zurückgegeben

                if (array[i + j] != toSearch[j])
                    break;
                else if (j == toSearch.length - 1)
                    return i;

            }

        }
        
        // Falls nichts gefunden wurde, wird -1 zurückgegeben
        return -1;
        
    }
    
    /**
     * Deletes a int at the specified position.
     * The array will not be modified if the position is bigger than the array itself
     * 
     * @param array The array in which something should be removed
     * @param pos The position of the int that shall be removed
     * @return The new array
     */
    public static int[] deleteAtPos(int[] array, int pos) {
        // Die position liegt außerhalb des Arrays, also müssen wir nichts machen
        if (pos >= array.length)
            return array;
        
        // Das das Array nicht zu groß ist brauchen wir ein neues, das eins kleiner ist
        int[] newArray = new int[array.length-1];
        
        // Übertragen der Daten, falls i der Position entspricht, muss nichts übertragen werden
        // Jeder weitere Wert muss eine Stelle vorher gespeichert werden
        for(int i = 0; i < array.length; i++) {
            if (i == pos)
                continue;
            newArray[(i < pos)? i : i-1] = array[i];
        }
        
        return newArray;
        
    }
    
    /**
     * Removes all occurrences of a specific int
     * 
     * @param array The array which will be modified
     * @param toDelete The int which will be deleted
     * @return The new modified array
     */
    public static int[] delete(int[] array, int toDelete) {
        
        int amount = 0;
        
        // Zählen wie oft das Zeichen vor kommt
        for (int i : array)
            if (i == toDelete)
                amount++;
        
        int offset = 0;
        
        // Prüfen ob das Zeichen überhaupt vorkam
        if (amount > 0) {
            // Erstellen eines neuen Arrays mit der richtigen Größe
            int[] input2 = new int[array.length - amount];
            
            for (int i = 0; i < array.length; i++) {
                
                // Falls das zu übertragende Zeichen das zu löschende ist, wird es übersprungen
                // und das offset namens catched um eins erhöht
                if (array[i] == toDelete) {
                    offset++;
                    continue;
                }
                
                // Übertragen der Daten mit Offset
                input2[i - offset] = array[i];
            }

            return input2;

        } else
            return array;
        
    }
    
    /**
     * Inserts a int at the specified position in the array.
     * If the position is too big, the new int will be placed at the end
     * 
     * @param array The array which will be modified
     * @param toInsert The int which will be inserted
     * @param pos The position at which the int will be inserted
     * @return The new modified array containing the new int
     */
    public static int[] insert(int[] array, int toInsert, int pos) {
        // Schauen ob die Position überhaupt innerhalb, bzw. am Ende des Arrays liegt
        if (pos > array.length)
            pos = array.length;
        
        // Erstellen eines neuen Arrays das wir Platz für das neue int haben
        int[] newArray = new int[array.length + 1];
        
        // Übertragen der Daten, falls i == pos, dann wird das neue Zeichen eingefügt und jedes Weitere
        // eine Stelle weiter
        for (int i = 0; i < newArray.length; i++) {
            if (i == pos) {
                newArray[i] = toInsert;
                continue;
            }
            
            newArray[i] = array[(i < pos)? i : i - 1];
            
        }
        
        return newArray;
    }
    
    /**
     * Inserts an array of ints at the specified position in the array.
     * If the position is too big, the new content will be placed at the end
     * 
     * @param array The array which will be modified
     * @param toInsert The array which will be inserted
     * @param pos The position at which the array will be inserted
     * @return The new modified array containing the new content
     */
    public static int[] insert(int[] array, int[] toInsert, int pos) {
        // Schauen ob die Position überhaupt innerhalb, bzw. am Ende des Arrays liegt
        if (pos > array.length)
            pos = array.length;
        
        // Erstellen eines neuen Arrays das wir Platz für die neuen Daten haben
        int[] newArray = new int[array.length + toInsert.length];
        
        // Einfügen des ersten arrays bis zur Stelle an der eingesetzt werden soll
        for (int i = 0; i < pos; i++)
            newArray[i] = array[i];
        
        // Einfügen des vollständigen zweiten arrays, ab der einzufügenden Position
        for (int i = 0; i < toInsert.length; i++)
            newArray[i + pos] = toInsert[i];
        
        // Einfügen des Rests vom ersten array
        for (int i = pos; i < array.length; i++)
            newArray[toInsert.length + i] = array[i];
        
        return newArray;
        
    }
    
    /**
     * Creates a copy of an array
     * 
     * @param The array which will be copied
     * @return The copied array
     */
    public static int[] copyArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * Checks if two arrays have the same content and length
     * 
     * @param array1 The first array to compare
     * @param array2 The second array to compare
     * @return True, if they have the same content and length
     */
    public static boolean compare(int[] array1, int[] array2) {
        // Wenn die Länge nicht passt, können die Arrays nicht gleich sein
        if (array1.length != array2.length)
            return false;
        
        // Checken der einzelnen Elemente
        for(int i = 0; i < array1.length; i++)
            if (array1[i] != array2[i])
                return false;
        
        // Falls alle gleich sind, sind die Arrays "gleich"
        return true;
        
    }
    
}