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
		// �����ۿ� ��ų�� �ο��ϴ� �޼���
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
