package main;

public class Bisection {
    
    public static int i;
    
    public static void main(String[] args) {
        double lower = -10000;
        double upper = 10000;
        double epsilon = 1;
        
        i = 0;
        double nullPosition = bisectIterativly(lower, upper, epsilon);
        System.out.println("N�herungsweise Nullstelle an " + nullPosition +
                " mit Wert " + f(nullPosition) + ". Schleifendurchl�ufe: " + i);
        
        i = 0;
        nullPosition = bisectRecursivly(lower, upper, epsilon);
        System.out.println("N�herungsweise Nullstelle an " + nullPosition +
                " mit Wert " + f(nullPosition) + ". Schleifendurchl�ufe: " + i);
        
        
    }
    
    
    
    public static double bisectIterativly(double lower, double upper, double epsilon) {
        double middle, middleY;
        
        do {
            // Berechnung der Mitte und des zugeh�rigen Werts
            middle = (lower+upper)/2;
            middleY = f(middle);
            
            // Wenn der Wert von f(x) an der Stelle middle positiv ist, dann muss der obere Wert ersetzt werden sonst der untere
            if (middleY > 0)
                upper = middle;
            else
                lower = middle;
            
            // Z�hlen der Schleifendurchl�ufe
            i++;
            
            // Solange das Ergebnis gr��er epsilon ist, ist die gew�nschte Genauigkeit noch nicht erreicht
        } while(Math.abs(middleY) > epsilon);
        
        return middle;
        
    }
    
    public static double bisectRecursivly(double lower, double upper, double epsilon) {
        // Berechnung der Mitte und des zugeh�rigen Wertes
        double middle = (lower+upper)/2;
        double middleY = f(middle);
        
        // Z�hlen der Schleifendurchl�ufe
        i++;
        
        // Falls die gew�nschte Genauigkeit erreicht wurde, kann man das Ergebnis zur�ckgeben
        if (Math.abs(middleY) <= epsilon)
            return middle;
        
        // Wenn der Wert von f(x) an der Stelle middle positiv ist, dann muss der obere Wert ersetzt werden sonst der untere
        if (middleY > 0)
            upper = middle;
        else
            lower = middle;
        
        // Dann wird die Methode erneut aufgerufen bis die Genauigkeit erreicht wird, oder eine Exception kommt
        return bisectRecursivly(lower, upper, epsilon);
    }
    
    public static double f(double x) {
        return Math.pow(x, 3) - 24 * Math.pow(x,2) + 59 * x + 420;
//        return -1/Math.exp(x) + 1e20;
    }
    
    
    
}
