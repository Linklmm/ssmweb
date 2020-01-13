package com.test.designMode.command;


import com.test.designMode.command.manufacturer.Light;

/**
 * Description 关灯命令对象
 * @author playboy
 * @date 2020-01-13 13:42
 * version 1.0
 */
public class LightOffCommand implements Command {
	private Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}

	@Override
	public void undo() {
		light.on();
	}

}
