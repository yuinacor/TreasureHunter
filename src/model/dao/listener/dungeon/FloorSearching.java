package model.dao.listener.dungeon;

import static common.LoadData.*;
import static controller.Main.MF;
import java.util.ArrayList;

import model.dto.battle.Battle;
import model.dto.character.Character;
import model.dto.dungeon.Dungeon;
import model.dto.item.Armor;
import model.dto.item.Item;
import model.dto.item.weapon;
import model.dto.skill.Skill;

public class FloorSearching {
	public ArrayList<Item> gettedItem;
	public int floorSize;
	public Character user;
	public int searchComplete;
	public Dungeon dun;

	public FloorSearching(Dungeon D, int floor, Character user) {
		floorSize = D.defaultFloorSize * floor;
		searchComplete = 0;
		dun = D;
		this.user = user;
		gettedItem = new ArrayList<>();
	}

	public int goFoward() {
		System.out.println("floor size = " + floorSize);
		System.out.println("searchComplete = " + searchComplete);
		if (searchStair()) {
			System.out.println("계단 찾음");
			return 100;
		}

		switch (checkEvent()) {
		case 1:
			// 아이템 get
			Item temp = null;
			while (temp == null)
				temp = getItem();
			System.out.println(temp.toString());
			this.gettedItem.add(temp);
			break;
		case 2:
			// 몬스터 조우
			System.out.println("몬스터 조우");
			Battle battle = new Battle(user, selectMonster());
			MF.setBattlePanel(battle);
			break;
		case 0:
			// 아무일도 없으므로 그냥 break;
			System.out.println("no event");
			break;
		default:
			break;
		}

		searchComplete++;

		if (completePercent() >= 100)
			{
				return 1;
			}

		return 0;
	}

	public Character selectMonster() {

		Character array[] = new Character[dun.monster.size()];
		int j = 0;
		for (int i : dun.monster.keySet())
			array[j++] = dun.monster.get(i);

		j = (int) (Math.random() * array.length);
		array[j].calStat();
		return array[j];
	}

	public Item getItem() {

		// 일단 어떤 종류의 아이템을 뽑을 것인지를 결정한다.
		String type = null;
		while (type == null) {
			switch (throwDice(3) + 1) {
			case 1:
				type = "w";
				break;
			case 2:
				type = "a";
				break;
			case 3:
				type = "r";
				break;
			// case 4:
			// type = "i";
			// break;
			default:
				break;
			}
		}

		// 해당하는 타입의 아이템을 array에 담아 랜덤으로 선택함
		ArrayList<Item> array = new ArrayList<>();
		for (String i : dun.item.keySet()) {
			if (type.charAt(0) == i.charAt(0)) {
				// System.out.println("i : " + i);
				// System.out.println("type : " + type);
				array.add(dun.item.get(i));
			}
		}

		Item temp = array.get(throwDice(array.size()));
		// 랭크, 랜덤 능력치, 스킬 부여
		// 랭크 부여

		makeRank(temp);
		// 랜덤 능력치 부여
		makeRandomStat(temp);
		// 스킬 부여
		// makeSkill(temp);

		return temp;
	}

	public void makeSkill(Item temp) {
		int slot = 0, type = 0;
		String rank = null;
		// 무기면 type 0, 방어구면 type 1
		if (temp.getClass().equals(weapon.class))
			type = 0;
		else if (temp.getClass().equals(Armor.class))
			type = 1;
		slot = temp.rank;
		rank = dun.rank;

		ArrayList<Skill> arrayActive = new ArrayList<>();
		ArrayList<Skill> arrayPassive = new ArrayList<>();
		for (String key : HMSkill.keySet())
			if (rank.equals(HMSkill.get(key))) { // 던전의 랭크와 같은 스킬이면
				if (type == 0)
					arrayActive.add(HMSkill.get(key));
				else
					arrayPassive.add(HMSkill.get(key));
			}

		System.out.println("arrayPassiveSize = " + arrayPassive.size());
		if (type == 0)
			for (int i = 0; i <= slot; i++)
				((weapon) temp).skill[i] = (arrayActive
						.get(throwDice(arrayActive.size())));
		else
			for (int i = 0; i <= slot; i++)
				((Armor) temp).skill.add(arrayPassive
						.get(throwDice(arrayPassive.size())));
	}

	public void makeRandomStat(Item temp) {
		double coef = 1;
		int STR = 1, DEX = 1, VIT = 1, LUK = 1, INT = 1;
		if (temp.getClass().equals("class model.dto.item.weapon"))
			STR = 0;
		else if (temp.getClass().equals("class model.dto.item.Armor"))
			DEX = 0;
		else if (temp.getClass().equals("class model.dto.item.Ring"))
			INT = 0;

		if (temp.rank == 0) // 커먼아이템이면
			coef = 0;
		else if (temp.rank == 1) // 레어아이템이면
			coef = 0.1;
		else if (temp.rank == 2)
			coef = 0.2;

		temp.STR += (int) Math.random() * temp.STR * STR * coef;
		temp.DEX += (int) Math.random() * temp.DEX * DEX * coef;
		temp.VIT += (int) Math.random() * temp.VIT * VIT * coef;
		temp.LUK += (int) Math.random() * temp.LUK * LUK * coef;
		temp.INT += (int) Math.random() * temp.INT * INT * coef;
	}

	public int checkEvent() {
		// 1.아이템 조우 확률 체크
		int rand;
		rand = (int) (Math.random() * 100);
		System.out.println("rand = " + rand);
		if (rand < (1 + user.LUK / 100))
			return 1;
		// 2.몬스터 조우 확률 체크
		System.out.println("rand = " + rand);
		if (rand < (15 - user.LUK / 100))
			return 2;
		// 3.해당 안되면 0 반환
		return 0;
	}

	public double completePercent() {
		return ((double) searchComplete / (double) floorSize) * 100;
	}

	public boolean searchStair() {
		double result = Math.random() * (floorSize - searchComplete);
		if (result < 1)
			// 계단 찾음
			return true;
		else
			// 계단이 아님
			return false;
	}

	public int throwDice(int n) {
		return (int) (Math.random() * n);
	}

	public void makeRank(Item temp) {
		int rank = throwDice(100);
		if (rank < 80)
			temp.rank = 0;
		else if (rank >= 80 && rank < 95)
			temp.rank = 1;
		else
			temp.rank = 2;
	}
}
