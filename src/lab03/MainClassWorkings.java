package lab03;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;

// Note: this whole lab 03 is simply a simulation, not actually garbage collecting [correct?]

public class MainClassWorkings {
	
	// Global Variables are as follows:
	// declare the three separate integer arrays.
	List<Integer> redFish;
	List<Integer> blueFish;
	List<Integer> yellowFish;
	
	/**
	 * Constructor. 
	 */
	public MainClassWorkings()
	{
		// Initialize the three integer arrays.
		List<Integer> redFish = new ArrayList<Integer>();
		List<Integer> blueFish = new ArrayList<Integer>();
		List<Integer> yellowFish = new ArrayList<Integer>();
		
		// 1 single integer is exactly 4 bytes.
		// therefore if i add exactly 3 integer variables to the
		// redFish integer array then the redFish integer array will be 
		// exactly 12 bytes.
		redFish.add(1);
		redFish.add(2);
		redFish.add(3);
		
		// 1 single integer is exactly 4 bytes.
		// therefore if i add exactly 2 integer variables to the
		// blueFish integer array then the blueFish integer array will be 
		// exactly 8 bytes.
		blueFish.add(1);
		blueFish.add(2);
		
		// 1 single integer is exactly 4 bytes.
		// therefore if i add exactly 1 integer variables to the
		// yellowFish integer array then the yellowFish integer array will be 
		// exactly 4 bytes.
		yellowFish.add(3);
		
		// so after this redFish is 12 bytes, blueFish is 8 bytes and yellowFish is 4 bytes.
	}
}
