package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.dao.listener.StatusListener;

@SuppressWarnings("serial")
public class StatusPanel extends JPanel {
    JButton Return;

    public StatusPanel() {
	Return = new JButton("처음으로 돌아가기");
	add(Return);
	setVisible(true);
	StatusListener EL = new StatusListener();
	Return.setActionCommand("return");
	Return.addActionListener(EL);
    }
}
