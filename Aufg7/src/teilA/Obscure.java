package teilA;

import java.io.IOException;

public class Obscure {
    
    public static void main(String[] args) throws IOException {
        
        int[] input = CharArrayOps.getLine("Bitte zu verschlüsselnden Text eingeben: ");
        
        int[] input2 = CharArrayOps.copyArray(input);
        HideInfo.part1(input2);
        CharArrayOps.print(input2);
        
        CharArrayOps.print(HideInfo.part2(input));
        
        CharArrayOps.print(HideInfo.part3(input, new int[] {'s', 'e', 'c', 'r', 'e', 't'}));
        
        CharArrayOps.print(HideInfo.part4(input));
        
    }
    
}
