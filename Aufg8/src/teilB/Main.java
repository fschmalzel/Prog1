package teilB;

public class Main {
    
    public static void main(String[] args) {
        
        double a = 3;
        long n = 3;
        
        System.out.println(potenzIter(a, n));
        System.out.println(potenzRecu(a, n));
        System.out.println(potenzOpti(a, n));
        
        
    }
    
    
    
    
    public static double potenzIter(double a, long n) {
        if (n == 0)
            return 1;
        
        double ergebnis = a;
        for (int i = 1; i < n; i++ ) {
            ergebnis *= a;
        }
        return ergebnis;
    }
    
    public static double potenzRecu(double a, long n) {
        if (n == 1)
            return a;
        else if (n == 0)
            return 1;
        return a * potenzRecu(a, n-1);
    }
    
    public static double potenzOpti(double a, long n) {
        if (n == 1)
            return a;
        else if (n == 0)
            return 1;
        
        return potenzOpti(a, n%2) * potenzOpti(a, n/2) * potenzOpti(a, n/2);
    }
    
    
}
