package lab03;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UserInterface extends JFrame {
	
	// in the handle pool every entry same size
	public DefaultListModel handlePool;
	// Below: each and every memory block has a 4 byte header (an int if 4 bytes)
	public DefaultListModel objectPool;
	
	public static DefaultListModel redPool;
	public static DefaultListModel bluePool;
	public static DefaultListModel yellowPool;
	
	//public static DefaultListModel links;
	private static final DefaultListModel<Link> links = new DefaultListModel<Link>();

	
	public UserInterface()
	{
		// so the GUI can attach to list
		handlePool = new DefaultListModel();
		objectPool = new DefaultListModel();
		
		redPool = new DefaultListModel();
		bluePool = new DefaultListModel();
		yellowPool = new DefaultListModel();
	}
	
	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI(MainClassWorkings main) {

		//MainClassWorkings main = new MainClassWorkings();

		//Create and set up the window.
		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = null; //createImageIcon("images/middle.gif");

		JComponent panel1 = makeTabOne(main);
		tabbedPane.addTab("Tab 1", icon, panel1,
				"Does nothing");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent panel2 = makeTabTwo();
		tabbedPane.addTab("Tab 2", icon, panel2,
				"Does twice as much nothing");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent panel3 = makeTabThree();
		tabbedPane.addTab("Tab 3", icon, panel3,
				"Still does nothing");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		JComponent panel4 = makeTabFour();
		//    "Panel #4 (has a preferred size of 410 x 50).");
		//panel4.setPreferredSize(new Dimension(410, 50));
		tabbedPane.addTab("Tab 4", icon, panel4,
				"Does nothing at all");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);


		frame.getContentPane().add(tabbedPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}

	public static JComponent makeTabOne(final MainClassWorkings main) {
		JPanel panel = new JPanel(false);

		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);

		JPanel innerPanelOne = new JPanel();
		innerPanelOne.setLayout(new GridLayout(2, 3));

		innerPanelOne.add(new JLabel("Handle Pool"));
		innerPanelOne.add(new JLabel("          "));
		innerPanelOne.add(new JLabel("Object Pool"));
		JList<Fish> handleList = new JList<Fish>(main.handlePool);
		innerPanelOne.add(handleList);

		innerPanelOne.add(new JLabel("          "));

		JList<Fish> objectList = new JList<Fish>(main.objectPool);
		innerPanelOne.add(objectList);

		objectList.setCellRenderer(new FishRenderer());

		JPanel innerPanelTwo = new JPanel();
		innerPanelTwo.setLayout(new FlowLayout());

		JButton addRedFish = new JButton("Add Red Fish");
		innerPanelTwo.add(addRedFish);
		addRedFish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				main.handlePool.addElement(new RedFish());

				// need size added too below. CUSTOM RENDERER NEEDED

				main.objectPool.addElement(new RedFish());

				//main.objectPool.setCellRenderer(new FishRenderer());
			}
		});

		//innerPanelTwo.add(new JButton("Red Fish"));
		//addRedFish

		JButton addBlueFish = new JButton("Add Blue Fish");
		innerPanelTwo.add(addBlueFish);
		addBlueFish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				main.handlePool.addElement(new BlueFish());
				main.objectPool.addElement(new BlueFish());

			}
		});

		JButton addYellowFish = new JButton("Add Yellow Fish");
		innerPanelTwo.add(addYellowFish);
		addYellowFish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				main.handlePool.addElement(new YellowFish());
				main.objectPool.addElement(new YellowFish());

				//main.objectPool.setCellRenderer(new FishRenderer());
			}
		});

		//innerPanelTwo.add(new JButton("Blue Fish"));
		//innerPanelTwo.add(new JButton("Yellow Fish"));

		panel.add(innerPanelOne);
		panel.add(innerPanelTwo);
		return panel;
	}

	public static JComponent makeTabTwo() {
		JPanel panel = new JPanel();

		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);

		JPanel innerPanelOne = new JPanel();
		//GridLayout gl = innerPanelOne.setLayout(new GridLayout(2,4));
		GridLayout gl = new GridLayout(2, 4);
		gl.setHgap(3);
		innerPanelOne.setLayout(gl);
		
		innerPanelOne.add(new JLabel("Local variables"));
		innerPanelOne.add(new JLabel("red Fish instances"));
		innerPanelOne.add(new JLabel("blue Fish instances"));
		innerPanelOne.add(new JLabel("yellow Fish instances"));
		//innerPanelOne.add(new JList());
		//innerPanelOne.add(new JList());
		//innerPanelOne.add(new JList());
		//innerPanelOne.add(new JList());
		
		DefaultListModel<String> localVariables = new DefaultListModel<String>();
		localVariables.addElement("Red variable:");
		localVariables.addElement("Yellow variable:");
		
		JList<String> list1 = new JList<String>(localVariables);
		panel.add(list1);
		
		JList<Fish> list2 = new JList<Fish>(redPool);
		panel.add(list2);
		
		JList<String> list3 = new JList<String>(bluePool);
		panel.add(list3);
		
		JList<String> list4 = new JList<String>(yellowPool);
		panel.add(list4);

		JPanel innerPanelTwo = new JPanel();
		innerPanelTwo.add(new JButton("Create Link"));

		JPanel innerPanelThree = new JPanel();
		innerPanelThree.setLayout(new GridLayout(2, 1));
		innerPanelThree.add(new JLabel("LINKS: (below)"));
		innerPanelThree.add(new JList());

		panel.add(innerPanelOne);
		panel.add(innerPanelTwo);
		panel.add(innerPanelThree);
		
		createLink.addActionListener(new ActionListener() {
			public void actionPerfomed(ActionEvent event) {
				String variable = list1.getSelectedValue();
				Fish redFish = list2.getSelectedValue();
				String blueFish = list3.getSelectedValue();
				String yellowFish = list4.getSelectedValue();
				
				if (variable != null) {
					if (redFish != null) {
						Link link = new Link(null, redFish);
						links.addElement(link);
					}
		}
		
		list1.clearSelection();
		list2.clearSelection();
		list3.clearSelection();
		list4.clearSelection();
		
		}
		});
		
		JList<Link> listOfLinks = new JList<Link>(links);

		//  JPanel innerPanelOne = new JPanel();
		return panel;
	}

	public static JComponent makeTabThree() {
		JPanel panel = new JPanel(false);
		panel.add(new JButton("garbage collect"));
		return panel;
	}

	public static JComponent makeTabFour() {
		JPanel panel = new JPanel(false);


		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);

		JPanel innerPanelOne = new JPanel();
		innerPanelOne.setLayout(new GridLayout(2, 3));

		innerPanelOne.add(new JLabel("Handle Pool"));
		innerPanelOne.add(new JLabel("          "));
		innerPanelOne.add(new JLabel("Object Pool"));
		innerPanelOne.add(new JList());
		innerPanelOne.add(new JLabel("          "));
		innerPanelOne.add(new JList());


		JPanel innerPanelTwo = new JPanel();
		innerPanelTwo.setLayout(new FlowLayout());
		innerPanelTwo.add(new JButton("Slide"));
		panel.add(innerPanelOne);
		panel.add(innerPanelTwo);

		return panel;
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainClassWorkings main = new MainClassWorkings();
				createAndShowGUI(main);
			}
		});  
	}  
}