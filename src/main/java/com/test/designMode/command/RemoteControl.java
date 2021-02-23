package com.test.designMode.command;


import java.util.Arrays;

/**
 * Description 遥控器实现
 *
 * @author playboy
 * @date 2020-01-13 11:05
 * version 1.0
 */
public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n----------Remote Control ------------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot " + i + " ]" + onCommands[i].getClass().getName() + " " + offCommands[i].getClass().getName() + "\n");
        }
        return sb.toString();
    }

}
