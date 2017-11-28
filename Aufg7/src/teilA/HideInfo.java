package teilA;

public class HideInfo {
    
    // Ersetzen der Zeichen
    public static void part1(int[] array) {
        CharArrayOps.replace(array, 'e', 'i');
        CharArrayOps.replace(array, 'a', 'u');
    }
    
    // Einfügen eines 'e's an jeder 2ten Stelle
    public static int[] part2(int[] array) {
        int len = array.length;
        for (int i = 1; i < len*2 - 1; i += 2) {
            array = CharArrayOps.insert(array, 'e', i);
        }
        
        return array;
        
    }
    
    // Einfügen eines Arrays an jeder zweiten Stelle
    public static int[] part3(int[] array, int[] toInsert) {
        int len = array.length;
        for (int i = 0; i < len && i < toInsert.length; i ++) {
            array = CharArrayOps.insert(array, toInsert[i], i*2 + 1);
        }
        
        return array;
        
    }
    
    // Löschen der Vokale
    public static int[] part4(int[] array) {
        
        array = CharArrayOps.delete(array, 'a');
        array = CharArrayOps.delete(array, 'e');
        array = CharArrayOps.delete(array, 'i');
        array = CharArrayOps.delete(array, 'o');
        array = CharArrayOps.delete(array, 'u');
        // https://de.wikipedia.org/wiki/Y
        array = CharArrayOps.delete(array, 'y');
        
        return array;
    }
    
}
