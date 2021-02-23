package com.test.designMode.command;


import com.test.designMode.command.manufacturer.Light;

/**
 * Description 电灯的命令接口实现
 *
 * @author playboy
 * @date 2020-01-11 14:12
 * version 1.0
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

}
