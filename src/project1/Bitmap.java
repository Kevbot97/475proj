package project1;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Bitmap {

	public int[] array;
	
	public Bitmap(int size)
	{
		array = new int[size];
	}
	
	public void convert(HashMap<Key, Integer> map, int supportThreshold)
	{
		 Entry[] entries = map.entrySet().toArray(new Entry[0]);
		 for (int i = 0; i < entries.length; i++)
		 {
			 if ((Integer)(entries[i].getValue()) >= supportThreshold)
				 this.setTrue((Key)entries[i].getKey());
		 }
		 for (int i= 0; i < array.length; i++)
		 {
			 System.out.println(array[i]);
		 }
		
	}
	
	public void setTrue(Key k)
	{	
		int c = k.hashCode();
		int index = c / 32;
		int binaryPlace = c % 32;
		
		array[index] += Math.pow(2, binaryPlace);
	}
}
