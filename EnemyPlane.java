package com.neuedu.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Observer;
import java.util.Random;

import com.neuedu.action.ActionAble;
import com.neuedu.client.GameClient;
import com.neuedu.util.GetImageUtil;

/**
* @ClassName: EnenyPlane
* @Description: �з��ɻ���
* @author neuedu_ZLC
* @date 2019��8��21��
* @version 0.1
*
*/
public class EnemyPlane extends Plane implements ActionAble {
    
    private Integer enemyType;
    
    private Integer speed;
    
    private GameClient gc;
    
    
    
    private static Image[] imgs1 = {
    		GetImageUtil.geyImg("enemy/di2.png"),
    		GetImageUtil.geyImg("enemy/di3.png"),
    		GetImageUtil.geyImg("enemy/di4.png"),
    		GetImageUtil.geyImg("enemy/di5.png"),
    		GetImageUtil.geyImg("enemy/di6.png")
    };
	
	public EnemyPlane() {
		
	}
	public EnemyPlane(int x,int y,int enemyType,GameClient gc,boolean isGood) {
		this.x = x;
		this.y = y;
		this.enemyType = enemyType;
		this.speed = 1;
		this.gc = gc;
		this.isGood = isGood;
	}
	
	
	@Override
		public void move() {
			y += speed;
		}
	
	int count = 0;
	@Override
	public void draw(Graphics g) {
		if(count>4) {
			count = 0;
		}
		g.drawImage(imgs1[count++], x, y, null);
		move();
		
		if(random.nextInt(500)>480) {
			fire();
		}
		
	}
	
	// �����
	Random random = new Random();
	
	
	// �о�����
	public void fire() {
		Bullet bullet = new Bullet(x+33, y+80, "bullet/dizidan_01.png", gc,false);
		gc.bullets.add(bullet);
	}
	
	
	
	
	 // ��ȡ���з��ɻ��ľ���
		public Rectangle getRec() {
			return new Rectangle(x, y, this.imgs1[0].getWidth(null), this.imgs1[0].getHeight(null));
		}
	
	
}
