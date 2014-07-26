package model.dao.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dungeon.DialogPanel;
import static controller.Main.*;

public class MainActionListner implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("dungeon")) {
			MF.setDungeonPanel();
		} else if (command.equals("equip")) {
			MF.setEquipPanel();
		} else if (command.equals("status")) {
			MF.setStatusPanel();
		} else if (command.equals("guild")) {
			MF.setGuildPanel();
		} else if (command.equals("exit")) {
			System.exit(0);
		}
	}
}
