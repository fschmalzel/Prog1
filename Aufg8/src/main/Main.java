package main;

public class Main {
    
    public static int i = 0;
    
    public static void main(String[] args) {
        double lower = -10000;
        double upper = 10000;
        double epsilon = 1;
        
        double nullPosition = bisectIterativly(lower, upper, epsilon);
        System.out.println("Schleifendurchläufe: " + i);
        
        System.out.println("Näherungsweise Nullstelle an " + nullPosition + " mit Wert " + f(nullPosition));
        
        i = 0;
        nullPosition = bisectRecursivly(lower, upper, epsilon);
        System.out.println("Schleifendurchläufe: " + i);
        
        System.out.println("Näherungsweise Nullstelle an " + nullPosition + " mit Wert " + f(nullPosition));
        
        
    }
    
    
    
    public static double bisectIterativly(double lower, double upper, double epsilon) {
        double middle, middleY;
        
        do {
            middle = (lower+upper)/2;
            middleY = f(middle);
            if (middleY > 0)
                upper = middle;
            else
                lower = middle;
            
            i++;
        } while(Math.abs(middleY) > epsilon);
        
        return middle;
        
    }
    
    public static double bisectRecursivly(double lower, double upper, double epsilon) {
        double middle = (lower+upper)/2;
        double middleY = f(middle);
        i++;
        if (Math.abs(middleY) <= epsilon)
            return middle;
        
        if (middleY > 0)
            upper = middle;
        else
            lower = middle;
        
        return bisectRecursivly(lower, upper, epsilon);
    }
    
    public static double f(double x) {
        return Math.pow(x, 3) - 24 * Math.pow(x,2) + 59 * x + 420;
//        return -1/Math.exp(x) + 1e20;
    }
    
    
    
}
