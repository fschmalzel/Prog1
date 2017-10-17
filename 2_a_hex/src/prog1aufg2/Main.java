package prog1aufg2;

public class Main {
    
    public static void main(String[] args) {
        
        //47 - 49
        int number = 47;
        String hexCode = "2F";
        
        System.out.printf("%03d | %s | %s || ", number, "\u002F", hexCode);
        
        number = 48;
        hexCode = "30";
        
        System.out.printf("%03d | %s | %s || ", number, "\u0030", hexCode);
        
        number = 49;
        hexCode = "31";
        
        System.out.printf("%03d | %s | %s%n", number, "\u0031", hexCode);
        
        
        //64 - 66
        number = 64;
        hexCode = "40";
        
        System.out.printf("%03d | %s | %s || ", number, "\u0040", hexCode);
        
        number = 65;
        hexCode = "41";
        
        System.out.printf("%03d | %s | %s || ", number, "\u0041", hexCode);
        
        number = 66;
        hexCode = "42";
        
        System.out.printf("%03d | %s | %s%n", number, "\u0042", hexCode);
        
        
        //121 - 123
        number = 121;
        hexCode = "79";
        
        System.out.printf("%03d | %s | %s || ", number, "\u0079", hexCode);
        
        number = 122;
        hexCode = "7A";
        
        System.out.printf("%03d | %s | %s || ", number, "\u007A", hexCode);
        
        number = 123;
        hexCode = "7B";
        
        System.out.printf("%03d | %s | %s%n", number, "\u007B", hexCode);
        
    }
    
}
