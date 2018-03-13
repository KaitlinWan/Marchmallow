//Alan Wang
//APCS2 pd08
//HW18 -- QuickSort
//2018-03-13t
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): 
 * QuickSort moves first element to the correct position and partitions the 
   other elements. Next it repeats the previous step for both left and right 
   sections until the recursive subcall has only 1 element. 
 * 2a. Worst pivot choice and associated runtime: 
 * 0,O(n^2)
 * 2b. Best pivot choice and associated runtime:
 * arr.length / 2, O(nlogn)
 * 3. Approach to handling duplicate values in array:
 * In the partition code arr[i] < v so the condition is not met and the elements
   are not swapped. 
 *****************************************************/

public class QuickSort
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }

    public static int partition(int[] arr, int start, int end, int target){
        
        int v = arr[target];
        swap(end, target, arr);
        int s = start;
        
        for (int i = start; i < end; i ++){
            if (arr[i] < v){
                swap(s, i, arr);
                s ++;
            }
        }
        swap(end, s, arr);
        return s;
        
    }
    
    public static void qsortH(int[] arr, int left, int right){

        if (left < right){
            int pvtPos = partition(arr, left, right, left);
            qsortH(arr, left, pvtPos - 1);
            qsortH(arr, pvtPos + 1, right);
        }
	
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d )
    { 
	qsortH(d, 0, d.length - 1);
    }

    //you may need a helper method...


    //main method for testing
    public static void main( String[] args )
    {

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);
	qsort( arr1 );	
	System.out.println("arr1 after qsort: " );
	printArr(arr1);
	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);
	shuffle(arrN);
	System.out.println("arrN post-shuffle: " );
	printArr(arrN);
	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);

	
	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);
	qsort( arr2 );	
	System.out.println("arr2 after qsort: " );
	printArr(arr2);
	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);
	shuffle(arrMatey);
	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);
	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);

    }//end main

}//end class QuickSort
