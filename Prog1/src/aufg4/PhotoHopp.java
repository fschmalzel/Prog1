package aufg4;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import javax.swing.*;

public class PhotoHopp {
    public static void main(String[] args) throws IOException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image srcImage1 = toolkit.getImage("river.gif");
        Image srcImage2 = toolkit.getImage("fki_start.jpg");
        Image srcImage3 = toolkit.getImage("farbenkreis_b.gif");
        Image srcImage4 = toolkit.getImage("avatar.jpg");

        ImageFilter colorfilter = new TestFilter();
        Image filteredImage1 = toolkit.createImage(
            new FilteredImageSource(srcImage1.getSource(), colorfilter));
        Image filteredImage2 = toolkit.createImage(
            new FilteredImageSource(srcImage2.getSource(), colorfilter));
        Image filteredImage3 = toolkit.createImage(
            new FilteredImageSource(srcImage3.getSource(), colorfilter));
        Image filteredImage4 = toolkit.createImage(
            new FilteredImageSource(srcImage4.getSource(), colorfilter));

        JFrame frame = new JFrame("Images and pixelwise filtering");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.RED);
        Panel allImagesPanel = new Panel();
        allImagesPanel.setLayout(new GridLayout(0, 4));
        allImagesPanel.add(new ImagePanel(srcImage1));
        allImagesPanel.add(new ImagePanel(srcImage2));
        allImagesPanel.add(new ImagePanel(srcImage3));
        allImagesPanel.add(new ImagePanel(srcImage4));
        allImagesPanel.add(new ImagePanel(filteredImage1));
        allImagesPanel.add(new ImagePanel(filteredImage2));
        allImagesPanel.add(new ImagePanel(filteredImage3));
        allImagesPanel.add(new ImagePanel(filteredImage4));
        frame.getContentPane().add(allImagesPanel);
        frame.setBounds(50, 50, 1500, 500);
        frame.setVisible(true);
    }
}

class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(Image image) {
        this.image = image;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // System.out.println("paintComponent" + this + image.getWidth(this) + " " + image.getHeight(this));
        g.drawImage(image, 10, 10, image.getWidth(this), image.getHeight(this), this);
    }
}

class TestFilter extends RGBImageFilter {

