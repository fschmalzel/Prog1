package teilA;

import java.io.IOException;

public class CryptoTest {
    public static void main(String[] args) throws IOException {
        
        int[] input = CharArrayOps.getLine("Bitte eine Zeile Text eingeben");
        CharArrayOps.print(input);
        int[] backup = CharArrayOps.copyArray(input);
        
        
        // Ceasar cipher
        System.out.println("\nCaesar-Verschlüsselung:");
        Crypto.encryptCeasar(input, 1);
        CharArrayOps.print(input);
        
        Crypto.decryptCeasar(input, 1);
        CharArrayOps.print(input);
        
        System.out.println(CharArrayOps.compare(input, backup) ? "Alles richtig!" : "Irgendwas hat einen Fehler!");
        
        // Bijective cipher
        int[] key = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'
        };
        
        System.out.println("\nBijektive-Verschlüsselung:");
        
        Crypto.encryptBijective(input, key);
        CharArrayOps.print(input);
        
        Crypto.decryptBijective(input, key);
        CharArrayOps.print(input);
        
        System.out.println(CharArrayOps.compare(input, backup) ? "Alles richtig!" : "Irgendwas hat einen Fehler!");
        
    }
}
