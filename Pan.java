package teamproject;
/***1. 판 num 바뀌는 부분에서 백도 수정 필요(해결)
 * 2. 윷, 모 나온 후 상대 말 잡았을 때 한번 더 안던지는 거 수정 필요(윷이나 모로 잡아도 한번 더 던지도록 수정)
 * 3. 윷, 모로 상대 말 잡았을 때 차례가 상대로 넘어가는 거 수정 필요(해결)
 * 4. player1 윷, 모 나왔을 때 한번 더 안던지는 거 수정 필요(해결)
 * */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;

public class Pan extends JFrame implements ActionListener{
	private int player1Nammal = 0;
	private int player2Nammal = 0;	
	private boolean turn = true;
	private String resText = "?";
	private yut yourYut = new yut();
//	private Pplayer player1 = new Pplayer();
//	private Pplayer player2 = new Pplayer();
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 720;
	public static final int POINT_SIZE = 30;	
	private JLabel resLabel = new JLabel(resText);
	private JLabel yutLabel1 = new JLabel();			
	private JLabel yutLabel2 = new JLabel();			
	private JLabel yutLabel3 = new JLabel();			
	private JLabel yutLabel4 = new JLabel();		
	
	//이미지 경로
	String playerCheckImage;
	String playerCheckPath;
	ImageIcon CheckIcon;
	String player1mallImage;
	String player1mallPath;
	ImageIcon player1mallIcon;
	String player2mallImage;
	String player2mallPath;
	ImageIcon player2mallIcon;
	String WhiteImage;
	String WhitePath;
	ImageIcon WhiteIcon;
	String frontYutImage;
	String frontYutPath;
	ImageIcon frontYutIcon;
	String rearYutImage;
	String rearYutPath;
	ImageIcon rearYutIcon;
	String backDoImage;
	String backDoPath;
	ImageIcon backDoIcon;
	JPanel PlayerPanel;
	JButton clickButton;
	
	static String Src = "src";
	static String Package = "teamproject";
	//윷 움짤 이미지
	String yutImage = "";
	String yutPath = "";
	ImageIcon yutIcon = new ImageIcon(yutPath);
	//결과 표시되는 글씨 관련해서 넣을 것, 이미지로 가져오면 도개걸윷모빽도 총 6개의 이미지를 가져와야 된다
	String resImage = "";
	String resPath = "";
	ImageIcon resIcon = new ImageIcon(resPath);
	
	public static final int TEXT_FIELD_SIZE = 10;
	public static final String srcPath = "src";
	public static final String packageName = "teamproject";
	
	JPanel comp = new JPanel();
	JPanel btnPanel = new JPanel();
	JPanel pan;
	
	ImageIcon btn1;
	ImageIcon btn2;
	ImageIcon btnch;
	ImageIcon trbtn;
	ImageIcon exist;
	ImageIcon bgCh;
	ImageIcon bgEx;
	ImageIcon exist2;
	ImageIcon bgEx2;
	
	Malll[] P1 = new Malll[2];
	Malll[] P2 = new Malll[2];
	
	boolean player1 = true;
	boolean player2 = false;
	
	boolean chance1 = true;
	boolean chance2 = true;
	
	public int[] checkNum1=new int[2];
	public int[] checkNum2=new int[2];
	public int[] midcheck1=new int[2];
	public int[] midcheck2=new int[2];
	
	public int p1cnt = 0;
	public int p2cnt = 0;
	public int num1;
	public int num2;
	public ArrayList<Integer> p1rd=new ArrayList<Integer>();
	public ArrayList<Integer> p2rd=new ArrayList<Integer>();
	
	public int mall;
	
	//public int loc;
	
	public int[] bfmv1 = new int[2];
	public int[] bfmv2 = new int[2];
	
	public int[] afmv1 = new int[2];
	public int[] afmv2 = new int[2];
	
	public int loc;
	
	JButton[] btn = new JButton[71];
	boolean[] ch1 = new boolean[71];
	boolean[] ch2 = new boolean[71];
	JLabel[] image = new JLabel[71];
	boolean throwY = false;
	
	yut y = new yut();
	
	private JTextField message;
	
	public static void main(String[] args) {
		Pan panGui = new Pan();
		panGui.comp.setVisible(true);
	}
	
