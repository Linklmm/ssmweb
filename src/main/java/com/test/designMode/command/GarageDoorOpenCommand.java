package com.test.designMode.command;


import com.test.designMode.command.manufacturer.GarageDoor;

/**
 * Description
 *
 * @author playboy
 * @date 2020-01-11 14:32
 * version 1.0
 */
public class GarageDoorOpenCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
        garageDoor.lightOn();
        garageDoor.stop();
    }

    @Override
    public void undo() {
        garageDoor.down();
        garageDoor.lightOff();

    }

}
