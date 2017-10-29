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
            new FilteredImageSource(srcImage1.getSource(),colorfilter));
        Image filteredImage2 = toolkit.createImage(
            new FilteredImageSource(srcImage2.getSource(),colorfilter));
        Image filteredImage3 = toolkit.createImage(
            new FilteredImageSource(srcImage3.getSource(),colorfilter));
        Image filteredImage4 = toolkit.createImage(
            new FilteredImageSource(srcImage4.getSource(),colorfilter));
        
        JFrame frame = new JFrame("Images and pixelwise filtering");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.RED);  
        Panel allImagesPanel = new Panel();
        allImagesPanel.setLayout(new GridLayout(0,4));
        allImagesPanel.add(new ImagePanel(srcImage1));
        allImagesPanel.add(new ImagePanel(srcImage2));
        allImagesPanel.add(new ImagePanel(srcImage3));
        allImagesPanel.add(new ImagePanel(srcImage4));
        allImagesPanel.add(new ImagePanel(filteredImage1));
        allImagesPanel.add(new ImagePanel(filteredImage2));
        allImagesPanel.add(new ImagePanel(filteredImage3));
        allImagesPanel.add(new ImagePanel(filteredImage4));
        frame.getContentPane().add(allImagesPanel);
        frame.setBounds(50,50,1500,500);
        frame.setVisible(true);          
     }
}

class ImagePanel extends JPanel  {
    private Image image;

    public ImagePanel(Image image)  {
        this.image = image;
    }
    
    public void paintComponent(Graphics g) {   
        super.paintComponent(g);
//        System.out.println("paintComponent" + this + image.getWidth(this) + " " + image.getHeight(this));
        g.drawImage(image, 10, 10,image.getWidth(this) , image.getHeight(this), this); 
    }
}
    
    

class TestFilter extends RGBImageFilter {
  
    public int filterRGB(int x, int y, int pixel) {
       
       int a = ((0xFF << 8 * 3) & pixel) >> 8 * 3;
       int r = ((0xFF << 8 * 2) & pixel) >> 8 * 2;
       int g = ((0xFF << 8 * 1) & pixel) >> 8 * 1;
       int b = ((0xFF << 8 * 0) & pixel) >> 8 * 0;
       
       switch('b') {
       default:
       case 'a':
           a = 0xFF;
           r = 0x80;
           g = 0x7E;
           b = 0x03;
           break;
           
       case 'b':
           switch('b') {
           default:
           case 'r':
               g = b = 0;
               break;
           case 'g':
               r = b = 0;
               break;
           case 'b':
               r = g = 0;
               break;
           }
           break;
           
       case 'c':
           int temp = r;
           r = b;
           b = temp;
           break;
           
       case 'd':
           int lum = r + g + b;
           if ( lum < (256 * 3) * (2/3) && lum > (256 * 3) * (1/3)) {
               a = 0xFF;
               r = g = b = 0;
           }
           break;
           
       case 'e':
           a = 0x7F; // Transparenz
           break;
           
       case 'f':
           // Konvertierung in das YUV Farbmodell
           double colorY = 0.299* r + 0.587 * g + 0.114 * b;
           double colorU = (b - colorY) * 0.493;
           double colorV = (r - colorY) * 0.877;
           
           // Erhˆhung der Helligkeit
           colorY += 50;
           
           // Konvertierung zur¸ck in das RGB Farbmodell
           r = (int) (colorY + colorV/0.877);
           b = (int) (colorY + colorU/0.493);
           g = (int) (1.704 * colorY - 0.509 * r - 0.194 * b);
           
           break;
           
       case 'g':
           switch('g') {
           default:
           case 'g':
               // Die RGB-Werte m¸ssen gleich groﬂ sein und
               // den Wert des Durchschnitts der urspr¸nglichen RGB-Werte haben.
               r = g = b = (r + g + b)/3;
               break;
           
           case 'b':
               // Berechnung der Helligkeit
               lum = (r + g + b)/3;
               
               // Falls die Helligkeit grˆﬂer als die H‰lfte des Maximalwerts ist, dann ist es weiﬂ
               // ansonsten sind die Pixel schwarz.
               r = g = b = (lum > (0xFF / 2)) ? 0xFF : 0x00;
               break;
               
           }
           break;
           
       case 'h':
           // Negieren der Farbwerte f¸hrt zu einem Negativbild
           r = ~r;
           g = ~g;
           b = ~b;
           break;
           
       case 'i':
           int offset;
           switch('4') {
           default:
           case '1':
               // Das Bild wird nur in den oberen linken 100x100 Pixel angezeigt, der Rest ist schwarz
               if (x > 100 || y > 100) {
                   r = g = b = 0x00;
                   a = 0xFF;
               }
               break;
               
           case '2':
               /*
                * x % 2 ist ist nur bei jeder zweiten Zahl 0 und ist damit abwechselnd wahr / falsch.
                * y%2 ist 1 in jeder zweiten Zeile und verschiebt damit das Muster in der Zeile.
                * Falls dieser Ausdruck wahr ist, soll der Pixel schwarz sein, wenn nicht soll er weiﬂ sein.
                */
               r = g = b = ((x + y%2) % 2 == 0) ? 0x00 : 0xFF;
               break;
               
           case '3':
               // Der Rot Wert wird in jedem zweiten Pixel um 1 angehoben
               r += (x + y%2) % 2;
               // Der Rot Wert wird in jedem zweiten Pixel um 1 angehoben, auﬂer er ist schon am
               // Maximum, dann wird er um 2 dekrementiert.
               // r += ((x + y%2) % 2 == 0) ? (r >= 255 ? -2 : 1) : 0;
               
               break;
               
           case '4':
               // Berechnung der Distanz zur Mitte, ausgehend davon dass das Bild 200x200 Pixel groﬂ ist
               // Die minimale Distanz zum Rand ist damit 100 Pixel, nachdem der Rand weiﬂ sein soll,
               // muss das Offset an dieser Stelle minimal 255 sein, deswegen wird die Distanz mal 2.55 genommen.
               offset = (int) (Math.sqrt( Math.pow(x-100, 2) + Math.pow(y-100,2) ) * 2.55);
               
               r += offset;
               g += offset;
               b += offset;
                              
               break;
               
           case '5':
               if ((x + y%20) % 20 <= 1 || (x - y%20 + 20) % 20 <= 1) {
                   r = ~r;
                   g = ~g;
                   b = ~b;
               }
               
               break;
           }
           break;
           
       case 'j':
           switch('1') {
           default:
           case '1':
               b = r + g + b;
               g = r + g;
               break;
               
           case '2':
               offset = (int) (Math.abs(x - 100)*2.55 + Math.abs(y - 100)*2.55);
               
               r -= offset;
               g -= offset;
               b -= offset;
               
               break;
           }
           
           break;
       }

       a = (a > 0xFF)? 0xFF : a;
       r = (r > 0xFF)? 0xFF : r;
       g = (g > 0xFF)? 0xFF : g;
       b = (b > 0xFF)? 0xFF : b;
       return (a << 8 * 3) + (r << 8 * 2) + (g << 8 * 1) + (b << 8 * 0);
    }
}