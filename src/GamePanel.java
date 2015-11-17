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
	int aXPaard, bYPaard;
	//coord van Grid
	int gridx, gridy;
	int marge_x, marge_y;
	int mouse_x = 0, mouse_y = 0;
	int coordX, coordY;
	BufferedImage sinterklaasImg;
	BufferedImage huisImg;
	BufferedImage pakHuisImg;
	BufferedImage huisEmptyImg;
	BufferedImage poolSteenImg;
	Level level1 = new Level();
	ListOfLevels lijstvanlevels;
	int welkLevel;
	int drieSterrenScore;
	boolean sintHeeftCadeaus;
	JButton backtoMenu = new JButton("Terug naar de Boot");

	public GamePanel(int level){
		backtoMenu.setActionCommand("1");
		//a.setSize(100, 40);
		//backtoMenu.setPreferredSize(new Dimension(180, 40));
		backtoMenu.addActionListener(this);	
		add(backtoMenu);
		cadeautjesTotaalGebracht = 0;
		lijstvanlevels = new ListOfLevels();
		level1 = lijstvanlevels.levels.get(level-1);
		welkLevel = level;
		sintHeeftCadeaus = level1.sintHeeftCadeaus;
		drieSterrenScore = level1.getScoreVoorDrieSterren();
		grid = new Grid(level1.getGridx(), level1.getGridy());
		
		for(int i = 0; i < level1.getHuisCoordX().size(); i++){
			int tileInArray = grid.getGridTile(level1.getHuisCoordX().get(i), level1.getHuisCoordY().get(i));
			System.out.println(level1.getHuisCoordY().get(i) + " " +  level1.getHuisCoordX().get(i) + " "+ grid.getGrid_y());
			System.out.println(tileInArray);
			Tile t = grid.grid.get(tileInArray);
			t.heeftHuis = true;
			t.wilCadeau = true;
			grid.grid.set(tileInArray, t);			
		}
		for(int i = 0; i < level1.getWaterX().size(); i++){
			int tileInArray = grid.getGridTile(level1.getWaterX().get(i), level1.getWaterY().get(i));
			Tile t = grid.grid.get(tileInArray);
			t.isWater = true;
			grid.grid.set(tileInArray, t);			
		}
		for(int i = 0; i < level1.getModderCoordX().size(); i++){
			int tileInArray = grid.getGridTile(level1.getModderCoordX().get(i), level1.getModderCoordY().get(i));
			Tile t = grid.grid.get(tileInArray);
			t.isModder = true;
			grid.grid.set(tileInArray, t);			
		}
		for(int i = 0; i < level1.getPakHuisCoordX().size(); i++){
			int tileInArray = grid.getGridTile(level1.getPakHuisCoordX().get(i), level1.getPakHuisCoordY().get(i));
			Tile t = grid.grid.get(tileInArray);
			t.heeftPakHuis = true;
			grid.grid.set(tileInArray, t);			
		}
		for(int i = 0; i < level1.getPoolSteenCoordX().size(); i++){
			int tileInArray = grid.getGridTile(level1.getPoolSteenCoordX().get(i), level1.getPoolSteenCoordY().get(i));
			Tile t = grid.grid.get(tileInArray);
			t.heeftPoolsteen = true;
			grid.grid.set(tileInArray, t);			
		}
		for(int i = 0; i < level1.getNoordPoolX().size(); i++){
			int tileInArray = grid.getGridTile(level1.getNoordPoolX().get(i), level1.getNoordPoolY().get(i));
			Tile t = grid.grid.get(tileInArray);
			t.zuidPool = false;
			grid.grid.set(tileInArray, t);			
		}
		for(int i = 0; i < level1.getZuidPoolX().size(); i++){
			int tileInArray = grid.getGridTile(level1.getZuidPoolX().get(i), level1.getZuidPoolY().get(i));
			Tile t = grid.grid.get(tileInArray);
			t.noordPool = false;
			grid.grid.set(tileInArray, t);			
		}
		paard = new Paard(level1.getSintx(), level1.getSinty());
		BoardPanel(paard, grid);
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
				if ((!t.noordPool) && (Tile.statusPoolsteen == 0)){
					return false;
				}
				if ((!t.zuidPool) && (Tile.statusPoolsteen == 1)){
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
	//checkt als het Sint Cadeaus bij zich heeft!
	public boolean sintHeeftCadeau(){
		if (sintHeeftCadeaus){
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

	private boolean tileIsModder() {
		Tile t = grid.grid.get(grid.getGridTile(coordX, coordY));
		if (t.isModder){
			return true;
		}
		return false;
	}
	private boolean tileIsPoolSteen() {
		Tile t = grid.grid.get(grid.getGridTile(coordX, coordY));
		if (t.heeftPoolsteen){
			return true;
		}
		return false;
	}
	private boolean tileIsPakHuis() {
		Tile t = grid.grid.get(grid.getGridTile(coordX, coordY));
		if (t.heeftPakHuis){
			return true;
		}
		return false;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {

	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		mousexLastClick = arg0.getX();
		mouseyLastClick = arg0.getY();
		setMouse(mousexLastClick, mouseyLastClick);
		vakjeHighLighted();
		if (viablePaardJump() && (viableValidePlaats())){
			paard.setX_positie(coordX);
			paard.setY_positie(coordY);
			setPaardPositie(paard);
			if (tileIsModder()){
				Paard.add1BijAantalKeerBewogen();
			}
			if (tileIsPakHuis()){
				sintHeeftCadeaus = true;
			}
			if (tileIsPoolSteen()){
				Tile.statusPoolsteen = Math.abs(Tile.statusPoolsteen-1);
			}
			Paard.add1BijAantalKeerBewogen();
			if (isHuisDatCadeauWil() && sintHeeftCadeau()){
				Tile t = grid.grid.get(grid.getGridTile(coordX, coordY));
				t.wilCadeau = false;
				grid.grid.set(grid.getGridTile(coordX, coordY), t);
				cadeautjesTotaalGebracht += 1;
			}
		}
		repaint();
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
		if ("1".equals(e.getActionCommand())) {
			Game.goToMenu();
			Paard.setAantalKeerBewogen(0);
		}
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
			pakHuisImg = ImageIO.read(getClass().getResourceAsStream("/cadeauPakHuis.png"));
			poolSteenImg = ImageIO.read(getClass().getResourceAsStream("/poolSteen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setPaardPositie(Paard a){
		this.aXPaard = a.getX_positie();
		this.bYPaard = a.getY_positie();
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

	public void animatePaard(){
		
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
				if (n.isWater){ //is WATER
					Color myRandomBlue = new Color(a,b,c+190);
					g.setColor(myRandomBlue);
					g.fillRect(i*Grid.getGridsizepixels() + marge_x,j*Grid.getGridsizepixels() + marge_y, Grid.getGridsizepixels(), Grid.getGridsizepixels());	
				} else if (n.isModder){ //is MODDER
					Color myRandomModder = new Color(a+100,b-90,c-20);
					g.setColor(myRandomModder);
					g.fillRect(i*Grid.getGridsizepixels() + marge_x,j*Grid.getGridsizepixels() + marge_y, Grid.getGridsizepixels(), Grid.getGridsizepixels());		
				} else if (!n.zuidPool){ //is ZUIDPOOL
					Color myRandomZuidKleur;
					if (Tile.statusPoolsteen == 0){
						myRandomZuidKleur = new Color(a,b,c+80);	
					} else {
						myRandomZuidKleur = new Color(a,b,c+160);
					}
					g.setColor(myRandomZuidKleur);
					g.fillRect(i*Grid.getGridsizepixels() + marge_x,j*Grid.getGridsizepixels() + marge_y, Grid.getGridsizepixels(), Grid.getGridsizepixels());		
				} else if (!n.noordPool){
					Color myRandomZuidKleur;
					if (Tile.statusPoolsteen == 1){
						myRandomZuidKleur = new Color(a,b,c+90);	
					} else {
						myRandomZuidKleur = new Color(a,b,c+150);
					}
					g.setColor(myRandomZuidKleur);
					g.fillRect(i*Grid.getGridsizepixels() + marge_x,j*Grid.getGridsizepixels() + marge_y, Grid.getGridsizepixels(), Grid.getGridsizepixels());		
				} else {
					Color myRandomGreen = new Color(a,b,c);
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
				} else if (n.heeftPakHuis){
					g.drawImage(pakHuisImg, i*Grid.getGridsizepixels() + marge_x,j*Grid.getGridsizepixels() + marge_y - huisImg.getHeight()+Grid.getGridsizepixels(), null);
				} else if (n.heeftPoolsteen){
					g.drawImage(poolSteenImg, i*Grid.getGridsizepixels() + marge_x,j*Grid.getGridsizepixels() + marge_y - huisImg.getHeight()+Grid.getGridsizepixels(), null);
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
//		g.setColor(Color.YELLOW);
//		g.fillRect(mouse_x-5,mouse_y-5, 10, 10);
		//Paard
		//g.drawImage(sinterklaasImg, aXPaard*Grid.getGridsizepixels() + marge_x + ((Grid.getGridsizepixels() -sinterklaasImg.getWidth())/2), bYPaard*Grid.getGridsizepixels() + marge_y - sinterklaasImg.getHeight()+Grid.getGridsizepixels(), null);
		g.drawImage(sinterklaasImg, aXPaard*Grid.getGridsizepixels() + marge_x + ((Grid.getGridsizepixels() -sinterklaasImg.getWidth())/2), bYPaard*Grid.getGridsizepixels() + marge_y - sinterklaasImg.getHeight()+Grid.getGridsizepixels(), null);
		g.setColor(Color.black);
		g.drawString("Totaal aantal kinderen blij gemaakt: " + cadeautjesTotaalGebracht, Game.playfieldx/2 - 70, 20);
		g.drawString("Aantal keer bewogen: " + Paard.getAantalKeerBewogen(), Game.playfieldx/2 - 40, 40);
		if (heeftGewonnen()){
			g.drawString("DU HABST GEWUNNEN!", Game.playfieldx/2 - 40, Game.playfieldy/2);
			//cardLayout.show(containerPanel, "1");
			Game.goToEndScreen(drieSterrenScore, Paard.getAantalKeerBewogen(), welkLevel);
//			int a = ;
			Paard.setTotaalKeerBewogen(Paard.getTotaalKeerBewogen() + Paard.getAantalKeerBewogen());
			Paard.setAantalKeerBewogen(0);
		}
	}	
}

