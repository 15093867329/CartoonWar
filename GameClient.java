package com.neuedu.client;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.constant.Constant;
import com.neuedu.entity.BackGround;
import com.neuedu.entity.Boom;
import com.neuedu.entity.Boss;
import com.neuedu.entity.Bullet;
import com.neuedu.entity.EnemyPlane;
import com.neuedu.entity.Plane;
import com.neuedu.entity.Prop;
import com.neuedu.util.GetImageUtil;
import com.neuedu.util.SoundPlayer;

/**
* @ClassName: GameClient
* @Description: 游戏客户端
* @author neuedu_ZLC
* @date 2019年8月19日
* @version 0.1
*
*/
public class GameClient extends Frame {
	// 创建一个Plane
//	Plane plane = new Plane(350, 650, "plane/moxing.png",this,true);
	
	// 创建一个我方子弹集合
	public List<Plane> planes = new ArrayList<>();
	
	// 创建道具集合
	public List<Prop> props = new ArrayList<>();
	
	// 创建一个子弹集合
	public List<Bullet> bullets = new ArrayList<>();
	
	// 创建一个背景图
	BackGround backImg = new BackGround(0,-7619,"beijing.png");
	
	// 创建一个爆炸的集合
	public List<Boom> booms = new ArrayList<>();
	
	

	
	// 创建敌方集合
	public List<Plane> enemys = new ArrayList<>();
	
	// 创建BOSS集合
	public List<Plane> bosss = new ArrayList<>();
	
	// 解决图片闪烁问题
	public void update(Graphics g) {
		Image backImg = createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		Graphics backg = backImg.getGraphics();
		Color color = backg.getColor();
		backg.setColor(Color.WHITE);
		backg.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		backg.setColor(color);
		paint(backg);
		g.drawImage(backImg,0,0,null);
	}
	
	Plane plane =null;
	
	// 生成客户端窗口的方法
	public void launchFrame() {
		
		SoundPlayer soundPlayer = new SoundPlayer("com/neuedu/sound/game.mp3");
		soundPlayer.start();
		
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setTitle("卡通大作战");
		// 窗口显示
		this.setVisible(true);
		// 禁止最大化
		this.setResizable(false);
		// 窗口居中
		this.setLocationRelativeTo(null);
		// 图标
		Image img = GetImageUtil.geyImg("tubiao.jpeg");
		this.setIconImage(img);
		// 关闭窗口 添加关闭监听器
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		plane = new Plane(350, 650, "plane/moxing.png",this,true);
		// 向我方容器中添加自己
		planes.add(plane);
		
		// 添加鼠标监听
//		this.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//                System.out.println("你点了一下鼠标");
//			}
//			
//		});
		// 添加键盘监听
		this.addKeyListener(new KeyAdapter() {
			// 按下键盘
			@Override
			public void keyPressed(KeyEvent e) {
				plane.keyPressed(e);
			}
			// 放开键盘
			public void keyReleased(KeyEvent e) {
				plane.keyReleased(e);
			}
			
		});
		
		
		// 启动线程
		new paintThread().start();
		
		
		// 创建敌方一号飞机
		EnemyPlane enemy1 = new EnemyPlane(600,50,1,this,false);
		EnemyPlane enemy2 = new EnemyPlane(300,50,1,this,false);
		EnemyPlane enemy3 = new EnemyPlane(50,50,1,this,false);
		EnemyPlane enemy4 = new EnemyPlane(600,-200,1,this,false);
		EnemyPlane enemy5 = new EnemyPlane(300,-200,1,this,false);
		EnemyPlane enemy6 = new EnemyPlane(50,-200,1,this,false);
		EnemyPlane enemy7 = new EnemyPlane(600,-400,1,this,false);
		EnemyPlane enemy8 = new EnemyPlane(300,-400,1,this,false);
		// 向敌方容器中添加敌人
		enemys.add(enemy1);
		enemys.add(enemy2);
		enemys.add(enemy3);
		enemys.add(enemy4);
		enemys.add(enemy5);
		enemys.add(enemy6);
		enemys.add(enemy7);
		enemys.add(enemy8);
		// 添加BOSS
		bosss.add(new Boss(300,-200,this,false));
	
	}
	
	// 重写paint方法
	@Override
	public void paint(Graphics g) {
		backImg.draw(g);
		for(int i=0;i<planes.size();i++) {
			Plane plane2 = planes.get(i);
			plane2.draw(g);
			plane2.containItems(props);
			
		}
		// 循环画出每个子弹
		for(int i=0;i<bullets.size();i++) {
			Bullet bullet = bullets.get(i);
			bullet.draw(g);
			bullet.hitMonsters(enemys);
			bullet.hitMonsters(planes);
			bullet.hitMonsters(bosss);
		}
		g.drawString("当前子弹数量:"+bullets.size(), 10, 40);
		g.drawString("当前敌机的数量:"+enemys.size(), 10, 60);
		// 循环画敌方
		for(int i=0;i<enemys.size();i++) {
			enemys.get(i).draw(g);
		}
		
		// 循环爆炸
		for(int i=0;i<booms.size();i++) {
			if(booms.get(i).isLive()==true) {
				booms.get(i).draw(g);
			}
		}
		// 循环画道具
		for(int i=0;i<props.size();i++) {
				props.get(i).draw(g);
		}
		if(enemys.size()==0) {
			// 循环画BOSS
			for(int i=0;i<bosss.size();i++) {
				bosss.get(i).draw(g);
		}
		
	}
	
	
	}
	// 内部类
	class paintThread extends Thread{
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	} 


	
}
