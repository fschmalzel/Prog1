package Aufgabe1;

public class Ausgaben {
    
    public static void main(String[] args) {
        int i = 0;
        System.out.println("A:" + i++ + " " + i);
        // A: 0 1
        
        i = 0;
        System.out.println("B:" + --i + " " + i++ + " " + i);
        // B: -1 -1 0
        
        char c = 'b';
        System.out.println("C:" + ('d' - c));
        // C: 2
        
        i = 6;
        System.out.println("D:" + (i >> 2) + " " + i);
        // D: 1 6
        
        i = 0x6;
        System.out.println("E:" + (i & 0x2));
        System.out.println("F:" + (i | 0x2));
        // E: 2
        // F: 6
        
        float f = Float.MAX_VALUE;
        System.out.println("G:" + (f+f));
        // G: Infinity

        String s1= new String("hallo"); String s2 = new String("hallo");
        System.out.println("H:" + (s1 == s2) + " " + s1.equals(s2));
        // H: false true
    }
    
}
