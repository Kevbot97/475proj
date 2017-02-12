package project1;

import java.util.*;

public class Basket {
	
	public ArrayList<Integer> items;
	
	//constructor
	public Basket() {
		items = new ArrayList<Integer>();
	}

	//constructor
	public Basket(String currentLine) {
		items = new ArrayList<Integer>();
		Scanner scanner = new Scanner(currentLine);
		while (scanner.hasNext())
			items.add(scanner.nextInt());
	}
	
	public ArrayList<Integer> getItems()
	{
		return items;
	}
	
	// mostly for testing
	public String toString() {
		String retString = "";
		int n = items.size();
		for (int i = 0; i < n; i++)
			retString += items.get(i) + " ";
		retString += "\n";
		return retString;
	}
	
}
