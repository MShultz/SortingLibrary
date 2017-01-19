package sorting.library;


public class Sorter<T extends Comparable<? super T>> {
	public static void quickSort(Comparable[] list) {
		quickSort(list, 0, list.length-1);
	}
	private static void quickSort(Comparable[] currentList, int currentLowIndex, int currentHighIndex){
		int pivotLocation;
		if(currentLowIndex < currentHighIndex){
			pivotLocation = partition(currentList, currentLowIndex, currentHighIndex);
			quickSort(currentList, currentLowIndex, pivotLocation);
			quickSort(currentList, pivotLocation + 1, currentHighIndex);
		}
	}
	
	private static int partition(Comparable[] currentList, int currentLowIndex, int currentHighIndex){
		Comparable pivot = currentList[currentLowIndex];
		int innerLow = currentLowIndex - 1;
		int innerHigh = currentHighIndex + 1;
		for(;;){
			do{
				++innerLow;
			}while(currentList[innerLow].compareTo(pivot) < 0);
			do{
				--innerHigh;
			}while(currentList[innerHigh].compareTo(pivot) > 0);
			if (innerLow >= innerHigh)
				return innerHigh;
			swap(currentList, innerLow, innerHigh);
		}
		
	}
	public static void mergeSort(Comparable[] list) {
		mergeSort(list, 0, list.length-1);
	}

	public static void mergeSort(Comparable[] currentList, int firstIndex, int lastIndex) {
		int midPoint, leftPoint, rightPoint;
		
		if (!(firstIndex >= lastIndex)) {
			midPoint = (firstIndex + lastIndex) / 2;
			mergeSort(currentList, firstIndex, midPoint);
			rightPoint = midPoint + 1;
			mergeSort(currentList, rightPoint, lastIndex);
			leftPoint = firstIndex;
			if (currentList[midPoint].compareTo(currentList[rightPoint]) > 0)
				merge(currentList, leftPoint, midPoint, rightPoint, lastIndex);
		}
	}
	
	public static void merge(Comparable[] currentList, int leftPoint, int midPoint, int rightPoint, int lastIndex){
		Comparable temp;
			while (leftPoint <= midPoint && rightPoint <= lastIndex) {
				if (currentList[leftPoint].compareTo(currentList[rightPoint]) <= 0)
					++leftPoint;
				else {
					temp = currentList[rightPoint];
					System.arraycopy(currentList, leftPoint, currentList, leftPoint + 1, rightPoint - leftPoint);
					currentList[leftPoint] = temp;
					leftPoint ++;
					midPoint ++;
					rightPoint ++;
				}
		}
	}

	public static void bubbleSort(Comparable[] list) {
		boolean sortComplete;
		int numSorted = 1;
		do {
			sortComplete = true;
			for (int i = 0; i < list.length - numSorted; ++i) {
				if (list[i].compareTo(list[i + 1]) > 0) {
					sortComplete = false;
					swap(list, i, i + 1);
				}
			}
			++numSorted;
		} while (!sortComplete);

	}

	public static void selectionSort(Comparable[] list) {
		int smallestObjectIndex;
		for (int i = 0; i < list.length - 1; ++i) {
			smallestObjectIndex = i;
			for (int j = i + 1; j < list.length; ++j) {
				if (list[smallestObjectIndex].compareTo(list[j]) > 0) {
					smallestObjectIndex = j;
				}
			}
			swap(list, smallestObjectIndex, i);
		}
	}

	public static void insertionSort(Comparable[] list) {
		for (int i = 1; i < list.length; ++i) {
			int j = i;
			while (j > 0 && list[j - 1].compareTo(list[j]) > 0) {
				swap(list, j - 1, j);
				--j;
			}
		}
	}

	public static void swap(Comparable[] list, int indexOfCurrent, int intendedIndex) {
		Comparable<?> temporaryHolder = list[indexOfCurrent];
		list[indexOfCurrent] = list[intendedIndex];
		list[intendedIndex] = temporaryHolder;
	}
}