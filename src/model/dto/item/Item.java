package model.dto.item;

public class Item {
	public int num;
	public String name;
	public String script;
	public int STR;
	public int DEX;
	public int VIT;
	public int LUK;
	public int INT;
	public int rank;
	public int enchant;

	@Override
	public String toString() {
		return "Item [num=" + num + ", name=" + name + ", script=" + script
				+ ", STR=" + STR + ", DEX=" + DEX + ", VIT=" + VIT + ", LUK="
				+ LUK + ", INT=" + INT + ", rank=" + rank + ", enchant="
				+ enchant + "]";
	}

	public void setSkill() {
		// 아이템에 스킬을 부여하는 메서드
	}
	
	public void enchantItem() {
		STR++;
		DEX++;
		VIT++;
		LUK++;
		INT++;
		enchant++;
	}

}
