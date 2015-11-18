package MazeGame;

import java.util.Random;

/**
 * Maze Class can be used to create maze for the MazeGame
 * <p>
 * This class can be used to create a maze object. IT will produce an integer[][] (matrix) with numbers.
 * These numbers have the following meaning:
 * 0 - Path
 * 1 - Wall
 * 3 - Player. Please see associated class: Player {@link MazeGame.Player}
 * 4 - Exit. The goal for the player. 
 * Includes an algorithm to find the exit from a given start location and option to print the maze to a console.  
 *
 * @version 1.0 01 Aug 2015
 * @author Jan Jaap Zoutendijk
 */
public class Maze {
	/** Number of rows, columns and location of the end of the maze */
	private int rows, columns;
	private int endX, endY;
	/** Maze array is the matrix that contains the actual maze */
	private int [][] mazeArray;
	/** Boolean arrays that are used to find: wasHere; and contain the solution: correctPath */
	boolean[][] wasHere;
	boolean[][] correctPath;
	
	/**
	 * Constructor for the maze objects
	 * 
	 * @param x Number of columns the maze should have
	 * @param y Number of rows the maze should have
	 */
	public Maze(int x, int y){
		//based on x,y coordinate system  
		rows = y;
		columns = x;
		//initiate the exit location at bottom right
		endX = columns - 2;
		endY = rows - 2;
		mazeArray = new int[x][y];
		wasHere = new boolean[x][y];
		correctPath = new boolean[x][y];
			
		//start by building walls
		initializeMaze(); 
		//create a valid maze
		buildMaze();
		//create an exit in the maze
		createExit();
	}	
	
	/**
	 * Initializes the maze by creating walls everywhere. Also initialize the solution arrays by setting to false.
	 */
	public void initializeMaze(){
		for (int y = 0; y < this.rows; y++){
			for(int x = 0; x < this.columns; x++){
				this.mazeArray[x][y] = 1;
				this.correctPath[x][y] = false;
				this.wasHere[x][y] = false;
			}
		}	
	}
	
	/**
	 * Method to address for building a path in the maze. Addresses the recursive build method.
	 * @param x next x position for the recursion algorithm to check
	 * @param y next y position for the recursion algorithm to check
	 */
	public void buildMaze(){
		//pick a starting location for building the maze (and check it's within the walls)
		Random rand = new Random();
		int c = rand.nextInt(columns);
		while (c % 2 == 0){//should be uneven
			c = rand.nextInt(columns); 
		}
		int r = rand.nextInt(rows);
		while (r % 2 == 0){//should be uneven
			r = rand.nextInt(rows);
		}
		//Start building the maze
		recursiveBuild(c, r);
	}
	
	/**
	 * Method to address for building a path in the maze. Addresses the recursive build method.
	 * @param x next x position for the recursion algorithm to check
	 * @param y next y position for the recursion algorithm to check
	 */
	public void recursiveBuild(int x, int y){
		// we need 4 random directions
		int [] directions = directions();
		
		for (int i = 0; i < directions.length; i++){
			switch(directions[i]){
			//up
			case 1:
				if (y - 2 <= 0)
					continue;
				if (this.mazeArray[x][y-2] != 0){
					this.mazeArray[x][y-2] = 0;
					this.mazeArray[x][y-1] = 0;
					recursiveBuild(x,y-2);
				}
				break;
			//right
			case 2:
				if (x + 2 >= this.columns - 1)
					continue;
				if (this.mazeArray[x+2][y] != 0){
					this.mazeArray[x+2][y] = 0;
					this.mazeArray[x+1][y] = 0;
					recursiveBuild(x+2,y);
				}
				break;
			//down
			case 3:
				if (y + 2 >= this.rows - 1)
					continue;
				if (this.mazeArray[x][y+2] != 0){
					this.mazeArray[x][y+2] = 0;
					this.mazeArray[x][y+1] = 0;
					recursiveBuild(x,y+2);
				}
				break;
			//left
			case 4:
				if (x - 2 <= 0)
					continue;
				if (this.mazeArray[x-2][y] != 0){
					this.mazeArray[x-2][y] = 0;
					this.mazeArray[x-1][y] = 0;
					recursiveBuild(x-2,y);
				}
				break;
			}
		}
		
	}

