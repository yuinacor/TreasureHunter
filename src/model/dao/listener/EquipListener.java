package model.dao.listener;

import static controller.Main.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
	String command = e.getActionCommand();
	if(command.equals("return")){
	    MF.setMainFrame();
	}
    }
}
