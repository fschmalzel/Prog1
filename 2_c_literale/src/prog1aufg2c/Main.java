package prog1aufg2c;

public class Main {

    public static void main(String[] args) {
        
        // Addition
        System.out.println("324 + 43: " + (324 + 43)); // 367
        System.out.println("3.34e2 + 1.12e5: " + (3.34e2 + 1.12e5)); // 112334.0
        System.out.println();
        
        // Subtraktion
        System.out.println("25 - 32: " + (25 - 32)); // -7
        System.out.println("65.9e1 - 6.3: " + (65.9e1 - 6.3)); // 652.7
        System.out.println();
        
        // Multiplikation
        System.out.println("2632 * 82: " + (2623 * 82)); // 215086
        System.out.println("5.51 * 3.75e3: " + (5.51 * 3.75e3)); // 20662.5
        System.out.println();
        
        // Division
        System.out.println("4 / 3: " + (4 / 3)); // 1
        System.out.println("43.23e2 / 3.21: " + (43.23e2 / 3.21)); // 1346.728971962617
        System.out.println();

        // Ungerade Zahlen durch 2 geteilt
        System.out.println("7 / 2: " + (7 / 2)); // 3 (Nachkommastellen werden ignoriert (Ganzzahl))
        System.out.println("7.0e1 / 2.0: " + (7.0e1 / 2.0)); // 35.0
        System.out.println();
        
        /* 
         * Große Zahlen:
         * 
         * The literal 123543534345234 of type int is out of range
         * Vorkommastellen:
         * The literal 3232132321231231231234543435252342245235234523466454536435256436345634573476543657546745674567456745674567546745674567547645764576457456745674567546745675674574567408674776453452345235324525344434523452343452345323452345234532452345234532453453453453453453453453453453453454353453453534534534534534542432234.4e2 of type double is out of range
         * 
         * Nachkommastellen
         * können theoretisch unendlich lang sein, da die am wenigsten signifikanten Stellen wahrscheinlich abgeschnitten werden
         * 
         * Exponent:
         * The literal 32334.423e304 of type double is out of range
         */
        
        // Addition maximaler Werte
        System.out.println("2147483647 + 2147483647: " + (2147483647 + 2147483647)); // -2
        System.out.println("1.797693e308 + 1.797693e308: " + (1.797693e308 + 1.797693e308)); // Infinity
        System.out.println();
        
        // Multiplikation maximaler Werte
        System.out.println("2147483647 * 2147483647: " + (2147483647 * 2147483647)); // 1
        System.out.println("1.797693e308 * 1.797693e308: " + (1.797693e308 * 1.797693e308)); // Infinity
        System.out.println();
        
        // Positive Zahl geteilt durch 0
        // System.out.println("7 / 0: " + (7 / 0));
        /*
         * Exception in thread "main" java.lang.ArithmeticException: / by zero
         * at prog1aufg2c.Main.main(Main.java:24)
         */
        System.out.println("7.0 / 0.0: " + (7.0 / 0.0)); // Infinity
        System.out.println();
        
        // Negative Zahl geteilt durch 0
        //System.out.println("-7 / 0: " + (-7 / 0));
        /*
         * Exception in thread "main" java.lang.ArithmeticException: / by zero
         * at prog1aufg2c.Main.main(Main.java:32)
         */
        System.out.println("-7.0 / 0.0: " + (-7.0 / 0.0)); // -Infinity
        System.out.println();
        
        // 0 geteilt durch 0
        //System.out.println("0 / 0: " + (0 / 0));
        /*
         * Exception in thread "main" java.lang.ArithmeticException: / by zero
         * at prog1aufg2c.Main.main(Main.java:40)
         */
        System.out.println("0.0 / 0.0: " + (0.0 / 0.0)); // NaN (Not a Number)
        System.out.println();
        
    }

}
