package view.dungeon;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class SearchResultView {
	public SearchResultView(){
		System.out.println("Å½»ö Á¾·á");
		JDialog JD = new JDialog();
		JPanel JP = new JPanel();
		JButton ok = new JButton("Yes");
		JButton no = new JButton("no");
		JD.setSize(240,320);
		JP.add(ok);
		JP.add(no);
		JD.add(JP);
		JP.setVisible(true);
		
		JD.setVisible(true);
	}
}
