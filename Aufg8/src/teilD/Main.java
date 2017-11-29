package teilD;

public class Main {
    
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
        
        timeForFindPrimes(100, 10);
        timeForFindPrimes2(10);
        
    }
    
    
    public static boolean isPrime(long n) {
        for (long i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
    public static long[] findPrimes(long n) {
        long[] array = new long[0];
        for (long i = n; i >= 2; i--) {
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
    
    public static long numberOfPrimes(int n) {
        int count = 0;
        
        for (int i = n; i >= 2; i--) {
            if(isPrime(i)) {
                count++;   
            }
        }
        return count;
    }
    
    public static void timeForFindPrimes(int steps, int stepSize) {
        for(int i = 1; i <= steps; i++) {
            long time = -System.nanoTime();
            numberOfPrimes(i*stepSize);
            time += System.nanoTime();
            System.out.println(i * stepSize + ";" + time);
            
        }
    }
    
    public static void timeForFindPrimes2(int steps) {
        int n = 2;
        for(int i = 1; i <= steps; i++) {
            long time = -System.nanoTime();
            numberOfPrimes(n);
            time += System.nanoTime();
            System.out.println(n + ";" + time);
            n <<= 1;
            
        }
    }
    
}
