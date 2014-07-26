package model.dto.dungeon;

import java.util.HashMap;

import model.dto.character.Character;
import model.dto.item.Item;

public class Dungeon {
	public int num;
	public String name;
	public String explain;
	public int depth;
	public int comp_depth;
	public int defaultFloorSize;
	public String rank;
	public HashMap<Integer, Character> monster;
	public HashMap<String, Item> item;
	public Character Boss;
	public String imagePath;
	@Override
	public String toString() {
		return "Dungeon [num=" + num + ", name=" + name + ", explain="
				+ explain + ", depth=" + depth + ", comp_depth=" + comp_depth
				+ ", defaultFloorSize=" + defaultFloorSize + ", monster="
				+ monster + ", item=" + item + ", Boss=" + Boss
				+ ", imagePath=" + imagePath + "]";
	}
}