    public int filterRGB(int x, int y, int pixel) {

        /*
         * Aufspalten des Pixels in die einzelnen Komponenten, indem man eine Maske auf
         * den Pixel anwendet und die herauskommende Zahl anschließend noch nach rechts
         * schiebt um einen Wert zwischen 0 und 255 zu erhalten mit dem man einfach
         * arbeiten kann.
         */
        int a = ((0xFF << 8 * 3) & pixel) >>> 8 * 3; // Alpha
        int r = ((0xFF << 8 * 2) & pixel) >>> 8 * 2; // Rot
        int g = ((0xFF << 8 * 1) & pixel) >>> 8 * 1; // Grün
        int b = ((0xFF << 8 * 0) & pixel) >>> 8 * 0; // Blau

        // a - j
        char aufgabe = 'a';

        // r / g / b
        char teilAufgabeB = 'r';

        // g (Graustufen) / b (Schwarz & Weiß)
        char teilAufgabeG = 'g';

        // 1 - 5
        char teilAufgabeI = '1';

        // 1 - 2
        char teilAufgabeJ = '1';

        switch (aufgabe) {
        default:
        case 'a':
            // Ersetzen aller Pixel mit dem Pixel 0xFF80_7E03
            a = 0xFF;
            r = 0x80;
            g = 0x7E;
            b = 0x03;
            break;

        case 'b':
            // Nur Rot, Grün oder Blau
            switch (teilAufgabeB) {
            default:
            case 'r':
                // Nur Rot
                g = b = 0;
                break;
            case 'g':
                // Nur Grün
                r = b = 0;
                break;
            case 'b':
                // Nur Blau
                r = g = 0;
                break;
            }
            break;

        case 'c':
            // Austauschen des Rot und Blauwerts
            {
                int temp = r;
                r = b;
                b = temp;
            }
            break;

        case 'd':
            // Nur helle oder dunkle Pixel
            {
                // Berechnung der Helligkeit
                int lum = (r + g + b) / 3;
    
                // Falls die Helligkeit kleiner als 2/3 des Maximums und größer als 1/3 des
                // Maximums ist,
                // dann ist der Pixel schwarz, ansonsten wird er ganz normal dargestellt
                if (lum < 256 * (2 / 3) && lum > 256 * (1 / 3)) {
                    a = 0xFF;
                    r = g = b = 0;
                }
            }
            break;

        case 'e':
            // Setzen der Transparenz auf 50%
            a = 0x7F;
            break;

        case 'f':
            // Aufhellen
            {
                // Konvertierung in das YUV Farbmodell
                double colorY = 0.299 * r + 0.587 * g + 0.114 * b;
                double colorU = (b - colorY) * 0.493;
                double colorV = (r - colorY) * 0.877;
    
                // Erhöhung der Helligkeit
                colorY += 50;
    
                // Konvertierung zurück in das RGB Farbmodell
                r = (int) (colorY + colorV / 0.877);
                b = (int) (colorY + colorU / 0.493);
                g = (int) (1.704 * colorY - 0.509 * r - 0.194 * b);
            }
            break;

        case 'g':
            // Graustufen / Schwarz & Weiß
            switch (teilAufgabeG) {
            default:
            case 'g':
                // Graustufen
                // Die RGB-Werte müssen gleich groß sein und
                // den Wert des Durchschnitts der ursprünglichen RGB-Werte haben.
                r = g = b = (r + g + b) / 3;
                break;

            case 'b':
                // Schwarz & Weiß
                {
                    // Berechnung der Helligkeit
                    int lum = (r + g + b) / 3;
    
                    // Falls die Helligkeit größer als die Hälfte des Maximalwerts ist, dann ist es
                    // weiß
                    // ansonsten sind die Pixel schwarz.
                    r = g = b = (lum > (0xFF / 2)) ? 0xFF : 0x00;
                }
                break;

            }
            break;

        case 'h':
            // Negation der Farbwerte (Negativbild)
            r = ~r;
            g = ~g;
            b = ~b;
            break;

        case 'i':
            // Nutzung der Koordinaten
            switch (teilAufgabeI) {
            default:
            case '1':
                // Das Bild wird nur in den oberen linken 100x100 Pixel angezeigt, der Rest ist
                // schwarz
                if (x > 100 || y > 100) {
                    r = g = b = 0x00;
                    a = 0xFF;
                }
                break;

            case '2':
                /*
                 * Muster
                 * 
                 * x % 2 ist ist nur bei jeder zweiten Zahl 0 und ist damit abwechselnd wahr /
                 * falsch. y%2 ist 1 in jeder zweiten Zeile und verschiebt damit das Muster in
                 * der Zeile. Falls dieser Ausdruck wahr ist, soll der Pixel schwarz sein, wenn
                 * nicht soll er weiß sein.
                 */
                r = g = b = ((x + y % 2) % 2 == 0) ? 0x00 : 0xFF;
                break;

            case '3':
                // Nicht sichtbares Muster

                // Der Rot Wert wird in jedem zweiten Pixel um 1 angehoben
                r += (x + y % 2) % 2;
                break;

            case '4':
                // Fading
    
                /*
                 * Berechnung der Distanz zur Mitte, ausgehend davon dass das Bild 200x200 Pixel
                 * groß ist Die minimale Distanz zum Rand ist damit 100 Pixel, nachdem der Rand
                 * weiß sein soll, muss das Offset an dieser Stelle minimal 255 sein, deswegen
                 * wird die Distanz mal 2.55 genommen.
                 */
                {
                    int offset = (int) (Math.sqrt(Math.pow(x - 100, 2) + Math.pow(y - 100, 2)) * 2.55);
    
                    r += offset;
                    g += offset;
                    b += offset;
                }
                break;

            case '5':
                // Muster von diagonalen Linien

                // Falls ein Pixel auf dieser Linie liegt wird er invertiert
                if ((x + y % 20) % 20 <= 1 || (x - y % 20 + 20) % 20 <= 1) {
                    r = ~r;
                    g = ~g;
                    b = ~b;
                }

                break;
            }
            break;

        case 'j':
            // Eigene Spielereien
            switch (teilAufgabeJ) {
            default:
            case '1':
                // Lässt die Pixel türkis werden
                b = r + g + b;
                g = r + g;
                break;

            case '2':

                // Interessanter Effekt der durch Underflows hervorgerufen wird, wie man es
                // z. B. von einer beschädigten Datei kennt
                {
                    int offset = (int) (Math.abs(x - 100) * 2.55 + Math.abs(y - 100) * 2.55);
    
                    r -= offset;
                    g -= offset;
                    b -= offset;
                }
                break;
            }

            break;
        }

        // Überprüfen ob die Werte ihren 8-bit Wertebereich übersteigen und falls doch
        // ist der Wert der Maximalwert
        a = (a > 0xFF) ? 0xFF : a;
        r = (r > 0xFF) ? 0xFF : r;
        g = (g > 0xFF) ? 0xFF : g;
        b = (b > 0xFF) ? 0xFF : b;

        /*
         * Zusammenfügen der Pixel in dem man die einzelnen Komponenten wieder an die
         * richtige Stelle bringt und anschließend addiert oder bitweise ODERt |.
         */
        return (a << 8 * 3) | (r << 8 * 2) | (g << 8 * 1) | (b << 8 * 0);
    }
}