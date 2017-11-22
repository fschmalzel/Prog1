package teilA;

public class CharArrayOps {

    public static void main(String[] args) {

    }

    public static int[] getArray() {

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
            return input2;
        }

        return input;
    }

    public static void printArray(int[] array) {
        for (int i : array)
            System.out.print((char) i);
        System.out.println();
    }

    public static void replaceInt(int[] array, int fromInt, int toInt) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == fromInt)
                array[i] = toInt;
    }

    public static int findeArrayInArray(int[] array, int[] toSearch) {
        for (int i = 0; i < array.length - toSearch.length + 1; i++) {

            for (int j = 0; j < toSearch.length; j++) {

                // Falls die Zeichen nicht gleich sind, kann die Suche von dieser Startstelle
                // abgebrochen werden
                // Falls nicht, wird weiter geschaut, wenn das letzte Zeichen auch passt, dann
                // ist der Text
                // an der jeweiligen Stelle vorhanden und es wird dementsprechend eine Nachricht
                // ausgegeben

                if (array[i + j] != toSearch[j])
                    break;
                else if (j == toSearch.length - 1)
                    return i;

            }

        }
        
        return -1;
        
    }

}
