package project1;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args)
	{
		// creates input handling
		Handling handler = new Handling();
		handler.initializeBufferedReader("input.txt");
		
		// iterates through all baskets.
		Basket b = new Basket();
		do {
			try {
				b = handler.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(b);
		} while (b != null);
	}
}
