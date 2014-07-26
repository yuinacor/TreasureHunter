package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.dao.listener.dungeon.FloorSearching;
import model.dto.battle.Battle;
import model.dto.dungeon.Dungeon;

import view.dungeon.BattlePanel;
import view.dungeon.DialogPanel;
import view.dungeon.SearchDungeon;
import java.awt.Color;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

    Cards cards;
    MainPanel mainPanel;
    DungeonPanel dungeonPanel;
    EquipPanel equipPanel;
    StatusPanel statusPanel;
    GuildPanel guildPanel;
    SearchDungeon searchDungeon;
    BattlePanel battlePanel;
    FloorSearching floorSearching;
    DialogPanel dialogPanel;
    
	public MainFrame() {
		getContentPane().setBackground(Color.GRAY);
		setTitle("Treasure Hunter");
		setSize(800, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		cards = new Cards();
		getContentPane().add(cards, "Center");
		cards.clayout.show(cards,"main");
		setResizable(false);
		setVisible(true);
	}

	public void setMainFrame() {
		cards.clayout.show(cards,"main");
	}

	public void setDungeonPanel() {
		cards.clayout.show(cards,"dungeon");
	}

	public void setEquipPanel() {
		cards.clayout.show(cards,"equip");
	}

	public void setStatusPanel() {
		cards.clayout.show(cards,"status");
	}

	public void setGuildPanel() {
		cards.clayout.show(cards,"guild");
	}
	public void setBattlePanel(Battle battle){
		this.battlePanel = new BattlePanel(battle);
		cards.add(battlePanel,"battle");
		cards.clayout.show(cards,"battle");
	}
	public void setBattlePanelDefault(){
		cards.clayout.show(cards,"battle");
	}

	public void setSearchDungeon(Dungeon D) {
		this.searchDungeon = new SearchDungeon(D);
		cards.add(searchDungeon, "search");
		cards.clayout.show(cards, "search");
	}
	public void setSearchDungeonDefault(){
		cards.clayout.show(cards, "search");
	}
	
	public void setDialogPanel(){
		cards.clayout.show(cards, "dialog");
	}
	
//	public void setFloorSearching(Dungeon D, int floor, Character user){
//		this.floorSearching = new FloorSearching(D, floor, user);
//		cards.add(floorSearching, "floor");
//		cards.clayout.show(cards, "floor");
//	}
//	public void setFloorSearchingDefault(){
//		cards.clayout.show(cards, "floor");
//	}
	
    private class Cards extends JPanel{
    	CardLayout clayout;
    	public Cards(){
    		clayout = new CardLayout();
    		setLayout(clayout);
    		mainPanel = new MainPanel();
    		dungeonPanel = new DungeonPanel();
    		equipPanel = new EquipPanel();
    		statusPanel = new StatusPanel();
    		guildPanel = new GuildPanel();
    		searchDungeon = new SearchDungeon();
    		battlePanel = new BattlePanel();
    		dialogPanel = new DialogPanel();
    		
//    		dungeonPanel.setOpaque(true);
    		
    		add(mainPanel, "main");
    		add(dungeonPanel, "dungeon");
    		add(equipPanel, "equip");
    		add(statusPanel, "status");
    		add(guildPanel, "guild");
    		add(searchDungeon, "search");
    		add(battlePanel, "battle");
    		add(dialogPanel, "dialog");
    	}
    }
    
}