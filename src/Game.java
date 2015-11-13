import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game implements ActionListener {
	static Scanner scanner = new Scanner(System.in);
	static int playfieldx = 800;
	static int playfieldy = 600;
//	static int mousexLastClick = 0;
//	static int mouseyLastClick = 0;
	static BoardPanel boardPanel;
	static MenuPanel menuPanel;
	static GamePanel game1panel; //dit is een panel, naam moet nog veranderen
	static int cadeautjesTotaalGebracht = 0;
	private JPanel containerPanel = new JPanel();
	private CardLayout cardLayout = new CardLayout();

	JFrame frame;
	JButton level1;
	JButton level2;
//	JButton level1;
//	JButton level2;
	JButton level3;
	JButton level4;
	JButton level5;
	JButton level6;
	JButton level7;
	JButton level8;
	JButton level9;
	JButton level10;
	JButton level11;
	JButton level12;
	JButton level13;
	JButton level14;
	JButton level15;
	JButton level16;
	Grid grid;
	Paard paard;
	
	public static void main(String[] args){	
		Game g = new Game();
		g.Menu();
	}
	
	public void Menu(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(playfieldx,playfieldy);
		menuPanel = new MenuPanel();	
		frame.add(containerPanel);
		containerPanel.setLayout(cardLayout);
		containerPanel.add(menuPanel, "1");	
		cardLayout.show(containerPanel, "1");
		
		level1 = maakButton(level1, "1");
		level2 = maakButton(level2, "2");
		level3 = maakButton(level3, "3");
		level4 = maakButton(level4, "4");
		level5 = maakButton(level5, "5");
		level6 = maakButton(level6, "6");
		level7 = maakButton(level7, "7");
		level8 = maakButton(level8, "8");
		level9 = maakButton(level9, "9");
		level10 = maakButton(level10, "10");
		level11 = maakButton(level11, "11");
		level12 = maakButton(level12, "12");
		level13 = maakButton(level13, "13");
		level14 = maakButton(level14, "14");
		level15 = maakButton(level15, "15");
		level16 = maakButton(level16, "16");
		menuPanel.setLayout(new GridLayout(4, 4, 20, 20));
		menuPanel.add(level1);
		menuPanel.add(level2);
		menuPanel.add(level3);
		menuPanel.add(level4, BorderLayout.CENTER);
		menuPanel.add(level5, BorderLayout.CENTER);
		menuPanel.add(level6, BorderLayout.CENTER);
		menuPanel.add(level7, BorderLayout.CENTER);
		menuPanel.add(level8, BorderLayout.CENTER);
		menuPanel.add(level9, BorderLayout.CENTER);
		menuPanel.add(level10, BorderLayout.CENTER);
		menuPanel.add(level11, BorderLayout.CENTER);
		menuPanel.add(level12, BorderLayout.CENTER);
		menuPanel.add(level13, BorderLayout.CENTER);
		menuPanel.add(level14, BorderLayout.CENTER);
		menuPanel.add(level15, BorderLayout.CENTER);
		menuPanel.add(level16);
		frame.setVisible(true);	
	}
	public JButton maakButton(JButton a, String i){
		a = new JButton(i);
		a.setActionCommand(i);
		//a.setSize(100, 40);
		a.setPreferredSize(new Dimension(100, 40));
		a.addActionListener(this);	
		return a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO JANJAAP
		//SinterKlaasGame();
		 if ("1".equals(e.getActionCommand())) {
			game1panel = new GamePanel(1);
		 } else if ("2".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(2);
		 } else if ("3".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(3);
		 } else if ("4".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(4);
		 } else if ("5".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(5);
		 }else if ("6".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(6);
		 }else if ("7".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(7);
		 }else if ("8".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(8);
		 }else if ("9".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(9);
		 }else if ("10".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(10);
		 }else if ("11".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(11);
		 }else if ("12".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(12);
		 }else if ("13".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(13);
		 }else if ("14".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(14);
		 }else if ("15".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(15);
		 }else if ("16".equals(e.getActionCommand())) {
			 game1panel = new GamePanel(16);
		 }
			containerPanel.add(game1panel, "2");
			cardLayout.show(containerPanel, "2");
		//boardPanel.requestFocus();
		//frame.remove(menuPanel);
		//frame.remove(start);
	}

}
