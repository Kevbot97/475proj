package project1;

import java.io.*;
import java.util.*;

public class Handling {
	//define methods for handling the data
	//reader for input from the dataset
	public static void main(String[] args) {
		readLine();

	}
	
	// TODO: move some of the code from readLine to here
	// we will call this guy before any readLines
	public void initializeBufferedReader(String inputFile) {
		
	}
	
	
	// currently reads all lines & makes baskets.
	// we ideally want it to read one at a time so we can update count's
	// per basket.
	public static void readLine() {
		Basket currentBasket;
		
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			String line;
		    while ((line = br.readLine()) != null) {
		       currentBasket = new Basket(line);
		       System.out.println(currentBasket.toString());
		    }
		}
		catch (Exception e){
			System.out.println(e.getClass());
		}
	}
	
}
