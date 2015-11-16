
public class Tile {
	private int rcolor, gcolor, bcolor;
	boolean heeftHuis = false;
	boolean wilCadeau = false;
	boolean isWater = false;
	boolean  Wortel = false;
	boolean isModder = false;
	private int xCoord, yCoord;
	
	public Tile(){
		rcolor = (int) (Math.random()*20 + 40);
		gcolor = (int) (Math.random()*20 + 180);
		bcolor = (int) (Math.random()*20 + 40);
//		int a = (int) (Math.random()*10);
//		if (a < 0){
//			if (!heeftHuis){
//				isWater = true;
//			}
			//isWater = true;
			//heeftHuis = true;
			//wilCadeau = true;
//		}
	}
	public Tile(int x, int y){
		this();
		xCoord = x;
		yCoord = y;
	}
	
	public int getRcolor() {
		return rcolor;
	}
	public void setRcolor(int rcolor) {
		this.rcolor = rcolor;
	}
	public int getGcolor() {
		return gcolor;
	}
	public void setGcolor(int gcolor) {
		this.gcolor = gcolor;
	}
	public int getBcolor() {
		return bcolor;
	}
	public void setBcolor(int bcolor) {
		this.bcolor = bcolor;
	}
	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

}
