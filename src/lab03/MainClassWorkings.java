package lab03;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

// Note: this whole lab 03 is simply a simulation, not actually garbage collecting [correct?]

public class MainClassWorkings {

	// in the handle pool every entry same size
	public DefaultListModel handlePool;
	// Below: each and every memory block has a 4 byte header (an int if 4 bytes)
	public DefaultListModel objectPool;

	/**
	 * Constructor. 
	 */
	public MainClassWorkings()
	{
		// so the GUI can attach to list
		handlePool = new DefaultListModel();
		objectPool = new DefaultListModel();
	}

	public void addFish()
	{

	}
}
