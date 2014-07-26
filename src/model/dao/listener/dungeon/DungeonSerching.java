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
		// floorSearching이 생성되어있지 않으면 플로어 탐색 객체를 생성한다.
		if (floorSearching == null)
			floorSearching = new FloorSearching(D, floor, user);
		// floorSearching이 생성되어 있다면
		int result = floorSearching.goFoward();
		System.out.println("getteditem size??? "
				+ floorSearching.gettedItem.size());
		if (result == 100 || result == 1)
			return 100;
		return 0; // 안끝났으면 0을 반환

	}

	public void integralFloorSearchingData() {
		// System.out.println("여기서 문제?"+floorSearching.gettedItem);

		try {
			for (int i = 0; floorSearching.gettedItem.isEmpty(); i++) {
				gettedItem.add(floorSearching.gettedItem.get(i));
				floorSearching.gettedItem.remove(i);
				System.out.println(floorSearching.gettedItem.size());
			}

		} catch (IndexOutOfBoundsException e) {
//			e.printStackTrace();
			System.out.println("주운 아이템이 없음");
		}

		user = floorSearching.user;
	}

}
