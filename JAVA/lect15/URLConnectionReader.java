package lect15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
	public URLConnectionReader() {
		try {
			URL url = new URL("https://www.daum.net");
			URLConnection uc = url.openConnection();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String inputLine;
			while((inputLine= in.readLine()) != null) {
				System.out.println(inputLine);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		URLConnectionReader uc = new URLConnectionReader();
	}

}
