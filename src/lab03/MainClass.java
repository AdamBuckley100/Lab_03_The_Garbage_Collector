package lab03;


public class MainClass {
	
	private MainClassWorkings engine;
	private UserInterfaceOne gui;

	/**
	 * Create a new calculator and show it.
	 */
	public MainClass()
	{
		engine = new MainClassWorkings();
		gui = new UserInterfaceOne(engine);
	}

}
