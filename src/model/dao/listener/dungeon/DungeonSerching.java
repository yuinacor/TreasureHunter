package model.dao.listener.dungeon;

import static common.LoadData.User;

import java.util.ArrayList;

import model.dto.character.Character;
import model.dto.dungeon.Dungeon;
import model.dto.item.Item;

public class DungeonSerching {
	public int floor;
	public Character user;
	public Dungeon D;
	public ArrayList<Item> gettedItem;
	public FloorSearching floorSearching;

	public DungeonSerching(Dungeon d) {
		this.user = User;
		D = d;
		floor = 1;
		gettedItem = new ArrayList<>();
	}

	public int goFoward() {
		System.out.println("DungeonSearching goFoaward start");
		// floorSearching�� �����Ǿ����� ������ �÷ξ� Ž�� ��ü�� �����Ѵ�.
		if (floorSearching == null)
			floorSearching = new FloorSearching(D, floor, user);
		// floorSearching�� �����Ǿ� �ִٸ�
		int result = floorSearching.goFoward();
		System.out.println("getteditem size??? "
				+ floorSearching.gettedItem.size());
		if (result == 100 || result == 1)
			return 100;
		return 0; // �ȳ������� 0�� ��ȯ

	}

	public void integralFloorSearchingData() {
		// System.out.println("���⼭ ����?"+floorSearching.gettedItem);

		try {
			for (int i = 0; floorSearching.gettedItem.isEmpty(); i++) {
				gettedItem.add(floorSearching.gettedItem.get(i));
				floorSearching.gettedItem.remove(i);
				System.out.println(floorSearching.gettedItem.size());
			}

		} catch (IndexOutOfBoundsException e) {
//			e.printStackTrace();
			System.out.println("�ֿ� �������� ����");
		}

		user = floorSearching.user;
	}

}
