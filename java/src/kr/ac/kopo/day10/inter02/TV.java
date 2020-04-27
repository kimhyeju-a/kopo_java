package kr.ac.kopo.day10.inter02;

public interface TV {

	int MAX_VOLUME = 30;
	
	void togglePower();
	void channeUp();
	void channelDown();
	void volumeUp();
	void volumeDown();
	void mute();
}