
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardPanel extends JPanel{
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
	
	
	public BoardPanel(Paard a, Grid b){
		
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
				//Tile n = gridClone.getGridTile(i, j);
				//y + x*getGrid_y()
				//int a = (int) (Math.random()*20 + 40);
				//a = gridClone.get(i);
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
		g.setColor(Color.GRAY);
		//g.fillRoundRect(coordX*50 + marge_x,coordY*50 + marge_y, 50, 50, 30, 30);	
		g.fillRect(coordX*Grid.getGridsizepixels() + marge_x - 5,coordY*Grid.getGridsizepixels() + marge_y - 5, Grid.getGridsizepixels()+10, 10);
		g.fillRect(coordX*Grid.getGridsizepixels() + marge_x - 5,coordY*Grid.getGridsizepixels() + marge_y - 5, 10, Grid.getGridsizepixels()+10);
		g.fillRect(coordX*Grid.getGridsizepixels() + marge_x + Grid.getGridsizepixels()-5,coordY*Grid.getGridsizepixels() + marge_y - 5, 10, Grid.getGridsizepixels()+10);
		g.fillRect(coordX*Grid.getGridsizepixels() + marge_x - 5,coordY*Grid.getGridsizepixels() + marge_y +Grid.getGridsizepixels()-5, Grid.getGridsizepixels()+10, 10);
		//Draw Rect at mousePositionClick
		g.setColor(Color.YELLOW);
		g.fillRect(mouse_x-5,mouse_y-5, 10, 10);
		//Paard
		//g.setColor(Color.BLUE);
		//g.fillRect(a*50 + marge_x,b*50 + marge_y, 50, 50);
		g.drawImage(sinterklaasImg, a*Grid.getGridsizepixels() + marge_x + ((Grid.getGridsizepixels() -sinterklaasImg.getWidth())/2), b*Grid.getGridsizepixels() + marge_y - sinterklaasImg.getHeight()+Grid.getGridsizepixels(), null);
		g.setColor(Color.black);
		g.drawString("Totaal aantal kinderen blij gemaakt: " + Game.cadeautjesTotaalGebracht, Game.playfieldx/2 - 70, 20);
		g.drawString("Aantal keer bewogen: " + Paard.getAantalKeerBewogen(), Game.playfieldx/2 - 40, 40);
		//if (Game.heeftGewonnen()){
			g.drawString("DU HABST GEWUNNEN!", Game.playfieldx/2 - 40, Game.playfieldy/2);
		//}
	}
	
}

