package project1;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args)
	{
		Apriori algorithm = new Apriori("input.txt");
		try {
			algorithm.firstPass();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		/*
		for (int i = 0; i < algorithm.individualItemCounts.size(); i++)
		{
			System.out.println(i + ": " + algorithm.individualItemCounts.get(i));
		}*/
	}
}
