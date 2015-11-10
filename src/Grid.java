import java.util.ArrayList;

public class Grid {

	ArrayList<Integer> grid = new ArrayList<Integer>();
	private int grid_x;
	private int grid_y;
	ArrayList[][] table;
	
	public Grid(){
		grid_x = 10;
		grid_y = 10;
		table = new ArrayList[grid_x][grid_y];
		for(int i = 0; i < grid_x; i++){
			for(int j = 0; j < grid_y; j++){
				grid.add(0);
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
		int size_table = table.length;
		return Integer.toString(size) + " " + size_table;
	}
	
	
}
