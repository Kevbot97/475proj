package project1;

import java.io.*;
import java.util.*;

public class Handling {
	//define methods for handling the data
	//reader for input from the dataset
	
	public void readLine() {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       // process the line.
		    }
		}
		catch(Exception e){
		}
	}
	
	
	//scan in a line
	//basket(currentbasket) = new 
	
	
}
