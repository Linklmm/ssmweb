package com.test.designMode.command;


/**
 * Description 命令接口
 *
 * @author playboy
 * @date 2020-01-11 14:05
 * version 1.0
 */
public interface Command {
    public void execute();

    public void undo();
}
