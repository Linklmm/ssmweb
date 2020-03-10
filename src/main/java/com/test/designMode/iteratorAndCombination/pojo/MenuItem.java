package com.test.designMode.iteratorAndCombination.pojo;


import java.io.Serializable;
import lombok.Data;

/**
 * Description 菜单选项 迭代器模式
 * @author playboy
 * @date 2020-03-10 16:32
 * version 1.0
 */
@Data
public class MenuItem implements Serializable {
	private static final long serialVersionUID = -3712994939882960851L;
	private String name;
	private String description;
	private boolean vegetarian;
	private double price;

	public MenuItem(String name, String description, boolean vegetarian, double price) {
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}

}
