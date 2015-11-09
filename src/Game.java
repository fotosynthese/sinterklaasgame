import java.util.Scanner;

import javax.swing.JFrame;

public class Game {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Draw draw = new Draw();
		frame.add(draw);
		frame.setSize(600,600);
		frame.setVisible(true);
		// TODO Auto-generated method stub
		Grid grid = new Grid();
		Paard paard = new Paard();
		System.out.println(grid.toString());
		System.out.println("x positie Paard: " + paard.getX_positie());
		System.out.println("y positie Paard: " + paard.getY_positie());
		paard.moveRechtsRechtsBoven();
		System.out.println("x positie Paard: " + paard.getX_positie());
		System.out.println("y positie Paard: " + paard.getY_positie());
		while(true){
			paard.move(scanner.nextInt());
			System.out.println("x positie Paard: " + paard.getX_positie());
			System.out.println("y positie Paard: " + paard.getY_positie());
		}
	}

}
