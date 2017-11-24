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
        
        // Um den Schl�ssel zu korrigieren, schieben wir ihn solange um eine Alphabet L�nge
        // nach rechts bis der Schl�ssel eine Gr��e zwischen 0 und 'z' hat
        while (key > 'z' - 'a' + 1)
            key -= 'z' - 'a' + 1;
        
        // Falls der key kleiner als 0 ist, muss nichts getan werden
        if (key <= 0)
            return;
        
        for (int i = 0; i < array.length; i++) {
            
            // Wir verschl�sseln nur Kleinbuchstaben
            if ('a' <= array[i] && array[i] <= 'z') {
                
                // Falls der Buchstabe nachdem verschieben �ber das Alphabet zur�ckgeht,
                // m�ssen wir ihn eine Alphabet L�nge zur�ckschieben
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
        
        // Zum entschl�sseln m�ssen wir die Buchstaben in die entgegengesetzte Richtung schieben
        key = -key;
        
        // Falls der key kleiner als 0 ist, m�ssen wir ihn solange um eine Alphabet L�nge verschieben,
        // bis er es nicht mehr ist
        while (key < 0)
            key += ('z' - 'a' + 1);
        
        // Nun kann man die Verschl�sselungsmethode zum entschl�sseln benutzen
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
        
        // Falls der key nicht die richtige L�nge besitzt kann an diesem Punkt abgebrochen werden
        if (key.length != ('z' - 'a' + 1) * 2)
            return;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < key.length/2; j++) {
                
                // Falls der Buchstabe mit einem Buchstaben im ersten Teil des keys �bereinstimmt,
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
        
        // Um den Schl�ssel f�r das entschl�sseln zu kriegen,
        // m�ssen wir die erste H�lfte der Daten in die zweite kriegen
        // und umgekehrt
        int[] reverseKey = new int[key.length];
        
        // �bertragen der ersten H�lfte in die zweite
        for (int i = 0; i < key.length/2; i++) {
            reverseKey[i+key.length/2] = key[i];
        }
        
        // �bertragen der zweiten H�lfte in die erste
        for (int i = key.length/2; i < key.length; i++) {
            reverseKey[i-key.length/2] = key[i];
        }
        
        // Nun kann man die Verschl�sselungsmethode zum entschl�sseln benutzen
        encryptBijective(array, reverseKey);
        
    }
    
}
