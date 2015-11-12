/**
 * Creates the player object in the maze and allows to move the player in the maze.
 * <p>
 * This class is used to create and use a Player object in a maze (matrix with zeros for paths and ones for walls).
 * This class will allow movement of a player object through that maze. Can reset the player position to start position
 * and can return the current position of the player.
 *   
 *
 * @version 1.0 01 Aug 2015
 * @author Jan Jaap Zoutendijk
 */

package MazeGame;

public class Player {
	private int[] pos = new int[2];
	private Maze level1;
	private int[][] mazeArray;
		
	/**
	 * Initializes the player in the maze and sets the current position to the top left corner [1,1]
	 * @param maze
	 */
	Player(Maze maze){
		//initialize player in the top left corner
		pos[0] = 1;
		pos[1] = 1;
		this.level1 = maze;		
		this.mazeArray = level1.getMazeArray();
		this.mazeArray[1][1] = 3;
	}
	
	/**
	 * Moves the player in the direction given:
	 * 1 - Up
	 * 2 - Right
	 * 3 - Down
	 * 4 - Left
	 * Checks if the location is a wall and if not moves the player to that location
	 * 
	 * @param d Direction in which the player wants to move: 1: up, 2 right, 3 down, 4 left
	 */
	
	public void movePlayer(int d){
		//current player position
		int x1 = pos[0];
		int y1 = pos[1];
		
		//new player position
		int x2,y2;
		
		switch (d){			
			case 1: //up
				x2 = x1;
				y2 = y1-1;
				if (level1.isEnd(x2,y2) == true){
					System.exit(0);
				}
				if (level1.isWall(x2, y2) == false){
					this.pos[1] = y2;
					this.mazeArray[x2][y2] = 3;
					if(this.mazeArray[x1][y1] == 3){
						this.mazeArray[x1][y1] = 0;
					}
				}
	
				break;				
			case 2: //right
				x2 = x1+1;
				y2 = y1;				
				if (level1.isEnd(x2,y2) == true){
					System.exit(0);
				}
				if (level1.isWall(x2, y2) == false){
					this.pos[0] = x2;
					this.mazeArray[x2][y2] = 3;
					if(this.mazeArray[x1][y1] == 3){
						this.mazeArray[x1][y1] = 0;
					}
				}

				break;	
			case 3: //down
				x2 = x1;
				y2 = y1+1;
				if (level1.isEnd(x2,y2) == true){
					System.exit(0);
				}
				if (level1.isWall(x2, y2) == false){
					this.pos[1] = y2;
					this.mazeArray[x2][y2] = 3;
					if(this.mazeArray[x1][y1] == 3){
						this.mazeArray[x1][y1] = 0;
					}
				}

				break;	
			case 4: //left
				x2 = x1-1;
				y2 = y1;
				if (level1.isEnd(x2,y2) == true){
					System.exit(0);
				}
				if (level1.isWall(x2, y2) == false){
					this.pos[0] = x2;
					this.mazeArray[x2][y2] = 3;
					if(this.mazeArray[x1][y1] == 3){
						this.mazeArray[x1][y1] = 0;
					}
				}
				break;
			}
		}
	
	/**
	 * Resets the player to the start position [1,1]
	 */
	public void resetPlayer(){
		mazeArray[this.pos[0]][this.pos[1]] = 0;
		this.pos[0] = 1;
		this.pos[1] = 1;
		this.mazeArray[1][1] = 3;
	}
	
	/**
	 * Returns the current position of the player within the maze
	 * @return int[] with the player location. [0] = x-coordinate, [1] = y-coordinate
	 */
	public int[] getLocation(){
		return this.pos;
	}
	
}
