
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class FileTest {
	public static void main(String[] args) throws IOException {
		String profilename = "Jorda12n";
		File file = new File("profiles.txt");
		BufferedReader br = new BufferedReader(new FileReader(file.getName()));
		
		String line;
		while ((line = br.readLine()) != null) {
			if(line.equals("")) {
				
			} else {
			System.out.println(line);
			}
		}
		
		System.out.println(doesProfileExistInFile(profilename));
		
	}
	
	public static boolean doesProfileExistInFile(String name) throws IOException {
		File file = new File("profiles.txt");
		BufferedReader br = new BufferedReader(new FileReader(file.getName()));
		
		String line;
		while ((line = br.readLine()) != null) {
			if(!line.equals("")) {
				//System.out.println(line);
				boolean exists = false;
				String[] profileDetails = line.split(",");
				
				if(profileDetails[0].equals(name)) {
					return true;
				}
			} else {
				
			}
		}
		
		return false;
	}
}
