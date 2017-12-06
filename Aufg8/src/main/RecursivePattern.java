package main;

public class RecursivePattern {

    public static void main(String[] args) {
        pattern(3);
    }

    public static void pattern(int n) {
        // Siehe Türme von Hanoi
        if (n==0) System.out.println(n);
        else {
           pattern(n-1);
           for (int i = 0; i < n; i++) {

               System.out.print(n);
               
           }
           System.out.println(n);
           
           pattern(n-1);
        }
        
        
        
    }
}
