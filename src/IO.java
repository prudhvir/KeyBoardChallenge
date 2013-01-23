import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class IO {

	public ArrayList<String> getTransformations(String filename) throws IOException {
		
		FileInputStream fstream = new FileInputStream(filename);
		
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String line;
		ArrayList<String> result = new ArrayList<String>();
		
		while ((line = br.readLine()) != null)   {
			result.add(line);
		}
		
		in.close();

		return result;
	}
	
	
	public StringBuffer getData(String filename) throws IOException {
		
		FileInputStream fstream = new FileInputStream(filename);
		
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String line;
		StringBuffer result = new StringBuffer();
		
		while ((line = br.readLine()) != null)   {
			result.append(line);
		}
		
		in.close();

		return result;
	}
}
