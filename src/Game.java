import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
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

public class Game implements MouseListener, MouseMotionListener, ActionListener {
	static Scanner scanner = new Scanner(System.in);
	static int playfieldx = 800;
	static int playfieldy = 600;
	static int mousexLastClick = 0;
	static int mouseyLastClick = 0;
	static BoardPanel boardPanel;
	static MenuPanel menuPanel;
	static GamePanel game1panel; //dit is een panel, naam moet nog veranderen
	static int cadeautjesTotaalGebracht = 0;
	private JPanel containerPanel = new JPanel();
	private CardLayout cardLayout = new CardLayout();

	JFrame frame;
	JButton start;
	JButton start2;
	JButton level3;
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
		//Create the main menu
		//InitiateMainMenu();
		//Add the main menu and show it
		containerPanel.add(menuPanel, "1");	
		containerPanel.addMouseListener(this);
		containerPanel.addMouseMotionListener(this);
		//SinterKlaasGame();
		cardLayout.show(containerPanel, "1");

		start = new JButton("1");
		start2 = new JButton("2");
		level3 = new JButton("3");
		level3.setActionCommand("3");
		level3.setPreferredSize(new Dimension(100, 40));
		level3.addActionListener(this);
		start.setActionCommand("1");
		start2.setActionCommand("2");
		start.setPreferredSize(new Dimension(100, 40));
		start.addActionListener(this);
		start2.setPreferredSize(new Dimension(100, 40));
		start2.addActionListener(this);
		menuPanel.add(start, BorderLayout.CENTER);
		menuPanel.add(start2, BorderLayout.CENTER);
		menuPanel.add(level3, BorderLayout.CENTER);

