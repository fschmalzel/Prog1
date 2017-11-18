package main;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        int[] input = new int[3];
        int index = 0;
        
        int c = System.in.read();
        while (c != '\n' && c != '\r') {
            
            if (index == input.length + 1) {
                int[] input2 = new int[input.length + 1024];
                for (int i = 0; i < input.length; i++) {
                    input2[i] = input[i];
                }
                input = input2;
            }
            
            input[index] = c;
            index++;
            
            c = System.in.read();
        }
        
        for (int i = input.length-1; i >= 0; i--) {
            if (input[i] == ' ')
                index--;
            else
                break;
        }
        
        if (index != input.length-1) {
            int[] input2 = new int[index+1];
            for (int i = 0; i < input2.length; i++) {
                input2[i] = input[i];
            }
            input = input2;
        }
        
        for (int i = 0; i < input.length; i++) {
            System.out.print((char) input[i]);
        }
        System.out.println("|");
        
        System.out.println("Welches Zeichen soll ersetzt werden? Bsp.: 'a->b'");
        
        int fromChar;
        
        do {
            fromChar = System.in.read();
        } while (fromChar == '\n' || fromChar == '\r');
        
        if (System.in.read() != '-') {
            System.out.println("Falsche Eingabe, ein Zeichen wurde erwartet an Stelle 2.");
            return;
        }
        
        if (System.in.read() != '>') {
            System.out.println("Falsche Eingabe, ein Zeichen wurde erwartet an Stelle 3.");
            return;
        }
        
        int toChar = System.in.read();
        
        if (toChar == '\r' || toChar == '\n') {
            System.out.println("Falsche Eingabe, ein Zeichen wurde erwartet an Stelle 1.");
            return;
        }
        
        for (int i = 0; i < input.length; i++) {
            if (input[i] == fromChar)
                input[i] = toChar;
        }
        
        for (int i = 0; i < input.length; i++) {
            System.out.print((char) input[i]);
        }
        System.out.println();
        
        
    }
    
}
