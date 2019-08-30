package com.neuedu.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import com.neuedu.action.ActionAble;
import com.neuedu.client.GameClient;
import com.neuedu.util.GetImageUtil;

/**
* @ClassName: Boss
* @Description: BOSS��
* @author neuedu_ZLC
* @date 2019��8��27��
* @version 0.1
*
*/
public class Boss extends Plane implements ActionAble {
	
	private int speed = 1;
	public Boss() {
		// TODO Auto-generated constructor stub
	}
	public Boss(int x,int y,GameClient gc,boolean isGood) {
		this.x = x;
		this.y = y;
		this.gc = gc;
		this.isGood = isGood;
		this.blood = 10000;
	}
	
	// ��̬��ʼ��һ��ͼƬ����
	private static Image[] imgs = new Image[5];
	static {
		for(int i = 0;i<imgs.length;i++) {
			imgs[i] = GetImageUtil.geyImg("boss/0"+(i+1)+".png");
		}
	}
    int count = 0;
    @Override
    public void draw(Graphics g) {
    	if(count > 4) {
    		count = 0;
    	}
    	g.drawImage(imgs[count++], x, y, null);
        move();
        g.drawString("��ǰѪ��"+blood, x, y);
    }
    @Override
    public void move() {
    	y += speed;
    	if(random.nextInt(500)>450) {
    		fire();
    	}
    }
    Random random = new Random();

    //��ȡ��Boss�ľ���
	public Rectangle getRec() {
		return new Rectangle(x, y, imgs[0].getWidth(null), imgs[0].getHeight(null));
	}
	@Override
	public void fire() {
		play.play("com/neuedu/sound/bullet.mp3");
		Bullet b = new Bullet(x+26, y+80, "bullet/dizidan_01.png",gc,false);
		gc.bullets.add(b);
	}
}