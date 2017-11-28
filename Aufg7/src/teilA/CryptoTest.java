package teilA;

import java.io.IOException;

public class CryptoTest {
    public static void main(String[] args) throws IOException {
        
        // Einlesen des zu verschlüsselnden Arrays
        int[] input = CharArrayOps.getLine("Bitte eine Zeile Text eingeben");
        CharArrayOps.print(input);
        // Erstellen eines Backups des Arrays
        int[] backup = CharArrayOps.copyArray(input);
        
        
        // Caesar-Verschlüsselung
        System.out.println("\nCaesar-Verschlüsselung:");
        
        // Verschlüsseln und ausgeben
        Crypto.encryptCeasar(input, 1);
        CharArrayOps.print(input);
        
        // Entschlüsseln und ausgeben
        Crypto.decryptCeasar(input, 1);
        CharArrayOps.print(input);
        
        // Schauen, ob das Entschlüsselte dem Original entspricht.
        System.out.println(CharArrayOps.compare(input, backup) ? "Alles richtig!" : "Irgendwo ist ein Fehler unterlaufen!");
        
        // Bijektive-Verschlüsselung
        int[] key = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'
        };
        
        System.out.println("\nBijektive-Verschlüsselung:");
        
        Crypto.encryptBijective(input, key);
        CharArrayOps.print(input);
        
        Crypto.decryptBijective(input, key);
        CharArrayOps.print(input);
        
        System.out.println(CharArrayOps.compare(input, backup) ? "Alles richtig!" : "Irgendwo ist ein Fehler unterlaufen!");
        
        
        // Bijektive-Verschlüsselung
        
        System.out.println("\nEXOR-Verschlüsselung:");
        
        long exorKey = 0xB13A_DE29_32F9_189CL;
        
        // 64 Plätze mit je 2 Möglichkeiten, also 2^64 viele Möglichkeiten
        // also 18446744073709551616 viele Möglichkeiten,
        // obwohl manche Schlüssel sinnlos sind
        Crypto.encryptEXOR(input, exorKey);
        CharArrayOps.print(input);
        
        Crypto.decryptEXOR(input, exorKey);
        CharArrayOps.print(input);
        
        System.out.println(CharArrayOps.compare(input, backup) ? "Alles richtig!" : "Irgendwo ist ein Fehler unterlaufen!");
        
        
        
    }
}
