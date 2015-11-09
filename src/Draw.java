import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Draw extends JPanel{
	int a, b;
	
	public Draw(Paard a){
		this.a = a.getX_positie();
		this.b = a.getY_positie();
	}

	public void paintComponent(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(a,b, 50, 50);
	}
	
}
