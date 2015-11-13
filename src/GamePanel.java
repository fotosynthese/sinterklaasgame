import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
	static Scanner scanner = new Scanner(System.in);
	static int playfieldx = 800;
	static int playfieldy = 600;
	static int mousexLastClick = 0;
	static int mouseyLastClick = 0;
	static BoardPanel boardPanel;
	static boolean valideJump = false;
	static MenuPanel menuPanel;
	static int cadeautjesTotaalGebracht = 0;
	private JPanel containerPanel = new JPanel();
	private CardLayout cardLayout = new CardLayout();
	JFrame frame;
	JButton start;
	Grid grid;
	Paard paard;
	ArrayList<Tile> gridClone;
	int a, b;
	//coord van Grid
	int gridx, gridy;
	int marge_x, marge_y;
	int mouse_x = 0, mouse_y = 0;
	int coordX, coordY;
	BufferedImage sinterklaasImg;
	BufferedImage huisImg;
	BufferedImage huisEmptyImg;
	Level level1 = new Level();
	//JButton button = new JButton();

	public GamePanel(int level){
		//button = new JButton("3");
		//button.setActionCommand("3");
		//button.setPreferredSize(new Dimension(100, 40));
		//button.addActionListener(this);
		//menuPanel.add(button, BorderLayout.CENTER);
		//level1 = new Level();
		switch(level){
		case 1: 
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
			level1.setTeBehalenPunten(6);
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
			break;
		case 2: 
			level1.setGridx(5);
			level1.setGridy(5);
			level1.setSintx(0);
			level1.setSinty(0);
			level1.setHuisInArray(0,2);
			level1.setHuisInArray(3,3);
			level1.setTeBehalenPunten(2);
			//System.out.println(level1.getTeBehalenPunten());
			level1.setWaterInArray(1, 1);
			level1.setWaterInArray(1, 2);
			level1.setWaterInArray(1, 3);
			break;
		case 3: 
			level1.setGridx(9);
			level1.setGridy(4);
			level1.setSintx(4);
			level1.setSinty(1);
			level1.setHuisInArray(0,2);
			level1.setHuisInArray(3,3);
			level1.setHuisInArray(8,3);
			level1.setTeBehalenPunten(3);
			level1.setWaterInArray(1, 1);
			level1.setWaterInArray(3, 2);
			level1.setWaterInArray(5, 2);
			level1.setWaterInArray(6, 0);
			level1.setWaterInArray(7, 3);
			level1.setWaterInArray(5, 0);
			break;
		case 4: 
			level1.setGridx(9);
			level1.setGridy(7);
			level1.setSintx(4);
			level1.setSinty(1);
			level1.setHuisInArray(6,2);
			level1.setHuisInArray(3,3);
			level1.setHuisInArray(8,3);
			level1.setHuisInArray(7,2);
			level1.setHuisInArray(4,3);
			level1.setHuisInArray(7,3);
			level1.setTeBehalenPunten(6);
			break;
		case 5: 
			level1.setGridx(7);
			level1.setGridy(7);
			level1.setSintx(0);
			level1.setSinty(1);
			level1.setHuisInArray(3,3);
			level1.setTeBehalenPunten(1);
			level1.setWaterInArray(0, 4);
			level1.setWaterInArray(2, 1);
			level1.setWaterInArray(1, 2);
			level1.setWaterInArray(2, 2);
			level1.setWaterInArray(2, 3);
			level1.setWaterInArray(2, 4);
			level1.setWaterInArray(2, 5);
			level1.setWaterInArray(3, 2);
			level1.setWaterInArray(3, 4);
			level1.setWaterInArray(1, 4);
			level1.setWaterInArray(4, 2);
			level1.setWaterInArray(4, 3);
			level1.setWaterInArray(4, 4);
			level1.setWaterInArray(4, 5);
			level1.setWaterInArray(4, 6);
			level1.setWaterInArray(5, 2);
			level1.setWaterInArray(5, 3);
			break;
		}

		grid = new Grid(level1.getGridx(), level1.getGridy());
		for(int i = 0; i < level1.getHuisCoordX().size(); i++){
			//int tileInArray = level1.getHuisCoordY().get(i) + level1.getHuisCoordX().get(i)*grid.getGrid_y();
			int tileInArray = grid.getGridTile(level1.getHuisCoordX().get(i), level1.getHuisCoordY().get(i));
			System.out.println(level1.getHuisCoordY().get(i) + " " +  level1.getHuisCoordX().get(i) + " "+ grid.getGrid_y());
			System.out.println(tileInArray);
			//		System.out.println(tileInArray2);
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
			//		System.out.println(tileInArray2);
			//System.out.println(level1.getHuisCoordX());
			Tile t = grid.grid.get(tileInArray);
			t.isWater = true;
			grid.grid.set(tileInArray, t);			
		}
		paard = new Paard(level1.getSintx(), level1.getSinty());
		BoardPanel(paard, grid);
		//boardPanel = new BoardPanel(paard, grid);
		//frame.add(boardPanel);
		//frame.setVisible(true);	
		addMouseListener(this);
		addMouseMotionListener(this);
		System.out.println(grid.toString());
		System.out.println("x positie Paard: " + paard.getX_positie());
		System.out.println("y positie Paard: " + paard.getY_positie());
	}

	//checkt als het paard een valide jump doet
	public boolean viablePaardJump(){
		int x_verschil, y_verschil;
		x_verschil = Math.abs(coordX - paard.getX_positie());
		y_verschil = Math.abs(coordY - paard.getY_positie());
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
		if (coordX >= 0 && coordX < grid.getGrid_x()){
			//checkt als paard zijn nieuwe positie in het grid valt op de Y
			if (coordY >= 0 && coordY < grid.getGrid_y()){
				//checkt als paard zijn nieuwe positie het water raakt.
				Tile t = grid.grid.get(grid.getGridTile(coordX, coordY));
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
		//Tile t = grid.grid.get(coordX*grid.getGrid_x() + coordY);
		Tile t = grid.grid.get(grid.getGridTile(coordX, coordY));
		if (t.wilCadeau){
			return true;
		}
		return false;
	}

	//checkt als je gewonnen hebt.
	public boolean heeftGewonnen(){
		if (cadeautjesTotaalGebracht >= level1.getTeBehalenPunten()){
			return true;
		}
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		mousexLastClick = arg0.getX();
		mouseyLastClick = arg0.getY();
		setMouse(mousexLastClick, mouseyLastClick);
		vakjeHighLighted();
		if (viablePaardJump() && (viableValidePlaats())){
			paard.setX_positie(coordX);
			paard.setY_positie(coordY);
			setPaardPositie(paard);
			Paard.add1BijAantalKeerBewogen();
			if (isHuisDatCadeauWil()){
				Tile t = grid.grid.get(grid.getGridTile(coordX, coordY));
				t.wilCadeau = false;
				grid.grid.set(grid.getGridTile(coordX, coordY), t);
				cadeautjesTotaalGebracht += 1;
			}
		}
		repaint();
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
		setMouse(mousexLastClick, mouseyLastClick);
		if (viablePaardJump() && (viableValidePlaats())){
			valideJump = true;
		} else {
			valideJump = false;
		}
		vakjeHighLighted();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public void BoardPanel(Paard a, Grid b){
		gridClone = b.grid;
		setGrid(b);
		setPaardPositie(a);
		marge_x = (Game.playfieldx - b.getGrid_x()*Grid.getGridsizepixels())/2;
		marge_y = (Game.playfieldy - b.getGrid_y()*Grid.getGridsizepixels())/2;
		try {
			sinterklaasImg = ImageIO.read(getClass().getResourceAsStream("/Sint2.png"));
			huisImg = ImageIO.read(getClass().getResourceAsStream("/Huis1.png"));
			huisEmptyImg = ImageIO.read(getClass().getResourceAsStream("/Huis2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setPaardPositie(Paard a){
		this.a = a.getX_positie();
		this.b = a.getY_positie();
	}

	public void setGrid(Grid a){
		this.gridx = a.getGrid_x();
		this.gridy = a.getGrid_y();
	}
	public void setMouse(int x, int y){
		this.mouse_x = x;
		this.mouse_y = y;
	}	
	public void vakjeHighLighted(){
		int mouseXinGrid, mouseYinGrid;
		mouseXinGrid = mouse_x - marge_x;
		mouseYinGrid = mouse_y - marge_y;
		coordX = mouseXinGrid / Grid.getGridsizepixels();
		coordY = mouseYinGrid / Grid.getGridsizepixels();
	}

	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0,0, Game.playfieldx, Game.playfieldy);
		//Bord
		for (int i = 0; i < gridx; i++){
			for (int j = 0; j < gridy; j++){
				Tile n = (gridClone.get(i*gridy + j));
				int a = n.getRcolor();
				int b = n.getGcolor();
				int c = n.getBcolor();
				Color myRandomGreen = new Color(a,b,c);
				if (n.isWater){
					Color myRandomBlue = new Color(a,b,c+190);
					g.setColor(myRandomBlue);
					g.fillRect(i*Grid.getGridsizepixels() + marge_x,j*Grid.getGridsizepixels() + marge_y, Grid.getGridsizepixels(), Grid.getGridsizepixels());	
				} else {
					g.setColor(myRandomGreen);
					g.fillRect(i*Grid.getGridsizepixels() + marge_x,j*Grid.getGridsizepixels() + marge_y, Grid.getGridsizepixels(), Grid.getGridsizepixels());		
				}
				g.setColor(Color.GREEN);
				g.drawString("  x:"+ n.getxCoord() + "  y:" + n.getyCoord(), i*Grid.getGridsizepixels() + marge_x,j*Grid.getGridsizepixels() + marge_y + 25);

				if (n.heeftHuis){
					if (n.wilCadeau){
						g.drawImage(huisImg, i*Grid.getGridsizepixels() + marge_x,j*Grid.getGridsizepixels() + marge_y - huisImg.getHeight()+Grid.getGridsizepixels(), null);
					} else {
						g.drawImage(huisEmptyImg, i*Grid.getGridsizepixels() + marge_x,j*Grid.getGridsizepixels() + marge_y - huisEmptyImg.getHeight()+Grid.getGridsizepixels(), null);
					}
				}
			}	
		}
		//Draw Rect at clicked Tile
		if (valideJump){
			g.setColor(Color.GREEN);
			g.fillRect(coordX*Grid.getGridsizepixels() + marge_x - 5,coordY*Grid.getGridsizepixels() + marge_y - 5, Grid.getGridsizepixels()+10, 10);
			g.fillRect(coordX*Grid.getGridsizepixels() + marge_x - 5,coordY*Grid.getGridsizepixels() + marge_y - 5, 10, Grid.getGridsizepixels()+10);
			g.fillRect(coordX*Grid.getGridsizepixels() + marge_x + Grid.getGridsizepixels()-5,coordY*Grid.getGridsizepixels() + marge_y - 5, 10, Grid.getGridsizepixels()+10);
			g.fillRect(coordX*Grid.getGridsizepixels() + marge_x - 5,coordY*Grid.getGridsizepixels() + marge_y +Grid.getGridsizepixels()-5, Grid.getGridsizepixels()+10, 10);
		} else {
			g.setColor(Color.ORANGE);
			g.fillRect(coordX*Grid.getGridsizepixels() + marge_x - 5,coordY*Grid.getGridsizepixels() + marge_y - 5, Grid.getGridsizepixels()+10, 10);
			g.fillRect(coordX*Grid.getGridsizepixels() + marge_x - 5,coordY*Grid.getGridsizepixels() + marge_y - 5, 10, Grid.getGridsizepixels()+10);
			g.fillRect(coordX*Grid.getGridsizepixels() + marge_x + Grid.getGridsizepixels()-5,coordY*Grid.getGridsizepixels() + marge_y - 5, 10, Grid.getGridsizepixels()+10);
			g.fillRect(coordX*Grid.getGridsizepixels() + marge_x - 5,coordY*Grid.getGridsizepixels() + marge_y +Grid.getGridsizepixels()-5, Grid.getGridsizepixels()+10, 10);
		}
		//Draw Rect at mousePositionClick
		g.setColor(Color.YELLOW);
		g.fillRect(mouse_x-5,mouse_y-5, 10, 10);
		//Paard
		g.drawImage(sinterklaasImg, a*Grid.getGridsizepixels() + marge_x + ((Grid.getGridsizepixels() -sinterklaasImg.getWidth())/2), b*Grid.getGridsizepixels() + marge_y - sinterklaasImg.getHeight()+Grid.getGridsizepixels(), null);
		g.setColor(Color.black);
		g.drawString("Totaal aantal kinderen blij gemaakt: " + cadeautjesTotaalGebracht, Game.playfieldx/2 - 70, 20);
		g.drawString("Aantal keer bewogen: " + Paard.getAantalKeerBewogen(), Game.playfieldx/2 - 40, 40);
		if (heeftGewonnen()){
			g.drawString("DU HABST GEWUNNEN!", Game.playfieldx/2 - 40, Game.playfieldy/2);
			//cardLayout.show(containerPanel, "1");
		}
	}	
}

