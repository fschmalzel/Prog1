package main;

public class Main {
    
    public static void main(String[] args) {
        int i = 0xFFFF_FFFF;
        int j = 0x0000_0000;
        
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);
        System.out.println(Integer.toBinaryString(j));
        i = -i;
        j = -j;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(j));
        
    }
    
}
