package lab03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventHandlingDemo implements ActionListener  {
	public EventHandlingDemo() {
		JFrame frame = new JFrame("Events Here");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		frame.getContentPane().setLayout(new FlowLayout());
		JButton b = new JButton("Click me!");
		b.addActionListener(this);
		frame.getContentPane().add(b);  

		frame.pack();           
		frame.setVisible(true); 
	}
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Thank you");
	}

	public static void main(String[] args)  { new EventHandlingDemo(); }   
}