package view;

import static common.LoadData.HMItem;
import static common.LoadData.User;
import static common.LoadData.HMInventory;
import static common.LoadData.EnchantStone;
//import static controller.Main.MF;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.dao.listener.EquipListener;
import model.dto.item.Armor;
import model.dto.item.Item;
import model.dto.item.Ring;
import model.dto.item.weapon;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.util.HashMap;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")
public class EquipPanel extends JPanel {
	JButton Return;
	JButton remove;
	JButton Equip;
	JButton RemoveWeapon;
	JButton RemoveArmor;
	JButton RemoveRing;
	JList itemList;
	JList weaponList;
	JList armorList;
	JList ringList;
	JLabel itemData[];
	JLabel userData[];
	JLabel userEquip[];
	JLabel upper;
	JPanel itemDataPanel;
	JPanel itemListPanel;
	JPanel lower;
	JPanel middle;
	JPanel userStatusPanel;
	JPanel userEquipPanel;
	private JPanel enchantPanel;
	private JLabel enchantTitle;
	private JLabel targetItem;
	private JLabel plus;
	private JLabel enchantStoneLabel;
	private JLabel resultItem;
	private JButton EnchantItemButton;
	private JTabbedPane itemTab;
	private JPanel panel;

	public static HashMap<String, weapon> HMWeapon = null;
	public static HashMap<String, Armor> HMArmor = null;
	public static HashMap<String, Ring> HMRing = null;
	
	int selectedTab = 0;
	private JPanel itemButtonPanel;
	private JButton Enchant;
	
