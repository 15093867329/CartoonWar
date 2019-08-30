package com.neuedu.util;

import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
* @ClassName: SinglePlay
* @Description: 单次播放
* @author neuedu_ZLC
* @date 2019年8月27日
* @version 0.1
*
*/
public class SinglePlay extends Thread {
	
	private String mp3Name;
	
	public SinglePlay() {
		// TODO Auto-generated constructor stub
	}
	public SinglePlay(String mp3Name){
		this.mp3Name = mp3Name;
	}
	
	public void play(String mp3Name) {
		SinglePlay singlePlay = new SinglePlay(mp3Name);
		singlePlay.start();
	}
	
	@Override
	public void run() {
		InputStream resourceAsStream = SoundPlayer.class.getClassLoader().getResourceAsStream(mp3Name);
		try {
			AdvancedPlayer advancedPlayer = new AdvancedPlayer(resourceAsStream);
		    advancedPlayer.play();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
