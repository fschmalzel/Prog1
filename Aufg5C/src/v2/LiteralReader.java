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
        int digits = 0;
        boolean firstNumber = true;
        boolean previousUnderscore = false;

        System.out.println("enter decimal literal");
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
                    // For now simply allow cipher 0 at every position of a decimal literal,
                    // which is strictly speaking not right for column 1.
                    // But this is the right hook for
                    // your extension concerning hex and oct literals, both starting with 0
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
                    if (firstNumber) {
                        currentState = STATE_WRONG;
                    }
                } else if ( ((c == '\r') || (c == '\n')) && !previousUnderscore && !firstNumber)
                    currentState = STATE_COMPL;
                else
                    currentState = STATE_WRONG;
                break;
                
            case (STATE_OCT):
                if ('0' <= c && c <= '7') { // nothing to do
                } else if (c == '_') {
                    if (firstNumber) {
                        currentState = STATE_WRONG;
                    }
                } else if ( ((c == '\r') || (c == '\n')) && !previousUnderscore && !firstNumber)
                    currentState = STATE_COMPL;
                else
                    currentState = STATE_WRONG;
                break;
                
            case (STATE_DEC):
                if ('0' <= c && c <= '9') { // nothing to do
                } else if (c == '_') {
                    if (firstNumber) {
                        currentState = STATE_WRONG;
                    }
                } else if ( ((c == '\r') || (c == '\n')) && !previousUnderscore && !firstNumber)
                    currentState = STATE_COMPL;
                else
                    currentState = STATE_WRONG;
                break;
                
            case (STATE_HEX):
                if ('0' <= c && c <= '9' || 'a' <= c && c <= 'f' || 'A' <= c && c <= 'F') { // nothing to do
                } else if (c == '_') {
                    if (firstNumber) {
                        currentState = STATE_WRONG;
                    }
                } else if ( ((c == '\r') || (c == '\n')) && !previousUnderscore && !firstNumber)
                    currentState = STATE_COMPL;
                else
                    currentState = STATE_WRONG;
                break;
            
            case (STATE_TYPE):
                if (c == 'b') {
                    currentState = STATE_BIN;
                    continue;
                } else if ('0' <= c && c <= '7') {
                    currentState = STATE_OCT;
                } else if (c == '_') {
                    currentState = STATE_OCT;
                } else if ( c == 'x' ) {
                    currentState = STATE_HEX;
                    continue;
                } else if ( ((c == '\r') || (c == '\n')) && !previousUnderscore)
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
                    digits += 4;
                    if (sign > 0) {
                        value = value << 4;
                        value += cipherValue;
                    } else {
                        value = - value;
                        value = value << 4;
                        value += cipherValue;
                        value = - value;
                    }
                } else {
                    System.out.println("Zu viele Stellen!");
                    currentState = STATE_CLEAR;
                }
                
                break;
                
                
            }
        }
    }
}