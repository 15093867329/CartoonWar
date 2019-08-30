package com.neuedu.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.accessibility.Accessible;

import com.neuedu.action.ActionAble;
import com.neuedu.client.GameClient;
import com.neuedu.constant.Constant;
import com.neuedu.util.GetImageUtil;
import com.neuedu.util.SinglePlay;

/**
* @ClassName: Plane
* @Description: 创建一个飞机类
* @author neuedu_ZLC
* @date 2019年8月20日
* @version 0.1
*
*/
public class Plane extends GameObj implements ActionAble{
	
	SinglePlay play = new SinglePlay();
	
	
	// 速度
	private int speed;
	// 方向布尔变量
	private boolean left,up,right,down;
	
	// 客户端拿过来
	public GameClient gc;
	
	// 判断是我军还是敌军
	public boolean isGood;
	
	// 添加飞机子弹等级变量
	public int BulletLevel = 1;;
	
	// 添加血量值
	public int blood;
	
	public Plane() {
		
	}
	public Plane(int x,int y,String imgName,GameClient gc,boolean isGood) {
		this.x = x;
		this.y= y;
		this.img = GetImageUtil.geyImg(imgName);
		this.speed = 15;
		this.gc = gc;
		this.isGood = isGood;
		this.blood = 100;
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
		g.drawString("当前血量:"+blood, 10, 80);
		
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
		play.play("com/neuedu/sound/bullet.mp3");
		Bullet b = new Bullet(x-30, y, "bullet/zidan_0"+BulletLevel+".png",gc,true);
		gc.bullets.add(b);
	}
	
	// 获取到当前的矩形
		public Rectangle getRec() {
			return new Rectangle(x, y, this.img.getWidth(null), this.img.getHeight(null));
		}
	
	// 检测我方飞机碰到道具
		public void containItem(Prop prop) {
			if(this.getRec().intersects(prop.getRect())) {
				// 移除道具
				gc.props.remove(prop);
				if(BulletLevel>5) {
					BulletLevel = 6;
					return;
				}
				// 更改子弹等级
				this.BulletLevel +=1;
			}
		}
	// 检测我方飞机碰撞到多个道具
		public void containItems(List<Prop> props) {
			if(props==null) {
				return;
			}else {
				for(int i=0;i<props.size();i++) {
					containItem(props.get(i));
				}
			}
		}
	

}
