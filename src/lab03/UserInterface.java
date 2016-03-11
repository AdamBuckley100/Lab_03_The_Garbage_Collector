package lab03;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Main Class and user interface combined.
 * @author Adam Buckley.
 * @Date 11/03/2016.
 *
 */

public class UserInterface extends JFrame {

	private static final DefaultListModel<Link> LinkList = new DefaultListModel<Link>();
	public static DefaultListModel<Fish> theHandlePool = new DefaultListModel<Fish>();
	public static DefaultListModel<Fish> theObjectPool = new DefaultListModel<Fish>();
	public static DefaultListModel<Fish> theRedPool = new DefaultListModel<Fish>();
	public static DefaultListModel theBluePool = new DefaultListModel<Fish>();
	public static DefaultListModel theYellowPool = new DefaultListModel<Fish>();

	/**
	 * The Constructor.
	 */
	public UserInterface()
	{
		// so the GUI can attach to list
		theHandlePool = new DefaultListModel();
		theObjectPool = new DefaultListModel();

		theRedPool = new DefaultListModel();
		theBluePool = new DefaultListModel();
		theYellowPool = new DefaultListModel();
	}

	/**
	 */
	private static void GraphicalInterface(MainClassWorkings main) {

		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = null;

		JComponent panel1 = firstTabCreate(main);
		tabbedPane.addTab("First tab section", icon, panel1,
				"");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent panel2 = secondTabCreate();
		tabbedPane.addTab("Second tab section", icon, panel2,
				"");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent panel3 = thirdTabCreate();
		tabbedPane.addTab("Third tab section", icon, panel3,
				"");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		JComponent panel4 = fourthTabCreate();
		tabbedPane.addTab("Fourth tab section", icon, panel4,
				"");
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

	public static JComponent firstTabCreate(final MainClassWorkings main)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));

		JLabel firstLabel = new JLabel("The Handle Pool: ");
		panel.add(firstLabel);

		panel.add(new JLabel());
		JLabel secondLabel = new JLabel("The Object Pool: ");
		panel.add(secondLabel);

		JList<Fish> theHandlePoolList = new JList<Fish>(theHandlePool);
		panel.add(theHandlePoolList);

		panel.add(new JLabel());
		JList<Fish> theObjectPoolList = new JList<Fish>(theObjectPool);
		panel.add(theObjectPoolList);
		theObjectPoolList.setCellRenderer(new FishRenderer());

		JButton buttonOne = new JButton("Create Red Fish");
		panel.add(buttonOne);

		JButton buttonTwo = new JButton("Create Blue Fish");
		panel.add(buttonTwo);

		JButton buttonThree = new JButton("Create Yellow Fish");
		panel.add(buttonThree);

		buttonOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				RedFish buttonPressFish = new RedFish();

				theHandlePool.addElement(buttonPressFish);
				theObjectPool.addElement(buttonPressFish);
				theRedPool.addElement(buttonPressFish);
			}
		});

		buttonTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				BlueFish buttonPressFish = new BlueFish();
				theHandlePool.addElement(buttonPressFish);
				theObjectPool.addElement(buttonPressFish);
				theBluePool.addElement(buttonPressFish);
			}
		});

		buttonThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				YellowFish buttonPressFish = new YellowFish();
				theHandlePool.addElement(buttonPressFish);
				theObjectPool.addElement(buttonPressFish);
				theYellowPool.addElement(buttonPressFish);
			}
		});
		return panel;
	}

	public static JComponent secondTabCreate()
	{
		JPanel panel = new JPanel(false);

		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);

		JPanel theMainPanel = new JPanel();

		GridLayout gl = new GridLayout(2, 4);
		gl.setHgap(3);
		theMainPanel.setLayout(gl);

		JLabel firstLabel = new JLabel("Local variables");
		theMainPanel.add(firstLabel);

		JLabel secondLabel = new JLabel("Red Fish");
		theMainPanel.add(secondLabel);
		JLabel thirdLabel = new JLabel("Blue Fish");
		theMainPanel.add(thirdLabel);
		JLabel fourthLabel = new JLabel("yellow Fish");
		theMainPanel.add(fourthLabel);

		DefaultListModel<String> localVariables = new DefaultListModel<String>();

		localVariables.addElement("The Red Variable");
		localVariables.addElement("The Blue Variable");
		localVariables.addElement("The Yellow Variable");

		JList<String> listNumberOne = new JList<String>(localVariables);
		theMainPanel.add(listNumberOne);

		JList<Fish> listNumberTwo = new JList<Fish>(theRedPool);
		theMainPanel.add(listNumberTwo);

		JList<Fish> listNumberThree = new JList<Fish>(theBluePool);
		theMainPanel.add(listNumberThree);

		JList<Fish> listNumberFour = new JList<Fish>(theYellowPool);
		theMainPanel.add(listNumberFour);

		panel.add(theMainPanel);
		JPanel secondPanel = new JPanel();
		secondPanel.setLayout(new GridLayout(2, 1));

		JButton createLink = new JButton("Create the link");
		secondPanel.add(createLink);

		createLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String var = listNumberOne.getSelectedValue();
				Fish redFish = listNumberTwo.getSelectedValue();
				Fish blueFish = listNumberThree.getSelectedValue();
				Fish yellowFish = listNumberFour.getSelectedValue();

				if (var != null)
				{
					if (redFish != null) {
						Link link = new Link(null, redFish);
						LinkList.addElement(link);
					}
					else if (blueFish !=null) {
						Link link = new Link(null, blueFish);
						LinkList.addElement(link);
					}
					else if (yellowFish !=null) {
						Link link = new Link(null, yellowFish);
						LinkList.addElement(link);
					}
				}
				else if (redFish != null)
				{
					if (blueFish !=null) {
						Link link = new Link(redFish, blueFish);
						LinkList.addElement(link);
					}
					else if (yellowFish !=null) {
						Link link = new Link(redFish, yellowFish);
						LinkList.addElement(link);
					}
					else if (redFish != null) {
						Link link = new Link(redFish, redFish);
						LinkList.addElement(link);
					}
				}
				else if (blueFish != null)
				{
					if (yellowFish != null) {
						Link link = new Link(blueFish, yellowFish);
						LinkList.addElement(link);
					}
					else if (blueFish !=null) {
						Link link = new Link(blueFish, blueFish);
						LinkList.addElement(link);
					}
				}
				else if (yellowFish != null)
				{
					if (yellowFish != null) {
						Link link = new Link(yellowFish, yellowFish);
						LinkList.addElement(link);
					}
				}
				// CLear selection added to take away selection after a link has been selected.
				listNumberOne.clearSelection();
				listNumberTwo.clearSelection();
				listNumberThree.clearSelection();
				listNumberFour.clearSelection();
			}
		});

		JList<Link> listOfLinkList = new JList<Link>(LinkList);
		secondPanel.add(listOfLinkList);
		panel.add(secondPanel);

		return panel;
	}

	//garbage collect...
	public static JComponent thirdTabCreate() {
		JPanel panel = new JPanel(false);
		panel.add(new JButton("Collect Garbage"));
		return panel;
	}

	public static JComponent fourthTabCreate() {
		JPanel panel = new JPanel(false);

		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);

		JPanel innerPanelOne = new JPanel();
		innerPanelOne.setLayout(new GridLayout(2, 3));

		innerPanelOne.add(new JLabel("The Handle Pool"));
		innerPanelOne.add(new JLabel("            "));
		innerPanelOne.add(new JLabel("The Object Pool"));
		JList<Fish> theHandlePoolList = new JList<Fish>(theHandlePool);
		innerPanelOne.add(theHandlePoolList);
		//space for serperation. (below)
		innerPanelOne.add(new JLabel("          "));
		JList<Fish> theObjectPoolList = new JList<Fish>(theObjectPool);
		innerPanelOne.add(theObjectPoolList);
		theObjectPoolList.setCellRenderer(new FishRenderer());

		JPanel innerPanelTwo = new JPanel();
		innerPanelTwo.setLayout(new FlowLayout());
		innerPanelTwo.add(new JButton("Slide"));
		panel.add(innerPanelOne);
		panel.add(innerPanelTwo);

		return panel;
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainClassWorkings mainWorkings = new MainClassWorkings();
				GraphicalInterface(mainWorkings);
			}
		});  
	}  
}