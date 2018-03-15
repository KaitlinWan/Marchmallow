# :cloud: :icecream: Team Marchmallow :icecream: :cloud: 

Kaitlin Wan, Alan Wang, Kevin Wang

APCS2 Pd. 8

LAB NUMERO UNO 

W 2018-03-14


# What Does the Data Say?

### Hypothesis
After writing partition, we established that the runtime is linear. The implementation of QuickSort is like MergeSort (which was O(nlogn) for the best case), but rather than sorting the whole array, it will just sort the selected area. If there is a size n array of integers we believe that the worst case will be O(n^2). This is because for each new pivot it will need to make the most comparision and swaps. The average case and best case will both be O(nlogn). We noticed the similarities of the implementation of the 2 different algorithms.

### Background 
We implemented the assignments from our past homeworks. After careful consideration we decided to use Kevin's code because it is beautifully coded. For the assignment, we needed to write a tester for the QuickSort. To implement the QuickSort.java that we wrote, we made QuickSort into a package. Making it a package allows us to easy call all the methods in QuicksSort.java.

Our Task:
1. Find the runtime of quicksort for a n size array of integers. 
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
After our experimentation, we concluded that the runtime for the worst case is n^2. From the chart of the worst case, it exhibits a very strong quadratic correlation. Using the chart program, we found the constant for the R^2. This was 0.9999 (which is basically 1). 


For our normal it looks 
r^2 nORMAL === 0.99999
r^2 == worst
.9999
