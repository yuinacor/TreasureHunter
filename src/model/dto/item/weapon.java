package model.dto.item;

import java.util.ArrayList;

import model.dto.skill.Skill;

public class weapon extends Item {
	public Skill[] skill;

	public weapon(){
		skill = new Skill[3];
	}
	
}
