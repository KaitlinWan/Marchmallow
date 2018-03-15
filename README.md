# :cloud: :icecream: Team Marchmallow :icecream: :cloud: 

Kaitlin Wan, Alan Wang, Kevin Wang

APCS2 Pd. 8

LAB NUMERO UNO 

W 2018-03-14


# What Does the Data Say?

### Hypothesis
If there is a size n array of integers, then we believe that quicksort will exhibit a worst case (n^2), average case O(nlogn) runtime, and a best case of (nlogn).


### Background
Find the runtime of quicksort for a n size array of integers. 
Find how the pivot selection and data arrangement affects execution time.

### Experiment Methodology
We are going to find out the runtime of our algorithm under different cases by testing how long the algorithm takes to run on increasing n values. With this data we are going to graph the points and look at the trend of the graph.

In order to time how long the quicksort takes, we will run System.currentTimeMillis() right before starting the algorithm and again when the algorithm just finishes and subtract the two values from each other.

We will create three different test cases: one when the array has consecutive elements {1,2,3,4,...} for worst case, one when the array has elements that will display best case behavior using a generator method we created, and one when the array has randoms in no specific order.

For all runs, we will start with a n value of 100 and end at 10000, going at increments of 100, due to computer memory limitations. To maximize computer performance, we will try our best not to run other programs manually. Furthermore, we will be running 5000 trials for each run so that we get a more accurate reading, in case that there are outliers.

However, of those 5000 trials, we will only be using the latter 4900 because of prior experience with unexplained runtime differences in a prior experiment. We will find the total time for the 4900 trials and calculate the average. Then we will repeat this many times and take the average for the multiple executions before analyzing.

### Results
#### Worst Unshuffled
![Chart](https://github.com/KaitlinWan/Marchmallow/blob/master/worst_unshuf.png)

### Conclusions

After our experimentation, we concluded that the runtime for the worst case is n^2. From the chart of the worst case, it exhibits a very strong quadratic correlation.
