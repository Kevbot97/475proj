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
		firstPassMap= new int[(int)(Runtime.getRuntime().freeMemory() / 8)];
		// make our bucketing hash table the size of our free memory / 2 
		// (and then further divided by 4 to account for integers being 4 bytes)

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
		// this should cause garbage collector to clean up firstPassMap
		firstPassMap = null;
		
	}
	
	public void addPairsToFirstPassTable(Basket currentBasket)
	{
		ArrayList<Integer> individuals = currentBasket.getItems();
		for (int i = 0; i < individuals.size() - 1; i++)
		{
			for (int j = i + 1; j < individuals.size(); j++)
			{
				// the hash to buckets is index = i * j % length of hash table
				firstPassMap[(individuals.get(i).intValue() * individuals.get(j).intValue()) % firstPassMap.length]++;
			}
		}
	}
	
	// addPairs builds all pairs (from an ArrayList of compatible individuals)
		// and adds them to the pairCounts hash table
		public void addPairs(ArrayList<Integer> individuals, HashMap<Key, Integer> map)
		{
			for (int i = 0; i < individuals.size() - 1; i++)
			{
				for (int j = i + 1; j < individuals.size(); j++)
				{
					if (!bmp.getValue((individuals.get(i).intValue() * individuals.get(j).intValue()) % bmp.sizeOfBuckets))
						continue;
					// create new key
					Key key = new Key(individuals.get(i).intValue(), individuals.get(j).intValue());
					
					// add 1 to count (if count exists, otherwise, initialize it as new Integer(1))
					Integer currentCount = map.get(key);
					if (currentCount == null)
						map.put(key, new Integer(1));
					else map.put(key, new Integer(currentCount.intValue() + 1));
				}
			}
		}
	
	
}
