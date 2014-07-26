package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import model.dto.item.Armor;
import model.dto.item.Item;
import model.dto.item.Ring;
import model.dto.item.weapon;

public class ParseItem {
	public static HashMap<String, Item> HMItem = null;

	public ParseItem() {
		Properties itemProperties = new Properties();
		Properties itemScriptProperties = new Properties();

		try {
			itemProperties.load(new FileReader("itemProperties.properties"));
			itemScriptProperties.load(new FileReader(
					"itemScriptProperties.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		for (String i : itemProperties.stringPropertyNames()) {
			// System.out.println(itemProperties.getProperty(i));

			// 무기정보부터 갖고오기
			if (i.charAt(0) == 'w') {
				String[] temp = itemProperties.getProperty(i).split(",");
				for (int k = 0; k < temp.length; k++)
					// 여백 제거
					temp[k] = temp[k].trim();
				Item item = new weapon();
				item.num = Integer.parseInt(i.split("w")[1]);
				item.name = temp[0];
				item.STR = Integer.parseInt(temp[1]);
				item.DEX = Integer.parseInt(temp[2]);
				item.VIT = Integer.parseInt(temp[3]);
				item.LUK = Integer.parseInt(temp[4]);
				item.INT = Integer.parseInt(temp[5]);
				item.rank = Integer.parseInt(temp[6]);
				item.enchant = Integer.parseInt(temp[7]);
				item.script = itemScriptProperties.getProperty(i);

				HMItem.put(i, item);
			}
			// 방어구 정보 가져오기
			if (i.charAt(0) == 'a') {
				String[] temp = itemProperties.getProperty(i).split(",");
				for (int k = 0; k < temp.length; k++)
					// 여백 제거
					temp[k] = temp[k].trim();
				Item item = new Armor();
				item.num = Integer.parseInt(i.split("a")[1]);
				item.name = temp[0];
				item.STR = Integer.parseInt(temp[1]);
				item.DEX = Integer.parseInt(temp[2]);
				item.VIT = Integer.parseInt(temp[3]);
				item.LUK = Integer.parseInt(temp[4]);
				item.INT = Integer.parseInt(temp[5]);
				item.rank = Integer.parseInt(temp[6]);
				item.enchant = Integer.parseInt(temp[7]);
				item.script = itemScriptProperties.getProperty(i);

				HMItem.put(i, item);
			}
			// 장신구 정보 가져오기
			if (i.charAt(0) == 'r') {
				String[] temp = itemProperties.getProperty(i).split(",");
				for (int k = 0; k < temp.length; k++)
					// 여백 제거
					temp[k] = temp[k].trim();
				Item item = new Ring();
				item.num = Integer.parseInt(i.split("r")[1]);
				item.name = temp[0];
				item.STR = Integer.parseInt(temp[1]);
				item.DEX = Integer.parseInt(temp[2]);
				item.VIT = Integer.parseInt(temp[3]);
				item.LUK = Integer.parseInt(temp[4]);
				item.INT = Integer.parseInt(temp[5]);
				item.rank = Integer.parseInt(temp[6]);
				item.enchant = Integer.parseInt(temp[7]);
				item.script = itemScriptProperties.getProperty(i);

				HMItem.put(i, item);
			}
			// 일반 아이템 정보 가져오기
			if (i.charAt(0) == 'i') {
				String[] temp = itemProperties.getProperty(i).split(",");
				for (int k = 0; k < temp.length; k++)
					// 여백 제거
					temp[k] = temp[k].trim();
				Item item = new Item();
				item.num = Integer.parseInt(i.split("i")[1]);
				item.name = temp[0];
				item.STR = Integer.parseInt(temp[1]);
				item.DEX = Integer.parseInt(temp[2]);
				item.VIT = Integer.parseInt(temp[3]);
				item.LUK = Integer.parseInt(temp[4]);
				item.INT = Integer.parseInt(temp[5]);
				item.rank = Integer.parseInt(temp[6]);
				item.enchant = Integer.parseInt(temp[7]);
				item.script = itemScriptProperties.getProperty(i);

				HMItem.put(i, item);
			}
		}
	}

	public void parseItem(Properties itemProperties,
			Properties itemScriptProperties) {
		for (String i : itemProperties.stringPropertyNames()) {
			// System.out.println(itemProperties.getProperty(i));

			// 무기정보부터 갖고오기
			if (i.charAt(0) == 'w') {
				String[] temp = itemProperties.getProperty(i).split(",");
				for (int k = 0; k < temp.length; k++)
					// 여백 제거
					temp[k] = temp[k].trim();
				Item item = new weapon();
				item.num = Integer.parseInt(i.split("w")[1]);
				item.name = temp[0];
				item.STR = Integer.parseInt(temp[1]);
				item.DEX = Integer.parseInt(temp[2]);
				item.VIT = Integer.parseInt(temp[3]);
				item.LUK = Integer.parseInt(temp[4]);
				item.INT = Integer.parseInt(temp[5]);
				item.rank = Integer.parseInt(temp[6]);
				item.enchant = Integer.parseInt(temp[7]);
				item.script = itemScriptProperties.getProperty(i);

				HMItem.put(i, item);
			}
			// 방어구 정보 가져오기
			if (i.charAt(0) == 'a') {
				String[] temp = itemProperties.getProperty(i).split(",");
				for (int k = 0; k < temp.length; k++)
					// 여백 제거
					temp[k] = temp[k].trim();
				Item item = new Armor();
				item.num = Integer.parseInt(i.split("a")[1]);
				item.name = temp[0];
				item.STR = Integer.parseInt(temp[1]);
				item.DEX = Integer.parseInt(temp[2]);
				item.VIT = Integer.parseInt(temp[3]);
				item.LUK = Integer.parseInt(temp[4]);
				item.INT = Integer.parseInt(temp[5]);
				item.rank = Integer.parseInt(temp[6]);
				item.enchant = Integer.parseInt(temp[7]);
				item.script = itemScriptProperties.getProperty(i);

				HMItem.put(i, item);
			}
			// 장신구 정보 가져오기
			if (i.charAt(0) == 'r') {
				String[] temp = itemProperties.getProperty(i).split(",");
				for (int k = 0; k < temp.length; k++)
					// 여백 제거
					temp[k] = temp[k].trim();
				Item item = new Ring();
				item.num = Integer.parseInt(i.split("r")[1]);
				item.name = temp[0];
				item.STR = Integer.parseInt(temp[1]);
				item.DEX = Integer.parseInt(temp[2]);
				item.VIT = Integer.parseInt(temp[3]);
				item.LUK = Integer.parseInt(temp[4]);
				item.INT = Integer.parseInt(temp[5]);
				item.rank = Integer.parseInt(temp[6]);
				item.enchant = Integer.parseInt(temp[7]);
				item.script = itemScriptProperties.getProperty(i);

				HMItem.put(i, item);
			}
			// 일반 아이템 정보 가져오기
			if (i.charAt(0) == 'i') {
				String[] temp = itemProperties.getProperty(i).split(",");
				for (int k = 0; k < temp.length; k++)
					// 여백 제거
					temp[k] = temp[k].trim();
				Item item = new Item();
				item.num = Integer.parseInt(i.split("i")[1]);
				item.name = temp[0];
				item.STR = Integer.parseInt(temp[1]);
				item.DEX = Integer.parseInt(temp[2]);
				item.VIT = Integer.parseInt(temp[3]);
				item.LUK = Integer.parseInt(temp[4]);
				item.INT = Integer.parseInt(temp[5]);
				item.rank = Integer.parseInt(temp[6]);
				item.enchant = Integer.parseInt(temp[7]);
				item.script = itemScriptProperties.getProperty(i);

				HMItem.put(i, item);
			}

		}
	}
}
