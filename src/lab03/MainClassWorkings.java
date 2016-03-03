package lab03;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;

// Note: this whole lab 03 is simply a simulation, not actually garbage collecting [correct?]

public class MainClassWorkings {
	
	RedFish redfish; // so redFish is 12 bytes?
	BlueFish bluefish; // so blueFish is 8 bytes?
	YellowFish yellowfish; // so yellowFish is 4 bytes cause it has reference? (global variable)
	
	// in the handle pool every entry same size
	Object[] handlePool;
	// Below: each and every memory block has a 4 byte header (an int if 4 bytes)
	int[] objectPool;
	/**
	 * Constructor. 
	 */
	public MainClassWorkings()
	{
		
	}
}
