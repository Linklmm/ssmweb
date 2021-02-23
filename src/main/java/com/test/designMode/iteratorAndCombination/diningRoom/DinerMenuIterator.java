package com.test.designMode.iteratorAndCombination.diningRoom;


import com.test.designMode.iteratorAndCombination.pojo.MenuItem;

import java.io.Serializable;
import java.util.Iterator;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Description 餐厅菜单实现，使用数组实现菜单选项
 *
 * @author playboy
 * @date 2020-03-10 16:43
 * version 1.0
 */
@Data
@Slf4j
public class DinerMenuIterator implements Serializable, Iterator {
    private static final long serialVersionUID = -4926677013232252841L;

    private MenuItem[] menuItems;

    private int position = 0;

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.length || null == menuItems[position]) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems[position];
        position++;
        return menuItem;
    }

}
