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
* @Description: 子弹类
* @author neuedu_ZLC
* @date 2019年8月20日
* @version 0.1
*
*/
public class Bullet extends GameObj implements ActionAble {
	// 创建速度属性
	private Integer speed;
	
	// 拿到客户端
	public GameClient gc;
	
	// 子弹类型
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
	// 子弹越界销毁
	public void outOfBounds() {
		if(y<0||y>755) {
			gc.bullets.remove(this);
		}
	}
	
	// 随机生成道具
	Random random = new Random();
	
	// 子弹打一个怪物
	public boolean hitMonster(Plane plane) {
		Boom boom = null;
		if(this.getRec().intersects(plane.getRec())&&this.isGood!=plane.isGood) {
			boom = new Boom(plane.x, plane.y,gc);
			if(plane.isGood) {
			    // 销毁自身
			    gc.planes.remove(plane);
			    // 添加爆炸
			    gc.booms.add(boom);
			}else {
				// 移除打中的敌人
				gc.enemys.remove(plane);
				// 移除子弹
				gc.bullets.remove(this);
				// 添加爆炸
				gc.booms.add(boom);
				// 随机生成一个道具
				if(random.nextInt(500)>400) {
					Prop prop = new Prop(plane.x, plane.y, "prop/daoju1.png");
					gc.props.add(prop);
				}
				
			}
			
			return true;
		}
		return false;
	}
	// 子弹打多个怪物
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
	
    // 获取到子弹的矩形
	public Rectangle getRec() {
		return new Rectangle(x, y, this.img.getWidth(null), this.img.getHeight(null));
	}
	
	
	
	
}
