package com.test.designMode.command;


/**
 * Description 简单的遥控器
 * @author playboy
 * @date 2020-01-11 14:14
 * version 1.0
 */
public class SimpleRemoteControl {
	private Command slot;

	/**
	 * 用来设置插槽控制的命令
	 * @param slot
	 */
	public void setCommand(Command slot) {
		this.slot = slot;
	}
	public void buttonWasPressed(){
		slot.execute();
	}

}
