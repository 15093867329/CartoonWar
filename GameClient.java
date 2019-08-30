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
* @Description: ��Ϸ�ͻ���
* @author neuedu_ZLC
* @date 2019��8��19��
* @version 0.1
*
*/
public class GameClient extends Frame {
	// ����һ��Plane
//	Plane plane = new Plane(350, 650, "plane/moxing.png",this,true);
	
	// ����һ���ҷ��ӵ�����
	public List<Plane> planes = new ArrayList<>();
	
	// �������߼���
	public List<Prop> props = new ArrayList<>();
	
	// ����һ���ӵ�����
	public List<Bullet> bullets = new ArrayList<>();
	
	// ����һ������ͼ
	BackGround backImg = new BackGround(0,-7619,"beijing.png");
	
	// ����һ����ը�ļ���
	public List<Boom> booms = new ArrayList<>();
	
	

	
	// �����з�����
	public List<Plane> enemys = new ArrayList<>();
	
	// ����BOSS����
	public List<Plane> bosss = new ArrayList<>();
	
	// ���ͼƬ��˸����
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
	
	// ���ɿͻ��˴��ڵķ���
	public void launchFrame() {
		
		SoundPlayer soundPlayer = new SoundPlayer("com/neuedu/sound/game.mp3");
		soundPlayer.start();
		
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setTitle("��ͨ����ս");
		// ������ʾ
		this.setVisible(true);
		// ��ֹ���
		this.setResizable(false);
		// ���ھ���
		this.setLocationRelativeTo(null);
		// ͼ��
		Image img = GetImageUtil.geyImg("tubiao.jpeg");
		this.setIconImage(img);
		// �رմ��� ��ӹرռ�����
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		plane = new Plane(350, 650, "plane/moxing.png",this,true);
		// ���ҷ�����������Լ�
		planes.add(plane);
		
		// ���������
//		this.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//                System.out.println("�����һ�����");
//			}
//			
//		});
		// ��Ӽ��̼���
		this.addKeyListener(new KeyAdapter() {
			// ���¼���
			@Override
			public void keyPressed(KeyEvent e) {
				plane.keyPressed(e);
			}
			// �ſ�����
			public void keyReleased(KeyEvent e) {
				plane.keyReleased(e);
			}
			
		});
		
		
		// �����߳�
		new paintThread().start();
		
		
		// �����з�һ�ŷɻ�
		EnemyPlane enemy1 = new EnemyPlane(600,50,1,this,false);
		EnemyPlane enemy2 = new EnemyPlane(300,50,1,this,false);
		EnemyPlane enemy3 = new EnemyPlane(50,50,1,this,false);
		EnemyPlane enemy4 = new EnemyPlane(600,-200,1,this,false);
		EnemyPlane enemy5 = new EnemyPlane(300,-200,1,this,false);
		EnemyPlane enemy6 = new EnemyPlane(50,-200,1,this,false);
		EnemyPlane enemy7 = new EnemyPlane(600,-400,1,this,false);
		EnemyPlane enemy8 = new EnemyPlane(300,-400,1,this,false);
		// ��з���������ӵ���
		enemys.add(enemy1);
		enemys.add(enemy2);
		enemys.add(enemy3);
		enemys.add(enemy4);
		enemys.add(enemy5);
		enemys.add(enemy6);
		enemys.add(enemy7);
		enemys.add(enemy8);
		// ���BOSS
		bosss.add(new Boss(300,-200,this,false));
	
	}
	
	// ��дpaint����
	@Override
	public void paint(Graphics g) {
		backImg.draw(g);
		for(int i=0;i<planes.size();i++) {
			Plane plane2 = planes.get(i);
			plane2.draw(g);
			plane2.containItems(props);
			
		}
		// ѭ������ÿ���ӵ�
		for(int i=0;i<bullets.size();i++) {
			Bullet bullet = bullets.get(i);
			bullet.draw(g);
			bullet.hitMonsters(enemys);
			bullet.hitMonsters(planes);
			bullet.hitMonsters(bosss);
		}
		g.drawString("��ǰ�ӵ�����:"+bullets.size(), 10, 40);
		g.drawString("��ǰ�л�������:"+enemys.size(), 10, 60);
		// ѭ�����з�
		for(int i=0;i<enemys.size();i++) {
			enemys.get(i).draw(g);
		}
		
		// ѭ����ը
		for(int i=0;i<booms.size();i++) {
			if(booms.get(i).isLive()==true) {
				booms.get(i).draw(g);
			}
		}
		// ѭ��������
		for(int i=0;i<props.size();i++) {
				props.get(i).draw(g);
		}
		if(enemys.size()==0) {
			// ѭ����BOSS
			for(int i=0;i<bosss.size();i++) {
				bosss.get(i).draw(g);
		}
		
	}
	
	
	}
	// �ڲ���
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
