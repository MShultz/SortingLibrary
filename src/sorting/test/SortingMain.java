package sorting.test;

import java.util.Random;

import shultz.helper.Timer;
import sorting.library.Sorter;

public class SortingMain {

	public static void main(String[] args) {
		Comparable[] list =  generateRandoms(1000000);
			//{ "Dog", "Cat", "Chicken", "Burrito", "Tears", "dog", "Dog", "cat", "chicken", "burrito","tears" };
		// generateRandoms(25);
		// {52, 1,2,3,5,8,9,1,0,1,0,4,8,7,7,7,9,1000,5,6,8};
		Timer timer = new Timer();
		timer.start();
		Sorter.quickSort(list);
		timer.end();
//		for (Comparable comparator : list) {
//			System.out.println(comparator + "  ");
//		}
		

	}

	private static Comparable[] generateRandoms(int numRands) {
		Comparable[] newRandoms = new Comparable[numRands];
		Random rand = new Random();
		for (int i = 0; i < numRands; ++i) {
			newRandoms[i] = rand.nextInt(10001);
		}
		return newRandoms;
	}

}
