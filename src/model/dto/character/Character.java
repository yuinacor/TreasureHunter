package model.dto.character;

import java.util.ArrayList;

import model.dto.item.Item;
import model.dto.skill.Skill;

public class Character {
	public String name;
	public int LV;
	public int HP;
	public int HP_MAX;
	public int MP;
	public int MP_MAX;
	public int EXP;
	public int EXP_MAX;
	public int STR;
	public int DEX;
	public int VIT;
	public int LUK;
	public int INT;

	public Item weapon;
	public Item armor;
	public Item ring;

	public Skill[] skill;

	public int atk;
	public int def;
	public char type;
	public Character(){
		skill = new Skill[2];
		
		skill[0] = new Skill();
		skill[1] = new Skill();
		skill[0].name = "";
		skill[1].name = "";
	}

	// 장비시 스탯 재계산
	// 장비 및 장비 해제시 반드시 호출해줘야함
	public void equipWeapon() {
		STR += weapon.STR;
		DEX += weapon.DEX;
		VIT += weapon.VIT;
		LUK += weapon.LUK;
		INT += weapon.INT;
		calStat();
	}

	public void equipArmor() {
		STR += armor.STR;
		DEX += armor.DEX;
		VIT += armor.VIT;
		LUK += armor.LUK;
		INT += armor.INT;
		calStat();
	}

	public void equipRing() {
		STR += ring.STR;
		DEX += ring.DEX;
		VIT += ring.VIT;
		LUK += ring.LUK;
		INT += ring.INT;
		calStat();
	}

	// 장비 해제시 스탯 재계산
	public void removeWeapon() {
		if(weapon == null)
			return;
		
		STR -= weapon.STR;
		DEX -= weapon.DEX;
		VIT -= weapon.VIT;
		LUK -= weapon.LUK;
		INT -= weapon.INT;
		calStat();
		weapon = null;
	}

	public void removeArmor() {
		if(armor == null)
			return;
		STR -= armor.STR;
		DEX -= armor.DEX;
		VIT -= armor.VIT;
		LUK -= armor.LUK;
		INT -= armor.INT;
		calStat();
		armor = null;
	}

	public void removeRing() {
		if(ring == null)
			return;
		STR -= ring.STR;
		DEX -= ring.DEX;
		VIT -= ring.VIT;
		LUK -= ring.LUK;
		INT -= ring.INT;
		calStat();
		ring = null;
	}

	// 스탯 재계산
	public void calAtk() {
		atk = STR;
	}

	public void calDef() {
		def = DEX;
	}

	public void calHP() {
		HP = 10 + VIT * 10;
		HP_MAX = HP;
	}

	public void calMP() {
		MP = 10 + INT * 10;
		MP_MAX = MP;
	}

	public void calStat() {
		EXP_MAX = EXP;
		EXP = 0;
		calAtk();
		calDef();
		calHP();
		calMP();
	}

}
