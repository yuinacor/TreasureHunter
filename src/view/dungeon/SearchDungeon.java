package view.dungeon;

import static common.LoadImage.image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.dao.listener.dungeon.DungeonSerching;
import model.dao.listener.dungeon.FloorSearching;
import model.dao.listener.dungeon.SearchDungeonListener;
import model.dto.dungeon.Dungeon;
import java.awt.FlowLayout;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JList;

@SuppressWarnings("serial")
public class SearchDungeon extends JPanel {
	JButton goFoward;
	JButton ReturnToMain;
	DungeonSerching DS;
	JPanel upper;
	JPanel lower;
	private JProgressBar progressBar;
	private JButton btnNewButton;
	public JPanel getStair;

	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	private JPanel resultPanel;

	public JList list;
	private JPanel panel;
	JButton btnNewButton_3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	public JLabel lblNewLabel_5;
	public JPanel selectBackground;
	public ImageIcon bgimg;
	private JPanel panel_3;

	public SearchDungeon() {
	}

	public SearchDungeon(Dungeon D) {

		bgimg = image[D.num - 1];
		selectBackground = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bgimg.getImage(), 0, 0, null);
				super.paintComponents(g);
			}
		};
		
		selectBackground.setBounds(0, 0, 800, 600);
		DS = new DungeonSerching(D);
		setLayout(null);

		panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 800, 600);
		panel_3.setOpaque(false);
		add(panel_3);
		add(selectBackground);
		panel_3.setLayout(null);
		upper = new JPanel();
		upper.setBounds(250, 0, 300, 30);
		panel_3.add(upper);

		lblNewLabel_4 = new JLabel(D.name);
		upper.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel(DS.floor + "");
		upper.add(lblNewLabel_5);

		lblNewLabel_3 = new JLabel("층");
		upper.add(lblNewLabel_3);

		progressBar = new JProgressBar();
		upper.add(progressBar);
		progressBar.setStringPainted(true);
		goFoward = new JButton("\uD0D0\uC0C9");
		ReturnToMain = new JButton("\uADC0\uD658");
		lower = new JPanel();
		lower.setBounds(250, 470, 300, 50);
		panel_3.add(lower);
		lower.setLayout(new GridLayout(0, 3, 0, 0));
		lower.add(goFoward);

		btnNewButton = new JButton("\uC544\uC774\uD15C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		lower.add(btnNewButton);
		lower.add(ReturnToMain);
		ReturnToMain.setActionCommand("returnToMain");

		goFoward.setActionCommand("goFoward");

		getStair = new JPanel();
		getStair.setBounds(250, 200, 300, 120);
		panel_3.add(getStair);
		getStair.setBackground(Color.ORANGE);
		getStair.setVisible(false);
		getStair.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		getStair.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel(
				"\uACC4\uB2E8\uC744 \uCC3E\uC558\uC2B5\uB2C8\uB2E4!");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
		panel_2.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1 = new JLabel(
				"\uB0B4\uB824\uAC00\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		getStair.add(panel_1, BorderLayout.SOUTH);

		btnNewButton_1 = new JButton("Yes");
		panel_1.add(btnNewButton_1);

		btnNewButton_2 = new JButton("No");
		panel_1.add(btnNewButton_2);

		resultPanel = new JPanel();
		resultPanel.setBounds(270, 130, 256, 288);
		panel_3.add(resultPanel);
		resultPanel.setBackground(Color.RED);
		resultPanel.setVisible(false);
		resultPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("이 층의 전리품");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		resultPanel.add(lblNewLabel_2, BorderLayout.NORTH);

		panel = new JPanel();
		resultPanel.add(panel);

		// String[] tt = new String[3];
		// tt[0] = "이히히";
		// tt[1] = "모르겠다";
		// tt[2] = "에헤헤";

		list = new JList();
		panel.add(list);

		btnNewButton_3 = new JButton("다음 층으로");
		resultPanel.add(btnNewButton_3, BorderLayout.SOUTH);

		goFoward.addActionListener(new SDListener());
		SearchDungeonListener SDL = new SearchDungeonListener();
		ReturnToMain.addActionListener(SDL);

		ResultLisetner RL = new ResultLisetner();
		btnNewButton_3.addActionListener(RL);
		btnNewButton_1.addActionListener(RL);
		btnNewButton_2.addActionListener(RL);
	}

	class SDListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("goFoward")) {
				int result = DS.goFoward();
				if (result == 100) {
					lower.setVisible(false);
					getStair.setVisible(true);

				} else
					progressBar.setValue((int) DS.floorSearching
							.completePercent());
			}
		}
	}

	class ResultLisetner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnNewButton_1) { // 다음층으로 내려가나요 Yes
				getStair.setVisible(false);
				// String[] array = new
				// String[DS.floorSearching.gettedItem.size()];
				// array = (String[])DS.floorSearching.gettedItem.toArray();
				// list = new JList(array);
				// list.add(DS.floorSearching.gettedItem.toArray(null));

				resultPanel.setVisible(true);
				//
				// DS.floor++;
				// DS.floorSearching = null;
				// DS.integralFloorSearchingData();
				// progressBar.setValue(0);

			} else if (e.getSource() == btnNewButton_2) { // 다음층으로 안내려감
				getStair.setVisible(false);
				lower.setVisible(true);
			} else if (e.getSource() == btnNewButton_3) { // 결과창 보고 다음층으로 내려감
				resultPanel.setVisible(false);
				lower.setVisible(true);
				DS.floor++;
				DS.integralFloorSearchingData();
				lblNewLabel_5.setText(DS.floor + "");
				DS.floorSearching = null;

				progressBar.setValue(0);

			}

		}

	}
}
