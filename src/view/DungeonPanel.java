package view;

import static common.LoadData.*;
import static common.LoadImage.image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.dao.listener.DungeonListener;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class DungeonPanel extends JPanel {
	public JButton Return;
	public JButton commit;
	public JList list;
	public JLabel label;
	public JLabel explainLabel;
	public JLabel upperLabel;
	public JPanel upper;
	public JPanel upperRight;
	public JPanel upperLeft;
	public JPanel lower;
	public JPanel selectBackground;
	//final ImageIcon bgimg = new ImageIcon("1.jpg");
	ImageIcon bgimg;
	
	DungeonListener DL = new DungeonListener();
	

	public DungeonPanel() {
		String[] dunlist = new String[HMDungeon.size()];
		for (String temp : HMDungeon.keySet())
			dunlist[Integer.parseInt(temp) - 1] = temp + " : " + HMDungeon.get(temp).name;
		upperRight = new JPanel();
		upperRight.setBounds(50, 70, 300, 300);
		upperLeft = new JPanel();
		upperLeft.setBounds(420, 270, 270, 100);
		upperLabel = new JLabel("[ 던전 메뉴입니다 ]", JLabel.CENTER);
		upper = new JPanel();
		lower = new JPanel();

		Return = new JButton("처음으로 돌아가기");
		commit = new JButton("선택한 던전으로 출발");
		list = new JList(dunlist);
		label = new JLabel("탐험하실 던전을 선택해주세요");
		explainLabel = new JLabel("던전에 대한 설명을 표시합니다");
		list.setDragEnabled(true);
		list.setFixedCellWidth(200);

		upperLabel.setFont(new Font("SanSerif", 1, 40));
		upperLabel.setBounds(new Rectangle());

		upperRight.add(list);
		upperLeft.add(label);
		upperLeft.add(explainLabel);
		lower.add(commit);
		lower.add(Return);
		setLayout(new BorderLayout(0, 0));
		add(upperLabel, BorderLayout.NORTH);
		upper.setLayout(null);
		upper.add(upperRight);
		upper.add(upperLeft);
		add(upper, BorderLayout.CENTER);
		add(lower, BorderLayout.SOUTH);
		upperLeft.setLayout(new GridLayout(2, 1));
		
		bgimg = new ImageIcon();
		selectBackground = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(bgimg.getImage(), 0, 0, null);
				super.paintComponents(g);
			}
		};
		selectBackground.setBackground(Color.WHITE);
		selectBackground.setBounds(420, 70, 270, 180);
		upper.add(selectBackground);

		upper.setVisible(true);
		upperRight.setVisible(true);
		upperLeft.setVisible(true);
		lower.setVisible(true);
		
//		upper.setBackground(Color.red);
//		upperRight.setBackground(Color.blue);
		upperRight.setOpaque(true);
		
		
		
		label.setOpaque(true);
//		upperLeft.setBackground(Color.CYAN);
		upperLeft.setOpaque(true);
		setOpaque(true);
		upper.setOpaque(true);
		lower.setOpaque(true);
		
		setVisible(true);

		Return.setActionCommand("return");
		Return.addActionListener(DL);
		commit.setActionCommand("commit");
		commit.addActionListener(DL);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		list.addListSelectionListener(new ListListener());

	}

	private class ListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			String selection = ((String)list.getSelectedValue()).split(" : ")[0];
			label.setText(((String)list.getSelectedValue()).split(" : ")[1] + "로 탐험을 떠납니다");
			explainLabel.setText(HMDungeon.get(selection).explain);
			
			bgimg = image[Integer.parseInt(selection)-1];
			selectBackground.repaint();
			DL.D = HMDungeon.get(selection);
		}
	}
}
