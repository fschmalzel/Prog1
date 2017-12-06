package main;

public class Prime {
    
    public static void main(String[] args) {
        
        System.out.println(isPrime(3));
        System.out.println(isPrime(20));
        System.out.println(isPrime(323));
        
        long n = 80;
        long[] primes = findPrimes(n);
        System.out.println("Von der Stelle " + n + " aus wurden " + primes.length + " viele Primzahlen gefunden!");
        for (long prime : primes) {
            System.out.print(prime + " | ");
        }
        System.out.println();
        
//        timeForFindPrimes(100, 10);
//        timeForFindPrimes2(10);
        
    }
    
    
    public static boolean isPrime(long n) {
        for (long i = 2; i < n; i++) {
            // Falls n sich durch eine Zahl die kleiner als n ist und größer als 1 ist
            // ohne Rest Teilen lässt, dann ist n keine Primzahl, da sie einen Faktor besitzt
            if (n % i == 0)
                return false;
        }
        // Falls dies nicht der Fall ist ist n eine Primzahl
        return true;
    }
    
    public static boolean isPrimeOptimized(int n) {
        // Wenn n größer als 2 ist und sich durch 2 teilen lässt, dann ist es keine Primzahl
        if (n > 2 && n % 2 == 0)
            return false;
        // Damit sind jetzt auch alle geraden Zahlen ausgeschlossen
        
        // Deswegen können wir von der Stelle 3 aus in 2er Schritten weitersuchen
        // Wir müssen auch nur bis n/2 teilen, da 2 der kleinste Primteiler ist
        for (int i = 3; i < n/2+1; i += 2) {
            // Der Test selber ist analog zu isPrime
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
    public static long[] findPrimes(long n) {
        long[] array = new long[0];
        // Finden von Primzahlen zwischen n und 2 einschließlich 2
        for (long i = n; i >= 2; i--) {
            
            // Falls es eine Primzahl ist, wird es in das Array gespeichert
            if(isPrime(i)) {
                
                long[] array2 = new long[array.length+1];
                for (int j = 0; j < array.length; j++) {
                    array2[j] = array[j];
                }
                array = array2;
                array[array.length-1] = i;
                
            }
        }
        return array;
    }
    
    // Gekürzte Variante von findPrimes für die Laufzeitanalyse
    public static long numberOfPrimes(int n) {
        int count = 0;
        
        for (int i = n; i >= 2; i--) {
            if(isPrimeOptimized(i)) {
                count++;   
            }
        }
        return count;
    }
    
    public static void timeForFindPrimes(int steps, int stepSize) {
        for(int i = 1; i <= steps; i++) {
            timingOutput(i*stepSize);
        }
    }
    
    public static void timeForFindPrimes2(int steps) {
        int n = 2;
        for(int i = 1; i <= steps; i++) {
            timingOutput(n);
            n <<= 1;
            
        }
    }
    
    // Kleine Funktion um, das Timing eines einzelnen numberOfPrimes() Aufrufes
    // aufzuzeichnen und auszugeben
    public static void timingOutput(int n) {
        long time = -System.nanoTime();
//        long time2= -java.lang.management.ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
        
        numberOfPrimes(n);
        
//        time2 += java.lang.management.ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
        time += System.nanoTime();
        
        System.out.println(n + ";" + time);// + ";" + time2);
        
    }
    
}
