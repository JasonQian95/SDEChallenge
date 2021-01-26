public interface MovingAverage<T extends Number> {

	/**
	 * Add an element
	 * @param element
	 */
	void addElement(T element);

	/**
	 * Returns the average of the last n elements as defined by windowSize
	 * If no elements are present, return 0
	 * If less than n elements are present, return their average
	 * @return the average of the last n elements
	 */
    Double getMovingAverage();

    /**
	 * Returns all elements seen by MovingAverage
	 * @return all elements seen by MovingAverage
	 */
    public T[] getElements();
}