package com.test.designMode.command;


import com.test.designMode.command.manufacturer.Stereo;

/**
 * Description 音响命令对象
 * @author playboy
 * @date 2020-01-13 13:43
 * version 1.0
 */
public class StereOnWithCDCommand implements Command {
	private Stereo stereo;

	public StereOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.on();
		stereo.setCd("cyp");
		stereo.setVolume(11);
	}

	@Override
	public void undo() {

	}

}