	public Pan() {
		comp.setSize(WIDTH, HEIGHT);
		comp.setBackground(Color.WHITE);
		comp.setLayout(null);
		
		pan = new JPanel(); 
		pan.setLayout(null);
		pan.setBounds(0,0,700,720);
		
		comp.validate();
		pan.validate();

		
		btnPanel.setLayout(new BorderLayout());
		btnPanel.setBounds(700,0,300,720);
		
		String currentProjPath = "";
		try {
			currentProjPath = new File(".").getCanonicalPath();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		String button1 = "BUTTON1.png";
		String button2 = "BUTTON2.png";
		String btonCh = "BUTTON_change.png";
		String button = "button.png";
		String exbutton = "exist.png";
		String bigCh = "bigchange.png";
		String bigEx = "bigexist.png";
		String exbutton2 = "exist2.png";
		String bigEx2 = "bigexist2.png";
		
		btn1 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+button1);
		btn2 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+button2);
		btnch = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+btonCh);
		trbtn = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+button);
		exist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+exbutton);
		bgCh = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+bigCh);
		bgEx = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+bigEx);
		exist2 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+exbutton2);
		bgEx2 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+bigEx2);
		
		//JButton click = new JButton("click");
		//click.addActionListener(this);
		//btnPanel.add(click);
		
		for(int i=0;i<2;i++) {
			P1[i] = new Malll();
			P2[i] = new Malll();
		}
		
		for(int i=0;i<71;i++) {
			image[i]=new JLabel(btn1);
			btn[i]=new JButton(trbtn);
		}
		
		image[46] = new JLabel(btn1);
		image[46].setBounds(535, 545, 100, 120);
			
		btn[46] = new JButton(trbtn);
		btn[46].setBounds(535, 545, 100, 120);
		btn[46].setBorderPainted(false);
		btn[46].setFocusPainted(false);
		btn[46].setContentAreaFilled(false);
		btn[46].addActionListener(this);
		
		image[1] = new JLabel(btn2);
		image[1].setBounds(535, 545-125, 100, 120);
			
		btn[1] = new JButton(trbtn);
		btn[1].setBounds(535, 545-125, 100, 120);
		btn[1].setBorderPainted(false);
		btn[1].setFocusPainted(false);
		btn[1].setContentAreaFilled(false);
		btn[1].addActionListener(this);

		image[2] = new JLabel(btn2);
		image[2].setBounds(535, 545-225, 100, 120);
		
		btn[2] = new JButton(trbtn);
		btn[2].setBounds(535, 545-225, 100, 120);
		btn[2].setBorderPainted(false);
		btn[2].setFocusPainted(false);
		btn[2].setContentAreaFilled(false);
		btn[2].addActionListener(this);
		//btn1_3.setEnabled(false);
		
		image[3] = new JLabel(btn2);
		image[3].setBounds(535, 545-325, 100, 120);
		
		btn[3] = new JButton(trbtn);
		btn[3].setBounds(535, 545-325, 100, 120);
		btn[3].setBorderPainted(false);
		btn[3].setFocusPainted(false);
		btn[3].setContentAreaFilled(false);
		btn[3].addActionListener(this);
		//btn1_4.setEnabled(false);
		
		image[4] = new JLabel(btn2);
		image[4].setBounds(535, 545-425, 100, 120);
		
		btn[4] = new JButton(trbtn);
		btn[4].setBounds(535, 545-425, 100, 120);
		btn[4].setBorderPainted(false);
		btn[4].setFocusPainted(false);
		btn[4].setContentAreaFilled(false);
		btn[4].addActionListener(this);
		//btn1_5.setEnabled(false);
		
		image[60] = new JLabel(btn1);
		image[60].setBounds(535, 10, 100, 120);
		
		btn[60] = new JButton(trbtn);
		btn[60].setBounds(535, 10, 100, 120);
		btn[60].setBorderPainted(false);
		btn[60].setFocusPainted(false);
		btn[60].setContentAreaFilled(false);
		btn[60].addActionListener(this);
		//btn2_1.setEnabled(false);
		
		image[6] = new JLabel(btn2);
		image[6].setBounds(535-120, 10, 100, 120);
		
		btn[6] = new JButton(trbtn);
		btn[6].setBounds(535-120, 10, 100, 120);
		btn[6].setBorderPainted(false);
		btn[6].setFocusPainted(false);
		btn[6].setContentAreaFilled(false);
		btn[6].addActionListener(this);
		//btn2_2.setEnabled(false);
		
		image[7] = new JLabel(btn2);
		image[7].setBounds(545-220, 10, 100, 120);
		
		btn[7] = new JButton(trbtn);
		btn[7].setBounds(545-220, 10, 100, 120);
		btn[7].setBorderPainted(false);
		btn[7].setFocusPainted(false);
		btn[7].setContentAreaFilled(false);
		btn[7].addActionListener(this);
		//btn2_3.setEnabled(false);
		
		image[8] = new JLabel(btn2);
		image[8].setBounds(545-320, 10, 100, 120);
		
		btn[8] = new JButton(trbtn);
		btn[8].setBounds(545-320, 10, 100, 120);
		btn[8].setBorderPainted(false);
		btn[8].setFocusPainted(false);
		btn[8].setContentAreaFilled(false);
		btn[8].addActionListener(this);
		//btn2_4.setEnabled(false);
		
		image[9] = new JLabel(btn2);
		image[9].setBounds(545-420, 10, 100, 120);
		
		btn[9] = new JButton(trbtn);
		btn[9].setBounds(545-420, 10, 100, 120);
		btn[9].setBorderPainted(false);
		btn[9].setFocusPainted(false);
		btn[9].setContentAreaFilled(false);
		btn[9].addActionListener(this);
		//btn2_5.setEnabled(false);
		
		image[40] = new JLabel(btn1);
		image[40].setBounds(10 , 10, 100, 120);
		
		btn[40] = new JButton(trbtn);
		btn[40].setBounds(10 , 10, 100, 120);
		btn[40].setBorderPainted(false);
		btn[40].setFocusPainted(false);
		btn[40].setContentAreaFilled(false);
		btn[40].addActionListener(this);
		//btn[10].setEnabled(false);
		
		image[11] = new JLabel(btn2);
		image[11].setBounds(10, 10+110, 100, 120);
		
		btn[11] = new JButton(trbtn);
		btn[11].setBounds(10, 10+110, 100, 120);
		btn[11].setBorderPainted(false);
		btn[11].setFocusPainted(false);
		btn[11].setContentAreaFilled(false);
		btn[11].addActionListener(this);
		//btn[11].setEnabled(false);
		
		image[12] = new JLabel(btn2);
		image[12].setBounds(10, 10+210, 100, 120);
		
		btn[12] = new JButton(trbtn);
		btn[12].setBounds(10, 10+210, 100, 120);
		btn[12].setBorderPainted(false);
		btn[12].setFocusPainted(false);
		btn[12].setContentAreaFilled(false);
		btn[12].addActionListener(this);
		//btn[12].setEnabled(false);
		
		image[13] = new JLabel(btn2);
		image[13].setBounds(10, 10+310, 100, 120);
		
		btn[13] = new JButton(trbtn);
		btn[13].setBounds(10, 10+310, 100, 120);
		btn[13].setBorderPainted(false);
		btn[13].setFocusPainted(false);
		btn[13].setContentAreaFilled(false);
		btn[13].addActionListener(this);
		//btn[13].setEnabled(false);
		
		image[14] = new JLabel(btn2);
		image[14].setBounds(10, 10+410, 100, 120);
		
		btn[14] = new JButton(trbtn);
		btn[14].setBounds(10, 10+410, 100, 120);
		btn[14].setBorderPainted(false);
		btn[14].setFocusPainted(false);
		btn[14].setContentAreaFilled(false);
		btn[14].addActionListener(this);
		//btn[14].setEnabled(false);
		
		image[15] = new JLabel(btn1);
		image[15].setBounds(10 , 545, 100, 120);
		
		btn[15] = new JButton(trbtn);
		btn[15].setBounds(10 , 545, 100, 120);
		btn[15].setBorderPainted(false);
		btn[15].setFocusPainted(false);
		btn[15].setContentAreaFilled(false);
		btn[15].addActionListener(this);
		//btn[15].setEnabled(false);
		
		image[16] = new JLabel(btn2);
		image[16].setBounds(10+110, 545, 100, 120);
		
		btn[16] = new JButton(trbtn);
		btn[16].setBounds(10+110, 545, 100, 120);
		btn[16].setBorderPainted(false);
		btn[16].setFocusPainted(false);
		btn[16].setContentAreaFilled(false);
		btn[16].addActionListener(this);
		//btn[16].setEnabled(false);
		
		image[17] = new JLabel(btn2);
		image[17].setBounds(10+210, 545, 100, 120);
		
		btn[17] = new JButton(trbtn);
		btn[17].setBounds(10+210, 545, 100, 120);
		btn[17].setBorderPainted(false);
		btn[17].setFocusPainted(false);
		btn[17].setContentAreaFilled(false);
		btn[17].addActionListener(this);
		//btn[17].setEnabled(false);
		
		image[18] = new JLabel(btn2);
		image[18].setBounds(10+310, 545, 100, 120);
		
		btn[18] = new JButton(trbtn);
		btn[18].setBounds(10+310, 545, 100, 120);
		btn[18].setBorderPainted(false);
		btn[18].setFocusPainted(false);
		btn[18].setContentAreaFilled(false);
		btn[18].addActionListener(this);
		//btn[18].setEnabled(false);
		
		image[19] = new JLabel(btn2);
		image[19].setBounds(10+410, 545, 100, 120);
		
		btn[19] = new JButton(trbtn);
		btn[19].setBounds(10+410, 545, 100, 120);
		btn[19].setBorderPainted(false);
		btn[19].setFocusPainted(false);
		btn[19].setContentAreaFilled(false);
		btn[19].addActionListener(this);
		//btn[19].setEnabled(false);
		
		image[61] = new JLabel(btn2);
		image[61].setBounds(535-100, 10+100, 100, 120);
		
		btn[61] = new JButton(trbtn);
		btn[61].setBounds(535-100, 10+100, 100, 120);
		btn[61].setBorderPainted(false);
		btn[61].setFocusPainted(false);
		btn[61].setContentAreaFilled(false);
		btn[61].addActionListener(this);
		//btn[20].setEnabled(false);
		
		image[62] = new JLabel(btn2);
		image[62].setBounds(535-170, 10+180, 100, 120);
		
		btn[62] = new JButton(trbtn);
		btn[62].setBounds(535-170, 10+180, 100, 120);
		btn[62].setBorderPainted(false);
		btn[62].setFocusPainted(false);
		btn[62].setContentAreaFilled(false);
		btn[62].addActionListener(this);
		//btn[21].setEnabled(false);
		
		image[41] = new JLabel(btn2);
		image[41].setBounds(10+100 , 10+100, 100, 120);
		
		btn[41] = new JButton(trbtn);
		btn[41].setBounds(10+100 , 10+100, 100, 120);
		btn[41].setBorderPainted(false);
		btn[41].setFocusPainted(false);
		btn[41].setContentAreaFilled(false);
		btn[41].addActionListener(this);
		//btn[22].setEnabled(false);
		
		image[42] = new JLabel(btn2);
		image[42].setBounds(10+170 , 10+180, 100, 120);
		
		btn[42] = new JButton(trbtn);
		btn[42].setBounds(10+170 , 10+180, 100, 120);
		btn[42].setBorderPainted(false);
		btn[42].setFocusPainted(false);
		btn[42].setContentAreaFilled(false);
		btn[42].addActionListener(this);
		//btn[23].setEnabled(false);
		
		image[65] = new JLabel(btn2);
		image[65].setBounds(10+100 , 545-100, 100, 120);
		
		btn[65] = new JButton(trbtn);
		btn[65].setBounds(10+100 , 545-100, 100, 120);
		btn[65].setBorderPainted(false);
		btn[65].setFocusPainted(false);
		btn[65].setContentAreaFilled(false);
		btn[65].addActionListener(this);
		//btn[24].setEnabled(false);
		
		image[64] = new JLabel(btn2);
		image[64].setBounds(10+170 , 545-180, 100, 120);
		
		btn[64] = new JButton(trbtn);
		btn[64].setBounds(10+170 , 545-180, 100, 120);
		btn[64].setBorderPainted(false);
		btn[64].setFocusPainted(false);
		btn[64].setContentAreaFilled(false);
		btn[64].addActionListener(this);
		//btn[25].setEnabled(false);
		
		image[45] = new JLabel(btn2);
		image[45].setBounds(535-100, 545-100, 100, 120);
		
		btn[45] = new JButton(trbtn);
		btn[45].setBounds(535-100, 545-100, 100, 120);
		btn[45].setBorderPainted(false);
		btn[45].setFocusPainted(false);
		btn[45].setContentAreaFilled(false);
		btn[45].addActionListener(this);
		//btn[26].setEnabled(false);

		image[44] = new JLabel(btn2);
		image[44].setBounds(535-170, 545-180, 100, 120);
		
		btn[44] = new JButton(trbtn);
		btn[44].setBounds(535-170, 545-180, 100, 120);
		btn[44].setBorderPainted(false);
		btn[44].setFocusPainted(false);
		btn[44].setContentAreaFilled(false);
		btn[44].addActionListener(this);
		//btn[27].setEnabled(false);
		
		image[43] = new JLabel(btn1);
		image[43].setBounds(272, 272, 100, 120);
		
		btn[43] = new JButton(trbtn);
		btn[43].setBounds(272, 272, 100, 120);
		btn[43].setBorderPainted(false);
		btn[43].setFocusPainted(false);
		btn[43].setContentAreaFilled(false);
		btn[43].addActionListener(this);
		//cen.setEnabled(false);
		
		int i;
		
		
		for(i=0; i<71; i++) {
			pan.add(btn[i]);
			ch1[i] = false;
			ch2[i] = false;
		}
		
		for(i=0; i<71; i++) {
			pan.add(image[i]);
		}
		
		for(i=0; i<2; i++) {
			P1[i] = new Malll();
			P2[i] = new Malll();
		}
		
		/*****************************************************************/
		
		playerCheckImage = "greenCircle.png";
		playerCheckPath = currentProjPath + "/" + Src + "/" + Package + "/" + playerCheckImage;
		CheckIcon = new ImageIcon(playerCheckPath);
		player1mallImage = "orangeCircle.png";
		player1mallPath = currentProjPath + "/" + Src + "/" + Package + "/" + player1mallImage;
		player1mallIcon = new ImageIcon(player1mallPath);
		player2mallImage = "purpleCircle.png";
		player2mallPath = currentProjPath + "/" + Src + "/" + Package + "/" + player2mallImage;
		player2mallIcon = new ImageIcon(player2mallPath);
		WhiteImage = "white.png";
		WhitePath = currentProjPath + "/" + Src + "/" + Package + "/" + WhiteImage;
		WhiteIcon = new ImageIcon(WhitePath);
		frontYutImage = "yut1.png";
		frontYutPath = currentProjPath + "/" + Src + "/" + Package + "/" + frontYutImage;
		frontYutIcon = new ImageIcon(frontYutPath);
		rearYutImage = "yut2.png";
		rearYutPath = currentProjPath + "/" + Src + "/" + Package + "/" + rearYutImage;
		rearYutIcon = new ImageIcon(rearYutPath);
		backDoImage = "yut3.png";
		backDoPath = currentProjPath + "/" + Src + "/" + Package + "/" + backDoImage;
		backDoIcon = new ImageIcon(backDoPath);
		
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(null);
		gamePanel.setBounds(0,0,720,720);
		add(gamePanel);
		
		//너비 280, 높이 720 , 그중에서 기본 720에서 더해서 시작하면 되겠다
		//플레이어1,2 남은말과 현재 누구턴인지 표현하는 패널
		PlayerPanel = new JPanel();
		PlayerPanel.setLayout(null);
		PlayerPanel.setBounds(720, 0, 280, 720);				
		
		//첫번째 플레이어쪽 표시 시작				
		
		JLabel IconCheck1 = new JLabel();
		IconCheck1.setBounds(0, 0, 40, 90);
		if(turn == true) {
			IconCheck1.setIcon(CheckIcon);
		}
		else {
			IconCheck1.setIcon(WhiteIcon);
		}
		
		//이거 이미지로 입힐지 아니면 폰트 활용해서 할 지 한번 말해보기		
		JLabel CheckLabel = new JLabel("Player 1");
		CheckLabel.setBounds(40, 0, 240, 90);		
		
		PlayerPanel.add(IconCheck1);
		PlayerPanel.add(CheckLabel);
		
		
		
		//첫번째 말쪽 시작		
		JLabel []mallLabel = new JLabel[4];
		
		int interval = 0;		
		for(i = 0; i< 4; i++) {
			mallLabel[i] = new JLabel();
			mallLabel[i].setBounds(0+interval, 90, 70, 90);
			PlayerPanel.add(mallLabel[i]);
			interval = interval + 70;
		}	
		
		//이거 버튼 바뀌면 바뀌도록 해야 함 그대로 ActionListener쪽에 가져가서 써도 될 듯 
