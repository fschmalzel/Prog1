package main;

public class Potentiation {
    
    public static int counter = 0;
    
    public static void main(String[] args) {
        
        // Zum Testen der Landau Symbole (groﬂ O Notation)
//        for (int i = 3; i < 300; i*=2) {
//            counter = 0;
//            potenzOpti2(a,i);
//            System.out.print(counter + "|");
//        }
//        System.out.println();
        
        // a^n
        double a = 2;
        long n = 256;
        
        counter = 0;
        // O(n)
        printCounterWithResult("Iterativ", a, n, potenzIterativ(a, n));
        
        // O(n)
        printCounterWithResult("Rekursiv", a, n, potenzRecursiv(a, n));

        // O(n)
        printCounterWithResult("Formel", a, n, potenzFormula(a, n));
        
        // O(log(n))
        printCounterWithResult("Optimisiert", a, n, potenzOptimized(a, n));
        
    }
    
    // Ausgabe der Potenzierung, mit der Rechnung, den Namen des Algorithmus und der Anzahl der Multiplikationen
    public static void printCounterWithResult(String name, double a, long n, double result) {
        
        System.out.println(name + ": " + a + "^" + n + " = " + result + " | Dies benˆtigte " + counter + " Multiplikationen.");
        counter = 0;
        
    }
    
    
    public static double potenzIterativ(double a, long n) {
        // Falls n = 0 ist, dann ist das Ergebnis unabh‰ngig von a null
        if (n == 0)
            return 1;
//        else if (n < 0)
//            // "Fehlerausgabe"
//            return -1;
        
        // Jetzt muss a so oft mit einander mal genommen werden wie n groﬂ ist
        // Daf¸r benˆtigt man ein zwischenErgebnis
        double ergebnis = a;
        for (int i = 1; i < n; i++ ) {
            ergebnis *= a;
            
            // Z‰hlen der Multiplikationen
            counter++;
        }
        return ergebnis;
    }
    
    public static double potenzRecursiv(double a, long n) {
        // Falls n = 1 ist, ist das Ergebnis a
        if (n == 1)
            return a;
        // Falls n = 0 ist, ist das Ergebnis unabh‰ngig von a 1.
        else if (n == 0)
            return 1;
//      else if (n < 0)
//      // "Fehlerausgabe"
//          return -1;
        
        // Z‰hlen der Multiplikation
        counter++;
        // Ansonsten muss a * a ^ n-1 genommen werden
        return a * potenzRecursiv(a, n-1);
    }
    
    public static double potenzFormula(double a, long n) {
        if (n == 1)
            return a;
        else if (n == 0)
            return 1;
//      else if (n < 0)
//      // "Fehlerausgabe"
//          return -1;
        
        // Z‰hlen der Multiplikation
        counter += 2;
        
        // Anwender der Formel
        return potenzFormula(a, n%2) * potenzFormula(a, n/2) * potenzFormula(a, n/2);
    }
    
    
    public static double potenzOptimized(double a, long n) {
        // Analog zu Opti2
        
        if (n == 1)
            return a;
        else if (n == 0)
            return 1;
        
        
        // Hier wird ein Zwischenergebnis berechnet, so dass wir potenzOpti nicht
        // zweimal mit den selben Parametern aufrufen m¸ssen
        double zwischenErgebnis = potenzOptimized(a, n/2);
        
        // Z‰hlen der Multiplikationen
        counter += 2;
        return potenzOptimized(a, n%2) * zwischenErgebnis * zwischenErgebnis;
    }
    
}
