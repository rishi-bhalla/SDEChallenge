package com.paytmlabs.sdechallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the implementation of the MovingAverage interface with type as Double.
 * 
 * @author Rishi Bhalla
 * 
 */
public class MovingAverageImpl implements MovingAverage<Double> {

	/**
	 * "sum" is used to store the sum of last N elements at any given time. The sum is modified every time a valid 
	 * element is added to the data structure.
	 */
	private Double sum;
	
	/**
	 * "windowSize" is used to capture the count of last N elements for which the moving average is to be calculated. 
	 * Made it "final" to make sure it's value isn't modified during the coarse of execution and results in inconsistent result.
	 * Also, this won't allow the client to change the value, once set, for each instance of this class. 
	 */
	private final int windowSize;
	
	/**
	 * "elements" here represents the data structure that contains all the elements. In this case, it is a list of Double elements.
	 */
	private List<Double> elements;
	
	
	/**
	 * Constructor of the MovingAverageImpl class that accepts a windowSize parameter. 
	 * 
	 * The necessary validation for windowSize not being less than zero has been taken into consideration to make sure we are 
	 * not even allowed to move ahead until we finalize the value of N, whose moving average is to be calculated.
	 * 
	 * More importantly, this is a one time check and we need not check the less than zero check later on during adding elements
	 * into the data structure or while calculating the moving average.
	 * 
	 * This will also improve the performance as we need not do the same check later on.
	 * 
	 * Other members i.e. sum and elements are also initialized and instantiated respectively.
	 * 
	 * @param windowSize
	 */
	public MovingAverageImpl(int windowSize) {
		if(windowSize <= 0)
			throw new IllegalArgumentException("Please enter a valid window size.");
		this.windowSize = windowSize;
		this.elements = new ArrayList<Double>();
		this.sum = 0.0;
	}

	/**
	 * This method provides the implementation of the addElement method of the MovingAverage interface.
	 * 
	 * Its add the input element to the data structure and calculates the sum of the last N elements at any given point of time.
	 * Necessary validations of null and negative elements have been added to make sure we only add valid elements.
	 * 
	 */
	@Override
	public void addElement(Double element) {
		if(element == null || element < 0)
			throw new IllegalArgumentException("Please add a valid element.");
		
		elements.add(element);
		sum += element;
		if(elements.size() > windowSize)
			sum = sum - elements.get(elements.size() - windowSize - 1);
	}

	/**
	 * This method provides the implementation of the getElements method of the MovingAverage interface.
	 * 
	 * It is used to return all the elements of the data structure.
	 */
	@Override
	public List<Double> getElements() {
		return elements;
	}

	/**
	 * This method provides the implementation of the calculateMovingAverage method of the MovingAverage interface.
	 * 
	 * It is used to return the moving average of the last N elements.
	 */
	@Override
	public Double calculateMovingAverage() {
		return sum/windowSize;
	}
}
