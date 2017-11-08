package main;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        long zahl;
        
        Scanner in = new Scanner(System.in);
        zahl = in.nextLong();
        in.close();
        
        if ( zahl <= 1 ) {
            System.out.println("Eine Primzahl muss größer als 1 sein!");
            return;
        }
        
        for ( long i = zahl - 1; i >= 2; i--) {
            if ( zahl % i == 0 ) {
                System.out.println("Keine Primzahl, da " + i + " ein Faktor von " + zahl + " ist!");
                return;
            }
        }
        
        System.out.println(zahl + " ist eine Primzahl!");
        
    }
    
}