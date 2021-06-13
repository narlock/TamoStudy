import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class DownloadCount {
	public static void main(String[] args) throws Exception {
		
		//Create HttpURLConnection 
		HttpURLConnection httpcon = (HttpURLConnection) new URL("https://api.github.com/repos/narlock/TamoStudy/releases").openConnection();
		httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
		BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
		
		//Read line by line
		StringBuilder responseSB = new StringBuilder();
		String line;
		while ( ( line = in.readLine() ) != null) {
			responseSB.append("\n" + line);
			//System.out.println(line);
		}
		in.close();
		
		//Get Git Hub Downloads of XR3Player
		Arrays.stream(responseSB.toString().split("\"download_count\":")).skip(1).map(l -> l.split(",")[0]).forEach(l -> System.out.println(l));
		
		//Sum up all download counts
		int total = Arrays.stream(responseSB.toString().split("\"download_count\":")).skip(1).mapToInt(l -> Integer.parseInt(l.split(",")[0])).sum();
		System.out.println("\nTotal Downloads: " + total);
		
	}
	
}