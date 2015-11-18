package MazeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/** 
 * The GamePanel Class
 * <p>
 * Displays the maze and player objects on a dedicated panel. 
 * 
 * 
 * @author Jan Jaap Zoutendijk
 * @version 1.0 01 Augustus 2015
 */

public class GamePanel extends JPanel implements KeyListener {
	/** The maze and player objects */
	private Maze level1;
	private Player player1;
	/** The solution arrays */
	private int[][] mazeArray;
	private boolean[][] solution;
	
	/**
	 * Constructor of the gamepanel object
	 * @param level1 The Maze object that is created in the game class
	 * @param player1 The Player object that is created in the game class 
	 */
	public GamePanel(Maze level1, Player player1){
		this.level1 = level1;
		this.mazeArray = level1.getMazeArray();
		this.player1 = player1;
		this.solution = level1.correctPath;		
		//Set the panel to the proper size to display the maze
		Dimension d = new Dimension((mazeArray.length)*10,(mazeArray.length)*10);
		this.setPreferredSize(d);
		setFocusable(true);
		addKeyListener(this);		
	}

	/**
	 * The paint methods display the maze using Rectangles and ovals. The Walls are displayed as dark gray rectangles
	 * the player and exit as ovals. 
	 * 
	 * Furthermore when the C button is pressed, the solution will be displayed as gray ovals to indicate the route to the exit.
	 */
	public void paint(Graphics g){
		this.paintComponent(g);
		int wallsize = 10;
		for (int y = 0; y <= mazeArray.length-1; y++){
			for (int x = 0; x <= mazeArray.length-1; x++){

				if(mazeArray[x][y] == 1){
					g.setColor(Color.DARK_GRAY);
					g.fillRect((x*wallsize), (y*wallsize), wallsize, wallsize);
				}
				if(solution[x][y] == true){
					g.setColor(Color.gray);
					g.fillOval((x*wallsize), (y*wallsize), wallsize, wallsize);
				}
				if(mazeArray[x][y] == 4){
					g.setColor(Color.GREEN);
					g.fillOval((x*wallsize), (y*wallsize), wallsize, wallsize);
				}
				if(mazeArray[x][y] == 5){
					g.setColor(Color.GRAY);
					g.fillOval((x*wallsize), (y*wallsize), wallsize, wallsize);
				}	
				if(mazeArray[x][y] == 3){
					g.setColor(Color.BLACK);
					g.fillOval((x*wallsize), (y*wallsize), wallsize, wallsize);
				}
			}
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	@Override
	/**
	 * The key events to correspond to the proper events.
	 * 
	 * key released events:
	 * 	67 C When the c key is released, the solution should be removed from the field
	 */
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 67){
			level1.removeSolution();
		}
		repaint();
	}

	@Override
	/**
	 * The key events to correspond to the proper events.
	 * 
	 * key pressed events: 
	 * 	38 left 
	 *  39 up
	 *  40 right
	 *  41 left
	 *  82 R(reset player location)
	 *  67 C(show the solution)
	 */
	public void keyPressed(KeyEvent e) {		
		if(e.getKeyCode() == 38 ){
			player1.movePlayer(1);
		}
		if(e.getKeyCode() == 39){
			player1.movePlayer(2);
		}			
		if(e.getKeyCode() == 40){
			player1.movePlayer(3);
		}
		if(e.getKeyCode() == 37){
			player1.movePlayer(4);
		}
		if(e.getKeyCode() == 82){
			player1.resetPlayer();
		}
		if(e.getKeyCode() == 67){
			solution = level1.solveMaze(player1.getLocation());
		}
		repaint();
	}
	

	
}
