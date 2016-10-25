package vue;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class UtilVue {
	
//	private String path = ""; 
	private static String path = "..\\ressources\\images\\";
//	private static String path = "\\ressources\\images\\";
	
	
	// Creation d'un ImageIcon
	protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = UtilVue.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

	// Redimensionne un ImageIcon
	public static ImageIcon scaleIcon(String source, int width, int height) {
		
		source = path + source;
		ImageIcon 	imgIcon 	= UtilVue.createImageIcon(source);
		Image 		img 		= imgIcon.getImage();
		
	    /* On crée une nouvelle image aux bonnes dimensions. */
	    BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

	    /* On dessine sur le Graphics de l'image bufferisée. */
	    Graphics2D g = buf.createGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(img, 0, 0, width, height, null);
	    g.dispose();

	    /* On transforme l'image en ImageIcon */
	    ImageIcon newIcon = new ImageIcon(buf);
	    return newIcon;
	}
	
	// Redimensionne une Image
	public static Image scaleImage(String source, int width, int height) {
		
		source = path + source;
		ImageIcon 	imgIcon 	= UtilVue.createImageIcon(source);
		Image 		img 		= imgIcon.getImage();
		
	    /* On crée une nouvelle image aux bonnes dimensions. */
	    BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

	    /* On dessine sur le Graphics de l'image bufferisée. */
	    Graphics2D g = buf.createGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(img, 0, 0, width, height, null);
	    g.dispose();

	    /* On retourne l'image bufferisée, qui est une image. */
	    return buf;
	}
}
