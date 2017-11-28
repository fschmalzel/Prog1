package teilA;

import java.io.IOException;

public class CryptoTest {
    public static void main(String[] args) throws IOException {
        
        // Einlesen des zu verschl�sselnden Arrays
        int[] input = CharArrayOps.getLine("Bitte eine Zeile Text eingeben");
        CharArrayOps.print(input);
        // Erstellen eines Backups des Arrays
        int[] backup = CharArrayOps.copyArray(input);
        
        
        // Caesar-Verschl�sselung
        System.out.println("\nCaesar-Verschl�sselung:");
        
        // Verschl�sseln und ausgeben
        Crypto.encryptCeasar(input, 1);
        CharArrayOps.print(input);
        
        // Entschl�sseln und ausgeben
        Crypto.decryptCeasar(input, 1);
        CharArrayOps.print(input);
        
        // Schauen, ob das Entschl�sselte dem Original entspricht.
        System.out.println(CharArrayOps.compare(input, backup) ? "Alles richtig!" : "Irgendwo ist ein Fehler unterlaufen!");
        
        // Bijektive-Verschl�sselung
        int[] key = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'
        };
        
        System.out.println("\nBijektive-Verschl�sselung:");
        
        Crypto.encryptBijective(input, key);
        CharArrayOps.print(input);
        
        Crypto.decryptBijective(input, key);
        CharArrayOps.print(input);
        
        System.out.println(CharArrayOps.compare(input, backup) ? "Alles richtig!" : "Irgendwo ist ein Fehler unterlaufen!");
        
        
        // Bijektive-Verschl�sselung
        
        System.out.println("\nEXOR-Verschl�sselung:");
        
        long exorKey = 0xB13A_DE29_32F9_189CL;
        
        // 64 Pl�tze mit je 2 M�glichkeiten, also 2^64 viele M�glichkeiten
        // also 18446744073709551616 viele M�glichkeiten,
        // obwohl manche Schl�ssel sinnlos sind
        Crypto.encryptEXOR(input, exorKey);
        CharArrayOps.print(input);
        
        Crypto.decryptEXOR(input, exorKey);
        CharArrayOps.print(input);
        
        System.out.println(CharArrayOps.compare(input, backup) ? "Alles richtig!" : "Irgendwo ist ein Fehler unterlaufen!");
        
        
        
    }
}
