package common;

import javax.swing.ImageIcon;

public class LoadImage {

	public static ImageIcon[] image;

	public LoadImage(){
		image = new ImageIcon[8];
		
		for(int i=1;i<9;i++)
		{
			image[i-1] = new ImageIcon("dungeon0"+i+".png");
		}
	}
}
