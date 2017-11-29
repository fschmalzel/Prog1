package main;

import java.io.IOException;

public class Obscure {
    
    public static void main(String[] args) throws IOException {
        
        int[] input = CharArrayOps.getLine("Bitte zu verschlüsselnden Text eingeben: ");
        
        int[] input2 = CharArrayOps.copyArray(input);
        
        // Ersetzen von 'e's und 'a's
        HideInfo.part1(input2);
        CharArrayOps.print(input2);
        
        // Einfügen von 'e's an jeder zweiten Stelle
        CharArrayOps.print(HideInfo.part2(input));
        
        // Einfügen eines zweiten Arrays an jeder zweiten Stelle
        CharArrayOps.print(HideInfo.part3(input, new int[] {'s', 'e', 'c', 'r', 'e', 't'}));
        
        // Entfernen aller Vokale
        CharArrayOps.print(HideInfo.part4(input));
        
    }
    
}
