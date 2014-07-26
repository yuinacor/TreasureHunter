package view.dungeon;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DialogPanel extends JComponent{
	public JLabel JL01;
	public JPanel JP01;
	
	public DialogPanel(){
		JL01 = new JLabel("Å×½ºÆ®");
		JP01 = new JPanel();
		JL01.setBackground(Color.red);
		JP01.add(JL01);
		add(JP01);
		setVisible(true);
		setBackground(Color.blue);
		setOpaque(true);
	}
	
}
