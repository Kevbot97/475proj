package project1;

import java.io.IOException;
import java.util.ArrayList;

public class Apriori {
	
	Handling inputHandler;
	
	ArrayList<Integer> individualItemCounts;
	
	public Apriori(String inputFileName)
	{
		inputHandler = new Handling(inputFileName);
		individualItemCounts = new ArrayList<Integer>();
	}
	
	public void firstPass() throws IOException
	{
		// should just keep a count of each item in each basket.
		// e.g. if my baskets are {1,2,3} and {2}
		// counts should be a[1] = 1; a[2] = 2; a[3] = 1;
	}


}
