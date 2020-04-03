package com.paytmlabs.sdechallenge;

import java.util.List;

/**
 * This interface declares the following three method:
 * 
 * 1. Calculate and return the moving average of the last N elements from the data structure to the client. 
 * 2. Add new element to the data structure sent by the client.
 * 3. Return all the elements in the data structure to the client.
 * 
 * This interface is of a generic type (<T>) and the implementing class can use any type as per their requirements while 
 * implementing this interface.
 * 
 * @author Rishi Bhalla
 * 
 */
public interface MovingAverage<T> {

	/**
	 * This method accepts an element from the client and adds it towards the end to the data structure.
	 * 
	 * @param element
	 */
	void addElement(T element);
	
	/**
	 * This method returns all the elements in the data structure to the client.
	 * 
	 * @return the data structure to the client. Here in the form of a list.
	 */
	List<T> getElements();
	
	/**
	 * This method returns the moving average of the last N elements in the data structure to the client.
	 * 
	 * @return the moving average of the last N elements in the data structure.
	 */
	T calculateMovingAverage();
}
