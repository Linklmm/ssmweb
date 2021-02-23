package com.test.designMode.command;


import com.test.designMode.command.manufacturer.GarageDoor;
import com.test.designMode.command.manufacturer.Light;
import org.junit.jupiter.api.Test;

/**
 * Description 遥控器使用的简单测试
 *
 * @author playboy
 * @date 2020-01-11 14:16
 * version 1.0
 * 命令模式的客户
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        //遥控器是【调用者】
        SimpleRemoteControl remote = new SimpleRemoteControl();
        //请求的【接收者】
        Light light = new Light(" ");
        //【命令对象】 将【接收者】传给【命令对象】
        LightOnCommand lightOn = new LightOnCommand(light);

        //把【命令】传给【调用者】
        remote.setCommand(lightOn);
        remote.buttonWasPressed();
    }

    @Test
    public void testGradeDoorControl() {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light("gradeDoor");
        GarageDoor garageDoor = new GarageDoor();
        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();

        remote.setCommand(garageDoorOpenCommand);
        remote.buttonWasPressed();

    }
}
