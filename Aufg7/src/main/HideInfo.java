package main;

public class HideInfo {
    
    /**
     * Hides info by replacing
     * 'e's by 'i's and
     * 'a's by 'u's.
     * 
     * @param array The array which will be modified
     */
    public static void part1(int[] array) {
        CharArrayOps.replace(array, 'e', 'i');
        CharArrayOps.replace(array, 'a', 'u');
    }
    
    /**
     * Hides info by placing
     * 'e's at every second position.
     * 
     * @param array The array which will be used
     * 
     * @return The new modified array
     */
     public static int[] part2(int[] array) {
        int len = array.length;
        for (int i = 1; i < len*2 - 1; i += 2) {
            array = CharArrayOps.insert(array, 'e', i);
        }
        
        return array;
        
    }
    
    /**
     * Inserts the data of a second array at every second position
     * 
     * @param array The array in which the data will be inserted
     * @param toInsert The data which will be inserted
     * @return The new array with the data inserted
     */
    public static int[] part3(int[] array, int[] toInsert) {
        int len = array.length;
        for (int i = 0; i < len && i < toInsert.length; i ++) {
            array = CharArrayOps.insert(array, toInsert[i], i*2 + 1);
        }
        
        return array;
        
    }
    
    /**
     * Hides info by removing all vocals
     * 
     * @param array The array which will be used
     * @return The new array without vocals
     */
    public static int[] part4(int[] array) {
        array = CharArrayOps.delete(array, 'a');
        array = CharArrayOps.delete(array, 'e');
        array = CharArrayOps.delete(array, 'i');
        array = CharArrayOps.delete(array, 'o');
        array = CharArrayOps.delete(array, 'u');
        // https://de.wikipedia.org/wiki/Y
        // array = CharArrayOps.delete(array, 'y');
        
        return array;
    }
    
}
