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
        
        int[] bijectiveKey2 = bruteForceBijectivKey(input, toSearch);
        
        if (bijectiveKey2[0] >= 0) {
            System.out.println("Der Schlüssel ist: ");
            CharArrayOps.print(bijectiveKey2);
        } else
            System.out.println("Der Schlüssel konnte nicht ermittelt werden!");
        
        int[] test = CharArrayOps.copyArray(input);
        Crypto.decryptBijective(test, bijectiveKey2);
        CharArrayOps.print(test);
        
        System.out.println();
        
        
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
        
        int[] pattern = CharArrayOps.copyArray(toSearch);
        boolean found = false;
        
        for (int i = 0; i < array.length - toSearch.length - 1 && !found; i++) {
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
                    
                    found = true;
                    break;
                    
                }
                
            }
            
        }
        
        if (found) {
            int[] key = new int[('z' - 'a' + 2) * 2];
            
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < key.length/2; j++) {
                    key[i*key.length/2 + j] = 'a' + j;
                }
            }
            
            for (int i = 0; i < key.length/2; i++) {
                
                for (int j = 0; j < toSearch.length; j++) {
                    
                    if (toSearch[j] == key[i]) {
                        int hold = key[i+key.length/2];
                        key[i+key.length/2] = pattern[j];
                        
                        for (int l = 0; l < key.length/2; l++) {
                            if (key[l + key.length/2] == pattern[j]) {
                                
                                key[l + key.length/2] = hold;
                                
                                break;
                            }
                            
                        }
                        
                        break;
                    }
                    
                }
                
                return key;
                
            }
            
        }
        
        return new int[] {-1};
        
    }
    
}
