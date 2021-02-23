package com.test.designMode.command;


/**
 * Description 空对象，不用每次检查遥控器插槽是否都加载了命令
 *
 * @author playboy
 * @date 2020-01-13 11:19
 * version 1.0
 */
public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }

}
