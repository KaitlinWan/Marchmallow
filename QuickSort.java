public class QuickSort
{
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



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d )
    { 
	qsortH(d, 0, d.length - 1);
    }


    //main method for testing
    public static void main( String[] args )
    {

    }//end main

}//end class QuickSort
