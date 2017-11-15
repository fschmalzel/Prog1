package main;

public class Main {
    public static void main(String[] args) throws Exception {  
        final char pattern = 'a';         
        int charCounter = 0;
        int patternCounter = 0;
        
        System.out.println("Bitte Zeichen mit abschliess. <return> eingeben ");
        int c;
        while ((c = System.in.read()) != '\r' && c != '\n') {
            if (c < 'a' || c > 'z')  // count lowercase characters only
                continue;
            charCounter++;
            if (c == pattern)
                patternCounter++;
        }

        System.out.println("Anz. char: " + charCounter + ",  Anz. " 
                            + pattern + ": " + patternCounter);    
    }
}