	public EquipPanel() {
		
		setLayout(new BorderLayout());

		String[] itemListArray = new String[HMItem.size()]; 
		int i = 0;
		int j = 0;
		int k = 0;
		
		HMWeapon = new HashMap<String, weapon>();
		HMArmor = new HashMap<String, Armor>();
		HMRing = new HashMap<String, Ring>();
		for (String temp : HMInventory.keySet()){
			if(temp.charAt(0) == 'w'){
				HMWeapon.put(temp, (weapon) HMInventory.get(temp));
			}else if(temp.charAt(0) == 'a'){
				HMArmor.put(temp, (Armor) HMInventory.get(temp));
			}else if(temp.charAt(0) == 'r'){
				HMRing.put(temp, (Ring) HMInventory.get(temp));
			}
		}
		
		
		/*for (String tempArm : HMInventory.keySet()){
			if(tempArm.charAt(0) == 'a'){
				HMArmor.put(tempArm, (Armor) HMInventory.get(tempArm));
			}
		}*/
		
		
		String[] weaponListArray = new String[HMWeapon.size()];
		String[] armorListArray = new String[HMArmor.size()]; 
		String[] ringListArray = new String[HMRing.size()];
		
		for (String tempWeapon : HMWeapon.keySet())
				weaponListArray[i++] = tempWeapon+ " : " + HMWeapon.get(tempWeapon).name;
		for (String tempArmor : HMArmor.keySet())
				armorListArray[j++] = tempArmor+ " : " + HMArmor.get(tempArmor).name;
		for (String tempRing : HMRing.keySet())
				ringListArray[k++] = tempRing+ " : " + HMRing.get(tempRing).name;
		
		/*for (String temp : HMInventory.keySet())
				itemListArray[i++] = temp+ " : " + HMInventory.get(temp).name;
		for (String tempArmor : HMArmor.keySet())
			armorListArray[j++] = tempArmor+ " : " + HMArmor.get(tempArmor).name;
		i=0;
		for (String temp : HMInventory.keySet()){
			if(temp.charAt(0) == 'a'){
				armorListArray[i++] = temp+ " : " + HMInventory.get(temp).name;
			}
		}*/
		
		
		itemData = new JLabel[8];
		userData = new JLabel[10];
		userEquip = new JLabel[12];
		remove = new JButton("����");
		
		Return = new JButton("ó������ ���ư���");
		upper = new JLabel("[ ��� ]", JLabel.CENTER);
		lower = new JPanel();
		itemDataPanel = new JPanel();
		itemDataPanel.setBounds(225, 40, 160, 270);
		itemDataPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		itemListPanel = new JPanel();
		itemListPanel.setBounds(40, 40, 156, 270);
		itemListPanel.setBorder(null);
		userStatusPanel = new JPanel();
		userStatusPanel.setBounds(415, 40, 150, 270);
		userStatusPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		userEquipPanel = new JPanel();
		userEquipPanel.setBounds(595, 40, 150, 270);
		userEquipPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		middle = new JPanel();
		
		itemData[0] = new JLabel("�̸� : ");
		itemData[1] = new JLabel("STR : ");
		itemData[2] = new JLabel("DEX : ");
		itemData[3] = new JLabel("VIT : ");
		itemData[4] = new JLabel("LUK : ");
		itemData[5] = new JLabel("INT : ");
		itemData[6] = new JLabel("rank : ");
		itemData[7] = new JLabel("enchant: ");
		
		userEquip[0] = new JLabel(User.name);
		userEquip[1] = new JLabel("���� : ");
		userEquip[2] = new JLabel("�� : ");
		userEquip[3] = new JLabel("���� : ");
		userEquip[4] = new JLabel("������ų : ");
		userEquip[5] = new JLabel("");
		userEquip[6] = new JLabel("���⽺ų : ");
		userEquip[7] = new JLabel("");
		userEquip[8] = new JLabel("");
		userEquip[9] = new JLabel("����ų : ");
		userEquip[10] = new JLabel("");
		userEquip[11] = new JLabel("");		
		
		for(int t =0;t<userData.length;t++)
			userData[t] = new JLabel();
		
		//�ʱ���¿����� �������ͽ� ������ ǥ���ϵ��� �̸����� �׸��� ����
		
//		userData[0] = new JLabel("Lv.  User");
//		userData[1] = new JLabel("HP : MP : ");
//		userData[2] = new JLabel("EXP : ");
//		userData[3] = new JLabel("ATK : ");
//		userData[4] = new JLabel("DEF : ");
//		userData[5] = new JLabel("STR : ");
//		userData[6] = new JLabel("DEX : ");
//		userData[7] = new JLabel("VIT : ");
//		userData[8] = new JLabel("LUK : ");
//		userData[9] = new JLabel("INT : ");
		
		userData[0].setText("Lv." + User.LV + "  " + User.name);
		userData[1].setText("HP : " + User.HP + "  MP : " + User.MP);
		userData[2].setText("EXP : " + User.EXP);
		userData[3].setText("ATK : " + User.atk);
		userData[4].setText("DEF : " + User.def);
		userData[5].setText("STR : " + User.STR);
		userData[6].setText("DEX : " + User.DEX);
		userData[7].setText("VIT : " + User.VIT);
		userData[8].setText("LUK : " + User.LUK);
		userData[9].setText("INT : " + User.INT);
		
		upper.setFont(new Font("SanSerif", 1, 40));
		
		itemListPanel.setLayout(new BorderLayout());
//		itemListPanel.add(remove);
		
		for(i=0;i<8;i++)
			itemDataPanel.add(itemData[i]);
		itemDataPanel.setLayout(new GridLayout(8,1));
		
		for(i=0;i<10;i++)
			userStatusPanel.add(userData[i]);
		userStatusPanel.setLayout(new GridLayout(10,1));
		
		for(i=0;i<12;i++)
			userEquipPanel.add(userEquip[i]);
		userEquipPanel.setLayout(new GridLayout(12,1));
		middle.setLayout(null);
		
		JLabel itemListTitle = new JLabel("Item List");
		itemListTitle.setBounds(52, 25, 57, 15);
		middle.add(itemListTitle);
		
		middle.add(itemListPanel);
		
		JLabel itemDataTitle = new JLabel("Item");
		itemDataTitle.setBounds(222, 25, 57, 15);
		middle.add(itemDataTitle);
		middle.add(itemDataPanel);
		
		JLabel userEquipTitle = new JLabel("Equip");
		userEquipTitle.setBounds(582, 25, 57, 15);
		middle.add(userEquipTitle);
		middle.add(userEquipPanel);
		
		JLabel userStatusTitle = new JLabel("Status");
		userStatusTitle.setBounds(402, 25, 57, 15);
		middle.add(userStatusTitle);
		middle.add(userStatusPanel);

		lower.add(Return);
		
		add(upper, BorderLayout.NORTH);
		add(lower, BorderLayout.SOUTH);
		add(middle, BorderLayout.CENTER);
		
		setVisible(true);
		EquipListener EL = new EquipListener();
		EquipItemListener EIL = new EquipItemListener();
		EquipPanelListener EPL = new EquipPanelListener();
		//UserListener UL = new UserListener();
		DoubleClickedListener DCL = new DoubleClickedListener();
		ItemTabChangeListener ITCL = new ItemTabChangeListener();
		
		Return.setActionCommand("return");
		Return.addActionListener(EL);
		
		itemTab = new JTabbedPane(JTabbedPane.TOP);
		itemTab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		itemListPanel.add(itemTab, BorderLayout.CENTER);
		
		/*itemList = new JList(itemListArray);
		itemTab.addTab("Weapon", null, itemList, null);
		itemList.setFixedCellWidth(200);
		itemList.setDragEnabled(true);*/
		
		weaponList = new JList(weaponListArray);
		armorList = new JList(armorListArray);
		ringList = new JList(ringListArray);
		itemTab.addTab("\uBB34\uAE30", null, weaponList, null);
		itemTab.addTab("\uBC29\uC5B4\uAD6C", null, armorList, null);
		itemTab.addTab("\uBC18\uC9C0", null, ringList, null);
		
		itemButtonPanel = new JPanel();
		itemListPanel.add(itemButtonPanel, BorderLayout.SOUTH);
		
		Equip = new JButton("\uC7A5\uCC29");
		itemButtonPanel.add(Equip);
		
		Enchant = new JButton("��ȭ");
		//Enchant.setActionCommand("\uAC15\uD654");
		itemButtonPanel.add(Enchant);
		
		
		Equip.addActionListener(EIL);
		Enchant.addActionListener(EIL);
		
		itemTab.addChangeListener(ITCL);
		
		armorList.addListSelectionListener(EPL);
		//armorList.addListSelectionListener(UL);
		weaponList.addListSelectionListener(EPL);
		//weaponList.addListSelectionListener(UL);
		
		ringList.addListSelectionListener(EPL);
		//ringList.addListSelectionListener(UL);
		
		//itemList.addListSelectionListener(EPL);
		//itemList.addListSelectionListener(UL);
		
		//itemList.addListSelectionListener(EIL);
		
		enchantTitle = new JLabel("Enchant");
		enchantTitle.setBounds(62, 335, 75, 15);
		middle.add(enchantTitle);
		enchantTitle.setAlignmentY(Component.TOP_ALIGNMENT);
		
		enchantPanel = new JPanel();
		enchantPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		enchantPanel.setBounds(60, 350, 680, 70);
		middle.add(enchantPanel);
		enchantPanel.setLayout(null);
		
		targetItem = new JLabel("targetItem");
		targetItem.setFont(new Font("����", Font.BOLD, 15));
		targetItem.setBounds(25, 15, 150, 40);
		enchantPanel.add(targetItem);
		
		plus = new JLabel("+");
		plus.setHorizontalAlignment(SwingConstants.CENTER);
		plus.setFont(new Font("����", Font.BOLD, 30));
		plus.setBounds(135, 15, 80, 40);
		enchantPanel.add(plus);
		
		enchantStoneLabel = new JLabel("\uAC15\uD654\uC11D(" + EnchantStone +")");
		enchantStoneLabel.setFont(new Font("����", Font.BOLD, 15));
		enchantStoneLabel.setBounds(220, 15, 120, 40);
		enchantPanel.add(enchantStoneLabel);
		
		EnchantItemButton = new JButton("\uC544\uC774\uD15C \uAC15\uD654");
		EnchantItemButton.setFont(new Font("����", Font.BOLD, 15));
		EnchantItemButton.setBounds(330, 15, 120, 40);
		enchantPanel.add(EnchantItemButton);
		
		resultItem = new JLabel("resultItem");
		resultItem.setFont(new Font("����", Font.BOLD, 15));
		resultItem.setBounds(480, 15, 180, 40);
		enchantPanel.add(resultItem);
		
		userEquip[1].addMouseListener(DCL);
		userEquip[2].addMouseListener(DCL);
		userEquip[3].addMouseListener(DCL);
		EnchantItemButton.addActionListener(EIL);
		}
	
