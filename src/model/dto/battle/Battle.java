package model.dto.battle;

import static controller.Main.MF;
import model.dto.character.Character;
import model.dto.skill.Passive;
import model.dto.skill.Skill;
import model.dto.skill.active;
import model.dto.skill.buf;
import model.dto.skill.heal;

public class Battle {
	public Character User;
	public Character monster;
	public int charge;

	public Battle() {
	}

	public Battle(Character User, Character monster) {
		this.User = User;
		this.monster = monster;
		charge = 0;
	}

	public void toBattle() {
		attack(User, monster);
		if (monster.HP > 0)
			attack(monster, User);

		// while (this.User.HP > 0 || this.monster.HP > 0)
		// // 둘중 하나가 죽을때까지 배틀
		// attack(this.User, this.monster);

		if (this.User.HP < 0)
			returnToMain();

		if (this.monster.HP < 0) {
			System.out.println("몬스터를 쓰러뜨렸다");
			levelUp();
			// MF.setSearchDungeonDefault();
		}
	}

	public void returnToMain() {
		MF.setMainFrame();
	}

	public Character result() {
		return this.User;
	}

	public void levelUp() {
		if (User.EXP < User.EXP_MAX)
			return;
		else {
			User.STR *= 1.1;
			User.DEX *= 1.1;
			User.VIT *= 1.1;
			User.LUK *= 1.1;
			User.LUK *= 1.1;
			User.calStat();
			User.EXP_MAX *= 2;
		}
	}

	public void attack(Character attacker, Character defenser) {
		charge++;
		if (attacker.name.equals("User")) { // 공격이 유저면
			// 공격메뉴 띄움
			int damage = attacker.atk - defenser.def;
			if (damage < 0)
				damage = 0;
			System.out.println("damage : " + damage);
			this.monster.HP -= damage;
			System.out.println("유저가 공격!!");
		} else {
			int damage = attacker.atk - defenser.def;
			if (damage < 0)
				damage = 0;
			this.User.HP -= damage;
			System.out.println("몬스터가 공격!!");
		}
	}

	public void defence() {
		charge++;
		int damage = User.atk - monster.def;
		damage = (int) (damage * (Math.random() * 50) / 100);
		this.User.HP -= damage;
		System.out.println("몬스터의 공격을 방어했다!!");
	}

	public void skillAttack(Skill SelectedSkill) {
		System.out.println(SelectedSkill.type);
		System.out.println(User.name);
		if (SelectedSkill.type == 'a') {
			active skill = (active) SelectedSkill;
			User.MP -= skill.MP;
			User.HP += skill.HP;
			int damage = (int) (User.STR * skill.coef + skill.damage + User.HP
					* skill.hcoef);
			System.out.println("damage : " + damage);
			this.monster.HP -= damage;
			this.User.HP += User.HP * skill.heal;
			System.out.println("유저가 스킬을 사용!!");
			damage = monster.atk - User.def;
			this.User.HP -= damage;
			System.out.println("몬스터가 공격!!");

		}
		if (SelectedSkill.type == 'b') {
			buf skill = (buf) SelectedSkill;
			User.MP -= skill.MP;
			User.HP += skill.HP;
			User.STR += skill.STR;
			User.DEX += skill.DEX;
			User.VIT += skill.VIT;
			User.LUK += skill.LUK;
			User.INT += skill.INT;
			monster.HP += skill.mhp + User.HP * skill.coef;
			System.out.println("유저가 스킬을 사용!!");
			int damage = User.atk - monster.def;
			this.User.HP -= damage;
			System.out.println("몬스터가 공격!!");
		}
		if (SelectedSkill.type == 'h') {
			heal skill = (heal) SelectedSkill;
			User.MP -= skill.MP;
			User.HP += User.INT * skill.coef + skill.HP;
			System.out.println("유저가 스킬을 사용!!");
			int damage = User.atk - monster.def;
			this.User.HP -= damage;
			System.out.println("몬스터가 공격!!");
		}
	}
}
