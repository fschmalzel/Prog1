package teilA;

public class HideInfo {
    
    public static void main(String[] args) {
        
        
        
        
        
    }
    
    public static void replaceChars(int[] array) {
        CharArrayOps.replace(array, 'e', 'i');
        CharArrayOps.replace(array, 'a', 'u');
    }
    
    public static int[] insertEs(int[] array) {
        
        for (int i = 1; i < array.length*2; i += 2) {
            array = CharArrayOps.insert(array, 'e', i);
        }
        
        return array;
        
    }
    
    public static int[] insertSecretArray(int[] array, int[] toInsert) {
        
        for (int i = 1; i < array.length*2; i += 2) {
            array = CharArrayOps.insert(array, 'e', i);
        }
        
        return array;
        
    }
    
    
}
