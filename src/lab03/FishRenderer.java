package lab03;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Custom renderer to display a country's flag alongside its name
 *
 * @author wwww.codejava.net
 */
public class FishRenderer extends JLabel implements ListCellRenderer<Fish>
{
	@Override
	public Component getListCellRendererComponent(JList<? extends Fish> list, Fish value, int index,
			boolean isSelected, boolean cellHasFocus) {

		return new JLabel("boo");
	}  
}
