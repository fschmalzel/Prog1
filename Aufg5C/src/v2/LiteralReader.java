package v2;

public class LiteralReader {

    public static void main(String[] args) throws Exception {
        final int STATE_INITIAL = 0;
        final int STATE_SIGN = 1;
        final int STATE_DEC = 2;
        final int STATE_WRONG = 3;
        final int STATE_COMPL = 4;
        final int STATE_CLEAR = 5;
        final int STATE_TYPE = 6;
        final int STATE_HEX = 7;
        final int STATE_OCT = 8;
        final int STATE_BIN = 9;
        
        int currentState = STATE_INITIAL;
        int column = 0;
        int sign = 1;
        int value = 0;
        // The amount of digits without leading zeros that have been read
        int digits = 0;
        // Is it the first digit to be read, important for the '_'
        boolean firstNumber = true;
        // Was the previous character a '_', is being checked in STATE_COMPL
        boolean previousUnderscore = false;

        System.out.println("enter literal");
        while (true) {
            char c = (char) System.in.read();
            column++;

            // check input and make state transitions triggered by input
            switch (currentState) {
            case (STATE_INITIAL):
                // reset values
                value = 0;
                sign = 1;
                column = 1;
                digits = 0;
                firstNumber = true;
                previousUnderscore = false;

                if ((c == 'q') || (c == 'Q')) {
                    System.out.println("bye");
                    return;
                } else if ('1' <= c && c <= '9')
                    currentState = STATE_DEC;
                else if (c == '0') {
                    // The number has to be a oct, hex or bin number, which has to be
                    // determined by the next input
                    currentState = STATE_TYPE;
                    continue;
                } else if ((c == '+') || (c == '-'))
                    currentState = STATE_SIGN;
                else if ((c == '\r') || (c == '\n'))
                    ; // still no real input, nothing to do
                else
                    currentState = STATE_WRONG;
                break;


            case (STATE_SIGN):
                // See STATE_INITIAL, just without the sign.
                if ('1' <= c && c <= '9')
                    currentState = STATE_DEC;
                else if ( c == '0')
                    currentState = STATE_TYPE;
                else
                    currentState = STATE_WRONG;
                break;

            case (STATE_BIN):
                if ('0' <= c && c <= '1') { // nothing to do
                } else if (c == '_') {
                    // If the first number is to be read, but a '_'
                    // has been read it is not a valid literal
                    if (firstNumber)
                        currentState = STATE_WRONG;
                } else if ( ((c == '\r') || (c == '\n')) && !previousUnderscore && !firstNumber)
                    // There has to be one digit, because '0b' is not valid and the
                    // previous symbol is not allowed to be a '_' because '0b0_' is
                    // also not a valid literal
                    currentState = STATE_COMPL;
                else
                    currentState = STATE_WRONG;
                break;
                
            case (STATE_OCT):
                if ('0' <= c && c <= '7') { // nothing to do
                } else if (c == '_') {
                    if (firstNumber)
                        currentState = STATE_WRONG;
                } else if ( ((c == '\r') || (c == '\n')) && !previousUnderscore && !firstNumber)
                    currentState = STATE_COMPL;
                else
                    currentState = STATE_WRONG;
                break;
                
            case (STATE_DEC):
                if ('0' <= c && c <= '9') { // nothing to do
                } else if (c == '_') {
                    if (firstNumber)
                        currentState = STATE_WRONG;
                } else if ( ((c == '\r') || (c == '\n')) && !previousUnderscore && !firstNumber)
                    currentState = STATE_COMPL;
                else
                    currentState = STATE_WRONG;
                break;
                
            case (STATE_HEX):
                if ('0' <= c && c <= '9' || 'a' <= c && c <= 'f' || 'A' <= c && c <= 'F') { // nothing to do
                } else if (c == '_') {
                    if (firstNumber)
                        currentState = STATE_WRONG;
                } else if ( ((c == '\r') || (c == '\n')) && !previousUnderscore && !firstNumber)
                    currentState = STATE_COMPL;
                else
                    currentState = STATE_WRONG;
                break;
            
            case (STATE_TYPE):
                if (c == 'b') {
                    // Input is now a '0b' so it has to be a binary number
                    currentState = STATE_BIN;
                    // We need to continue, so that the b is not interpreted
                    continue;
                } else if ('0' <= c && c <= '7' || c == '_') {
                    // Input is now a '01' - '07' which is oct
                    // or a '0_' which can only be valid if the overall number is oct
                    // Here we can't continue because we have to interpret the 0 - 7
                    currentState = STATE_OCT;
                } else if ( c == 'x' ) {
                    // Input is now a '0x' so it has to be a hexadecimal number
                    currentState = STATE_HEX;
                    // We need to continue, so that the x is not interpreted
                    continue;
                } else if ( ((c == '\r') || (c == '\n')) )
                    // 
                    currentState = STATE_COMPL;
                else
                    currentState = STATE_WRONG;
                break;

            case (STATE_CLEAR):
                if ((c == '\r') || (c == '\n'))
                    currentState = STATE_INITIAL;
                break;
                
            default:
                System.out.println("Unknown State: " + currentState);
            }

            if (currentState == STATE_WRONG) {
                System.out.println("Fehlerhafte Eingabe an Position : " + column);
                
                if ((c == '\r') || (c == '\n'))
                    currentState = STATE_INITIAL;
                else
                    currentState = STATE_CLEAR;
                continue;
            }

            if (currentState == STATE_COMPL) {
                System.out.println("ermittelter int-Wert: " + value);
                currentState = STATE_INITIAL;
                continue;
            }
            
            firstNumber = false;
            
            if (c == '_') {
                previousUnderscore = true;
                continue;
            } else {
                previousUnderscore = false;
            }
            
            // now interpret unicode character
            int cipherValue = 0;
            if ('0' <= c && c <= '9')
                cipherValue = c - '0';
            else if ('a' <= c && c <= 'f')
                cipherValue = c - 'a' + 10;
            else if ('A' <= c && c <= 'F')
                cipherValue = c - 'A' + 10;
            else if (c == '-')
                sign = -1;

            // apply Horner
            switch (currentState) {
            case (STATE_DEC):
                // Kontrollfrage: Warum die Fallunterscheidung fuer neg. bzw. pos. Vorzeichen
                // und nicht einfach zum Schluss sign * errechneter Betrag ?
                if (sign > 0)
                    if ((Integer.MAX_VALUE - cipherValue)/10 >= value )
                        value = value * 10 + cipherValue;
                    else {
                        System.out.println("Zahl zu gross");
                        currentState = STATE_CLEAR;
                    }
            
                if (sign < 0)
                    if ((Integer.MIN_VALUE + cipherValue)/10 <= value )
                        value = value * 10 - cipherValue;
                    else {
                        System.out.println("Zahl zu klein");
                        currentState = STATE_CLEAR;
                    }
                
                break;
                
            case (STATE_BIN):
                if (cipherValue == 0 && digits == 0) {
                    break;
                } else if (digits < 32) {
                    digits += 1;
                    if (sign > 0) {
                        value = value << 1;
                        value += cipherValue;
                    } else {
                        value = - value;
                        value = value << 1;
                        value += cipherValue;
                        value = - value;
                    }
                } else {
                    System.out.println("Zu viele Stellen!");
                    currentState = STATE_CLEAR;
                }
                break;
                
            case (STATE_OCT):
                if (cipherValue == 0 && digits == 0) {
                    break;
                } else if (digits < 30) {
                    if (digits == 0 && cipherValue <= 3)
                        digits += 2;
                    else
                        digits += 3;
                    
                    if (sign > 0) {
                        value = value << 3;
                        value += cipherValue;
                    } else {
                        value = - value;
                        value = value << 3;
                        value += cipherValue;
                        value = - value;
                    }
                } else {
                    System.out.println("Zu viele Stellen!");
                    currentState = STATE_CLEAR;
                }
                break;
            
            case (STATE_HEX):
                if (cipherValue == 0 && digits == 0) {
                    break;
                } else if (digits < 32) {
                    // Wenn es weniger als 32 Zahlen ohne führende 0 sind können
                    // noch Zahlen eingelesen werden
                    digits += 4;
                    // Nachdem es eine Hexzahl ist kommen 4 bits hinzu
                    if (sign > 0) {
                        // Die bits um 4 nach links schieben und an
                        // die 4 leeren Stellen den Wert reinsetzen
                        value = value << 4;
                        value += cipherValue;
                    } else {
                        // Falls das Vorzeichen negativ ist muss am Schluss das Komplement gebildet
                        // werden, was auch heißt das ich davon ausgehe das ich ein Komplement reinkriege
                        
                        // Deswegen wechsle ich das Vorzeichen, schiebe den Wert 4 nach rechts
                        // fülle die Lücke mit den neuen Bits und wechsle das Vorzeichen wieder
                        value = - value;
                        value = value << 4;
                        value += cipherValue;
                        value = - value;
                    }
                } else {
                    // Falls die Zahl schon 32 signifikante Stellen beinhalten, können keine mehr
                    // hinzugefügt werden, da sonst vorne Zahlen verloren gehen
                    // Deswegen der Fehler mit zu vielen Stellen
                    System.out.println("Zu viele Stellen!");
                    currentState = STATE_CLEAR;
                }
                
                break;
                
                
            }
        }
    }
}