package com.test.designMode.iteratorAndCombination.diningRoom;


import com.test.designMode.iteratorAndCombination.pojo.MenuItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import lombok.Data;

/**
 * Description 煎饼屋的菜单实现 使用list实现
 * @author playboy
 * @date 2020-03-10 16:34
 * version 1.0
 */
@Data
public class PancakeHouseMenu implements Serializable {
	ArrayList menuItems;

	public Iterator createIterator(){
		return menuItems.iterator();
	}
	public PancakeHouseMenu() {
		menuItems = new ArrayList();
		addItem("K&B's pancake breakfast", "pancakes with scrambled eggs,and toast"
				, true, 2.99);
		addItem("Regular pancake breakfast","pancakes with fried eggs,and sausage",
				false,2.99);
		addItem("Blueberry pancake","pancakes with fresh blueberries",
				true,3.49);
		addItem("Waffles","waffles , with your choice of blueberries or strawberries",
				true,3.99);
	}

	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}

}
