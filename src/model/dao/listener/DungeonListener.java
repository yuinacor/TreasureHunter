package model.dao.listener;

import static controller.Main.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.dto.dungeon.Dungeon;

public class DungeonListener implements ActionListener {
	public Dungeon D;

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("return")) {
			MF.setMainFrame();
		} else if (command.equals("commit")) {
			MF.setSearchDungeon(D);
		}

	}

}
