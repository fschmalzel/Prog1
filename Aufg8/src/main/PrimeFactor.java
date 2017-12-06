package main;

public class PrimeFactor {

    
    public static void main(String[] args) {
        int number = 45765476;
        
        int[] factors = primeFactors(number);
        
        System.out.print("Primfaktorzerlegung von " + number + ": ");
        
        for (int i = 0; i < factors.length - 1; i++)
            System.out.print(factors[i] + " | ");
        
        System.out.println(factors[factors.length-1]);
        
    }
    
    public static int[] primeFactors(int n) {
        int[] factors = new int[0];
        
        for (int i = 2; i <= n/2; i++) {
            
            // Falls n sich durch i teilen lässt, ohne Rest, dann ist i ein Primteiler
            if (n % i == 0) {
                
                // Einfügen des Primfaktors in ein Array
                int[] factors2 = new int[factors.length+1];
                for (int j = 0; j < factors.length; j++)
                    factors2[j] = factors[j];
                factors = factors2;
                factors[factors.length-1] = i;
                
                // n muss ohne den Primfaktor seien um die Weiteren zu finden
                n /= i;
                // Und i muss wieder zurückgesetzt werden
                i = 1;
            }
        }
        
        if (n != 1) {
            // Falls n nicht 1 ist, ist n auch noch ein Primteiler vom ursprünglichen n
            // und muss angefügt werden
            int[] factors2 = new int[factors.length+1];
            for (int j = 0; j < factors.length; j++)
                factors2[j] = factors[j];
            factors = factors2;
            factors[factors.length-1] = n;
        }
        
        // Zurückgeben der Primfaktoren
        return factors;
        
    }
    
}
