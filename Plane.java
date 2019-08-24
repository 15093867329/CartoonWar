package com.neuedu.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.accessibility.Accessible;

import com.neuedu.action.ActionAble;
import com.neuedu.client.GameClient;
import com.neuedu.constant.Constant;
import com.neuedu.util.GetImageUtil;

/**
* @ClassName: Plane
* @Description: 创建一个飞机类
* @author neuedu_ZLC
* @date 2019年8月20日
* @version 0.1
*
*/
public class Plane extends GameObj implements ActionAble{
	
	// 速度
	private int speed;
	// 方向布尔变量
	private boolean left,up,right,down;
	
	// 客户端拿过来
	public GameClient gc;
	
	// 判断是我军还是敌军
	public boolean isGood;
	
	public Plane() {
		
	}
	public Plane(int x,int y,String imgName,GameClient gc,boolean isGood) {
		this.x = x;
		this.y= y;
		this.img = GetImageUtil.geyImg(imgName);
		this.speed = 15;
		this.gc = gc;
		this.isGood = isGood;
	}
	// 移动的方法
	@Override
	public void move() {
		if(left) {
			x -= speed;
		}
		if(up) {
			y -= speed;
		}
		if(right) {
			x += speed;
		}
		if(down) {
			y += speed;
		}
		outOfBound();
		
	}
	// 画一个飞机
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		move();
		
	}
	// 处理飞机边界问题
	public void outOfBound() {
		if(y<=35) {
			y = 30;
		}
		if(x<=5) {
			x = 0;
		}
		if(x>=Constant.GAME_WIDTH-img.getWidth(null)) {
			x = Constant.GAME_WIDTH-img.getWidth(null);
		}
		if(y>=Constant.GAME_HEIGHT-img.getHeight(null)) {
			y = Constant.GAME_HEIGHT-img.getHeight(null);
		}
	}
	
	// 键盘按下
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
//		case KeyEvent.VK_X:
//			fire();
//			break;
		default:
			break;
		}
		
	}
	// 键盘释放
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_X:
			fire();
			break;
		default:
			break;
		}
		
	}
	// 我方飞机的开火
	public void fire() {
		Bullet b = new Bullet(x, y, "bullet/zidan.png",gc,true);
		gc.bullets.add(b);
	}
	
	// 获取到当前的矩形
		public Rectangle getRec() {
			return new Rectangle(x, y, this.img.getWidth(null), this.img.getHeight(null));
		}
	
	

}
