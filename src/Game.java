import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

public class Game {
	static Scanner scanner = new Scanner(System.in);
	static int playfieldx = 800;
	static int playfieldy = 600;


	public static void main(String[] args) throws IOException {
		Grid grid = new Grid();
		Paard paard = new Paard();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoardPanel boardPanel = new BoardPanel(paard, grid);
		frame.add(boardPanel);
		frame.setSize(800,600);
		frame.setVisible(true);
		// TODO Auto-generated method stub

		System.out.println(grid.toString());
		System.out.println("x positie Paard: " + paard.getX_positie());
		System.out.println("y positie Paard: " + paard.getY_positie());
//		paard.moveRechtsRechtsBoven();
//		System.out.println("x positie Paard: " + paard.getX_positie());
//		System.out.println("y positie Paard: " + paard.getY_positie());
		while(true){
			paard.move(scanner.nextInt());
			System.out.println("x positie Paard: " + paard.getX_positie());
			System.out.println("y positie Paard: " + paard.getY_positie());
			boardPanel.setPaardPositie(paard);
			boardPanel.repaint();
		}
	}

}
