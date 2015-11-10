import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardPanel extends JPanel{
	ArrayList<Tile> gridClone = new ArrayList<Tile>();
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
		marge_x = (Game.playfieldx - b.getGrid_x()*50)/2;
		marge_y = (Game.playfieldy - b.getGrid_y()*50)/2;
		try {
			sinterklaasImg = ImageIO.read(getClass().getResourceAsStream("/Sint.png"));
			huisImg = ImageIO.read(getClass().getResourceAsStream("/Huis.png"));
			huisEmptyImg = ImageIO.read(getClass().getResourceAsStream("/Huis_empty.png"));
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
	public void VakjeHighLighted(){
		int mouseXinGrid, mouseYinGrid;
		mouseXinGrid = mouse_x - marge_x;
		mouseYinGrid = mouse_y - marge_y;
		
		coordX = mouseXinGrid / 50;
		coordY = mouseYinGrid / 50;
	}

	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0,0, Game.playfieldx, Game.playfieldy);
		
		//Bord
		for (int i = 0; i < gridx; i++){
			for (int j = 0; j < gridy; j++){
				Tile n = (gridClone.get(i*gridx + j));
				//int a = (int) (Math.random()*20 + 40);
				//a = gridClone.get(i);
				int a = n.getRcolor();
				int b = n.getGcolor();
				int c = n.getBcolor();
				Color myRandomGreen = new Color(a,b,c);
				g.setColor(myRandomGreen);
				g.fillRect(i*50 + marge_x,j*50 + marge_y, 50, 50);
				if (n.heeftHuis){
					if (n.wilCadeau){
						g.drawImage(huisImg, i*50 + marge_x,j*50 + marge_y - huisImg.getHeight()+50, null);
					} else {
						g.drawImage(huisEmptyImg, i*50 + marge_x,j*50 + marge_y - huisImg.getHeight()+50, null);
					}
					//g.setColor(Color.BLUE);
					//g.fillRect(i*50 + marge_x +10,j*50 + marge_y +10, 30, 30);
				}
				//System.out.println(myRandomGreen);
			}	
			
		}
		
		

		
		//Draw Rect at clicked Tile
		g.setColor(Color.GRAY);
		
		//g.fillRoundRect(coordX*50 + marge_x,coordY*50 + marge_y, 50, 50, 30, 30);	
		g.fillRect(coordX*50 + marge_x - 5,coordY*50 + marge_y - 5, 60, 10);
		g.fillRect(coordX*50 + marge_x - 5,coordY*50 + marge_y - 5, 10, 60);
		g.fillRect(coordX*50 + marge_x + 45,coordY*50 + marge_y - 5, 10, 60);
		g.fillRect(coordX*50 + marge_x - 5,coordY*50 + marge_y +45, 60, 10);
		
		
		//Draw Rect at mousePositionClick
		g.setColor(Color.YELLOW);
		g.fillRect(mouse_x,mouse_y, 10, 10);
		
		//Paard
		//g.setColor(Color.BLUE);
		//g.fillRect(a*50 + marge_x,b*50 + marge_y, 50, 50);
		g.drawImage(sinterklaasImg, a*50 + marge_x,b*50 + marge_y - sinterklaasImg.getHeight()+50, null);
		
		
	}
	
}
