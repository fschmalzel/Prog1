package teil1;

public class Main {
    
    public static void main(String[] args) {
        
        char indentChar = '.';
        char fillChar = '+';
        
        int indentWidth;
        int fillWidth;
        
        int triangleBaseLength = 9;
        int triangleHeight = (triangleBaseLength + 1) / 2;
        
        for (int i = 0; i < triangleHeight; i++) {
            fillWidth = triangleBaseLength - (2 * i);
            indentWidth = (triangleBaseLength - fillWidth) / 2;
            
            for (int j = 0; j < indentWidth; j++) {
                System.out.print(indentChar);
            }
            
            for (int j = 0; j < fillWidth; j++) {
                System.out.print(fillChar);
            }
            
            System.out.println();
        }
        
        int i = 0;
        while(i < triangleHeight) {
            
            fillWidth = triangleBaseLength - (2 * i);
            indentWidth = (triangleBaseLength - fillWidth) / 2;
            
            for (int j = 0; j < indentWidth; j++) {
                System.out.print(indentChar);
            }
            
            for (int j = 0; j < fillWidth; j++) {
                System.out.print(fillChar);
            }
            
            System.out.println();
            
            i++;
        }
        
        
        
    }
    
}
