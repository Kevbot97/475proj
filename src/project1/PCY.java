package project1;

import java.io.IOException;
import java.util.*;

public class PCY extends Apriori {
	
	public HashMap<Key, Integer> firstPassMap;

	public PCY(String inputFileName, int percentage, int supportPercentage) {
		super(inputFileName, percentage, supportPercentage);
	}
	
	@Override
	public void firstPass() throws IOException
	{
		individualItemCounts = new int[LARGEST_ITEM_IN_FILE];
		firstPassMap = new HashMap<Key, Integer>((int)(Runtime.getRuntime().freeMemory() / 2));

		for (Basket currentBasket = inputHandler.readLine(); currentBasket != null; currentBasket = inputHandler.readLine())
		{
			ArrayList<Integer> currentItems = currentBasket.getItems();
			super.addPairs(currentItems, firstPassMap);
			for (int i = 0; i < currentItems.size(); i++)
			{
				// increment value
				individualItemCounts[currentItems.get(i).intValue()]++;
			}
		}
		
		//convert hashmap to bitmap
		Bitmap bmp = new Bitmap(firstPassMap.size());
		bmp.convert(firstPassMap, supportThreshold);
	}
	
	//TODO: write secondPass() shit
}
