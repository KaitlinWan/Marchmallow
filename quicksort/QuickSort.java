package quicksort;

/*
Kaitlin Wan, Alan Wang, Kevin Wang
APCS2 Pd. 8
HW #18 -- QuickSort
2018-03-13
*/

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Method partition() is run on arr and then recursively run on the subarray of elements whose
 *             indices are less than the returned pivot index and the subarray of elements whose indices are
 *             greater than the returned pivot index. If the arr.length <= 1, arr is returned.
 *
 * 2a. Worst pivot choice and associated runtime:
 * Worst pivot choice would be one that divides all subarrays as unevenly as possible. O(n^2)
 *
 * 2b. Best pivot choice and associated runtime:
 * Best pivot choice would be one that divides all subarrays as evenly as possible. O(n log n)
 *
 * 3. Approach to handling duplicate values in array:
 * Run partition as normal because duplicate values will be compared as normal and which one goes before the
 * other makes no difference.
 *
 *****************************************************/

public class QuickSort {
	//--------------v  HELPER METHODS  v--------------
	//swap values at indices x, y in array o
	public static void swap(int x, int y, int[] o) {
		int tmp = o[x];
		o[x] = o[y];
		o[y] = tmp;
	}

	//print input array 
	public static void printArr(int[] a) {
		for (int o : a)
			System.out.print(o + " ");
		System.out.println();
	}

	//shuffle elements of input array
	public static void shuffle(int[] d) {
		int tmp;
		int swapPos;
		for (int i = 0; i < d.length; i++) {
			tmp = d[i];
			swapPos = i + (int) ((d.length - i) * Math.random());
			swap(i, swapPos, d);
		}
	}

	//return int array of size s, with each element fr range [0,maxVal)
	public static int[] buildArray(int s, int maxVal) {
		int[] retArr = new int[s];
		for (int i = 0; i < retArr.length; i++)
			retArr[i] = (int) (maxVal * Math.random());
		return retArr;
	}

	/**
	* Method partition moves all values less than a particular set value (the pivot) to one
	* side
	* @param arr is the array to be operated on
	* @param low is the index of the lower bound of the array that you want to operate on
	* @param high is the index of the upper bound of the array that you want to operate on
	* @param pivotPos is the index of the pivot value
	*/
	public static int[] partition(int[] arr, int low, int high, int pivotPos) {
		if (low >= high) //if arr.length <= 1
			return arr;

		int pivot = arr[pivotPos];

		//swap pivot with rightmost element
		swap(pivotPos, high, arr);

		int pivotFinal = low;
		for (int i = low; i < high; i++) {
			if (arr[i] < pivot) { //move values smaller than pivot to one side

				//swap
				swap(pivotFinal, i, arr);
				pivotFinal += 1; //update pivot's final index
			}
		}

		//swap pivot to correct index
		swap(pivotFinal, high, arr);

		partition(arr, low, pivotFinal - 1, (pivotFinal - 1 + low) / 2); //run on lower half
		partition(arr, pivotFinal + 1, high, (high + pivotFinal + 1) / 2); //run on upper half
		return arr;
	}
	//--------------^  HELPER METHODS  ^--------------

	/*****************************************************
	 * void qsort(int[])
	 * @param d -- array of ints to be sorted in place
	 *****************************************************/
	public static void qsort(int[] d) {
		shuffle(d); //shuffle d first in case it is nearly sorted to prevent worst case
		partition(d, 0, d.length - 1, 0); //use first element as pivot
	}

	//main method for testing
	public static void main(String[] args) {

		//get-it-up-and-running, static test case:
		int[] arr1 = { 7, 1, 5, 12, 3 };
		System.out.println("\narr1 init'd to: ");
		printArr(arr1);

		qsort(arr1);
		System.out.println("arr1 after qsort: ");
		printArr(arr1);

		// randomly-generated arrays of n distinct vals
		int[] arrN = new int[10];
		for (int i = 0; i < arrN.length; i++)
			arrN[i] = i;

		System.out.println("\narrN init'd to: ");
		printArr(arrN);

		shuffle(arrN);
		System.out.println("arrN post-shuffle: ");
		printArr(arrN);

		qsort(arrN);
		System.out.println("arrN after sort: ");
		printArr(arrN);
		/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

		//get-it-up-and-running, static test case w/ dupes:
		int[] arr2 = { 7, 1, 5, 12, 3, 7 };
		System.out.println("\narr2 init'd to: ");
		printArr(arr2);

		qsort(arr2);
		System.out.println("arr2 after qsort: ");
		printArr(arr2);

		// arrays of randomly generated ints
		int[] arrMatey = new int[20];
		for (int i = 0; i < arrMatey.length; i++)
			arrMatey[i] = (int) (48 * Math.random());

		System.out.println("\narrMatey init'd to: ");
		printArr(arrMatey);

		shuffle(arrMatey);
		System.out.println("arrMatey post-shuffle: ");
		printArr(arrMatey);

		qsort(arrMatey);
		System.out.println("arrMatey after sort: ");
		printArr(arrMatey);
		/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

		//array with 3 of the same values
		int[] bobby = { 1, 1, 2, 2, 3, 4, 5, 5, 6, 12, 22, 13, 15, 15, 15 };
		System.out.println("\nbobby init'd to: ");
		printArr(bobby);

		shuffle(bobby);
		System.out.println("bobby post-shuffle: ");
		printArr(bobby);

		qsort(bobby);
		System.out.println("bobby after sort: ");
		printArr(bobby);
	}//end main

}//end class QuickSort
