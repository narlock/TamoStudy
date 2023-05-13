package resources;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ImageResourceHandler
 * @author narlock
 *
 */
public class ImageResourceHandler {
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public Image readImageFromUrl(String url) {
		Image img;
		try { 
			img = ImageIO.read(getClass().getClassLoader().getResource(url));
			return img;
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Unexpected error occurred at runtime");
	}

}
