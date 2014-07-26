package model.dao.listener.dungeon;

import static controller.Main.MF;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchDungeonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("returnToMain")) {
			MF.setMainFrame();
		} 
	}
}
