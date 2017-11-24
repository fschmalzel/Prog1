package teilA;

import java.io.IOException;

public class Eavesdropper {
    
    public static void main(String[] args) throws IOException {
        
        int[] input = CharArrayOps.getLine("Welche Nachricht, soll getestet werden?");
        int[] toSearch = {'a', 'u', 'g', 's', 'b', 'u', 'r', 'g'};
        
        // Caesar-Verschlüsselung knacken
        Crypto.encryptCeasar(input, 26);
        
        int key = bruteForceCeaserKey(input, toSearch);
        
        if (key >= 0)
            System.out.println("Der Schlüssel ist: " + key + ".");
        else
            System.out.println("Der Schlüssel konnte nicht ermittelt werden!");
        
        System.out.println();
        
        // Bijektive-Verschlüsselung knacken
        int[] bijectivKey = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'
        };
        
        Crypto.encryptBijective(input, bijectivKey);
        
        
        
        
    }
    
    public static int bruteForceCeaserKey(int[] array, int[] toSearch) {
        
        for (int i = 1; i <= 'z' - 'a' + 1; i++) {
            int[] newArray = CharArrayOps.copyArray(array);
            Crypto.decryptCeasar(newArray, i);
            if ( CharArrayOps.find(newArray, toSearch) >= 0)
                return i;
        }
        
        return -1;
        
    }
    
    public static int[] bruteForceBijectivKey(int[] array, int[] toSearch) {
        
        int[] pattern;
        for (int i = 0; i < array.length - toSearch.length - 1; i++) {
            pattern = CharArrayOps.copyArray(toSearch);
            boolean noMatch = false;
            
            for (int j = 0; j < toSearch.length && !noMatch; j++) {
                pattern[j] = array[i + j];
                for (int l = 0; l < j - 1; l++) {
                    boolean patternMatch = pattern[j] == pattern[l];
                    boolean searchMatch = toSearch[j] != toSearch[l];
                    
                    if (patternMatch && !searchMatch || !patternMatch && searchMatch) {
                        noMatch = true;
                        break;
                    }
                    
                }
                if (j == toSearch.length - 1 && !noMatch) {
                    
                    int[] key = new int[('z' - 'a' + 2) * 2];
                    
                    
                    // Success need to convert to a real key
                    for (int l = 0; l < key.length / 2; l++) {
                        key[l] = 'a' + l;
                        if (toSearch[l] == 'a' + l)
                            key[key.length/2 + l] = pattern[l];
                                    
                    }
                    
                    for (int l = key.length / 2; l < key.length; l++) {
                        for (int t = 0; t < toSearch.length; t++) {
                            if (toSearch[t] == key[])
                        }
                    }
                    
                    
                }
                
            }
            
            
        }
        
        
        
        
    }
    
    
    
}