//		for(i = 0; i< 4; i++) {
//			if(i <= visualizeMall(player1)){
//				mallLabel[i].setIcon(player1mallIcon);
//			}else{
//				mallLabel[i].setIcon(WhiteIcon);
//			}			
//		}		
				
		
		//두번째 플레이어 이름 표시 시작		
		
		JLabel IconCheck2 = new JLabel();
		IconCheck2.setBounds(0, 180, 40, 90);
		
		//앞의 코드와 중복되니 나중에 turn을 합칠때 구현을 잘해놓을것
		if(turn == false) {
			IconCheck2.setIcon(CheckIcon);
		}
		else {
			IconCheck2.setIcon(WhiteIcon);
		}
		
		JLabel CheckLabel2 = new JLabel("Player 2");
		CheckLabel2.setBounds(40, 180, 240, 90);
		
		PlayerPanel.add(IconCheck2);
		PlayerPanel.add(CheckLabel2);		
		
		//두번째 플레이어 말 표시 시작				
		JLabel []mallLabel2 = new JLabel[4];
		
		int secondInterval = 0;
		
		for(i = 0; i< 4; i++) {
			mallLabel2[i] = new JLabel();
			mallLabel2[i].setBounds(0+secondInterval, 270, 70, 90);
			PlayerPanel.add(mallLabel2[i]);
			secondInterval = secondInterval + 70;
		}	
		
		//이거 버튼 바뀌면 바뀌도록 해야 함 그대로 ActionListener쪽에 가져가서 써도 될 듯 
	//	for(i = 0; i< 4; i++) {
