package project1;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args)
	{
		int mode;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter 1 for test mode, 2 for regular output");
		int testMode = keyboard.nextInt();
		
		System.out.println("Enter support threshold (as a decimal value, e.g. 0.01:");
		double supportThreshold = keyboard.nextDouble();
		
		if (testMode == 1)
		{	
			// i controls dataset size
			// size iterates through 0.1 to 1.0
			System.out.println("Apriori: ");
			for (double size = 0.1; size < 1.0; size += 0.1)
			{
				Apriori algorithm = new Apriori("input.txt", size, supportThreshold);
				try {
					final long startTime = System.currentTimeMillis();
					algorithm.firstPass();
					algorithm.secondPass();
					algorithm.test();
					final long endTime = System.currentTimeMillis();
					
					System.out.println("Dataset size " + size + ", Total execution time: " + (endTime - startTime) + "ms" );
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			
			System.out.println("PCY: ");
			for (double size = 0.1; size < 1.0; size += 0.1)
			{
				PCY algorithm = new PCY("input.txt", size, supportThreshold);
				try {
					final long startTime = System.currentTimeMillis();
					algorithm.firstPass();
					algorithm.secondPass();
					algorithm.test();
					final long endTime = System.currentTimeMillis();
					
					System.out.println("Dataset size " + size + ", Total execution time: " + (endTime - startTime) + "ms" );
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
		else {
			System.out.println("Enter 1 for Apriori, 2 for PCY");
			mode = keyboard.nextInt();
			
			System.out.println("Enter dataset size (as decimal again, e.g. 0.2");
			double datasetSize = keyboard.nextDouble();
			
			if (mode == 1)
			{
				Apriori algorithm = new Apriori("input.txt", datasetSize, supportThreshold);
				try {
					final long startTime = System.currentTimeMillis();
					algorithm.firstPass();
					algorithm.secondPass();
					algorithm.test();
					final long endTime = System.currentTimeMillis();
					
					System.out.println("Dataset size " + datasetSize + ", Total execution time: " + (endTime - startTime) + "ms" );
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			else {
				PCY algorithm = new PCY("input.txt", datasetSize, supportThreshold);
				try {
					final long startTime = System.currentTimeMillis();
					algorithm.firstPass();
					algorithm.secondPass();
					algorithm.test();
					final long endTime = System.currentTimeMillis();
					
					System.out.println("Dataset size " + datasetSize + ", Total execution time: " + (endTime - startTime) + "ms" );
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			System.out.println("Check output.txt for frequent pairs & counts.");
		
		}
	}
}
