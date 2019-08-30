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
* @Description: ����һ���ɻ���
* @author neuedu_ZLC
* @date 2019��8��20��
* @version 0.1
*
*/
public class Plane extends GameObj implements ActionAble{
	
	SinglePlay play = new SinglePlay();
	
	
	// �ٶ�
	private int speed;
	// ���򲼶�����
	private boolean left,up,right,down;
	
	// �ͻ����ù���
	public GameClient gc;
	
	// �ж����Ҿ����ǵо�
	public boolean isGood;
	
	// ��ӷɻ��ӵ��ȼ�����
	public int BulletLevel = 1;;
	
	// ���Ѫ��ֵ
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
	// �ƶ��ķ���
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
	// ��һ���ɻ�
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		move();
		g.drawString("��ǰѪ��:"+blood, 10, 80);
		
	}
	// ����ɻ��߽�����
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
	
	// ���̰���
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
	// �����ͷ�
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
	// �ҷ��ɻ��Ŀ���
	public void fire() {
		play.play("com/neuedu/sound/bullet.mp3");
		Bullet b = new Bullet(x-30, y, "bullet/zidan_0"+BulletLevel+".png",gc,true);
		gc.bullets.add(b);
	}
	
	// ��ȡ����ǰ�ľ���
		public Rectangle getRec() {
			return new Rectangle(x, y, this.img.getWidth(null), this.img.getHeight(null));
		}
	
	// ����ҷ��ɻ���������
		public void containItem(Prop prop) {
			if(this.getRec().intersects(prop.getRect())) {
				// �Ƴ�����
				gc.props.remove(prop);
				if(BulletLevel>5) {
					BulletLevel = 6;
					return;
				}
				// �����ӵ��ȼ�
				this.BulletLevel +=1;
			}
		}
	// ����ҷ��ɻ���ײ���������
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
