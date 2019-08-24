package com.neuedu.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.Random;

import com.neuedu.action.ActionAble;
import com.neuedu.client.GameClient;
import com.neuedu.constant.Constant;
import com.neuedu.util.GetImageUtil;

/**
* @ClassName: Bullet
* @Description: �ӵ���
* @author neuedu_ZLC
* @date 2019��8��20��
* @version 0.1
*
*/
public class Bullet extends GameObj implements ActionAble {
	// �����ٶ�����
	private Integer speed;
	
	// �õ��ͻ���
	public GameClient gc;
	
	// �ӵ�����
	public boolean isGood;
	
	public Bullet() {
		
	}
	public Bullet(int x,int y,String imgName,GameClient gc,boolean isGood) {
		this.x = x;
		this.y = y;
		this.img = GetImageUtil.geyImg(imgName);
		this.speed = 15;
		this.gc = gc;
		this.isGood = isGood;
	}
	@Override
	public void move() {
		if(isGood) {
			y -= speed;
		}else {
			y += speed;
		}
		
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x+48, y-60, null);
		move();
		outOfBounds();
	}
	// �ӵ�Խ������
	public void outOfBounds() {
		if(y<0||y>755) {
			gc.bullets.remove(this);
		}
	}
	
	// ������ɵ���
	Random random = new Random();
	
	// �ӵ���һ������
	public boolean hitMonster(Plane plane) {
		Boom boom = null;
		if(this.getRec().intersects(plane.getRec())&&this.isGood!=plane.isGood) {
			boom = new Boom(plane.x, plane.y,gc);
			if(plane.isGood) {
			    // ��������
			    gc.planes.remove(plane);
			    // ��ӱ�ը
			    gc.booms.add(boom);
			}else {
				// �Ƴ����еĵ���
				gc.enemys.remove(plane);
				// �Ƴ��ӵ�
				gc.bullets.remove(this);
				// ��ӱ�ը
				gc.booms.add(boom);
				// �������һ������
				if(random.nextInt(500)>400) {
					Prop prop = new Prop(plane.x, plane.y, "prop/daoju1.png");
					gc.props.add(prop);
				}
				
			}
			
			return true;
		}
		return false;
	}
	// �ӵ���������
	public boolean hitMonsters(List<Plane> monsters) {
		if(monsters==null) {
			return false;
		}
		for(int i=0;i<monsters.size();i++) {
			if(hitMonster(monsters.get(i))) {
				return true;
			}
		}
		return false;
	}
	
    // ��ȡ���ӵ��ľ���
	public Rectangle getRec() {
		return new Rectangle(x, y, this.img.getWidth(null), this.img.getHeight(null));
	}
	
	
	
	
}