//			if(i <= visualizeMall(player2)){
//				mallLabel2[i].setIcon(player2mallIcon);
//			}else{
//				mallLabel2[i].setIcon(WhiteIcon);
//			}			
//		}		
				
		
		yutLabel1.setBounds(0, 360, 70, 270);
		yutLabel2.setBounds(70, 360, 70, 270);
		yutLabel3.setBounds(140, 360, 70, 270);
		yutLabel4.setBounds(210, 360, 70, 270);
		
		yutLabel1.setIcon(frontYutIcon);
		yutLabel2.setIcon(frontYutIcon);
		yutLabel3.setIcon(frontYutIcon);
		yutLabel4.setIcon(frontYutIcon);
				
		PlayerPanel.add(yutLabel1);				
		PlayerPanel.add(yutLabel2);				
		PlayerPanel.add(yutLabel3);				
		PlayerPanel.add(yutLabel4);		
				
		
		
		
		resLabel.setBounds(0, 630, 40, 60);
		PlayerPanel.add(resLabel);
		
		
		clickButton = new JButton("click!");
		clickButton.setBounds(40, 630, 240, 60);
		clickButton.addActionListener(this);
		PlayerPanel.add(clickButton);
		
		add(PlayerPanel);
		
		
		comp.add(pan);
		comp.add(PlayerPanel);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Scanner keyboard = new Scanner(System.in);
		String actionCommand = e.getActionCommand();
		
		String currentProjPath = "";
		
		try {
			currentProjPath = new File(".").getCanonicalPath();
		}catch (IOException E) {
			E.printStackTrace();
		}
		
		if(actionCommand.equals("click!") && throwY==false) {//윷 던져서 위치 받아오기, throwY : throw 된 상태인지 확인(true이면 click으로 윷 던지기 불가능, 이동 후 false로 변경)
			
			
			if (player1 == true) { //플레이어 1 턴이면
			//	p1rd = y.yutDun(); //p1rd : 윷 던져서 숫자 받아옴
		//		System.out.println("윷 : " + p1rd);
			//	if (p1rd == 4 || p1rd == 5) chance1 = true;
				int testnum=0;
				/*
				 * if(testnum==4||testnum==5) { chance1=true; }
				 */
				
				if(p1rd.size()>=1) {
					if(chance1) {
						testnum=yutdun();
						p1rd.add(testnum);
						System.out.println("p1윷: "+p1rd);
						if(testnum<4)
							chance1=false;
					}
				}
				else {
					testnum=yutdun();
					p1rd.add(testnum);
					System.out.println("p1윷 : " + p1rd);
				}
				
				if(testnum<=3) {
					throwY = true;
					chance1=false;
				System.out.println("P1. Which mall : ");
				mall = keyboard.nextInt(); // 말 선택
				
				if(mall == 1) {
					System.out.println("p1이동하고 싶은 칸 수 위치"+p1rd);
					num1=keyboard.nextInt();
					num1=num1-1;
					bfmv1[0] = P1[0].getLocation();
					afmv1[0] = P1[0].preview(p1rd.get(num1));
				}
				else if(mall == 2) {
					System.out.println("p1이동하고 싶은 칸 수 위치"+p1rd);
					num1=keyboard.nextInt();
					num1=num1-1;
					bfmv1[1] = P1[1].getLocation();
					afmv1[1] = P1[1].preview(p1rd.get(num1));
				}
				
				if(mall == 1 && afmv1[0]>=0) { //getlocation : 이동 전 말의 위치 받아옴
					ch1[afmv1[0]] = true;
					ch1[bfmv1[0]] = false;
					
					
					if(afmv1[0]==46 || afmv1[0]==60 || afmv1[0]==40|| afmv1[0]==15|| afmv1[0]==43) {
						image[afmv1[0]].setIcon(bgCh);
					}
					else image[afmv1[0]].setIcon(btnch);
					//위 코드는 이동 가능한 칸의 색 변화를 시행함
				}
				
				if(mall == 2 && afmv1[1]>=0) { //getlocation : 이동 전 말의 위치 받아옴
					ch1[afmv1[1]] = true;
					ch1[bfmv1[1]] = false;
					
					
					if(afmv1[1]==46 || afmv1[1]==60 || afmv1[1]==40|| afmv1[1]==15|| afmv1[1]==43) {
						image[afmv1[1]].setIcon(bgCh);
					}
					else image[afmv1[1]].setIcon(btnch);
					//위 코드는 이동 가능한 칸의 색 변화를 시행함
				}
				
				else if((mall == 1 && afmv1[0]<0) || (mall == 2 && afmv1[1]<0)){
					throwY = false;
					JOptionPane.showMessageDialog(null, "You cannot move", "", JOptionPane.INFORMATION_MESSAGE);
					p1rd.remove(num1);
					player1 = false;
					player2 = true;
					
				}
			}
			}
			
			else if (player2 == true) { //플레이어 2 턴이면
				int testnum2=0;				
				/*
				 * if(testnum2==4 || testnum2==5) { chance2 = true; }
				 */
				
				if(p2rd.size()>=1) {
					if(chance2) {
						testnum2=yutdun();
						p2rd.add(testnum2);
						System.out.println("p2윷 : " + p2rd);
						if(testnum2<4)
							chance2=false;
					}
				}
				else {
					testnum2=yutdun();
					p2rd.add(testnum2);
					System.out.println("p2윷 : " + p2rd);
				}
				
				if(testnum2<=3) {
				//		p2rd = y.yutDun(); //p1rd : 윷 던져서 숫자 받아옴
				throwY = true;
				chance2=false;
		//		System.out.println("윷 : " + p2rd);
		//		if (p2rd == 4 || p2rd == 5) chance2 = true;
				
				System.out.println("P2. Which mall : ");
				mall = keyboard.nextInt(); // 말 선택
				
				if(mall == 1) {
					System.out.println("p2이동하고 싶은 칸 수 위치"+p2rd);
					num2=keyboard.nextInt();
					num2=num2-1;
					
					bfmv2[0] = P2[0].getLocation();
					afmv2[0] = P2[0].preview(p2rd.get(num2));
				}
				else if(mall == 2) {
					System.out.println("p2이동하고 싶은 칸 수 위치"+p2rd);
					num2=keyboard.nextInt();
					num2=num2-1;
					bfmv2[1] = P2[1].getLocation();
					afmv2[1] = P2[1].preview(p2rd.get(num2));
				}
				
				if(mall == 1 && afmv2[0]>=0) { //getlocation : 이동 전 말의 위치 받아옴
					ch2[afmv2[0]] = true;
					ch2[bfmv2[0]] = false;
					
					
					if(afmv2[0]==46 || afmv2[0]==60 || afmv2[0]==40|| afmv2[0]==15|| afmv2[0]==43) {
						image[afmv2[0]].setIcon(bgCh);
					}
					else image[afmv2[0]].setIcon(btnch);
					//위 코드는 이동 가능한 칸의 색 변화를 시행함
				}
				
				if(mall == 2 && afmv2[1]>=0) { //getlocation : 이동 전 말의 위치 받아옴
					ch2[afmv2[1]] = true;
					ch2[bfmv2[1]] = false;
					
					
					if(afmv2[1]==46 || afmv2[1]==60 || afmv2[1]==40|| afmv2[1]==15|| afmv2[1]==43) {
						image[afmv2[1]].setIcon(bgCh);
					}
					else image[afmv2[1]].setIcon(btnch);
					//위 코드는 이동 가능한 칸의 색 변화를 시행함
				}
				
				else if((mall == 1 && afmv2[0]<0) || (mall == 2 && afmv2[1]<0)){
					throwY = false;
					JOptionPane.showMessageDialog(null, "You cannot move", "", JOptionPane.INFORMATION_MESSAGE);
					p2rd.remove(num2);
					player1 = true;
					player2 = false;
					
				}
			}
		
			}
			}
		
		
		for(int i = 0; i<71; i++) { //이동
			if(player1 == true) {//플레이어 1의 차례
				if(e.getSource() == btn[i] && ch1[i] == true && throwY == true) { //버튼(칸)이 눌렸음 && 칸에 말 존재 && 윷 던져진 상태
					throwY = false; //다음 턴에서 윷을 던질 수 있도록 함
					
					if(mall==1 && bfmv1[0]==0) {
						if(afmv1[0]==46 || afmv1[0]==60 || afmv1[0]==40|| afmv1[0]==15|| afmv1[0]==43) {
							image[afmv1[0]].setIcon(bgEx);
						}
						else image[afmv1[0]].setIcon(exist);
						//이동 후, 1번 말이 위치한 곳의 아이콘을 바꾸기 위함
						
						P1[0].setLocation(p1rd.get(num1)); //1번 말 이동한 위치 저장
						System.out.println("P1[0] location : " + P1[0].getLocation());
					}
					
					else if(mall==2 && bfmv1[0]==0) {
						if(afmv1[1]==46 || afmv1[1]==60 || afmv1[1]==40|| afmv1[1]==15|| afmv1[1]==43) {
							image[afmv1[1]].setIcon(bgEx);
						}
						else image[afmv1[1]].setIcon(exist);
						
						P1[1].setLocation(p1rd.get(num1));
						System.out.println("P1[1] location : " + P1[1].getLocation());
					}
					else for(int j = 0; j<2; j++) { // 업기
						loc = P1[j].getLocation() + p1rd.get(num1);
						
						if(loc == 5)	{
							System.out.println("---");
							loc=60;
							//모 나왔을때 옆으로 가는거
						}
						else if(loc==10) {
							System.out.println("---");
							loc=40;
					//		location=location+a.yutDun();
							//두번 쨰 꺽는 구간 
						}else if(loc==14&&checkNum1[j]==1) {
							System.out.println("---");
							loc=65;
					//		location=location+a.yutDun();
							//두번 쨰 꺽는 구간 
						}else if(loc==0) {
							loc=46;
						}
						
						else if(loc == 63) {
							System.out.println("---");
							loc-=20;
						//	location+=a.yutDun();
						}	//중앙에 도착했을 때 꺽기
						else if(loc>65) {
							System.out.println("---");
							loc-=51;
							checkNum1[j]=1;//온 방향대로 백도
						}else if (loc==42&&midcheck1[j]==1) {
							loc=62;
						}
						else if(loc==59) {
							System.out.println("---");
							loc = 4;//모 자리에서 백도
						}
						else if(loc==20) {
							System.out.println("---");
							loc=46;//마지막은 46으로 통일
							checkNum1[j]=1;
						}else if(loc==45&&checkNum1[j]==1) {
							System.out.println("---");
							loc=19;// 온 방향대로 백도
						}else if(loc == 39) {
							System.out.println("---");
							loc=9;
						}
						
						System.out.println("i : " + i + "P1["+j+"]위치 "+ P1[j].getLocation() +" "+ p1rd+"loc " + loc);
						if(i == loc) {
							if(loc==46 || loc==60 || loc==40|| loc==15|| loc==43) {
								image[loc].setIcon(bgEx);
							}
							else image[loc].setIcon(exist);
							//이동 후, 1번 말이 위치한 곳의 아이콘을 바꾸기 위함
							
							P1[j].setLocation(p1rd.get(num1)); //1번 말 이동한 위치 저장
							System.out.println("p1["+j+"] location : " + P1[j].getLocation());
						}
					}
					
					if(ch2[i]==true) {
						for(int j=0; j<2; j++) {
							if(i == P2[j].getLocation()) {
								midcheck2[j]=0;
								P2[j].goStart();
							}
						}
					//	p1rd.remove(num1);
						JOptionPane.showMessageDialog(null, "You catch the Player2's mal", "Catch", JOptionPane.INFORMATION_MESSAGE);
						ch2[i]=false;
						chance1 =true;
					}
					
					for(int j = 0; j<71; j++) {
						if(ch1[j] == false && ch2[j] == false) { //말이 없는 칸을 찾아서 버튼 변경
							if(j==46 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(btn1);
							}
							else image[j].setIcon(btn2);
						}
						if(ch1[j] == true && ch2[j] == false) {
							if(j==46 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(bgEx);
							}
							else image[j].setIcon(exist);
						}
						else if(ch1[j] == false && ch2[j] == true) {
							if(j==46 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(bgEx2);
							}
							else image[j].setIcon(exist2);
						}
					}
					p1rd.remove(num1);
					System.out.println(p1rd.size());
					if(0!=p1rd.size()) 
						chance1=true;
				//	else
				//		chance1=false;
					if(chance1) {
						player1 = true;
						player2 = false;
						chance1 = false;
					}
					else {
						player1 = false;
						player2 = true;
						chance1=true;
					}
				}
			}
				
			else if(player2 == true) {//플레이어 1의 차례
				if(e.getSource() == btn[i] && ch2[i] == true && throwY == true) { //버튼(칸)이 눌렸음 && 칸에 말 존재 && 윷 던져진 상태
					throwY = false; //다음 턴에서 윷을 던질 수 있도록 함
					
					if(mall==1 && bfmv2[0]==0) {
						if(afmv2[0]==46 || afmv2[0]==60 || afmv2[0]==40|| afmv2[0]==15|| afmv2[0]==43) {
							image[afmv2[0]].setIcon(bgEx2);
						}
						else image[afmv2[0]].setIcon(exist2);
						//이동 후, 1번 말이 위치한 곳의 아이콘을 바꾸기 위함
						
						P2[0].setLocation(p2rd.get(num2)); //1번 말 이동한 위치 저장
						System.out.println("P2[0] location : " + P2[0].getLocation());
					}
					else if(mall==2 && bfmv2[1]==0) {
						if(afmv2[1]==46 || afmv2[1]==60 || afmv2[1]==40|| afmv2[1]==15|| afmv2[1]==43) {
							image[afmv2[1]].setIcon(bgEx2);
						}
						else image[afmv2[1]].setIcon(exist2);
						
						P2[1].setLocation(p2rd.get(num2));
						System.out.println("P2[1] location : " + P2[1].getLocation());
					}
					else for(int j = 0; j<2; j++) { // 업기
						loc = P2[j].getLocation() + p2rd.get(num2);
						
						if(loc == 5)	{
							System.out.println("---");
							loc=60;
							//모 나왔을때 옆으로 가는거
						}
						else if(loc==10) {
							System.out.println("---");
							loc=40;
					//		location=location+a.yutDun();
							//두번 쨰 꺽는 구간 
						}else if(loc==14&&checkNum2[j]==1) {
							System.out.println("---");
							loc=65;
					//		location=location+a.yutDun();
							//두번 쨰 꺽는 구간 
						}
						
						else if(loc == 63) {
							System.out.println("---");
							loc-=20;
							midcheck2[j]=1;
						//	location+=a.yutDun();
						}	//중앙에 도착했을 때 꺽기
						else if (loc==42&&midcheck2[j]==1) {
							loc=62;
						}
						else if(loc>65) {
							System.out.println("---");
							loc-=51;
							checkNum2[j]=1;//온 방향대로 백도
						}
						else if(loc==59) {
							System.out.println("---");
							loc = 4;//모 자리에서 백도
						}else if(loc==0) {
							loc=46;
						}
						else if(loc==20) {
							System.out.println("---");
							loc=46;//마지막은 46으로 통일
							checkNum2[j]=1;
						}else if(loc==45&&checkNum2[j]==1) {
							System.out.println("---");
							loc=19;// 온 방향대로 백도
						}else if(loc == 39) {
							System.out.println("---");
							loc=9;
						}
						System.out.println("i ; " + i + "P2[j] 위치 "+  P2[j].getLocation() + "loc값: "  + loc);
						if(i == loc) {
							if(loc==46 || loc==60 || loc==40|| loc==15|| loc==43) {
								image[loc].setIcon(bgEx);
							}
							else image[loc].setIcon(exist);
							//이동 후, 1번 말이 위치한 곳의 아이콘을 바꾸기 위함
							
							P2[j].setLocation(p2rd.get(num2)); //1번 말 이동한 위치 저장
							System.out.println("P2["+j+"] location : " + P2[j].getLocation());
						}
					}
					
					if(ch1[i]==true) {
						for(int j=0; j<2; j++) {
							if(i == P1[j].getLocation()) {
								P1[j].goStart();
								midcheck1[j]=0;
								ch1[loc]=false;
							}
						}
						p2rd.remove(num2);
						JOptionPane.showMessageDialog(null, "You catch the Player1's mal", "Catch", JOptionPane.INFORMATION_MESSAGE);
						ch1[i]=false;
						chance2 =true;
					}
					
					for(int j = 0; j<71; j++) {
						if(ch1[j] == false && ch2[j] == false) { //말이 없는 칸을 찾아서 버튼 변경
							if(j==46 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(btn1);
							}
							else image[j].setIcon(btn2);
						}
						if(ch1[j] == true && ch2[j] == false) {
							if(j==46 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(bgEx);
							}
							else image[j].setIcon(exist);
						}
						else if(ch1[j] == false && ch2[j] == true) {
							if(j==46 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(bgEx2);
							}
							else image[j].setIcon(exist2);
						}
					}
					
					p2rd.remove(num2);
					System.out.println(p2rd.size());
					if(0!=p2rd.size()) 
						chance2=true;
				//	else
				//		chance2=false;
					if(chance2) {
						player2 = true;
						player1 = false;
						chance2 = false;
					}
					else {
						player2 = false;
						player1 = true;
						chance2=true;
					}
				}
			}
		}
	}	
	
	public int yutdun() {
		int res = 0;
		//먼저 새창 띄워서 윷던지는 움짤 보여준다.
		//그 후 윷던 실행
		int temp;
		
		temp = yourYut.yutDun();			
		for(int i = 0; i< 3; i++) {
			res += yourYut.getYut(i);
		}
		if(res == 3 && yourYut.getYut(3) == 0) {
			resText = "걸";
			resLabel.setText(resText);
			if(yourYut.getYut(0) == 0) {			
				yutLabel1.setIcon(frontYutIcon);
			}
			else {
				yutLabel1.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(1) == 0) {			
				yutLabel2.setIcon(frontYutIcon);
			}
			else {
				yutLabel2.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(2) == 0) {			
				yutLabel3.setIcon(frontYutIcon);
			}
			else {
				yutLabel3.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(3) == 0) {			
				yutLabel4.setIcon(frontYutIcon);					
			}
			else {
				yutLabel4.setIcon(backDoIcon);				
			}
		}
		else if(res == 3 && yourYut.getYut(3) == 1) {
			resText = "윷";
			resLabel.setText(resText);
			if(yourYut.getYut(0) == 0) {			
				yutLabel1.setIcon(frontYutIcon);
			}
			else {
				yutLabel1.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(1) == 0) {			
				yutLabel2.setIcon(frontYutIcon);
			}
			else {
				yutLabel2.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(2) == 0) {			
				yutLabel3.setIcon(frontYutIcon);
			}
			else {
				yutLabel3.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(3) == 0) {			
				yutLabel4.setIcon(frontYutIcon);
			}
			else {					
				yutLabel4.setIcon(backDoIcon);
			}
		}
		else if(res == 2 && yourYut.getYut(3) == 1) {
			resText = "걸";
			resLabel.setText(resText);
			if(yourYut.getYut(0) == 0) {			
				yutLabel1.setIcon(frontYutIcon);
			}
			else {
				yutLabel1.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(1) == 0) {			
				yutLabel2.setIcon(frontYutIcon);
			}
			else {
				yutLabel2.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(2) == 0) {			
				yutLabel3.setIcon(frontYutIcon);
			}
			else {
				yutLabel3.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(3) == 0) {			
				yutLabel4.setIcon(frontYutIcon);
			}
			else {
				yutLabel4.setIcon(backDoIcon);				
			}
		}
		else if(res == 1 && yourYut.getYut(3) == 1) {
			resText = "개";
			resLabel.setText(resText);
			if(yourYut.getYut(0) == 0) {			
				yutLabel1.setIcon(frontYutIcon);
			}
			else {
				yutLabel1.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(1) == 0) {			
				yutLabel2.setIcon(frontYutIcon);
			}
			else {
				yutLabel2.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(2) == 0) {			
				yutLabel3.setIcon(frontYutIcon);
			}
			else {
				yutLabel3.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(3) == 0) {			
				yutLabel4.setIcon(frontYutIcon);
			}
			else {
				yutLabel4.setIcon(backDoIcon);				
			}
		}
		else if(res == 0 && yourYut.getYut(3) == 1) {
			resText = "빽도";
			resLabel.setText(resText);
			if(yourYut.getYut(0) == 0) {			
				yutLabel1.setIcon(frontYutIcon);
			}
			else {
				yutLabel1.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(1) == 0) {			
				yutLabel2.setIcon(frontYutIcon);
			}
			else {
				yutLabel2.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(2) == 0) {			
				yutLabel3.setIcon(frontYutIcon);
			}
			else {
				yutLabel3.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(3) == 0) {			
				yutLabel4.setIcon(frontYutIcon);
			}
			else {
				yutLabel4.setIcon(backDoIcon);				
			}
		}			
		else if(res == 2 && yourYut.getYut(3) == 0) {
			resText = "개";
			resLabel.setText(resText);
			if(yourYut.getYut(0) == 0) {			
				yutLabel1.setIcon(frontYutIcon);
			}
			else {
				yutLabel1.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(1) == 0) {			
				yutLabel2.setIcon(frontYutIcon);
			}
			else {
				yutLabel2.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(2) == 0) {			
				yutLabel3.setIcon(frontYutIcon);
			}
			else {
				yutLabel3.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(3) == 0) {			
				yutLabel4.setIcon(frontYutIcon);
			}
			else {
				yutLabel4.setIcon(backDoIcon);				
			}
		}
		else if(res == 1 && yourYut.getYut(3) == 0) {
			resText = "도";
			resLabel.setText(resText);
			if(yourYut.getYut(0) == 0) {			
				yutLabel1.setIcon(frontYutIcon);
			}
			else {
				yutLabel1.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(1) == 0) {			
				yutLabel2.setIcon(frontYutIcon);
			}
			else {
				yutLabel2.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(2) == 0) {			
				yutLabel3.setIcon(frontYutIcon);
			}
			else {
				yutLabel3.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(3) == 0) {			
				yutLabel4.setIcon(frontYutIcon);
			}
			else {
				yutLabel4.setIcon(backDoIcon);				
			}
		}
		else if(res == 0 && yourYut.getYut(3) == 0) {
			resText = "모";
			resLabel.setText(resText);
			if(yourYut.getYut(0) == 0) {			
				yutLabel1.setIcon(frontYutIcon);
			}
			else {
				yutLabel1.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(1) == 0) {			
				yutLabel2.setIcon(frontYutIcon);
			}
			else {
				yutLabel2.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(2) == 0) {			
				yutLabel3.setIcon(frontYutIcon);
			}
			else {
				yutLabel3.setIcon(rearYutIcon);				
			}
			if(yourYut.getYut(3) == 0) {			
				yutLabel4.setIcon(frontYutIcon);
			}
			else {
				yutLabel4.setIcon(backDoIcon);				
			}
		}
		else {
			System.out.print("not correct yutDun");
		}
		revalidate();
		repaint();
		return temp;
	}
}

