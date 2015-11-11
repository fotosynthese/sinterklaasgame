import java.util.ArrayList;

public class Level {
	private int gridx, gridy;
	ArrayList<Integer> huisCoordX = new ArrayList();
	ArrayList<Integer> huisCoordY = new ArrayList();
	private int sintx, sinty;
	
	public ArrayList<Integer> getHuisCoordX() {
		return huisCoordX;
	}
	public void setHuisCoordX(ArrayList<Integer> huisCoordX) {
		this.huisCoordX = huisCoordX;
	}
	public ArrayList<Integer> getHuisCoordY() {
		return huisCoordY;
	}
	public void setHuisCoordY(ArrayList<Integer> huisCoordY) {
		this.huisCoordY = huisCoordY;
	}
	public int getGridx() {
		return gridx;
	}
	public void setGridx(int gridx) {
		this.gridx = gridx;
	}
	public int getGridy() {
		return gridy;
	}
	public void setGridy(int gridy) {
		this.gridy = gridy;
	}

	public void setHuisInArray(int x, int y){
		huisCoordX.add(x);
		huisCoordY.add(y);
	}
	
	public int getSintx() {
		return sintx;
	}
	public void setSintx(int sintx) {
		this.sintx = sintx;
	}
	public int getSinty() {
		return sinty;
	}
	public void setSinty(int sinty) {
		this.sinty = sinty;
	}

}
