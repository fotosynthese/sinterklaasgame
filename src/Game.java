import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

public class Game implements MouseListener, MouseMotionListener {
	static Scanner scanner = new Scanner(System.in);
	static int playfieldx = 800;
	static int playfieldy = 600;
	static int mousexLastClick = 0;
	static int mouseyLastClick = 0;
	static BoardPanel boardPanel;
	static int cadeautjesTotaalGebracht = 0;
	JFrame frame;
	Grid grid;
	Paard paard;
	public static void main(String[] args){
		Game g = new Game();
		g.SinterKlaasGame();
	}
	
	public void SinterKlaasGame(){
		grid = new Grid();
		paard = new Paard();
		boardPanel = new BoardPanel(paard, grid);
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(boardPanel);
		boardPanel.addMouseListener(this);
		boardPanel.addMouseMotionListener(this);
		frame.setSize(playfieldx,playfieldy);
		frame.setVisible(true);
		System.out.println(grid.toString());
		System.out.println("x positie Paard: " + paard.getX_positie());
		System.out.println("y positie Paard: " + paard.getY_positie());
		while(true){
			paard.move(scanner.nextInt());
			System.out.println("x positie Paard: " + paard.getX_positie());
			System.out.println("y positie Paard: " + paard.getY_positie());
			System.out.println("x en y van mouseclick zijn: "+ mousexLastClick + mouseyLastClick );
			boardPanel.setPaardPositie(paard);
			boardPanel.repaint();
		}		
	}
	public boolean viablePaardPlek(){
		//als er geklikt wordt en het paard mag hiernaar toe.
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
	public boolean isHuisDatCadeauWil(){
		Tile t = grid.grid.get(boardPanel.coordX*grid.getGrid_x() + boardPanel.coordY);
		if (t.heeftHuis){
			return true;
		}
		return false;
	}
	static boolean heeftGewonnen(){
		if (cadeautjesTotaalGebracht > 5){
			return true;
		}
		return false;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		mousexLastClick = arg0.getX();
		mouseyLastClick = arg0.getY();
		boardPanel.setMouse(mousexLastClick, mouseyLastClick);
		boardPanel.VakjeHighLighted();
		if (viablePaardPlek()){
			paard.setX_positie(boardPanel.coordX);
			paard.setY_positie(boardPanel.coordY);
			boardPanel.setPaardPositie(paard);
			Paard.add1BijAantalKeerBewogen();
			if (isHuisDatCadeauWil()){
				Tile t = grid.grid.get(boardPanel.coordX*grid.getGrid_x() + boardPanel.coordY);
				t.wilCadeau = false;
				grid.grid.set(boardPanel.coordX*grid.getGrid_x() + boardPanel.coordY, t);
				cadeautjesTotaalGebracht += 1;
			}
		}
		boardPanel.repaint();
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
		boardPanel.setMouse(mousexLastClick, mouseyLastClick);
		boardPanel.VakjeHighLighted();
		boardPanel.repaint();
	}

}
