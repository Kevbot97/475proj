package project1;

import java.io.IOException;
import java.util.ArrayList;

public class Apriori {
	
	public static final int BASKETS_IN_FILE = 88162;
	public static final int LARGEST_ITEM_IN_FILE = 16469;
	
	Handling inputHandler;
	int individualItemCounts[];
	// used when only working with subsets of the data
	int percent, supportPercent;

	
	public Apriori(String inputFileName, int percentage, int supportPercentage)
	{
		inputHandler = new Handling(inputFileName);
		percent = percentage;
		supportPercent = supportPercentage;
	}
	
	public void firstPass() throws IOException
	{
		// should just keep a count of each item in each basket.
		// e.g. if my baskets are {1,2,3} and {2}
		// counts should be a[1] = 1; a[2] = 2; a[3] = 1;
	}
	
}
