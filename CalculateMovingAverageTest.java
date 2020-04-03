package com.paytmlabs.sdechallenge;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This is the JUnit test class used to unit test various test cases of the MovingAverageImpl implementation class.
 * 
 * @author Rishi Bhalla
 *
 */
public class CalculateMovingAverageTest {
	
	/**
	 * This is the exception rule to check if the necessary exception is being thrown on providing incorrect values.
	 */
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	/**
	 * Instance of the MovingAverageImpl implementation class.
	 */
	private MovingAverageImpl movingAverageImpl;
	
	/**
	 * Final windowSize to freeze the value of the N.
	 */
	private final int windowSize = 3;
	
	
	/**
	 * init method to initialize the data to be used by the test cases.
	 */
	@Before
	public void init() {
		movingAverageImpl = new MovingAverageImpl(windowSize);
	}
	
    /**
     * Test case to verify that windowSize is not zero.
     */
	@Test
    public void testZeroWindowSize() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Please enter a valid window size.");
        new MovingAverageImpl(0);
    }
	
	/**
     * Test case to verify that windowSize is not negative.
     */
    @Test
    public void testNegativeWindowSize() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Please enter a valid window size.");
        new MovingAverageImpl(-1);
    }
	
    /**
     * Test case to verify that null element cannot be added.
     */
    @Test
    public void testAddingNullElement() {
    	exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Please add a valid element.");
        movingAverageImpl.addElement(null);
    }
    
    /**
     * Test case to verify that negative element cannot be added.
     */
    @Test
    public void testAddingNegativeElement() {
    	exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Please add a valid element.");
        movingAverageImpl.addElement(-1.0);
    }
    
    /**
     * Test case to verify that system calculates the moving average of the last N elements 
     * if the number of elements are less than N.
     */
    @Test
	public void testCalculateMovingAverageForLessThanNElements() {
		movingAverageImpl.addElement(2.0);
		movingAverageImpl.addElement(3.0);
		assertEquals(1.6, movingAverageImpl.calculateMovingAverage(), 0.1);
	}
    
    /**
     * Test case to verify that system calculates the moving average of the last N elements 
     * if the number of elements are equal to N.
     */
	@Test
	public void testCalculateMovingAverageForNElements() {
		movingAverageImpl.addElement(2.0);
		movingAverageImpl.addElement(3.0);
		movingAverageImpl.addElement(4.0);
		assertEquals(3.0, movingAverageImpl.calculateMovingAverage(), 0.0);
	}
	
	/**
     * Test case to verify that system calculates the moving average of the last N elements
     * if the number of elements are more than N.
     */
	@Test
	public void testCalculateMovingAverageForMoreThanNElements() {
		movingAverageImpl.addElement(2.0);
		movingAverageImpl.addElement(3.0);
		movingAverageImpl.addElement(4.0);
		movingAverageImpl.addElement(5.0);
		assertEquals(4.0, movingAverageImpl.calculateMovingAverage(), 0.0);
	}
}
