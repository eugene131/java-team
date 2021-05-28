package teamproject;
/***1. 말 이동시 작은 칸인데 큰 칸으로 표시되는 문제 수정 필요
 * 2. 턴 넘어갈 때 두 번 던지는 경우 존재
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
	
	JPanel choose1Panel = new JPanel();
	JPanel choose2Panel = new JPanel();
	
	
	
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
	
	boolean []redVisible = new boolean[5];
	boolean []yellowVisible = new boolean[5];
	
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
	
	ImageIcon R1exist;
	ImageIcon R2exist;
	ImageIcon R3exist;
	ImageIcon R4exist;
	
	ImageIcon Y1exist;
	ImageIcon Y2exist;
	ImageIcon Y3exist;
	ImageIcon Y4exist;
	
	ImageIcon R1bgexist;
	ImageIcon R2bgexist;
	ImageIcon R3bgexist;
	ImageIcon R4bgexist;
	
	ImageIcon Y1bgexist;
	ImageIcon Y2bgexist;
	ImageIcon Y3bgexist;
	ImageIcon Y4bgexist;
	
	Malll[] P1 = new Malll[2];
	Malll[] P2 = new Malll[2];
	
	JButton redmall1Button;
	JButton redmall2Button;
	JButton redmall3Button;
	JButton redmall4Button;
	
	JButton yellowMall1Button;
	JButton yellowMall2Button;
	JButton yellowMall3Button;
	JButton yellowMall4Button;
	
	boolean player1 = true;
	boolean player2 = false;
	
	boolean chance1 = false;
	boolean chance2 = false;
	
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
		
		String r1exist = "existr1.png";
		String r2exist = "existr2.png";
		String r3exist = "existr3.png";
		String r4exist = "existr4.png";
		
		String y1exist = "existy1.png";
		String y2exist = "existy2.png";
		String y3exist = "existy3.png";
		String y4exist = "existy4.png";
		
		String r1bgexist = "bigexistr1.png";
		String r2bgexist = "bigexistr2.png";
		String r3bgexist = "bigexistr3.png";
		String r4bgexist = "bigexistr4.png";
		
		String y1bgexist = "bigexisty1.png";
		String y2bgexist = "bigexisty2.png";
		String y3bgexist = "bigexisty3.png";
		String y4bgexist = "bigexisty4.png";
		
		btn1 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+button1);
		btn2 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+button2);
		btnch = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+btonCh);
		trbtn = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+button);
		exist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+exbutton);
		bgCh = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+bigCh);
		bgEx = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+bigEx);
		exist2 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+exbutton2);
		bgEx2 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+bigEx2);
		
		R1exist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+r1exist);
		R2exist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+r2exist);
		R3exist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+r3exist);
		R4exist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+r4exist);
		
		Y1exist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+y1exist);
		Y2exist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+y2exist);
		Y3exist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+y3exist);
		Y4exist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+y4exist);
		
		R1bgexist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+r1bgexist);
		R2bgexist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+r2bgexist);
		R3bgexist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+r3bgexist);
		R4bgexist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+r4bgexist);
		
		Y1bgexist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+y1bgexist);
		Y2bgexist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+y2bgexist);
		Y3bgexist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+y3bgexist);
		Y4bgexist = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+y4bgexist);
		
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
		
		image[0] = new JLabel(btn1);
		image[0].setBounds(535, 545, 100, 120);
			
		btn[0] = new JButton(trbtn);
		btn[0].setBounds(535, 545, 100, 120);
		btn[0].setBorderPainted(false);
		btn[0].setFocusPainted(false);
		btn[0].setContentAreaFilled(false);
		btn[0].addActionListener(this);
		
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
			btn[i].setEnabled(false);
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
		
		
		
		
		//------------------------------------------------------------------------------
		//chooseMall 말 선택하는 부분으로 평소에는 unvisible 해놨다가 click을 눌렀을 때 visible하게 바꾼다.
		//chooseMall인데 Player1일때 choose를 하는 것으로 프로그램을 짜보자	
		
		
		String redmallbutton1 = "red1.png";
		String redmallbutton2 = "red2.png";
		String redmallbutton3 = "red3.png";
		String redmallbutton4 = "red4.png";
		
		ImageIcon redmall1 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+redmallbutton1);
		ImageIcon redmall2 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+redmallbutton2);
		ImageIcon redmall3 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+redmallbutton3);
		ImageIcon redmall4 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+"/"+redmallbutton4);
		
		
		//choose1Panel.setVisible(false);
		choose1Panel.setLayout(null);
		choose1Panel.setBounds(160, 310, 400, 100);
		choose1Panel.setBackground(Color.white);
		
		redmall1Button = new JButton();
		redmall1Button.setBounds(0,10,100,100);
		redmall1Button.setBorderPainted(false);
		redmall1Button.setFocusPainted(false);
		redmall1Button.setContentAreaFilled(false);		
		redmall1Button.addActionListener(this);
		redmall1Button.setIcon(redmall1);
		
		redmall2Button = new JButton("2");
		redmall2Button.setBounds(100,10,100,100);
		redmall2Button.setBorderPainted(false);
		redmall2Button.setFocusPainted(false);
		redmall2Button.setContentAreaFilled(false);		
		redmall2Button.addActionListener(this);		
		redmall2Button.setIcon(redmall2);
		
		
		
		redmall3Button = new JButton();
		redmall3Button.setBounds(200,10,100,100);
		redmall3Button.setBorderPainted(false);
		redmall3Button.setFocusPainted(false);
		redmall3Button.setContentAreaFilled(false);		
		redmall3Button.addActionListener(this);		
		redmall3Button.setIcon(redmall3);
		
		
		redmall4Button = new JButton();
		redmall4Button.setBounds(300,10,100,100);
		redmall4Button.setBorderPainted(false);
		redmall4Button.setFocusPainted(false);
		redmall4Button.setContentAreaFilled(false);		
		redmall4Button.addActionListener(this);		
		redmall4Button.setIcon(redmall4);	
		
		
		choose1Panel.add(redmall1Button);		
		choose1Panel.add(redmall2Button);		
		choose1Panel.add(redmall3Button);		
		choose1Panel.add(redmall4Button);
		choose1Panel.setVisible(false);
		
		
		
		//chooseMall 말 선택하는 부분으로 평소에는 unvisible 해놨다가 click을 눌렀을 때 visible하게 바꾼다.
		//chooseMall인데 Player2일때 choose를 하는 것으로 프로그램을 짜보자
				
			
				
		String yellowmallbutton1 = "yellow1.png";
		String yellowmallbutton2 = "yellow2.png";
		String yellowmallbutton3 = "yellow3.png";
		String yellowmallbutton4 = "yellow4.png";
			
		ImageIcon yellowmall1 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+ "/" + yellowmallbutton1);
		ImageIcon yellowmall2 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+ "/" + yellowmallbutton2);
		ImageIcon yellowmall3 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+ "/" + yellowmallbutton3);
		ImageIcon yellowmall4 = new ImageIcon(currentProjPath+"/"+srcPath+"/"+packageName+ "/" + yellowmallbutton4);
				
			
		choose2Panel.setVisible(false);
		choose2Panel.setLayout(null);
		choose2Panel.setBounds(160, 310, 400, 100);
				
		yellowMall1Button = new JButton();
		yellowMall1Button.setBounds(0,10,100,100);
		yellowMall1Button.setBorderPainted(false);
		yellowMall1Button.setFocusPainted(false);
		yellowMall1Button.setContentAreaFilled(false);		
		yellowMall1Button.addActionListener(this);
		yellowMall1Button.setIcon(yellowmall1);
			
		yellowMall2Button = new JButton();
		yellowMall2Button.setBounds(100,10,100,100);
		yellowMall2Button.setBorderPainted(false);
		yellowMall2Button.setFocusPainted(false);
		yellowMall2Button.setContentAreaFilled(false);		
		yellowMall2Button.addActionListener(this);			
		yellowMall2Button.setIcon(yellowmall2);
				
			
		yellowMall3Button = new JButton();
		yellowMall3Button.setBounds(200,10,100,100);
		yellowMall3Button.setBorderPainted(false);
		yellowMall3Button.setFocusPainted(false);
		yellowMall3Button.setContentAreaFilled(false);		
		yellowMall3Button.addActionListener(this);				
		yellowMall3Button.setIcon(yellowmall3);
				
				
		yellowMall4Button = new JButton();
		yellowMall4Button.setBounds(300,10,100,100);
		yellowMall4Button.setBorderPainted(false);
		yellowMall4Button.setFocusPainted(false);
		yellowMall4Button.setContentAreaFilled(false);		
		yellowMall4Button.addActionListener(this);				
		yellowMall4Button.setIcon(yellowmall4);
				
				
		choose2Panel.add(yellowMall1Button);		
		choose2Panel.add(yellowMall2Button);		
		choose2Panel.add(yellowMall3Button);		
		choose2Panel.add(yellowMall4Button);
				
			
				
		
		
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
		
		comp.add(choose2Panel);
		comp.add(choose1Panel);
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
		/***********************************************************************************/
		if(actionCommand.equals("click!") && throwY == false) {
			System.out.println("click");
			if(player1 == true) {
				System.out.println("p1");
				int testnum = 0;
				
				testnum = yutdun();
				p1rd.add(testnum);
				System.out.println("p1윷: " + p1rd);
				
				if (testnum == 4 || testnum == 5) {
					throwY = false;
				}
				
				else {
					throwY = true;
					choose1Panel.setVisible(true);
					for(int i=0; i<71; i++) {
						btn[i].setEnabled(false);
					}
				}
			}
			
			if(player2 == true) {
				System.out.println("p2");
				int testnum = 0;
				
				testnum = yutdun();
				p2rd.add(testnum);
				System.out.println("p2윷: " + p2rd);
				
				if (testnum == 4 || testnum == 5) {
					throwY = false;
				}
				
				else {
					throwY = true;
					choose2Panel.setVisible(true);
					for(int i=0; i<71; i++) {
						btn[i].setEnabled(false);
					}
				} 
			}
		}
		/***********************************************************************************/
		
		if(e.getSource() == redmall1Button && throwY == true) { //p1의 1번이면, 이동 가능한 칸의 색 바꾸기
			choose1Panel.setVisible(false);
			for(int i=0; i<71; i++) {
				btn[i].setEnabled(true);
			}
			mall = 1;
			System.out.println("p1이동하고 싶은 칸 수 위치"+p1rd);
			num1=keyboard.nextInt();
			num1=num1-1;
			bfmv1[0] = P1[0].getLocation();
			afmv1[0] = P1[0].preview(p1rd.get(num1));
			
			if(afmv1[0]>=0) { //getlocation : 이동 전 말의 위치 받아옴
				ch1[afmv1[0]] = true;
				ch1[bfmv1[0]] = false;
				
				if(afmv1[0]==0 || afmv1[0]==60 || afmv1[0]==40|| afmv1[0]==15|| afmv1[0]==43) {
					image[afmv1[0]].setIcon(bgCh);
				}
				else image[afmv1[0]].setIcon(btnch);
				//위 코드는 이동 가능한 칸의 색 변화를 시행함
			}
			
			else if(afmv1[0]<0) {
				throwY = false;
				JOptionPane.showMessageDialog(null, "You cannot move", "", JOptionPane.INFORMATION_MESSAGE);
				p1rd.remove(num1);
				player1 = false;
				player2 = true;	
			}		//위 코드는 이동 가능한 칸의 색 변화를 시행함
		}
		
		/***************/
		
		if(e.getSource() == redmall2Button && throwY == true) { //p1의 2번이면
			//패널 setvisible(false)
			choose1Panel.setVisible(false);
			for(int i=0; i<71; i++) {
				btn[i].setEnabled(true);
			}
			//버튼 전부 enable
			
			mall = 2;
			System.out.println("p1이동하고 싶은 칸 수 위치"+p1rd);
			num1=keyboard.nextInt();
			num1=num1-1;
			bfmv1[1] = P1[1].getLocation();
			afmv1[1] = P1[1].preview(p1rd.get(num1));
			
			if(afmv1[1]>=0) { //getlocation : 이동 전 말의 위치 받아옴
				ch1[afmv1[1]] = true;
				ch1[bfmv1[1]] = false;
				
				if(afmv1[1]==0 || afmv1[1]==60 || afmv1[1]==40|| afmv1[1]==15|| afmv1[1]==43) {
					image[afmv1[1]].setIcon(bgCh);
				}
				else image[afmv1[1]].setIcon(btnch);
				//위 코드는 이동 가능한 칸의 색 변화를 시행함
			}
			
			else if(afmv1[1]<0) {
				throwY = false;
				JOptionPane.showMessageDialog(null, "You cannot move", "", JOptionPane.INFORMATION_MESSAGE);
				p1rd.remove(num1);
				player1 = true;
				player2 = false;	
			}		//위 코드는 이동 가능한 칸의 색 변화를 시행함
		}
		
		if(e.getSource() == yellowMall1Button && throwY == true) { //p1의 1번이면, 이동 가능한 칸의 색 바꾸기
			choose2Panel.setVisible(false);
			for(int i=0; i<71; i++) {
				btn[i].setEnabled(true);
			}
			mall = 1;
			System.out.println("p2이동하고 싶은 칸 수 위치"+p2rd);
			num2=keyboard.nextInt();
			num2=num2-1;
			bfmv2[0] = P2[0].getLocation();
			afmv2[0] = P2[0].preview(p2rd.get(num2));
			
			if(afmv2[0]>=0) { //getlocation : 이동 전 말의 위치 받아옴
				ch2[afmv2[0]] = true;
				ch2[bfmv2[0]] = false;
				
				if(afmv2[0]==0 || afmv2[0]==60 || afmv2[0]==40|| afmv2[0]==15|| afmv2[0]==43) {
					image[afmv2[0]].setIcon(bgCh);
				}
				else image[afmv2[0]].setIcon(btnch);
				//위 코드는 이동 가능한 칸의 색 변화를 시행함
			}
			
			else if(afmv2[0]<0) {
				throwY = false;
				JOptionPane.showMessageDialog(null, "You cannot move", "", JOptionPane.INFORMATION_MESSAGE);
				p2rd.remove(num2);
				player2 = false;
				player1 = true;	
			}		//위 코드는 이동 가능한 칸의 색 변화를 시행함
		}
		
		/***************/
		
		if(e.getSource() == yellowMall2Button && throwY == true) { //p1의 2번이면
			//패널 setvisible(false)
			choose2Panel.setVisible(false);
			for(int i=0; i<71; i++) {
				btn[i].setEnabled(true);
			}
			//버튼 전부 enable
			
			mall = 2;
			System.out.println("p2이동하고 싶은 칸 수 위치"+p2rd);
			num2=keyboard.nextInt();
			num2=num2-1;
			bfmv2[1] = P2[1].getLocation();
			afmv2[1] = P2[1].preview(p2rd.get(num1));
			
			if(afmv2[1]>=0) { //getlocation : 이동 전 말의 위치 받아옴
				ch2[afmv2[1]] = true;
				ch2[bfmv2[1]] = false;
				
				if(afmv2[1]==0 || afmv2[1]==60 || afmv2[1]==40|| afmv2[1]==15|| afmv2[1]==43) {
					image[afmv2[1]].setIcon(bgCh);
				}
				else image[afmv2[1]].setIcon(btnch);
				//위 코드는 이동 가능한 칸의 색 변화를 시행함
			}
			
			else if(afmv2[1]<0) {
				throwY = false;
				JOptionPane.showMessageDialog(null, "You cannot move", "", JOptionPane.INFORMATION_MESSAGE);
				p2rd.remove(num2);
				player2 = false;
				player1 = true;	
			}		//위 코드는 이동 가능한 칸의 색 변화를 시행함
		}
		
		
		/***********************************************************************************/
		
		for(int i = 0; i<71; i++) { //이동
			if(player1 == true) {//플레이어 1의 차례
				if(e.getSource() == btn[i] && ch1[i] == true && throwY == true) { //버튼(칸)이 눌렸음 && 칸에 말 존재 && 윷 던져진 상태
					 //다음 턴에서 윷을 던질 수 있도록 함
					
					if(mall==1 && bfmv1[0]==0) {
						if(afmv1[0]==0 || afmv1[0]==60 || afmv1[0]==40|| afmv1[0]==15|| afmv1[0]==43) {
							image[afmv1[0]].setIcon(R1bgexist);
						}
						else image[afmv1[0]].setIcon(R1exist);
						//이동 후, 1번 말이 위치한 곳의 아이콘을 바꾸기 위함
						
						P1[0].setLocation(p1rd.get(num1)); //1번 말 이동한 위치 저장
						System.out.println("location : " + P1[0].getLocation());
					}
					
					else if(mall==2 && bfmv1[0]==0) {
						if(afmv1[1]==0 || afmv1[1]==60 || afmv1[1]==40|| afmv1[1]==15|| afmv1[1]==43) {
							image[afmv1[1]].setIcon(R2bgexist);
						}
						else image[afmv1[1]].setIcon(R2exist);
						
						P1[1].setLocation(p1rd.get(num1));
						System.out.println("location : " + P1[1].getLocation());
					}
					else for(int j = 0; j<2; j++) { // 업기
						loc = P1[j].getLocation() + p1rd.get(num1);
						
						if(loc==5) loc = 60;
						else if(loc==10) loc = 40;
						else if(loc==63) loc = 43;
						else if(loc>=66) loc -= 51;
						
						System.out.println("i ; " + i + "  P1[j].getLocation() + p1rd ; " + loc);
						if(i == loc) {
							if(loc==0 || loc==60 || loc==40|| loc==15|| loc==43) {
								if(j==0) image[loc].setIcon(R1bgexist);
								else if(j==1) image[loc].setIcon(R2bgexist);
							}
							else {
								if(j==0) image[loc].setIcon(R1exist);
								else if(j==1) image[loc].setIcon(R2bgexist);
							}
							//이동 후, 1번 말이 위치한 곳의 아이콘을 바꾸기 위함
							
							P1[j].setLocation(p1rd.get(num1)); //1번 말 이동한 위치 저장
							System.out.println("location : " + P1[j].getLocation());
						}
					}
					
					if(ch2[i]==true) {
						for(int j=0; j<2; j++) {
							if(i == P2[j].getLocation()) {
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
							if(j==0 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(btn1);
							}
							else image[j].setIcon(btn2);
						}
						/*if(ch1[j] == true && ch2[j] == false) {
							if(j==0 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(bgEx);
							}
							else image[j].setIcon(exist);
						}
						else if(ch1[j] == false && ch2[j] == true) {
							if(j==0 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(bgEx2);
							}
							else image[j].setIcon(exist2);
						}*/
					}
					p1rd.remove(num1);
					System.out.println(p1rd.size());
					System.out.println(p1rd.size());
					if(0!=p1rd.size()) {
						//p1패널 setvisible
						choose1Panel.setVisible(true);
						for(int k=0; k<71; k++) {
							btn[k].setEnabled(false);
						}
						//continue;
					}
						//chance1=true;
				//	else
				//		chance1=false;
					else{
						throwY = false;
					
						if(chance1) {
							player1 = true;
							player2 = false;
							chance1 = false;
						}
						else {
							player1 = false;
							player2 = true;
							chance1 = true;
						}
					}
				}
			}
				
			else if(player2 == true) {//플레이어 1의 차례
				if(e.getSource() == btn[i] && ch2[i] == true && throwY == true) { //버튼(칸)이 눌렸음 && 칸에 말 존재 && 윷 던져진 상태
					//throwY = false; //다음 턴에서 윷을 던질 수 있도록 함
					
					if(mall==1 && bfmv2[0]==0) {
						if(afmv2[0]==0 || afmv2[0]==60 || afmv2[0]==40|| afmv2[0]==15|| afmv2[0]==43) {
							image[afmv2[0]].setIcon(Y1bgexist);
						}
						else image[afmv2[0]].setIcon(Y1exist);
						//이동 후, 1번 말이 위치한 곳의 아이콘을 바꾸기 위함
						
						P2[0].setLocation(p2rd.get(num2)); //1번 말 이동한 위치 저장
						System.out.println("location : " + P2[0].getLocation());
					}
					else if(mall==2 && bfmv2[1]==0) {
						if(afmv2[1]==0 || afmv2[1]==60 || afmv2[1]==40|| afmv2[1]==15|| afmv2[1]==43) {
							image[afmv2[1]].setIcon(Y2bgexist);
						}
						else image[afmv2[1]].setIcon(Y2exist);
						
						P2[1].setLocation(p2rd.get(num2));
						System.out.println("location : " + P2[1].getLocation());
					}
					else for(int j = 0; j<2; j++) { // 업기
						loc = P2[j].getLocation() + p2rd.get(num2);
						
						if(loc==5) loc = 60;
						else if(loc==10) loc = 40;
						else if(loc==63) loc = 43;
						else if(loc>=66) loc -= 51;
						
						System.out.println("i ; " + i + "  P2[j].getLocation() + p2rd ; " + loc);
						if(i == loc) {
							if(loc==0 || loc==60 || loc==40|| loc==15|| loc==43) {
								if(j==0) {
									image[loc].setIcon(Y1bgexist);
								}
								else if(j==1) image[loc].setIcon(Y2bgexist);
							}
							else{
								if(j==0) image[loc].setIcon(Y1exist);
								else if(j==1) image[loc].setIcon(Y2exist);
							}
							//이동 후, 1번 말이 위치한 곳의 아이콘을 바꾸기 위함
							
							P2[j].setLocation(p2rd.get(num2)); //1번 말 이동한 위치 저장
							System.out.println("location : " + P2[j].getLocation());
						}
					}
					
					if(ch1[i]==true) {
						for(int j=0; j<2; j++) {
							if(i == P1[j].getLocation()) {
								P1[j].goStart();
							}
						}
						//p2rd.remove(num2);
						JOptionPane.showMessageDialog(null, "You catch the Player1's mal", "Catch", JOptionPane.INFORMATION_MESSAGE);
						ch1[i]=false;
						chance2 =true;
					}
					
					for(int j = 0; j<71; j++) {
						if(ch1[j] == false && ch2[j] == false) { //말이 없는 칸을 찾아서 버튼 변경
							if(j==0 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(btn1);
							}
							else image[j].setIcon(btn2);
						}
						/*if(ch1[j] == true && ch2[j] == false) {
							if(j==0 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(bgEx);
							}
							else image[j].setIcon(exist);
						}
						else if(ch1[j] == false && ch2[j] == true) {
							if(j==0 || j==60 || j== 40 || j==15 || j==43 ) {
								image[j].setIcon(bgEx2);
							}
							else image[j].setIcon(exist2);
						}*/
					}
					p2rd.remove(num2);
					System.out.println(p2rd.size());
					if(0!=p2rd.size()) {
						// 패널 set visible
						//continue;
						choose2Panel.setVisible(true);
						for(int k=0; k<71; k++) {
							btn[k].setEnabled(false);
						}
					}
					else{
						throwY = false;
					
						//chance2=true;
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
							chance2 = true;
						}
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