	class ItemTabChangeListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			selectedTab = itemTab.getSelectedIndex();
		}
	}
	
	class EquipPanelListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e)
		{
			String selection; 
			
			if(selectedTab == 0)
				selection= ((String)weaponList.getSelectedValue()).split(" :")[0];
			else if(selectedTab == 1)
				selection= ((String)armorList.getSelectedValue()).split(" :")[0];
			else
				selection= ((String)ringList.getSelectedValue()).split(" :")[0];
			
			/*itemData[0].setText("�̸�  : "+HMInventory.get(selection).name);
			itemData[1].setText("STR : "+HMInventory.get(selection).STR);
			itemData[2].setText("DEX : "+HMInventory.get(selection).DEX);
			itemData[3].setText("VIT : "+HMInventory.get(selection).VIT);
			itemData[4].setText("LUK : "+HMInventory.get(selection).LUK);
			itemData[5].setText("INT : "+HMInventory.get(selection).INT);
			itemData[6].setText("rank : "+HMInventory.get(selection).rank);
			itemData[7].setText("enchant : "+HMInventory.get(selection).enchant);*/
			setItemData(selection);
		}
	}
	
	class EquipItemListener implements ActionListener{
		 public void actionPerformed(ActionEvent e){
				String command = e.getActionCommand();
				if(command.equals("����")){
					String selection;// = ((String)weaponList.getSelectedValue()).split(" :")[0];
					//char itemConfig = ((String)weaponList.getSelectedValue()).charAt(0);
					if(selectedTab == 0){
						selection = ((String)weaponList.getSelectedValue()).split(" :")[0];
						User.removeWeapon();
						userEquip[1].setText("���� : "+HMWeapon.get(selection).name);
						User.weapon = HMInventory.get(selection);
						User.equipWeapon();
					}
					else if(selectedTab == 1){
						selection = ((String)armorList.getSelectedValue()).split(" :")[0];
						User.removeArmor();
						userEquip[2].setText("�� : "+HMArmor.get(selection).name);
						User.armor = HMInventory.get(selection);
						User.equipArmor();
					}
					else if(selectedTab == 2){
						selection = ((String)ringList.getSelectedValue()).split(" :")[0];
						User.removeRing();
						userEquip[3].setText("���� : "+HMRing.get(selection).name);
						User.ring = HMInventory.get(selection);
						User.equipRing();
					}
					userEquip[4].setText("������ų : " + User.skill[0].name);
					userEquip[5].setText("       " + User.skill[1].name);
					
					setUserData();
				}else if(command.equals("��ȭ")){
					String selection;
					if(selectedTab == 0){
						selection = ((String)weaponList.getSelectedValue()).split(" :")[0];
						targetItem.setText(selection + " :" + HMWeapon.get(selection).name);
					}else if(selectedTab == 1){
						selection = ((String)armorList.getSelectedValue()).split(" :")[0];
						targetItem.setText(selection + " :" + HMArmor.get(selection).name);
					}else if(selectedTab == 2){
						selection = ((String)ringList.getSelectedValue()).split(" :")[0];
						targetItem.setText(selection + " :" + HMRing.get(selection).name);
					}
				}else if(command.equals("������ ��ȭ")){
					String selection = targetItem.getText().split(" :")[0];
					if(EnchantStone>0){
						HMInventory.get(selection).enchantItem();
						EnchantStone--;
						enchantStoneLabel.setText("\uAC15\uD654\uC11D(" + EnchantStone +")");
						resultItem.setText(selection + " :" + HMInventory.get(selection).name + "(+" 
											+ HMInventory.get(selection).enchant + ")");
						setItemData(selection);
					}else{
						resultItem.setText("��ȭ���� ����İ�ϴ�...");
					}					
				}
				
		 }
	}
	
	public void setUserData(){
		User.calStat();
		userData[0].setText("Lv." + User.LV + "  " + User.name);
		userData[1].setText("HP : " + User.HP + "  MP : " + User.MP);
		userData[2].setText("EXP : " + User.EXP);
		userData[3].setText("ATK : " + User.atk);
		userData[4].setText("DEF : " + User.def);
		userData[5].setText("STR : " + User.STR);
		userData[6].setText("DEX : " + User.DEX);
		userData[7].setText("VIT : " + User.VIT);
		userData[8].setText("LUK : " + User.LUK);
		userData[9].setText("INT : " + User.INT);
	}
	
	public void setItemData(String selection){
		itemData[0].setText("�̸�  : "+HMInventory.get(selection).name + "(+" 
							+ HMInventory.get(selection).enchant + ")");
		itemData[1].setText("STR : "+HMInventory.get(selection).STR);
		itemData[2].setText("DEX : "+HMInventory.get(selection).DEX);
		itemData[3].setText("VIT : "+HMInventory.get(selection).VIT);
		itemData[4].setText("LUK : "+HMInventory.get(selection).LUK);
		itemData[5].setText("INT : "+HMInventory.get(selection).INT);
		itemData[6].setText("rank : "+HMInventory.get(selection).rank);
		itemData[7].setText("enchant : "+HMInventory.get(selection).enchant);
	}
	/*class EquipItemListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e)
		{
			String selection = itemList.getSelectedValue().split(" :")[0];
			
			userEquip[0].setText(User.name);
			userEquip[1].setText("���� : "+HMItem.get(selection).name);
			userEquip[2].setText("�� : ");
			userEquip[3].setText("���� : ");
		}
	}*/
	
	/*class UserListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e){
			String selection = ((String)weaponList.getSelectedValue()).split(" :")[0];
			
//			System.out.println(selection);
			setUserData();
		}
	}*/
	
	class DoubleClickedListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			JLabel clickedLabel = (JLabel) e.getSource();
			String selection = clickedLabel.getText().split(" :")[0];
			if(e.getClickCount() == 2){
				if(selection.equals("����")){
					User.removeWeapon();
					userEquip[1].setText("���� : ");
				}
				else if(selection.equals("��")){
					User.removeArmor();
					userEquip[2].setText("�� : ");
				}
				else if(selection.equals("����")){
					User.removeRing();
					userEquip[3].setText("���� : ");
				}					
			}
			setUserData();
		}
	}
}
