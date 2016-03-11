package lab03;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UserInterface extends JFrame {

	// in the handle pool every entry same size
	//public DefaultListModel handlePool;
	// Below: each and every memory block has a 4 byte header (an int if 4 bytes)
	//public DefaultListModel objectPool;
	
	public static DefaultListModel<Fish> handlePool = new DefaultListModel<Fish>();
	public static DefaultListModel<Fish> objectPool = new DefaultListModel<Fish>();

	public static DefaultListModel<Fish> redPool = new DefaultListModel<Fish>();
	public static DefaultListModel bluePool = new DefaultListModel<Fish>();
	public static DefaultListModel yellowPool = new DefaultListModel<Fish>();

	//public static DefaultListModel links;
	private static final DefaultListModel<Link> links = new DefaultListModel<Link>();

	/**
	 * The Constructor.
	 */
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
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		
		JLabel label1 = new JLabel("Handle Pool");
		panel.add(label1);
		
		panel.add(new JLabel());
		
		JLabel label2 = new JLabel("Object Pool");
		panel.add(label2);
		
		JList<Fish> handlePoolList = new JList<Fish>(handlePool); // change?
		panel.add(handlePoolList);
		
		panel.add(new JLabel());
		
		JList<Fish> objectPoolList = new JList<Fish>(objectPool);
		panel.add(objectPoolList);
		objectPoolList.setCellRenderer(new FishRenderer());
		
		JButton button1 = new JButton("Red Fish");
		panel.add(button1);
		
		JButton button2 = new JButton("Blue Fish");
		panel.add(button2);
		
		JButton button3 = new JButton("Yellow Fish");
		panel.add(button3);
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				RedFish f = new RedFish();
				handlePool.addElement(f);
				objectPool.addElement(f);
				redPool.addElement(f);
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				BlueFish f = new BlueFish();
				handlePool.addElement(f);
				objectPool.addElement(f);
				bluePool.addElement(f);
			}
		});
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				YellowFish f = new YellowFish();
				handlePool.addElement(f);
				objectPool.addElement(f);
				yellowPool.addElement(f);
			}
		});
		
		return panel;
	}

	public static JComponent makeTabTwo() {
		
		JPanel panel = new JPanel(false);

		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);

		JPanel topPanel = new JPanel();
		
		GridLayout gl = new GridLayout(2, 4);
		gl.setHgap(3);
		topPanel.setLayout(gl);
		
		JLabel label1 = new JLabel("Local variables");
		topPanel.add(label1);
		
		JLabel label2 = new JLabel("Red Fish");
		topPanel.add(label2);
		
		JLabel label3 = new JLabel("Blue Fish");
		topPanel.add(label3);
		
		JLabel label4 = new JLabel("yellow Fish");
		topPanel.add(label4);
		
		DefaultListModel<String> localVariables = new DefaultListModel<String>();
		
		localVariables.addElement("red var");
		localVariables.addElement("blue var");
		localVariables.addElement("yellow var");
		
		JList<String> list1 = new JList<String>(localVariables);
		topPanel.add(list1);
		
		JList<Fish> list2 = new JList<Fish>(redPool);
		topPanel.add(list2);
		
		JList<Fish> list3 = new JList<Fish>(bluePool);
		topPanel.add(list3);
		
		JList<Fish> list4 = new JList<Fish>(yellowPool);
		topPanel.add(list4);
		
		panel.add(topPanel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(2, 1));
		
		JButton createLink = new JButton("Create Link");
		bottomPanel.add(createLink);
		
		createLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String var = list1.getSelectedValue();
				Fish redFish = list2.getSelectedValue();
				Fish blueFish = list3.getSelectedValue();
				Fish yellowFish = list4.getSelectedValue();

				if (var != null) {
					if (redFish != null) {
						Link link = new Link(null, redFish);
						links.addElement(link);
					}
					else if (blueFish !=null) {
						Link link = new Link(null, blueFish);
						links.addElement(link);
					}
				}
				
				// Why I hav clear selection: takes away selection after a link has been selected/
				list1.clearSelection();
				list2.clearSelection();
				list3.clearSelection();
				list4.clearSelection();
			}
		});

		JList<Link> listOfLinks = new JList<Link>(links);
		bottomPanel.add(listOfLinks);
		
		panel.add(bottomPanel);

		//  JPanel innerPanelOne = new JPanel();
		return panel;
	}

	//garbage collect...
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