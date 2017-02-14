package project1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Apriori {
	
	public static final int BASKETS_IN_FILE = 10;//88162;//
	public static final int LARGEST_ITEM_IN_FILE = 15;//16470;//
	
	protected Handling inputHandler;
	protected int individualItemCounts[];
	// used when only working with subsets of the data
	protected double datasetPercent, supportThresholdPercent = 0.2;
	protected int supportThreshold = (int) Math.round(supportThresholdPercent * BASKETS_IN_FILE);
	
	HashMap<Key, Integer> pairCounts;

	
	public Apriori(String inputFileName, int percentage, int supportPercentage)
	{
		inputHandler = new Handling(inputFileName);
		datasetPercent = percentage;
		pairCounts = new HashMap<Key, Integer>();
	}
	
	public void firstPass() throws IOException
	{
		individualItemCounts = new int[LARGEST_ITEM_IN_FILE];

		for (Basket currentBasket = inputHandler.readLine(); currentBasket != null; currentBasket = inputHandler.readLine())
		{
			ArrayList<Integer> currentItems = currentBasket.getItems();
			for (int i = 0; i < currentItems.size(); i++)
			{
				// increment value
				individualItemCounts[currentItems.get(i).intValue()]++;
			}
		}
	}
	
	public void secondPass() throws IOException
	{
		inputHandler.reset();
		for (Basket currentBasket = inputHandler.readLine(); currentBasket != null; currentBasket = inputHandler.readLine())
		{
			ArrayList<Integer> currentItems = currentBasket.getItems();
			for (int i = 0; i < currentItems.size(); i++)
			{
				if (individualItemCounts[currentItems.get(i)] >= supportThreshold)
				{
					checkBasket(currentBasket, i);
					break;
				}
			}
		}
	}
	
	// checkBasket takes a basket with potential pairs, starts looking for frequent
	// individuals at thresholdIndex (the instance of the first frequent item).
	// when the loop finishes, it calculates all pairs from entries to possibleFrequents.
	public void checkBasket(Basket currentBasket, int thresholdIndex)
	{
		ArrayList<Integer> currentItems = currentBasket.getItems();
		ArrayList<Integer> possibleFrequents = new ArrayList<Integer>();
		for (int i = thresholdIndex; i < currentItems.size(); i++)
		{
			if (individualItemCounts[currentItems.get(i)] >= supportThreshold)
				possibleFrequents.add(currentItems.get(i));
		}
		if (possibleFrequents.size() > 1)
			addPairs(possibleFrequents, pairCounts);
	}
 
	// addPairs builds all pairs (from an ArrayList of compatible individuals)
	// and adds them to the pairCounts hash table
	public void addPairs(ArrayList<Integer> individuals, HashMap<Key, Integer> map)
	{
		for (int i = 0; i < individuals.size() - 1; i++)
		{
			for (int j = i + 1; j < individuals.size(); j++)
			{
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
	
	// prints out all pairs that were hashed
	public void test()
	{
		Key[] keys = (Key[]) pairCounts.keySet().toArray(new Key[0]);
		for (int i = 0; i < keys.length; i++)
			if (pairCounts.get(keys[i]) >= supportThreshold)
				System.out.println(keys[i] + ": " + pairCounts.get(keys[i]) );
	}
}
