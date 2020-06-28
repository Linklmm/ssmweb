package com.test.test.pojo;


/**
 * Description
 * @author playboy
 * @date 2020-03-28 09:26
 * version 1.0
 */
public class User {
	private String name;
	private int id=1;

	public User(String name, int Nid) {
		this.name = name;
		id = Nid;
	}

	public User() {
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", id=" + id +
				'}';
	}

}