		frame.setVisible(true);
		while(true){
			if (scanner.nextInt() == 1){
				SinterKlaasGame();
			}
		}	
	}
	
	public void SinterKlaasGame(){
		Level level1 = new Level();
		level1.setGridx(9);
		level1.setGridy(7);
		level1.setSintx(3);
		level1.setSinty(2);
		level1.setHuisInArray(0,2);
		level1.setHuisInArray(1,3);
		level1.setHuisInArray(6,5);
		level1.setHuisInArray(4,1);
		level1.setHuisInArray(3,3);
		level1.setHuisInArray(6,6);
		level1.setWaterInArray(1, 1);
		level1.setWaterInArray(1, 2);
		level1.setWaterInArray(2, 1);
		level1.setWaterInArray(2, 2);
		level1.setWaterInArray(0, 4);
		level1.setWaterInArray(1, 4);
		level1.setWaterInArray(2, 4);
		level1.setWaterInArray(3, 4);
		level1.setWaterInArray(4, 4);
		level1.setWaterInArray(4, 5);
		level1.setWaterInArray(4, 6);
		grid = new Grid(level1.getGridx(), level1.getGridy());
		for(int i = 0; i < level1.getHuisCoordX().size(); i++){
			//int tileInArray = level1.getHuisCoordY().get(i) + level1.getHuisCoordX().get(i)*grid.getGrid_y();
			int tileInArray = grid.getGridTile(level1.getHuisCoordX().get(i), level1.getHuisCoordY().get(i));
			System.out.println(level1.getHuisCoordY().get(i) + " " +  level1.getHuisCoordX().get(i) + " "+ grid.getGrid_y());
			System.out.println(tileInArray);
//			System.out.println(tileInArray2);
			//System.out.println(level1.getHuisCoordX());
			Tile t = grid.grid.get(tileInArray);
			t.heeftHuis = true;
			t.wilCadeau = true;
			grid.grid.set(tileInArray, t);			
		}
		for(int i = 0; i < level1.getWaterX().size(); i++){
			//int tileInArray = level1.getHuisCoordY().get(i) + level1.getHuisCoordX().get(i)*grid.getGrid_y();
			int tileInArray = grid.getGridTile(level1.getWaterX().get(i), level1.getWaterY().get(i));
			//System.out.println("x is: "+ level1.getWaterX().get(i) + " y is: " +  level1.getWaterY().get(i) + "grid lengte y is: "+ grid.getGrid_y());
			//System.out.println(tileInArray);
//			System.out.println(tileInArray2);
			//System.out.println(level1.getHuisCoordX());
			Tile t = grid.grid.get(tileInArray);
			t.isWater = true;
			grid.grid.set(tileInArray, t);			
		}
		paard = new Paard(level1.getSintx(), level1.getSinty());
		boardPanel = new BoardPanel(paard, grid);
		frame.add(boardPanel);
		frame.setVisible(true);	
		boardPanel.addMouseListener(this);
		boardPanel.addMouseMotionListener(this);
		System.out.println(grid.toString());
		System.out.println("x positie Paard: " + paard.getX_positie());
		System.out.println("y positie Paard: " + paard.getY_positie());
//		while(true){
//			paard.move(scanner.nextInt());
//			System.out.println("x positie Paard: " + paard.getX_positie());
//			System.out.println("y positie Paard: " + paard.getY_positie());
//			System.out.println("x en y van mouseclick zijn: "+ mousexLastClick + mouseyLastClick );
//			boardPanel.setPaardPositie(paard);
//			boardPanel.repaint();
//		}		
	}
	//checkt als het paard een valide jump doet
	public boolean viablePaardJump(){
		int x_verschil, y_verschil;
		x_verschil = Math.abs(boardPanel.coordX - paard.getX_positie());
		y_verschil = Math.abs(boardPanel.coordY - paard.getY_positie());
		if (x_verschil == 2 || y_verschil == 2){
			if (x_verschil == 1 || y_verschil == 1){
				return true;
			}
		}
		return false;
	}
	
	//checkt als het paard zijn nieuwe positie in het grid valt en als het geen water is.
	public boolean viableValidePlaats() {
		//checkt als paard zijn nieuwe positie in het grid valt op de X
		if (boardPanel.coordX >= 0 && boardPanel.coordX < grid.getGrid_x()){
			//checkt als paard zijn nieuwe positie in het grid valt op de Y
			if (boardPanel.coordY >= 0 && boardPanel.coordY < grid.getGrid_y()){
				//checkt als paard zijn nieuwe positie het water raakt.
				Tile t = grid.grid.get(grid.getGridTile(boardPanel.coordX, boardPanel.coordY));
				if (t.isWater) {
					return false;
				}
				return true;
			}
		}
		return false;
	}
	
	//checkt als het Huis waarop je komt een cadeau wil.
	public boolean isHuisDatCadeauWil(){
		//Tile t = grid.grid.get(boardPanel.coordX*grid.getGrid_x() + boardPanel.coordY);
		Tile t = grid.grid.get(grid.getGridTile(boardPanel.coordX, boardPanel.coordY));
		if (t.wilCadeau){
			return true;
		}
		return false;
	}
	
	//checkt als je gewonnen hebt.
	static boolean heeftGewonnen(){
		if (cadeautjesTotaalGebracht > 5){
			return true;
		}
		return false;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
//		mousexLastClick = arg0.getX();
//		mouseyLastClick = arg0.getY();
//		boardPanel.setMouse(mousexLastClick, mouseyLastClick);
//		boardPanel.vakjeHighLighted();
//		if (viablePaardJump() && (viableValidePlaats())){
//			paard.setX_positie(boardPanel.coordX);
//			paard.setY_positie(boardPanel.coordY);
//			boardPanel.setPaardPositie(paard);
//			Paard.add1BijAantalKeerBewogen();
//			if (isHuisDatCadeauWil()){
//				//Tile t = grid.grid.get(boardPanel.coordX*grid.getGrid_x() + boardPanel.coordY);
//				Tile t = grid.grid.get(grid.getGridTile(boardPanel.coordX, boardPanel.coordY));
//				t.wilCadeau = false;
////				grid.grid.set(boardPanel.coordX*grid.getGrid_x() + boardPanel.coordY, t);
//				grid.grid.set(grid.getGridTile(boardPanel.coordX, boardPanel.coordY), t);
//				cadeautjesTotaalGebracht += 1;
//			}
//		}
//		boardPanel.repaint();
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		mousexLastClick = arg0.getX();
		mouseyLastClick = arg0.getY();
		//boardPanel.setMouse(mousexLastClick, mouseyLastClick);
		//boardPanel.vakjeHighLighted();
		//boardPanel.repaint();
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
		 }
			containerPanel.add(game1panel, "2");
			cardLayout.show(containerPanel, "2");
		//boardPanel.requestFocus();
		//frame.remove(menuPanel);
		//frame.remove(start);
	}

}
