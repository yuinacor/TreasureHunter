package controller;


import common.LoadData;
import common.LoadImage;

import view.*;

public class Main {
    public static MainFrame MF;
    
    public static void main(String[] args) {
    	LoadData LD = new LoadData();
    	LoadImage LI = new LoadImage();
	MF = new MainFrame();
	MF.setMainFrame();
    }

}