	/**
	 * Creates an integer array with the numbers 1-4 in random order, but each occurring one time.
	 * @return int[][] with numbers 1,2,3,4 in random order
	 * @example [4,1,2,3] , [1,2,4,3] etc.
	 */
	private int[] directions() {
		int[] dirs = new int[]{1, 2, 3, 4};
		Random rgen = new Random();
		
		//Randomize the directions
		for (int i=0; i < 3; i++) {
			int randomPosition = rgen.nextInt(4);
			int temp = dirs[i];
			dirs[i] = dirs[randomPosition];
			dirs[randomPosition] = temp;
		}
		return dirs;
	}
	
	/**
	 * Creates the exit in the maze. Done by setting the bottom right values to 4.
	 */
	private void createExit() {
		this.mazeArray[columns-2][rows-2] = 4;	
	}
		
	/**
	 * Returns the matrix (maze array)
	 * @return int[][] with the maze
	 */
	public int[][] getMazeArray(){
		return this.mazeArray;
	}
	
	/**
	 * Check if there is a wall on the given location
	 * @param x
	 * @param y
	 * @return True is there is a wall, false if there isn't
	 */
	public boolean isWall(int x, int y){
		if(this.mazeArray[x][y] == 1){
			return true;
		}
		else return false;
	}
	
	/**
	 * Check if the exit is at the given location
	 * @param x
	 * @param y
	 * @return True if the exit is on the given location, false if not
	 */
	public boolean isEnd(int x, int y) {
		if(this.mazeArray[x][y] == 4){
			return true;
		}
		else return false;
	}
	
	/**
	 * Method to call to get the solution for a maze. Addresses the recursive solve method until a solution is found (or cannot be found)
	 * @param int[] location from where to start the maze solving algorithm (usually the player location).
	 * @return boolean[][] with the solution. True if the location is part of the solution path, false if not
	 */
	public boolean [][] solveMaze (int[] playerLoc){
		recursiveSolve(playerLoc[0], playerLoc[1]);
		return this.correctPath; 
	}
	
	/**
	 * Recursive solve algorithm for solving the maze.
	 * @param x int location (x-coordinate) to start searching
	 * @param y int location {y-coordinate) to start searching
	 * @return true if the exit can be found from the given location, false if not.
	 * @link https://en.wikipedia.org/wiki/Maze_solving_algorithm - source of the code
	 */
	public boolean recursiveSolve(int x, int y) {
	    if (x == endX && y == endY) return true; // If you reached the end
	    if (mazeArray[x][y] == 1 || wasHere[x][y]) return false;  
	    // If you are on a wall or already were here
	    wasHere[x][y] = true;
	    
        if (recursiveSolve(x-1, y) == true) { // Recalls method one to the left
            correctPath[x][y] = true; // Sets that path value to true;
            return true;
        }
        if (recursiveSolve(x+1, y) == true) { // Recalls method one to the right
            correctPath[x][y] = true;
            return true;
        }
        if (recursiveSolve(x, y-1) == true ) { // Recalls method one up
            correctPath[x][y] = true;
            return true;
        }
        if (recursiveSolve(x, y+1) == true) { // Recalls method one down
            correctPath[x][y] = true;
            return true;
        }
    return false;    
	}
	
	/**
	 * Removes the solution from the boolean arrays. Can be used to reset these arrays.
	 */
	public void removeSolution() {
		for (int y = 0; y < rows; y++){		
			for(int x = 0; x < columns; x++){
			this.correctPath[x][y] = false;
			this.wasHere[x][y] = false;
 			}	
		}
	}
	
	
	/**
	 * Used for printing the mazeArray via the console.
	 */
	public void printMaze(){
		for (int y = 0; y < rows; y++){		
			for(int x = 0; x < columns; x++){
			System.out.print(this.mazeArray[x][y] + " ");
			}
		System.out.println();	
		}	
	}
	
		
}