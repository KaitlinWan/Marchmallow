import quicksort.*;

public class QuickSortTester {

    /** Generates a best case scenario for quicksort by working backwards
     * @param arr is the array
     * @param low is the lower index of the array
     * @param high is the length of the array
     * precond: arr is an array sorted in ascending order
     * postcond: arr is a best case scenario for quicksort
     */
    public static void bestCaseGen(int[] arr, int low, int high) {
      int count = high - 1 - low;
      if (count < 2){
        return;
      }

      int mid = low + count / 2; //pivot
      //recurse through left side
      bestCaseGen(arr, low, mid);
      //swap pivot
      QuickSort.swap(low, mid, arr);

      //recurse through right side
      bestCaseGen(arr, mid + 1, high);
    }

    public static void main(String[] args) {
      long a = 0; //begin time
      long b = 0; //end time

      //worst case
      for (int n = 30000; n >= 5000; n -= 100) { //array size
        System.out.print(n + ","); //print array size
        long total = 0; //total runtime for each run

        //declare and instantiate
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
          arr[i] = i;
        }

        for (int trial = 0; trial < 5000; trial++) { //4900 runs
          if (trial > 99) { //in case there is weird behavior for first few runs
            a = System.currentTimeMillis();
            QuickSort.qsort(arr); //quicksort
            b = System.currentTimeMillis();
            total += b - a; //find time took and add to total
          }
        }
        System.out.println(total / 4900000.0); //average time for one search
      }

      //best case

      for (int n = 30000; n >= 5000; n -= 100) { //array size
        System.out.print(n + ","); //print array size
        long total = 0; //total runtime for each run

        //declare and instantiate
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
          arr[i] = i;
        }

        for (int trial = 0; trial < 5000; trial++) { //4900 runs
          if (trial > 99) { //in case there is weird behavior for first few runs
            bestCaseGen(arr, 0, arr.length);
            a = System.currentTimeMillis();
            QuickSort.qsort(arr); //quicksort
            b = System.currentTimeMillis();
            total += b - a; //find time took and add to total
          }
        }
        System.out.println(total / 4900000.0); //average time for one search
      }

      //average case

      for (int n = 30000; n >= 5000; n -= 100) { //array size
        System.out.print(n + ","); //print array size
        long total = 0; //total runtime for each run

        //declare and instantiate
        int[] arr = QuickSort.buildArray(n, n);

        for (int trial = 0; trial < 5000; trial++) { //4900 runs
          if (trial > 99) { //in case there is weird behavior for first few runs
            a = System.currentTimeMillis();
            QuickSort.qsort(arr); //quicksort
            total += b - a; //find time took and add to total
          }
        }
        System.out.println(total / 4900000.0); //average time for one search
      }
    }
  }
