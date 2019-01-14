package cn.com.iherpai.common.utils.image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.awt.*;
import java.io.File;

public class MiniPictureProducer {
	

	
	public static void saveImageAsJpg(String fromFileStr, String saveToFileStr, int width, int hight) throws Exception {
		BufferedImage srcImage;
		String imgType = "JPEG";
		if (fromFileStr.toLowerCase().endsWith(".png")) {
			imgType = "PNG";
		}
		File saveFile = new File(saveToFileStr);
		File fromFile = new File(fromFileStr);
		if( !saveFile.exists() ){
			srcImage = ImageIO.read(fromFile);
			if (width > 0 || hight > 0) {
				int type = srcImage.getType();
				BufferedImage target = null;
				double sx = (double) width / srcImage.getWidth();
				double sy = (double) hight / srcImage.getHeight();
				if (sx > sy) {
					sx = sy;
					width = (int) (sx * srcImage.getWidth());
				} else {
					sy = sx;
					hight = (int) (sy * srcImage.getHeight());
				}
				if (type == BufferedImage.TYPE_CUSTOM) { // handmade
					ColorModel cm = srcImage.getColorModel();
					WritableRaster raster = cm.createCompatibleWritableRaster(width,
							hight);
					boolean alphaPremultiplied = cm.isAlphaPremultiplied();
					target = new BufferedImage(cm, raster, alphaPremultiplied, null);
				} else
					target = new BufferedImage(width, hight, type);
				Graphics2D g = target.createGraphics();
				// smoother than exlax:
				g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
				g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
				g.drawImage(srcImage.getScaledInstance(width, hight,  Image.SCALE_SMOOTH), 0, 0,  null);  
				g.dispose();
				srcImage = target;
			}	
			ImageIO.write(srcImage, imgType, saveFile);
		}
	}
	

	
	public static long saveMiniImageAsJpg(BufferedImage srcImage, String saveToFileStr, int width, int hight) throws Exception {
		long res = 0L;
		String imgType = "JPEG";
		File saveFile = new File(saveToFileStr);
		//if( !saveFile.exists() ){
			if (width > 0 || hight > 0) {
				int type = srcImage.getType();
				BufferedImage target = null;
				double sx = (double) width / srcImage.getWidth();
				double sy = (double) hight / srcImage.getHeight();
				if (sx > sy) {
					sx = sy;
					width = (int) (sx * srcImage.getWidth());
				} else {
					sy = sx;
					hight = (int) (sy * srcImage.getHeight());
				}
				if (type == BufferedImage.TYPE_CUSTOM) { // handmade
					ColorModel cm = srcImage.getColorModel();
					WritableRaster raster = cm.createCompatibleWritableRaster(width,
							hight);
					boolean alphaPremultiplied = cm.isAlphaPremultiplied();
					target = new BufferedImage(cm, raster, alphaPremultiplied, null);
				} else
					target = new BufferedImage(width, hight, type);
				Graphics2D g = target.createGraphics();
				// smoother than exlax:
				g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
				g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
				g.drawImage(srcImage.getScaledInstance(width, hight,  Image.SCALE_SMOOTH), 0, 0,  null);  
				g.dispose();
				srcImage = target;
			}	
			ImageIO.write(srcImage, imgType, saveFile);
			res += saveFile.length();
		//}
		return res;
	}
	
	
	
	
	
	
	public static BufferedImage toBufferedImage(Image image) throws HeadlessException {
        if (image instanceof BufferedImage) {
            return (BufferedImage)image;
        }    
        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();    
        // Determine if the image has transparent pixels; for this method's
        // implementation, see e661 Determining If an Image Has Transparent Pixels
        //boolean hasAlpha = hasAlpha(image);    
        // Create a buffered image with a format that's compatible with the screen
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // Determine the type of transparency of the new buffered image
            int transparency = Transparency.OPAQUE;
            /* if (hasAlpha) {
                transparency = Transparency.BITMASK;
            }*/    
            // Create the buffered image
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);
        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            //int type = BufferedImage.TYPE_3BYTE_BGR;//by wang
            /*if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;
            }*/
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }    
        // Copy image to buffered image
        Graphics g = bimage.createGraphics();    
        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();    
        return bimage;
    }

	
	
	
	
	
	
	
	

}
