package view.dungeon;

import static controller.Main.MF;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.dto.battle.Battle;
import model.dto.item.weapon;

import javax.swing.border.TitledBorder;
import javax.swing.JProgressBar;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class BattlePanel extends JPanel {
	Battle battle;

	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	JButton btnNewButton_4;

	JProgressBar progressBar;
	JProgressBar progressBar_1;
	JProgressBar progressBar_2;
	JProgressBar progressBar_3;
	JProgressBar progressBar_4;

	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel SkillPanel;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	public JPanel victoryPanel;
	public JLabel victoryLabel;
	public JLabel getExpLabel;
	public JButton victoryButton;
	private JPanel panel_9;
	private JPanel monsterImagePanel;
	private JPanel MonsterDamage;
	private JPanel UserDamage;

	public BattlePanel() {
	}

	public BattlePanel(Battle battle) {
		this.battle = battle;
		
		System.out.println("경험치 : "+battle.monster.EXP);
		System.out.println("경험치 : "+battle.monster.EXP_MAX);
		setLayout(null);

		JPanel userStatPanel = new JPanel();
		userStatPanel.setBounds(12, 428, 212, 120);
		userStatPanel.setBorder(new TitledBorder(null, "유저", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(userStatPanel);
		userStatPanel.setLayout(new GridLayout(0, 1, 0, 0));

		panel_3 = new JPanel();
		userStatPanel.add(panel_3);
		JLabel UserStat2 = new JLabel("HP : ");
		panel_3.add(UserStat2);

		progressBar = new JProgressBar();
		panel_3.add(progressBar);
		progressBar.setString(battle.User.HP + " / " + battle.User.HP_MAX);
		progressBar.setValue((int) ((double) battle.User.HP
				/ (double) battle.User.HP_MAX * 100));
		progressBar.setStringPainted(true);

		panel_4 = new JPanel();
		userStatPanel.add(panel_4);
		JLabel UserStat3 = new JLabel("MP : ");
		panel_4.add(UserStat3);

		progressBar_1 = new JProgressBar();
		panel_4.add(progressBar_1);
		progressBar_1
				.setString(battle.User.MP_MAX + " / " + battle.User.MP_MAX);
		progressBar_1.setValue((int) ((double) battle.User.MP
				/ (double) battle.User.MP_MAX * 100));
		progressBar_1.setStringPainted(true);

		panel_5 = new JPanel();
		userStatPanel.add(panel_5);
		JLabel UserStat4 = new JLabel("EXP : ");
		panel_5.add(UserStat4);

		progressBar_2 = new JProgressBar();
		panel_5.add(progressBar_2);
		progressBar_2.setStringPainted(true);

		JPanel controllPanel = new JPanel();
		controllPanel.setBounds(245, 480, 500, 50);
		add(controllPanel);

		btnNewButton = new JButton("공격");
		controllPanel.setLayout(new GridLayout(0, 5, 0, 0));
		controllPanel.add(btnNewButton);

		btnNewButton_1 = new JButton("방어");
		controllPanel.add(btnNewButton_1);

		btnNewButton_2 = new JButton("스킬");
		controllPanel.add(btnNewButton_2);

		btnNewButton_3 = new JButton("아이템");
		controllPanel.add(btnNewButton_3);

		btnNewButton_4 = new JButton("도주");
		controllPanel.add(btnNewButton_4);

		JPanel mosterStatPanel = new JPanel();
		mosterStatPanel.setBorder(new TitledBorder(null, battle.monster.name,
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mosterStatPanel.setBounds(540, 29, 212, 100);
		add(mosterStatPanel);
		mosterStatPanel.setLayout(new GridLayout(0, 1, 0, 0));

		panel_6 = new JPanel();
		mosterStatPanel.add(panel_6);

		JLabel label_2 = new JLabel("HP : ");
		panel_6.add(label_2);

		progressBar_3 = new JProgressBar();
		panel_6.add(progressBar_3);
		progressBar_3.setValue((int) ((double) battle.monster.HP
				/ (double) battle.monster.HP_MAX * 100));
		progressBar_3.setStringPainted(false);

		panel_7 = new JPanel();
		mosterStatPanel.add(panel_7);

		JLabel label_3 = new JLabel("MP : ");
		panel_7.add(label_3);

		progressBar_4 = new JProgressBar();
		panel_7.add(progressBar_4);
		progressBar_4.setValue((int) ((double) battle.monster.MP
				/ (double) battle.monster.MP_MAX * 100));
		progressBar_4.setStringPainted(false);

		SkillPanel = new JPanel();
		SkillPanel.setBounds(445, 230, 100, 250);
		add(SkillPanel);
		SkillPanel.setLayout(new GridLayout(0, 1, 0, 0));

		btnNewButton_5 = new JButton();
		SkillPanel.add(btnNewButton_5);

		btnNewButton_6 = new JButton();
		SkillPanel.add(btnNewButton_6);

		btnNewButton_7 = new JButton();
		SkillPanel.add(btnNewButton_7);

		btnNewButton_8 = new JButton();
		SkillPanel.add(btnNewButton_8);

		btnNewButton_9 = new JButton();
		SkillPanel.add(btnNewButton_9);
		SkillPanel.setVisible(false);
		SkillPanel.setEnabled(false);

		victoryPanel = new JPanel();
		victoryPanel.setBackground(SystemColor.activeCaptionBorder);
		victoryPanel.setBounds(245, 225, 300, 55);
		add(victoryPanel);
		victoryPanel.setLayout(new BorderLayout(0, 0));
		
		panel_9 = new JPanel();
		panel_9.setBackground(Color.LIGHT_GRAY);
		victoryPanel.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
				victoryLabel = new JLabel("\uC2B9\uB9AC\uD558\uC600\uC2B5\uB2C8\uB2E4");
				panel_9.add(victoryLabel);
				
						getExpLabel = new JLabel();
						panel_9.add(getExpLabel);
						
								JLabel lblNewLabel_1 = new JLabel(
										"\uC758 \uACBD\uD5D8\uCE58\uB97C \uC5BB\uC5C8\uC2B5\uB2C8\uB2E4");
								panel_9.add(lblNewLabel_1);

		victoryButton = new JButton("\uB2EB\uAE30");
		victoryPanel.add(victoryButton, BorderLayout.SOUTH);
		victoryPanel.setVisible(false);

		String[] array = getSkillName();
		btnNewButton_5.setText(array[0]);
		btnNewButton_6.setText(array[1]);
		btnNewButton_7.setText(array[2]);
		btnNewButton_8.setText(array[3]);
		btnNewButton_9.setText(array[4]);
		
		MonsterDamage = new JPanel();
		MonsterDamage.setBackground(Color.CYAN);
		MonsterDamage.setBounds(374, 54, 132, 130);
		add(MonsterDamage);
		
		UserDamage = new JPanel();
		UserDamage.setBackground(Color.CYAN);
		UserDamage.setBounds(261, 304, 132, 130);
		add(UserDamage);
		
		JPanel userImagePanel = new JPanel();
		userImagePanel.setBackground(Color.RED);
		userImagePanel.setBounds(96, 230, 249, 370);
		add(userImagePanel);
		
		monsterImagePanel = new JPanel();
		monsterImagePanel.setBackground(Color.RED);
		monsterImagePanel.setBounds(445, 29, 200, 250);
		add(monsterImagePanel);

		ButtonAction BP = new ButtonAction();
		btnNewButton.addActionListener(BP);
		btnNewButton_1.addActionListener(BP);
		btnNewButton_2.addActionListener(BP);
		btnNewButton_3.addActionListener(BP);
		btnNewButton_4.addActionListener(BP);

		VictoryAction VA = new VictoryAction();
		victoryButton.addActionListener(VA);

		SkillAction SA = new SkillAction();
		btnNewButton_5.addActionListener(SA);
		btnNewButton_6.addActionListener(SA);
		btnNewButton_7.addActionListener(SA);
		btnNewButton_8.addActionListener(SA);
		btnNewButton_9.addActionListener(SA);

	}

	public String[] getSkillName() {
		String[] array = new String[5];
		// 유저 스킬 이름 얻어오기
		array[0] = battle.User.skill[0].name;
		array[1] = battle.User.skill[1].name;
		// 아이템 스킬 이름 얻어오기
		System.out.println(array[0]);

		for (int i = 2; i < 5; i++)
			try {
				array[i] = ((weapon) battle.User.weapon).skill[i - 2].name;
			} catch (NullPointerException e) {
				array[i] = "";
			}

		if (array[0] == "") {
			this.btnNewButton_5.setEnabled(false);
			System.out.println("되나");
		}
		if (array[1] == "") {
			btnNewButton_6.setEnabled(false);
			System.out.println("되나");
		}
		if (array[2] == "") {
			btnNewButton_7.setEnabled(false);
			System.out.println("되나");
		}
		if (array[3] == "") {
			btnNewButton_8.setEnabled(false);
			System.out.println("되나");
		}
		if (array[4] == "") {
			btnNewButton_9.setEnabled(false);
			System.out.println("되나");
		}

		return array;
	}

	public void setStatus() {
		// 유저 스테이터스 갱신
		System.out.println((double) battle.User.HP
				/ (double) battle.User.HP_MAX);
		System.out.println((int) ((double) battle.User.HP
				/ (double) battle.User.HP_MAX * 100));
		progressBar.setString(battle.User.HP + " / " + battle.User.HP_MAX);
		progressBar_1
				.setString(battle.User.MP_MAX + " / " + battle.User.MP_MAX);
		progressBar.setValue((int) ((double) battle.User.HP
				/ (double) battle.User.HP_MAX * 100));
		progressBar_1.setValue((int) ((double) battle.User.MP
				/ (double) battle.User.MP_MAX * 100));
		// 몬스터 스테이터스 갱신
		progressBar_3.setValue((int) ((double) battle.monster.HP
				/ (double) battle.monster.HP_MAX * 100));
		progressBar_4.setValue((int) ((double) battle.monster.MP
				/ (double) battle.monster.MP_MAX * 100));
	}

	public void setVictoryPanel() {
		getExpLabel.setText(battle.monster.EXP_MAX + "");
		victoryPanel.setVisible(true);
		victoryPanel.setEnabled(true);
		System.out.println("여기는 된다");

	}

	class ButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnNewButton) {
				System.out.println("공격");
				battle.toBattle();
				setStatus();
			} else if (e.getSource() == btnNewButton_1) {
				System.out.println("방어");
				battle.defence();
				setStatus();
			} else if (e.getSource() == btnNewButton_2) {

				if (SkillPanel.isVisible()) {
					SkillPanel.setVisible(false);
					SkillPanel.setEnabled(false);
				} else {
					SkillPanel.setVisible(true);
					SkillPanel.setEnabled(true);
				}
			} else if (e.getSource() == btnNewButton_3) {
				System.out.println("아이템");
			} else if (e.getSource() == btnNewButton_4) {
				System.out.println("도주");
				MF.setMainFrame();
			}

			if (battle.monster.HP <= 0) {
				System.out.println("승리조건 검사");
				battle.User.EXP_MAX += battle.monster.EXP_MAX;
				setVictoryPanel();
			}

		}
	}

	class SkillAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnNewButton_5) {
				battle.skillAttack(battle.User.skill[0]);
				System.out.println("참격참격");
			} else if (e.getSource() == btnNewButton_6) {
				battle.skillAttack(battle.User.skill[1]);
			} else if (e.getSource() == btnNewButton_7) {
				battle.skillAttack(((weapon) battle.User.weapon).skill[0]);
			} else if (e.getSource() == btnNewButton_8) {
				battle.skillAttack(((weapon) battle.User.weapon).skill[1]);
			} else if (e.getSource() == btnNewButton_9) {
				battle.skillAttack(((weapon) battle.User.weapon).skill[2]);
			}
			setStatus();
			if (battle.monster.HP <= 0) {
				battle.User.EXP_MAX += battle.monster.EXP_MAX;
				setVictoryPanel();
			}
		}
	}

	class VictoryAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == victoryButton) {
				System.out.println("여기는?");
				MF.setSearchDungeonDefault();
			}
		}

	}
}
