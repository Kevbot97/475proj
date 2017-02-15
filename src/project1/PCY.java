package project1;

import java.io.IOException;
import java.util.*;

public class PCY extends Apriori {
	
	int[] firstPassMap;
	Bitmap bmp;

	public PCY(String inputFileName, double size, double supportThreshold) {
		super(inputFileName, size, supportThreshold);
	}
	
	@Override
	public void firstPass() throws IOException
	{
		individualItemCounts = new int[LARGEST_ITEM_IN_FILE];
		firstPassMap= new int[(int)(BASKETS_IN_FILE * datasetPercent * 2)];

		int j = 0;
		for (Basket currentBasket = inputHandler.readLine(); currentBasket != null; currentBasket = inputHandler.readLine())
		{
			if (j >= (datasetPercent * BASKETS_IN_FILE))
				break;
			j++;
			ArrayList<Integer> currentItems = currentBasket.getItems();
			for (int i = 0; i < currentItems.size(); i++)
			{
				// increment value
				individualItemCounts[currentItems.get(i).intValue()]++;
			}
			addPairsToFirstPassTable(currentBasket);
		}
		
		//convert hashmap to bitmap
		bmp = new Bitmap(firstPassMap.length);
		bmp.convert(firstPassMap, supportThreshold);
	}
	
	public void addPairsToFirstPassTable(Basket currentBasket)
	{
		ArrayList<Integer> individuals = currentBasket.getItems();
		for (int i = 0; i < individuals.size() - 1; i++)
		{
			for (int j = i + 1; j < individuals.size(); j++)
			{
				// pretty much the worst hash to buckets ever
				// it just adds 1 to the table at [i+j]
				firstPassMap[individuals.get(i).intValue() + individuals.get(j)]++;
			}
		}
	}
	
	
}
