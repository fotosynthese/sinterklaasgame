
public class Tile {
	private int rcolor, gcolor, bcolor;
	boolean heeftHuis = false;
	boolean heeftPakHuis = false;
	boolean wilCadeau = false;
	boolean isWater = false;
	boolean  Wortel = false;
	boolean isModder = false;
	boolean heeftGras = false;
	private int xCoord, yCoord;
	boolean noordPool = true; // als een tegel mee doet aan de PoolSteen, moet deze of de zuid op false gezet worden.
	boolean zuidPool = true;
	boolean heeftPoolsteen = false;
	static int statusPoolsteen = 0; //0= NoordPool aan, 1= ZuidPool aan
	int a;
	
	public Tile(){
		rcolor = (int) (Math.random()*20 + 40);
		gcolor = (int) (Math.random()*20 + 180);
		bcolor = (int) (Math.random()*20 + 40);
//		a = (int) (Math.random()*5);
//		if (a==1){
//			heeftGras = true;
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
