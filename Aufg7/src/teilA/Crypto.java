package teilA;

public class Crypto {
    
    /**
     * Encrypts an array using the Caesar cipher.
     * It only encrypts lower case letters.
     * 
     * @param array The array which will be encrypted
     * @param key The key used to encrypt the array
     */
    public static void encryptCeasar(int[] array, int key) {
        
        // Um den Schlüssel zu korrigieren, schieben wir ihn solange um eine Alphabet Länge
        // nach rechts bis der Schlüssel eine Größe zwischen 0 und 'z' hat
        while (key > 'z' - 'a' + 1)
            key -= 'z' - 'a' + 1;
        
        // Falls der key kleiner als 0 ist, muss nichts getan werden
        if (key <= 0)
            return;
        
        for (int i = 0; i < array.length; i++) {
            
            // Wir verschlüsseln nur Kleinbuchstaben
            if ('a' <= array[i] && array[i] <= 'z') {
                
                // Falls der Buchstabe nachdem verschieben über das Alphabet zurückgeht,
                // müssen wir ihn eine Alphabet Länge zurückschieben
                int newVal = array[i] + key;
                
                if (newVal > 'z')
                    newVal -= 'z' - 'a' + 1;
                
                // Jetzt kann der neue Wert in das Array geschrieben werden
                array[i] = newVal;
                
            }
            
        } 
    
    }
    
    /**
     * Decrypts an array which was encrypted using the Caesar cipher.
     * It only decrypts lower case letters.
     * 
     * @param array The array which will be decrypted
     * @param key The key used to decrypt the array
     */
    public static void decryptCeasar(int[] array, int key) {
        
        // Zum entschlüsseln müssen wir die Buchstaben in die entgegengesetzte Richtung schieben
        key = -key;
        
        // Falls der key kleiner als 0 ist, müssen wir ihn solange um eine Alphabet Länge verschieben,
        // bis er es nicht mehr ist
        while (key < 0)
            key += ('z' - 'a' + 1);
        
        // Nun kann man die Verschlüsselungsmethode zum entschlüsseln benutzen
        encryptCeasar(array, key);
    }
    
    /**
     * Encrypts an array using the a bijective function.
     * It only encrypts lower case letters.
     * The first half of the key are the letters which should be replaced
     * The second half contains the new letters
     * 
     * @param array The array which will be encrypted
     * @param key The key used to encrypt the array
     */
    public static void encryptBijective(int[] array, int[] key) {
        
        // Falls der key nicht die richtige Länge besitzt kann an diesem Punkt abgebrochen werden
        if (key.length != ('z' - 'a' + 1) * 2)
            return;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < key.length/2; j++) {
                
                // Falls der Buchstabe mit einem Buchstaben im ersten Teil des keys übereinstimmt,
                // wird er ersetzt durch den Buchstaben im zweiten Teil des Arrays
                // Danach sollte nicht weiter geschaut werden, da wir Buchstaben nur einmal ersetzen
                if (array[i] == key[j]) {
                    array[i] = key[j + key.length/2];
                    break;
                }
                
            }
        }
        
    }
    
    /**
     * Decrypts an array using the a bijective function.
     * It only decrypts lower case letters.
     * The first half of the key are the letters which should be replaced
     * The second half contains the new letters
     * 
     * @param array The array which will be decrypted
     * @param key The key used to decrypt the array
     */
    public static void decryptBijective(int[] array, int[] key) {
        
        // Um den Schlüssel für das entschlüsseln zu kriegen,
        // müssen wir die erste Hälfte der Daten in die zweite kriegen
        // und umgekehrt
        int[] reverseKey = new int[key.length];
        
        // Übertragen der ersten Hälfte in die zweite
        for (int i = 0; i < key.length/2; i++) {
            reverseKey[i+key.length/2] = key[i];
        }
        
        // Übertragen der zweiten Hälfte in die erste
        for (int i = key.length/2; i < key.length; i++) {
            reverseKey[i-key.length/2] = key[i];
        }
        
        // Nun kann man die Verschlüsselungsmethode zum entschlüsseln benutzen
        encryptBijective(array, reverseKey);
        
    }
    
}
