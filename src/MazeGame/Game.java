package MazeGame;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Game class
 * <p>
 * The game class creates a frame with 3 panels. One container panel, a panel with the main menu 
 * and a game panel. The main menu panel is included in this class, the game panel has its own class.
 * 
 * @version 1.0 01 Aug 2015
 * @author Jan Jaap Zoutendijk
 */

public class Game {
	/** The Frame, container panel, main menu panel and the game panel */
	private JFrame f;
	private JPanel containerPanel = new JPanel();
	private JPanel mainMenuPanel = new JPanel();
	private GamePanel gamePanel;
	/** The main menu has text with movement instructions and buttons to choose the game size */
	private JRadioButton size1, size2, size3, size4;
	private JLabel field1, field2, field3, field4, field5;
	private String RadioChoice;
	private ButtonGroup mazeSize = new ButtonGroup();
	private JButton start = new JButton("Start");
	/** The container panel has a card layout to switch from the main menu to the game */
	private CardLayout cl = new CardLayout();
	/** The Game create a maze and player object that are given to the gamePanel */
	private Maze maze;
	private Player player;
	
	/**
	 * The constructor of the game object
	 * 
	 * Create the frame, a container panel, and the main menu panel.
	 * Add a action listener to the start button and when clicked, create the game.
	 * 
	 */
	public Game() {	
		//Create the frame and add a container panel to it
		f = new JFrame("MazeGame");			
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(containerPanel);
		f.setFocusable(true);
		f.setVisible(true);	
		
		//Set the layout of the container panel to switch from main menu to game
		containerPanel.setLayout(cl);
	
		//Create the main menu
		InitiateMainMenu();
	
		//Add the main menu and show it
		containerPanel.add(mainMenuPanel, "1");		
		cl.show(containerPanel, "1");
		
		//Add an action listener to the start button that creates a game when clicked
		start.addActionListener(new ActionListener() {
			/** Included the action listener  */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Get the selected choice for the radio buttons
				RadioChoice =  getSelectedButtonText(mazeSize);
				switch(RadioChoice){
				case "21x21": startGame(21,21);
					break;
				case "31x31": startGame(31,31);
					break;
				case "41x41": startGame(41,41);
					break;
				case "51x51": startGame(51,51);
					break;
				}
				cl.show(containerPanel, "2");
				gamePanel.requestFocus();
			}
			
		}); 
		
		//Fit the main menu in the frame
		f.pack();
			
	}
	
	/**
	 * Create the main menu 	
	 */
	public void InitiateMainMenu(){
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Create & add the buttons to the same group
		size1 = new JRadioButton("21x21");
		size2 = new JRadioButton("31x31");
		size3 = new JRadioButton("41x41");
		size4 = new JRadioButton("51x51");
		
		mazeSize.add(size1);
		mazeSize.add(size2);
		mazeSize.add(size3);
		mazeSize.add(size4);
		
		field1 = new JLabel("Maze Size:");	
		field2 = new JLabel("Player Controls:");
		field3 = new JLabel("Arrows: Movement");				
		field4 = new JLabel("C(Hold): Show a solution");
		field5 = new JLabel("R: Reset the player");
		
		//Select a default size		
		size1.setSelected(true);
		mainMenuPanel.setLayout(new GridBagLayout());
		
		//Add the buttons to the panel
		gbc.gridx = 0;
		gbc.gridy = 0;
		mainMenuPanel.add(field1, gbc);
		gbc.gridy = 1;
		mainMenuPanel.add(size1,gbc);
		gbc.gridy = 2;
		mainMenuPanel.add(size2,gbc);
		gbc.gridy = 3;
		mainMenuPanel.add(size3,gbc);
		gbc.gridy = 4;
		mainMenuPanel.add(size4,gbc);
		gbc.gridy = 0;
		gbc.insets = new Insets(0,30,0,0);
		gbc.gridx = 1;
		mainMenuPanel.add(field2, gbc);
		gbc.gridy = 1;
		mainMenuPanel.add(field3,gbc);
		gbc.gridy = 2;
		mainMenuPanel.add(field4,gbc);
		gbc.gridy = 3;
		mainMenuPanel.add(field5,gbc);
		gbc.gridy = 4;
		mainMenuPanel.add(start,gbc);
		
		//set the preferred size
		mainMenuPanel.setPreferredSize(new Dimension(300,300));
	}
	
	/**
	 * This method start the game as soon as the start game button is clicked on the main menu panel.
	 * The size chosen is given
	 * 
	 * @param i Number of columns
	 * @param j Number of rows
	 */
	public void startGame(int i, int j){
		this.maze = new Maze(i,j);
		this.player = new Player(this.maze);
		
		this.gamePanel = new GamePanel(this.maze, this.player); 
		containerPanel.add(gamePanel, "2");
		f.pack();
	}
	/**
	 * This class returns the text from the selected radiobutton from the button group that is given as argument
	 * @param buttonGroup
	 * @return the text of the selected button
	 */
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
	
	
	
}
	




