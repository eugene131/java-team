package teamproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fileinput extends JFrame implements ActionListener{
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	private int page;
	JFrame comp = new JFrame();
	JPanel notice = new JPanel();
	JTextField input;
	private boolean check = false;
	
	public Fileinput() {
		comp.setSize(WIDTH,HEIGHT);
		comp.setBackground(Color.WHITE);
		comp.setLayout(new FlowLayout());
		comp.setTitle("불러오기");
		
		notice.setLayout(new GridLayout(5,1));
		
		JLabel label = new JLabel("이름을 입력하세요.");
		
		input = new JTextField(20);
		
		JButton submit = new JButton("확인");
		submit.addActionListener(this);
		submit.setBackground(Color.white);
		
		notice.add(new JLabel());
		notice.add(label);
		notice.add(input);
		notice.add(submit);
		
		comp.add(notice);

	}
	
	public static void main(String[] args) {
		Fileinput panGui = new Fileinput();
		panGui.comp.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals("확인")) {
			fileInput();
			if(check) {
				comp.dispose();
			}
		}
		
	}
	
	public void fileInput() {
		Scanner keyboard = new Scanner(System.in);
		Scanner inputStream = null;
		String line = null;
		String fileName = null;
		//PrintWriter outputStream = null;
		
		String currentProjPath = "";
		try {
			currentProjPath = new File(".").getCanonicalPath();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		fileName = input.getText() + ".txt";
		
		File fileObj = null;
		
		boolean cnt = true;
		
			fileObj = new File(currentProjPath+ "/src/teamproject/" +fileName);
			if(fileObj.exists()) {
				try {
					inputStream = new Scanner(new FileInputStream(currentProjPath + "/src/teamproject/" + fileName));
					cnt = false;
					check = true;
					
					//내용 넣기
					
				}catch(FileNotFoundException e) {
					e.printStackTrace();
					System.exit(0);
				}catch(IOException e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "파일이 존재하지 않습니다. 다른 이름을 입력해 주세요.", "Notice", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}