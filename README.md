The provided implementation of the MovingAverage interface has the following properties:
1) O(1) additional space usage. O(n) in total due to the underlying list data structure.
2) O(1) time complexity for addElement and getMovingAverage. 
3) O(n) time complexity for getElements due to the time conversions, however, if we expect to use getElements frequently, we can improve on this. For example, if we know the number of elements in our input ahead of time, we can keep an array alongside the actual list implementation to reduce this to O(n). Alternatively, I made the decision to have the interface return a <T>[] for this function which results in having to do type conversions for the boxed Java types. If it is acceptable to relax the requirements for getElements, or if porting this implementation to another language like Python, this can also easily be reduced to O(1).

Implementation details:
1) addElement keeps track of the starting index for our moving average window and updates the current sum of n elements.
2) getMovingAverage returns 0 when no elements are in the list, and when less than n elements are in the list, it returns the average of those elements. Libraries with similiar functionality such as Pandas have the option to either behave as the above, or return null when there are less than n elements, however Pandas defaults to the behavior above.
3) getElements behaves in a self-explanitory manner.