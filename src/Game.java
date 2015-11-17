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
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game implements ActionListener {
	Player speler1 = new Player();
	static Scanner scanner = new Scanner(System.in);
	static int playfieldx = 800;
	static int playfieldy = 600;
	static BoardPanel boardPanel;
	static MenuPanel menuPanel;
	static LevelSelectPanel endScreenPanel;
	static LevelSelectPanel levelSelectPanel;
	JPanel blablabla = new JPanel();
	static GamePanel game1panel; //dit is een panel, naam moet nog veranderen
	static int cadeautjesTotaalGebracht = 0;
	private static JPanel containerPanel;
	private static CardLayout cardLayout = new CardLayout();
	JFrame frame;
	JFrame menuFrame;
	JLabel titelGameLabel;
	static ButtonPanel level1;
	static ButtonPanel level2;
	static ButtonPanel level3;
	static ButtonPanel level4;
	static ButtonPanel level5;
	static ButtonPanel level6;
	static ButtonPanel level7;
	static ButtonPanel level8;
	static ButtonPanel level9;
	static ButtonPanel level10;
	static ButtonPanel level11;
	static ButtonPanel level12;
	static ButtonPanel level13;
	static ButtonPanel level14;
	static ButtonPanel level15;
	static ButtonPanel level16;
	static ButtonPanel test1;
	JButton backToMainMenu = new JButton("BAJKCK!");
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
		
		menuFrame = new JFrame();
		menuFrame.setLayout(new BorderLayout());
		
		containerPanel = new JPanel();
		
		frame.add(containerPanel);
		containerPanel.setLayout(cardLayout);
		
		menuPanel = new MenuPanel();	
		titelGameLabel = new JLabel("SINTERKLAAS en zijn PFERDE!");
		
		levelSelectPanel = new LevelSelectPanel();
		endScreenPanel = new LevelSelectPanel();
		backToMainMenu = maakButton(backToMainMenu, "mainMenu");
		backToMainMenu.addActionListener(this);
		endScreenPanel.add(backToMainMenu);
		
		//menuFrame.add(levelSelectPanel, BorderLayout.SOUTH);
		
		menuPanel.add(levelSelectPanel, BorderLayout.SOUTH);
		//menuPanel.add(blablabla);
		containerPanel.add(menuPanel, "1");
		containerPanel.add(endScreenPanel, "3");
		cardLayout.show(containerPanel, "1");
		
		level1 = new ButtonPanel("1");
		//level1.setBehaaldeSterren(2);
		level1.startButton.addActionListener(this);
		
		level2 = new ButtonPanel("2");
		level2.startButton.addActionListener(this);
		level3 = new ButtonPanel("3");
		level3.startButton.addActionListener(this);
		level4 = new ButtonPanel("4");
		level4.startButton.addActionListener(this);
		level5 = new ButtonPanel("5");
		level5.startButton.addActionListener(this);
		level6 = new ButtonPanel("6");
		level6.startButton.addActionListener(this);
		level7 = new ButtonPanel("7");
		level7.startButton.addActionListener(this);
		level8 = new ButtonPanel("8");
		level8.startButton.addActionListener(this);
		level9 = new ButtonPanel("9");
		level9.startButton.addActionListener(this);
		level10 = new ButtonPanel("10");
		level10.startButton.addActionListener(this);
		level11 = new ButtonPanel("11");
		level11.startButton.addActionListener(this);
		level12 = new ButtonPanel("12");
		level12.startButton.addActionListener(this);
		level13 = new ButtonPanel("13");
		level13.startButton.addActionListener(this);
		level14 = new ButtonPanel("14");
		level14.startButton.addActionListener(this);
		level15 = new ButtonPanel("15");
		level15.startButton.addActionListener(this);
		level16 = new ButtonPanel("16");
		level16.startButton.addActionListener(this);
//		level1 = maakButton(level1, "1");
//		level2 = maakButton(level2, "2");
//		level3 = maakButton(level3, "3");
//		level4 = maakButton(level4, "4");
//		level5 = maakButton(level5, "5");
//		level6 = maakButton(level6, "6");
//		level7 = maakButton(level7, "7");
//		level8 = maakButton(level8, "8");
//		level9 = maakButton(level9, "9");
//		level10 = maakButton(level10, "10");
//		level11 = maakButton(level11, "11");
//		level12 = maakButton(level12, "12");
//		level13 = maakButton(level13, "13");
//		level14 = maakButton(level14, "14");
//		level15 = maakButton(level15, "15");
//		level16 = maakButton(level16, "16");
		menuPanel.setLayout(new GridLayout(4, 4, 20, 20));
//		blablabla.setSize(new Dimension(200, 200));
//		blablabla.setPreferredSize(new Dimension(400, 40));
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
//		menuPanel.add(level16, BorderLayout.CENTER);
//		menuPanel.add(blablabla, BorderLayout.NORTH);


		frame.setVisible(true);	
	}
	static void goToMenu(){
		cardLayout.show(containerPanel, "1");
	}
	static void goToEndScreen(int sterren, int stappen, int level){
		int a = 0;
		a = berekenAantalBehaaldeSterren(sterren, stappen);
		switch(level){
		case 1: 
			level1.setBehaaldeSterren(a);
			level1.setRecordStappen(stappen);
			break;
		case 2: 
			level2.setBehaaldeSterren(a);
			level2.setRecordStappen(stappen);
			break;
		case 3: 
			level3.setBehaaldeSterren(a);
			level3.setRecordStappen(stappen);
			break;
		case 4: 
			level4.setBehaaldeSterren(a);
			level4.setRecordStappen(stappen);
			break;
		case 5: 
			level5.setBehaaldeSterren(a);
			level5.setRecordStappen(stappen);
			break;
		case 6:
			level6.setBehaaldeSterren(a);
			level6.setRecordStappen(stappen);
			break;
		case 7: 
			level7.setBehaaldeSterren(a);
			level7.setRecordStappen(stappen);
			break;
		case 8: 
			level8.setBehaaldeSterren(a);
			level8.setRecordStappen(stappen);
			break;
		case 9: 
			level9.setBehaaldeSterren(a);
			level9.setRecordStappen(stappen);
			break;
		case 10: 
			level10.setBehaaldeSterren(a);
			level10.setRecordStappen(stappen);
			break;
		case 11: 
			level11.setBehaaldeSterren(stappen);
			break;
		case 12: 
			level12.setBehaaldeSterren(stappen);
			break;
		case 13: 
			level13.setBehaaldeSterren(stappen);
			break;
		case 14: 
			level14.setBehaaldeSterren(stappen);
			break;
		}

		levelSelectPanel.setPaardStappen(Paard.getTotaalKeerBewogen());
		cardLayout.show(containerPanel, "3");
	}
	
	private static int berekenAantalBehaaldeSterren(int maxSterrenVoorDrie, int stappen) {
		if (stappen <= maxSterrenVoorDrie){
			return 3;
		} else if (stappen <= (maxSterrenVoorDrie+5)){
			return 2;
		} else {
			return 1;
		}	
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
//			System.out.println("hjet werkt");
//			goToMenu();
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
	 
		if ("mainMenu".equals(e.getActionCommand())) {
			cardLayout.show(containerPanel, "1");
		} else {
			containerPanel.add(game1panel, "2");
			cardLayout.show(containerPanel, "2");					
		}

	}
}
