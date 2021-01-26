import java.util.ArrayList;
import java.util.List;

public class MovingAverageList implements MovingAverage<Double>{
	private int windowSize;
	private int windowHead;
	private double currentSum;
	private List<Double> list;
	
	public MovingAverageList(int windowSize){
		if (windowSize <= 0){
			throw new IllegalArgumentException("Window size cannot be zero or negative");
		}
		this.windowSize = windowSize;
		this.windowHead = 0;
		this.currentSum = 0.0;
		this.list = new ArrayList<Double>();
	}

	@Override
	public void addElement(Double element) {
		if (element == null){
			throw new IllegalArgumentException("Element was null");
		}

		this.list.add(element);
		this.currentSum += element;

		if (this.list.size() > windowSize){
			this.currentSum -= this.list.get(windowHead);
			this.windowHead += 1;
		}
	}

	@Override
	public Double getMovingAverage() {
		if (this.list.size() > 0){
			int size = this.list.size() < this.windowSize ? this.list.size() : this.windowSize;
			return currentSum / size;
		}
		return 0.0;
	}

	@Override
	public Double[] getElements() {
		Double[] arr = new Double[windowSize];
		return this.list.toArray(arr);
	}

}
