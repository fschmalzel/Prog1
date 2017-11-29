package main;

import java.io.IOException;

public class Eavesdropper {
    
    public static void main(String[] args) throws IOException {
        
        int[] input = CharArrayOps.getLine("Welche Nachricht, soll getestet werden?");
        int[] toSearch = {'a', 'u', 'g', 's', 'b', 'u', 'r', 'g'};
        
        // Verschlüsseln des Arrays
        Crypto.encryptCeasar(input, 26);
        
        // Bekommen des Keys durch pures probieren
        int key = bruteForceCeaserKey(input, toSearch);
        
        // Falls der key < 0 wurde der Schlüssel nicht gefunden
        if (key >= 0)
            System.out.println("Der Schlüssel ist: " + key + ".");
        else
            System.out.println("Der Schlüssel konnte nicht ermittelt werden!");
        
        
    }
    
    /**
     * With this method you can get the key for an array which has been
     * encrypted using the Caesar cipher, if you know part of the right message.
     * 
     * @param array The encrypted array
     * @param toSearch Part of the message in clear text
     * @return The key which was used to encrypt the array or -1 if there is no key
     */
    public static int bruteForceCeaserKey(int[] array, int[] toSearch) {
        // Wir testen einfach jede Verschiebung, wenn das zu Suchende im neuen
        // entschlüsselten gefunden wurde, dann haben wir den key und geben ihn zurück
        for (int i = 1; i <= 'z' - 'a' + 1; i++) {
            int[] newArray = CharArrayOps.copyArray(array);
            Crypto.decryptCeasar(newArray, i);
            if ( CharArrayOps.find(newArray, toSearch) >= 0)
                return i;
        }
        
        return -1;
        
    }
    
}
