import java.util.ArrayList;

public class Grid {

	ArrayList<Tile> grid = new ArrayList<Tile>();
	private int grid_x;
	private int grid_y;
	
	public Grid(){
		grid_x = 10;
		grid_y = 10;
		for(int i = 0; i < grid_x; i++){
			for(int j = 0; j < grid_y; j++){
				Tile tile = new Tile();
				grid.add(tile);
			}
		}
	}
	
	public int getGrid_x() {
		return grid_x;
	}

	public void setGrid_x(int grid_x) {
		this.grid_x = grid_x;
	}

	public int getGrid_y() {
		return grid_y;
	}

	public void setGrid_y(int grid_y) {
		this.grid_y = grid_y;
	}
	
	public String toString(){
		int size = grid.size();
		return Integer.toString(size);
	}
}
