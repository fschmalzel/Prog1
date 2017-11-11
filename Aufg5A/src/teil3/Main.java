package teil3;

public class Main {

    public static void main(String[] args) {

        char indentChar = ' ';
        char fillChar = '+';

        int triangleBaseLength = 9;
        int fillWidth = triangleBaseLength;

        int verticalRepeats = 5;
        int horizontalRepeats = 3;

        for (int horizontalRun = 0; horizontalRun < horizontalRepeats; horizontalRun++) {

            for (int indentIncrement = 1; indentIncrement >= -1; indentIncrement -= 2) {

                int indentWidth = (triangleBaseLength - fillWidth) / 2;
                while (fillWidth > 0 && fillWidth <= triangleBaseLength) {

                    for (int verticalRun = 0; verticalRun < verticalRepeats; verticalRun++) {

                        for (int j = 0; j < indentWidth; j++) {
                            System.out.print(indentChar);
                        }

                        for (int j = 0; j < fillWidth; j++) {
                            System.out.print(fillChar);
                            // System.out.print((j == 0 || j == fillWidth - 1) ? fillChar : indentChar);
                        }

                        for (int j = 0; j < indentWidth; j++) {
                            System.out.print(indentChar);
                        }
                        
                    }

                    indentWidth += indentIncrement;
                    fillWidth = triangleBaseLength - 2 * indentWidth;
                    System.out.println();

                }

                fillWidth = 3;
                
            }

            fillWidth = triangleBaseLength - 2;
            
        }

    }

}
