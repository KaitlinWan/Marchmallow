# :cloud: :icecream: Team Marchmallow :icecream: :cloud: 

Kaitlin Wan, Alan Wang, Kevin Wang

APCS2 Pd. 8

LAB NUMERO UNO 

W 2018-03-14


# What Does the Data Say?

### Hypothesis
After writing partition, we established that its runtime is linear. The implementation of QuickSort is like MergeSort (which was O(nlogn) for best case), but rather than sorting the whole array, it will just sort the selected area. If there is a size n array of integers we believe that the worst case will be O(n^2). This is because for each new pivot it will need to make the most comparision and swaps. The average case and best case will both be O(nlogn). We noticed the similarities of the implementation of the 2 different algorithms.

### Background 
We implemented the assignments from our past homeworks. For the assignment, we needed to write a tester for the QuickSort. To implement the QuickSort.java that we wrote, we added QuickSort.java into the package quicksort. Adding it to a package allows us to easily to call all the methods in QuickSort.java.

Our Task:
1. Find the relationship for runtime of Quicksort for a n size array of integers. 
2. Find how the pivot selection and data arrangement affects execution time.

### Experiment Methodology
We are going to find out the runtime of our algorithm under different cases by testing how long the algorithm takes to run on increasing n values. With this data we are going to graph the points and look at the trend of the graph.

In order to time how long the quicksort takes, we will run System.currentTimeMillis() right before starting the algorithm and again when the algorithm just finishes and subtract the two values from each other.

We will create three different test cases: one when the array has consecutive elements {1,2,3,4,...} for worst case, one when the array has elements that will display best case behavior using a generator method we created, and one when the array has randoms in no specific order.

For all runs, we will start with a n value of 100 and end at 10000, going at increments of 100, due to computer memory limitations. To maximize computer performance, we will try our best not to run other programs manually. Furthermore, we will be running 5000 trials for each run so that we get a more accurate reading, in case that there are outliers.

However, of those 5000 trials, we will only be using the latter 4900 because of prior experience with unexplained runtime differences in a prior experiment. We will find the total time for the 4900 trials and calculate the average. Then we will repeat this many times and take the average for the multiple executions before analyzing.

### Results
#### Worst Unshuffled
![Chart](https://github.com/KaitlinWan/Marchmallow/blob/master/worst_unshuf.png)

#### Best Unshuffled
![Chart](https://github.com/KaitlinWan/Marchmallow/blob/master/best_unshuf.png)

#### Normal Unshuffled
![Chart](https://github.com/KaitlinWan/Marchmallow/blob/master/norm_unshuf.png)

#### Comparison
![Chart](https://github.com/KaitlinWan/Marchmallow/blob/master/compare.png)

### Conclusions
After our experimentation, we concluded that the runtime for the worst case is O(n^2). From the chart of the worst case, it exhibits a very strong quadratic correlation. For best case, it appears that the relationship is not as curved as a quadratic, but more curved than a linear. This fits the behavior of O(nlogn). For a random array, it appears to also be quadratic for some reason, but we think that it is because of something in our code.

As we saw, the array size is important in Quicksort's run-time. In our case, a sorted array took much more longer to sort than a "best case" array. However, the pivot point also makes a difference. If the array is nearly sorted, then choosing the first element as a pivot (which is what we did) will result in a much worse run-time than choosing a middle pivot when sorting a nearly sorted array.
