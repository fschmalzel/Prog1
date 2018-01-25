package Aufgabe2;

public class Bisection {
    
    // Teilaufgabe a) Bisektion
    public static double bisection(double lower, double upper, double epsilon) {
        double middle = (upper + lower) / 2;
        double fmiddle = f(middle);
        
        while (fmiddle > epsilon || fmiddle < -epsilon) {
            if (fmiddle > 0)
                upper = middle;
            else
                lower = middle;
            middle = (upper + lower) / 2;
            fmiddle = f(middle);
        }
        return middle;
    }
    
    // Teilaufgabe b) rekursive Bisektion
    public static double recBisection(double lower, double upper, double epsilon) {
        double middle = (upper + lower ) / 2;
        double fmiddle = f(middle);
        if (fmiddle <= epsilon && fmiddle >= -epsilon)
            return middle;
        if (fmiddle > 0)
            upper = middle;
        else
            lower = middle;
        return recBisection(lower, upper, epsilon);
    }
    
    /*
     * Teilaufgabe c)
     * 
     * 
     * 
     * 
     * 
     */
    
    
    // Beispiel Funktion
    public static double f(double x) {
        return x;
        
        // Sollte nicht funktionieren (endlos Schleife)
        //return Math.abs(x) + 1;
    }
    
    // Zum Testen
    public static void main(String[] args) {
        System.out.println(bisection(-1000, 1000, 0));
        System.out.println(recBisection(-1000, 1000, 0));
    }
    
    
}
