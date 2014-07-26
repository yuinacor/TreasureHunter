package view;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.dao.listener.MainActionListner;
import javax.swing.UIManager;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	JButton dungeon;
	JButton equip;
	JButton guild;
	JButton exit;
	private JPanel menuPanel;

	public MainPanel() {

		JPanel panel_1 = new MyPanel();
		panel_1.paintComponents(null);
		panel_1.setSize(800, 350);
		panel_1.setBounds(100, 50, 600, 240);
		add(panel_1);
		setLayout(null);
		menuPanel = new JPanel();
		menuPanel.setBorder(null);
		menuPanel.setBackground(Color.ORANGE);
		menuPanel.setOpaque(false);
		menuPanel.setBounds(162, 350, 480, 50);
		add(menuPanel);
		menuPanel.setLayout(new GridLayout(0, 4, 8, 0));
		dungeon = new JButton("´øÀü");
		dungeon.setFont(new Font("±¼¸²", Font.BOLD, 23));
		dungeon.setForeground(Color.WHITE);
		dungeon.setBackground(Color.DARK_GRAY);
		menuPanel.add(dungeon);

		dungeon.setActionCommand("dungeon");
		equip = new JButton("Àåºñ");
		equip.setFont(new Font("±¼¸²", Font.BOLD, 23));
		equip.setForeground(Color.WHITE);
		equip.setBackground(Color.DARK_GRAY);
		menuPanel.add(equip);
		equip.setActionCommand("equip");
		guild = new JButton("±æµå");
		guild.setFont(new Font("±¼¸²", Font.BOLD, 23));
		guild.setForeground(Color.WHITE);
		guild.setBackground(Color.DARK_GRAY);
		menuPanel.add(guild);
		guild.setActionCommand("guild");
		exit = new JButton("Á¾·á");
		exit.setFont(new Font("±¼¸²", Font.BOLD, 23));
		exit.setForeground(Color.WHITE);
		exit.setBackground(Color.DARK_GRAY);
		menuPanel.add(exit);
		exit.setActionCommand("exit");

		setVisible(true);
		setBackground(Color.GRAY);

		
		MainActionListner MAL = new MainActionListner();
		exit.addActionListener(MAL);
		guild.addActionListener(MAL);
		equip.addActionListener(MAL);
		dungeon.addActionListener(MAL);
		
		JPanel panel_2 = new MyPanel2();
		panel_2.paintComponents(null);
//		panel_2.setSize(800, 350);
		panel_2.setBounds(0, 0, 800, 600);
		add(panel_2);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g)
		{
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File("THlogo_L.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(img, 0, 0, img.getWidth() ,img.getHeight(), this);
		}
	}
	class MyPanel2 extends JPanel{
		public void paintComponent(Graphics g)
		{
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File("Dragons.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(img, 0, 0, img.getWidth() ,img.getHeight(), this);
		}
	}
}
