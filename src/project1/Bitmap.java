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
	
	public void convert(int[] firstPassMap, int supportThreshold)
	{
		 for (int i = 0; i < firstPassMap.length; i++)
		 {
			 if (firstPassMap[i] >= supportThreshold)
				 this.setTrue(i);
		 }
	}
	
	public void setTrue(int c)
	{	
		int index = c / 32;
		int binaryPlace = c % 32;
		
		array[index] += Math.pow(2, binaryPlace);
	}
	
	public boolean getValue(int c)
	{
		int index = c / 32;
		int binaryPlace = c % 32;
		if ( (array[index] & Math.round(Math.pow(2, binaryPlace))) > 0)
			return true;
		else return false;
	}
}
