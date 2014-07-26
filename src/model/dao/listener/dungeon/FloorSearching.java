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
			System.out.println("��� ã��");
			return 100;
		}

		switch (checkEvent()) {
		case 1:
			// ������ get
			Item temp = null;
			while (temp == null)
				temp = getItem();
			System.out.println(temp.toString());
			this.gettedItem.add(temp);
			break;
		case 2:
			// ���� ����
			System.out.println("���� ����");
			Battle battle = new Battle(user, selectMonster());
			MF.setBattlePanel(battle);
			break;
		case 0:
			// �ƹ��ϵ� �����Ƿ� �׳� break;
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

		// �ϴ� � ������ �������� ���� �������� �����Ѵ�.
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

		// �ش��ϴ� Ÿ���� �������� array�� ��� �������� ������
		ArrayList<Item> array = new ArrayList<>();
		for (String i : dun.item.keySet()) {
			if (type.charAt(0) == i.charAt(0)) {
				// System.out.println("i : " + i);
				// System.out.println("type : " + type);
				array.add(dun.item.get(i));
			}
		}

		Item temp = array.get(throwDice(array.size()));
		// ��ũ, ���� �ɷ�ġ, ��ų �ο�
		// ��ũ �ο�

		makeRank(temp);
		// ���� �ɷ�ġ �ο�
		makeRandomStat(temp);
		// ��ų �ο�
		// makeSkill(temp);

		return temp;
	}

	public void makeSkill(Item temp) {
		int slot = 0, type = 0;
		String rank = null;
		// ����� type 0, ���� type 1
		if (temp.getClass().equals(weapon.class))
			type = 0;
		else if (temp.getClass().equals(Armor.class))
			type = 1;
		slot = temp.rank;
		rank = dun.rank;

		ArrayList<Skill> arrayActive = new ArrayList<>();
		ArrayList<Skill> arrayPassive = new ArrayList<>();
		for (String key : HMSkill.keySet())
			if (rank.equals(HMSkill.get(key))) { // ������ ��ũ�� ���� ��ų�̸�
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

		if (temp.rank == 0) // Ŀ�վ������̸�
			coef = 0;
		else if (temp.rank == 1) // ����������̸�
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
		// 1.������ ���� Ȯ�� üũ
		int rand;
		rand = (int) (Math.random() * 100);
		System.out.println("rand = " + rand);
		if (rand < (1 + user.LUK / 100))
			return 1;
		// 2.���� ���� Ȯ�� üũ
		System.out.println("rand = " + rand);
		if (rand < (15 - user.LUK / 100))
			return 2;
		// 3.�ش� �ȵǸ� 0 ��ȯ
		return 0;
	}

	public double completePercent() {
		return ((double) searchComplete / (double) floorSize) * 100;
	}

	public boolean searchStair() {
		double result = Math.random() * (floorSize - searchComplete);
		if (result < 1)
			// ��� ã��
			return true;
		else
			// ����� �ƴ�
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
