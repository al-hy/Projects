# Projects

Sorting Algorithm Project

This project asked us to implement four types of sorting algorithms into our program. Unsorted arrays of size 10^i, for i = 1 … k are passed into each sorting class, and the output should be an array that is sorted.  

The algorithms used were Heap Sorting, Merge Sorting, Quick Sorting, and Insertion Sorting. 
I found that Insertion sorting takes the longest to sort in worst case because it has a property of O(n^2), for n is the number of elements in the array. Also, heap sorting and quick sorting I found were easier to sort in-place compared to merge sorting. 

The implementation includes an interface called SortAlgortithm.java that has a sort method, in which all sorting classes must include. The sort method receives the unsorted array and the SortTimer instance. A SortTimer.java class is provided, which keeps track of the time it takes for the sorting algorithm to execute. It also keeps track of the number of comparisons and moves. Each time the sorting algorithm swaps to sort the array, the move counter is increment. The same thing goes for the comparison counter. Each time the sorting algorithm compares two elements in an array, the comparison counter is incremented in the SortTimer instance. Then a verify method is added to make sure that the sorting algorithm has sorted properly.

The implement is checked by using the verify method which returns a Boolean value. The verify method traverses the array to make sure it is properly sorted in ascending order. If the list is properly sorted, then a true value is passed back to prompt the method that called it to print out the array list. However, if the value is false, a note is printed to notify that the list is not properly sorted.

I found out that there are many different ways to implement Quick Sort. Depending on how it is to implement, the sorting algorithm can either be efficient or not efficient. I had trouble trying to sort in-place with the Merge Sort algorithm. However, following the pseudo code provided, I was able create a separate array that keeps the sorting in order rather than sort in-place. Also, I found that Insertion Sorting is the sorting algorithm that takes the longest because it O(n^2). Furthermore, the following table shows findings of the constant factor from each sorting algorithm. 
