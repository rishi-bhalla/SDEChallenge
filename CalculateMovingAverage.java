package com.paytmlabs.sdechallenge;

/**
 * This is the main class which is used to instantiate the MovingAverageImpl class, add elements into the data structure
 * and calculate the moving average of the last N elements.
 * It also accesses all the elements of the underlying data structure.
 * 
 * @author Rishi Bhalla
 *
 */
public class CalculateMovingAverage {
	
	public static void main(String[] args) {
		int windowSize = -1;
		MovingAverageImpl movingAverageImpl = null;
		
		//example of null check for windowSize. For now commented out.
		//movingAverageImpl = new MovingAverageImpl(windowSize);
		
		windowSize = 3;
		movingAverageImpl = new MovingAverageImpl(windowSize);
		
		//accessing the addElements of the implementation class.
		movingAverageImpl.addElement(2.0);
		movingAverageImpl.addElement(3.0);
		movingAverageImpl.addElement(4.0);
		movingAverageImpl.addElement(5.0);
		movingAverageImpl.addElement(6.0);
		
		//calculating the moving average of the last N elements.
		System.out.println("The moving average is: " + movingAverageImpl.calculateMovingAverage());
		
		//accessing all the elements of the underlying data structure.
		System.out.println("Elements in the list are: " + movingAverageImpl.getElements());
	}
}
