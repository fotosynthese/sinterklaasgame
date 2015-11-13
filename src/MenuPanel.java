import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
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
	
	public MenuPanel(){
	}
	public MenuPanel(Paard a, Grid b){
		gridClone = b.grid;
		setGrid(b);
		setPaardPositie(a);
		marge_x = (Game.playfieldx - b.getGrid_x()*50)/2;
		marge_y = (Game.playfieldy - b.getGrid_y()*50)/2;
		try {
			sinterklaasImg = ImageIO.read(getClass().getResourceAsStream("/Sint2.png"));
			huisImg = ImageIO.read(getClass().getResourceAsStream("/Huis1.png"));
			huisEmptyImg = ImageIO.read(getClass().getResourceAsStream("/Huis2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		coordX = mouseXinGrid / 50;
		coordY = mouseYinGrid / 50;
	}
	public void paintComponent(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(0,0, Game.playfieldx, Game.playfieldy);
		
		g.setColor(Color.BLACK);
		g.drawString("THIS IST DER MENU", 50, 50);
	}
}
