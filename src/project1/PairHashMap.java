package project1;

import java.util.HashMap;


// this class is pretty basic; it primarily is a way to get a 2-key hashmap
// it does this by implementing a map of maps.
// it's the same as using a HashMap of HashMaps of Integers, basically just nicer to use

public class PairHashMap extends HashMap<Integer, HashMap<Integer, Integer>> {
	public PairHashMap()
	{
		super();
	}
	
	public PairHashMap(int initialCapacity)
	{
		super(initialCapacity);
	}
	
	public Integer get(int i, int j)
	{
		return super.get(i).get(j);
	}
}
