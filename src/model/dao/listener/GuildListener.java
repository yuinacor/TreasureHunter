package model.dao.listener;

import static controller.Main.MF;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuildListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("return")) {
			MF.setMainFrame();
		}
	}
}
