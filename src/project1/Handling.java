package project1;

import java.io.*;
import java.util.*;

public class Handling {
	//define methods for handling the data
	//reader for input from the dataset
	
	BufferedReader br;
	Basket currentBasket;
	String inputFile;
	
	
	// initialized buffer reader before we can read
	public Handling(String inputFile) {
		this.inputFile = inputFile;
		try {
			br = new BufferedReader(new FileReader(this.inputFile));
		}
		catch (Exception e){
			System.out.println(e.getClass());
		}
	}
	
	// resets buffered reader
	public void reset() {
		try {
			br = new BufferedReader(new FileReader(this.inputFile));
		}
		catch (Exception e){
			System.out.println(e.getClass());
		}
	}
	
	
	// returns a basket per line
	// returns null when it hits the end
	public Basket readLine() throws IOException {
		String line = br.readLine();
		if (line == null)
			return null;
		return new Basket(line);
    }
}