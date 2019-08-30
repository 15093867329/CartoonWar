package com.neuedu.util;

import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
* @ClassName: SoundPlayer
* @Description: ±≥æ∞“Ù¿÷
* @author neuedu_ZLC
* @date 2019ƒÍ8‘¬27»’
* @version 0.1
*
*/
public class SoundPlayer extends Thread {
	
	private String mp3Name;
	
	
	public SoundPlayer() {
	}
	public SoundPlayer(String mp3Name) {
		this.mp3Name = mp3Name;
	}
	
	
	@Override
	public void run() {
		for(;;) {
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
	
	

}
