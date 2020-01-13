package com.test.designMode.command.manufacturer;


/**
 * Description 音响厂商类
 * @author playboy
 * @date 2020-01-13 13:44
 * version 1.0
 */
public class Stereo {
	private String cd;
	/**
	 * 音量
	 */
	private int volume;
	/**
	 * 位置
	 */
	private String position;

	public Stereo(String position) {
		this.position = position;
	}

	public void on(){
		System.out.println("Stereo is on ");
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Stereo{" +
				"cd='" + cd + '\'' +
				", volume=" + volume +
				'}';
	}

}
