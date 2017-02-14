package project1;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args)
	{
		Apriori algorithm = new Apriori("input_test.txt", 10, 10);
		PCY alg2 = new PCY("input_test.txt", 10, 10);
		try {
			algorithm.firstPass();
			algorithm.secondPass();
			algorithm.test();
			alg2.firstPass();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
