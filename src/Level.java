import java.util.ArrayList;

public class Level {
	private int gridx, gridy;
	ArrayList<Integer> huisCoordX = new ArrayList();
	ArrayList<Integer> huisCoordY = new ArrayList();
	ArrayList<Integer> waterCoordX = new ArrayList();
	ArrayList<Integer> waterCoordY = new ArrayList();
	ArrayList<Integer> modderCoordX = new ArrayList();
	ArrayList<Integer> modderCoordY = new ArrayList();
	
	public ArrayList<Integer> getModderCoordY() {
		return modderCoordY;
	}
	public void setModderCoordY(ArrayList<Integer> modderCoordY) {
		this.modderCoordY = modderCoordY;
	}
	private int sintx, sinty;
	private int teBehalenPunten;
	
	public ArrayList<Integer> getWaterX() {
		return waterCoordX;
	}
	public void setWaterX(ArrayList<Integer> waterX) {
		this.waterCoordX = waterX;
	}
	public ArrayList<Integer> getWaterY() {
		return waterCoordY;
	}
	public ArrayList<Integer> getModderCoordX() {
		return modderCoordX;
	}
	public void setModderCoordX(ArrayList<Integer> modderCoordX) {
		this.modderCoordX = modderCoordX;
	}
	public void setWaterY(ArrayList<Integer> waterY) {
		this.waterCoordY = waterY;
	}
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
	public void setWaterInArray(int x, int y){
		waterCoordX.add(x);
		waterCoordY.add(y);
	}
	public void setModderInArray(int x, int y){
		modderCoordX.add(x);
		modderCoordY.add(y);
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
	public int getTeBehalenPunten() {
		return teBehalenPunten;
	}
	public void setTeBehalenPunten(int teBehalenPunten) {
		this.teBehalenPunten = teBehalenPunten;
	}

}
