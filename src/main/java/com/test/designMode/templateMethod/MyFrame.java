package com.test.designMode.templateMethod;


import java.awt.*;
import javax.swing.*;

/**
 * Description Swing窗口程序
 * @author playboy
 * @date 2020-03-05 15:44
 * version 1.0
 */
public class MyFrame extends JFrame {
	public MyFrame(String title) throws HeadlessException {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(300,300);
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		String msg = "I rule!!";
		g.drawString(msg,100,100);
	}

	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame("Head First Design Patterns");
	}

}
