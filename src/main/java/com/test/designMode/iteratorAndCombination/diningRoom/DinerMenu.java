package com.test.designMode.iteratorAndCombination.diningRoom;


import com.test.designMode.iteratorAndCombination.pojo.MenuItem;
import java.io.Serializable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Description 餐厅菜单实现，使用数组实现菜单选项
 * @author playboy
 * @date 2020-03-10 16:43
 * version 1.0
 */
@Data
@Slf4j
public class DinerMenu implements Serializable {
	private static final long serialVersionUID = -4926677013232252841L;
	private static final int MAX_ITEMS =6;
	private int numberOfItems = 0;
	private MenuItem[] menuItems;

	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		addItem("Vegetarian BLT","11111111",
				true,2.99);
		addItem("Soup of the day","2222222",
				false,3.29);
		addItem("BLT","3333333",
				false,2.99);
		addItem("hot dog","444444",
				false,3.05);
	}

	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS){
			log.info("sorry ,menu is full! can't add item");
		}else {
			menuItems[numberOfItems++] = menuItem;
		}
	}

}
