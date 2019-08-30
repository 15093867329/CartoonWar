package com.neuedu.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.neuedu.action.ActionAble;
import com.neuedu.constant.Constant;
import com.neuedu.util.GetImageUtil;

/**
* @ClassName: Prop
* @Description: 道具类
* @author neuedu_ZLC
* @date 2019年8月23日
* @version .01
*
*/
public class Prop extends GameObj implements ActionAble {
	public Prop() {
		// TODO Auto-generated constructor stub
	}
	private int speed;
	
	public Prop(int x,int y,String imgName) {
		this.x = x;
		this.y = y;
		this.img = GetImageUtil.geyImg(imgName);
		this.speed = 5;
	}
	
	
	
	
    private double theta = Math.PI/4;
	@Override
	public void move() {
		x += speed*Math.cos(theta);
		x += speed*Math.sin(theta);
		if(x<0 || x>Constant.GAME_WIDTH-img.getWidth(null)) {
			theta = Math.PI-theta;
		}
		if(y<35 || y>Constant.GAME_HEIGHT-img.getHeight(null)) {
			theta = -theta;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		move();
		
	}
	// 拿到当前道具存在的矩形
	public Rectangle getRect() {
		return new Rectangle(x, y, this.img.getWidth(null), this.img.getHeight(null));
	}

}
