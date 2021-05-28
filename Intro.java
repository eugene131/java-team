package teamproject;
/***1. �� num �ٲ�� �κп��� �鵵 ���� �ʿ�
 * 2. ��, �� ���� �� ��� �� ����� �� �ѹ� �� �ȴ����� �� ���� �ʿ�(��� ����� ���� ������ ����)
 * 3. ��, ��� ��� �� ����� �� ���ʰ� ���� �Ѿ�� �� ���� �ʿ�(�ذ�)
 * 4. player1 ��, �� ������ �� �ѹ� �� �ȴ����� �� ���� �ʿ�(�ذ�)
 * */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Intro extends JFrame implements ActionListener{
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 720;
	private int page;
	JFrame comp = new JFrame();
	JPanel intro = new JPanel();
	Pan panPanel = new Pan();
	mallGui mallPanel = new mallGui();
	JMenuItem backmenu;
	JMenuItem savemenu;
	
	JPanel panMain;
	//JPanel panBtn;
	
	public Intro() {
		comp.setSize(WIDTH, HEIGHT);
		comp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		comp.setBackground(Color.WHITE);
		comp.setLayout(null);
		
		intro.setLayout(null);
		intro.setBounds(0,0,WIDTH,HEIGHT);
		intro.setBackground(Color.gray);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(null);
		
		btnPanel.setBounds(400,430,200,320);
		btnPanel.setBackground(Color.gray);
		
		JButton nstart = new JButton("�����ϱ�");
		nstart.addActionListener(this);
		nstart.setBounds(0,0,200,40);
		nstart.setBackground(Color.WHITE);
		btnPanel.add(nstart);
		
		JButton con = new JButton("�̾��ϱ�");
		con.addActionListener(this);
		con.setBounds(0,50,200,40);
		con.setBackground(Color.WHITE);
		btnPanel.add(con);
		
		JButton explanation = new JButton("���Ӽ���");
		explanation.addActionListener(this);
		explanation.setBounds(0,100,200,40);
		explanation.setBackground(Color.WHITE);
		btnPanel.add(explanation);
		
		JButton exit = new JButton("�����ϱ�");
		exit.addActionListener(this);
		exit.setBounds(0,150,200,40);
		exit.setBackground(Color.WHITE);
		btnPanel.add(exit);
		
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("�޴�");
		
		JMenuItem newmenu = new JMenuItem("�����ϱ�");
		newmenu.addActionListener(this);
		JMenuItem callmenu = new JMenuItem("�̾��ϱ�");
		callmenu.addActionListener(this);
		backmenu = new JMenuItem("���ư���");
		backmenu.addActionListener(this);
		backmenu.setEnabled(false);
		savemenu = new JMenuItem("�����ϱ�");
		savemenu.addActionListener(this);
		savemenu.setEnabled(false);
		JMenuItem finmenu = new JMenuItem("�����ϱ�");
		finmenu.addActionListener(this);
		
		screenMenu.add(newmenu);
		screenMenu.add(callmenu);
		screenMenu.add(backmenu);
		screenMenu.add(savemenu);
		screenMenu.addSeparator();
		screenMenu.add(finmenu);

		mb.add(screenMenu);

		comp.setJMenuBar(mb);
		
		panMain = panPanel.comp;
		//panBtn = mallPanel.PlayerPanel;
		panMain.setVisible(false);
		//panBtn.setVisible(false);
		
		intro.add(btnPanel);
		comp.add(intro);
		comp.add(panMain);
		//comp.add(panBtn);
	}
	
	public int getPage() {
		return page;
	}
	
	public static void main(String[] args) {
		Intro panGui = new Intro();
		panGui.comp.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		// TODO Auto-generated method stub
		if(actionCommand.equals("�����ϱ�")) {
			intro.setVisible(false);
			panMain.setVisible(true);
			//panBtn.setVisible(true);
			backmenu.setEnabled(true);
			savemenu.setEnabled(true);
		}
		else if(actionCommand.equals("�̾��ϱ�")) {
			Fileinput con = new Fileinput();
			con.comp.setVisible(true);
			
			backmenu.setEnabled(true);
			savemenu.setEnabled(true);
		}
		else if(actionCommand.equals("���ư���")) {
			intro.setVisible(true);
			panMain.setVisible(false);
			//panBtn.setVisible(false);
			
			backmenu.setEnabled(false);
			savemenu.setEnabled(false);
		}
		else if(actionCommand.equals("�����ϱ�")) {
			//
		}
		else if(actionCommand.equals("�����ϱ�")) {
			comp.dispose();
		}
		else if(actionCommand.equals("���Ӽ���")) {
			page = 3;
		}
	}
}