import java.util.ArrayList;

public class Level {
	private int scoreVoorDrieSterren;
	private int gridx, gridy;
	boolean sintHeeftCadeaus = true;
	ArrayList<Integer> huisCoordX = new ArrayList();
	ArrayList<Integer> huisCoordY = new ArrayList();
	ArrayList<Integer> pakHuisCoordX = new ArrayList();
	ArrayList<Integer> pakHuisCoordY = new ArrayList();
	
	ArrayList<Integer> poolSteenCoordX = new ArrayList();
	ArrayList<Integer> poolSteenCoordY = new ArrayList();

	ArrayList<Integer> waterCoordX = new ArrayList();
	ArrayList<Integer> waterCoordY = new ArrayList();
	ArrayList<Integer> modderCoordX = new ArrayList();
	ArrayList<Integer> modderCoordY = new ArrayList();
	
	ArrayList<Integer> noordPoolX = new ArrayList();
	ArrayList<Integer> noordPoolY = new ArrayList();
	ArrayList<Integer> zuidPoolX = new ArrayList();
	ArrayList<Integer> zuidPoolY = new ArrayList();
	
	public ArrayList<Integer> getPakHuisCoordY() {
		return pakHuisCoordY;
	}
	public void setPakHuisCoordY(ArrayList<Integer> pakHuisCoordY) {
		this.pakHuisCoordY = pakHuisCoordY;
	}	
	public ArrayList<Integer> getModderCoordY() {
		return modderCoordY;
	}
	public void setModderCoordY(ArrayList<Integer> modderCoordY) {
		this.modderCoordY = modderCoordY;
	}
	private int sintx, sinty;
	private int teBehalenPunten;
	
	public int getScoreVoorDrieSterren() {
		return scoreVoorDrieSterren;
	}
	public void setScoreVoorDrieSterren(int scoreVoorDrieSterren) {
		this.scoreVoorDrieSterren = scoreVoorDrieSterren;
	}
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
	public void setPakHuisInArray(int x, int y){
		pakHuisCoordX.add(x);
		pakHuisCoordY.add(y);
	}
	public void setPoolSteenInArray(int x, int y){
		poolSteenCoordX.add(x);
		poolSteenCoordY.add(y);
	}
	public void setNoordPoolInArray(int x, int y){
		noordPoolX.add(x);
		noordPoolY.add(y);
	}
	public void setZuidPoolInArray(int x, int y){
		zuidPoolX.add(x);
		zuidPoolY.add(y);
	}
	public ArrayList<Integer> getPoolSteenCoordX() {
		return poolSteenCoordX;
	}
	public ArrayList<Integer> getNoordPoolX() {
		return noordPoolX;
	}
	public void setNoordPoolX(ArrayList<Integer> noordPoolX) {
		this.noordPoolX = noordPoolX;
	}
	public ArrayList<Integer> getNoordPoolY() {
		return noordPoolY;
	}
	public void setNoordPoolY(ArrayList<Integer> noordPoolY) {
		this.noordPoolY = noordPoolY;
	}
	public ArrayList<Integer> getZuidPoolX() {
		return zuidPoolX;
	}
	public void setZuidPoolX(ArrayList<Integer> zuidPoolX) {
		this.zuidPoolX = zuidPoolX;
	}
	public ArrayList<Integer> getZuidPoolY() {
		return zuidPoolY;
	}
	public void setZuidPoolY(ArrayList<Integer> zuidPoolY) {
		this.zuidPoolY = zuidPoolY;
	}
	public void setPoolSteenCoordX(ArrayList<Integer> poolSteenCoordX) {
		this.poolSteenCoordX = poolSteenCoordX;
	}
	public ArrayList<Integer> getPoolSteenCoordY() {
		return poolSteenCoordY;
	}
	public void setPoolSteenCoordY(ArrayList<Integer> poolSteenCoordY) {
		this.poolSteenCoordY = poolSteenCoordY;
	}
	public ArrayList<Integer> getPakHuisCoordX() {
		return pakHuisCoordX;
	}
	public void setPakHuisCoordX(ArrayList<Integer> pakHuisCoordX) {
		this.pakHuisCoordX = pakHuisCoordX;
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
