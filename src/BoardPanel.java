import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardPanel extends JPanel{
	int a, b;
	//coord van Grid
	int gridx, gridy;
	int marge_x, marge_y;
	BufferedImage img;
	
	public BoardPanel(Paard a, Grid b) throws IOException{
		setGrid(b);
		setPaardPositie(a);
		marge_x = (Game.playfieldx - b.getGrid_x()*50)/2;
		marge_y = (Game.playfieldy - b.getGrid_y()*50)/2;
		img = ImageIO.read(getClass().getResourceAsStream("/Sint.png"));
	}
	
	public void setPaardPositie(Paard a){
		this.a = a.getX_positie();
		this.b = a.getY_positie();
	}
	
	public void setGrid(Grid a){
		this.gridx = a.getGrid_x();
		this.gridy = a.getGrid_y();
	}
	
	

	public void paintComponent(Graphics g){
		//Bord
		for (int i = 0; i < gridx; i++){
			for (int j = 0; j < gridy; j++){
				int a = (int) (Math.random()*20 + 40);
				int b = (int) (Math.random()*20 + 180);
				int c = (int) (Math.random()*20 + 40);
				Color myRandomGreen = new Color(a,b,c);
				g.setColor(myRandomGreen);
				g.fillRect(i*50 + marge_x,j*50 + marge_y, 50, 50);
			}	
		}
		//Paard
		g.setColor(Color.BLUE);
		g.fillRect(a*50 + marge_x,b*50 + marge_y, 50, 50);
		
		g.drawImage(img, a*50 + marge_x,b*50 + marge_y, null);
		
	}
	
}
