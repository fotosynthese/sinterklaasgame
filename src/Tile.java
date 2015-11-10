
public class Tile {
	private int rcolor, gcolor, bcolor;
	boolean heeftHuis = false;
	boolean wilCadeau = false;
	
	public Tile(){
		rcolor = (int) (Math.random()*20 + 40);
		gcolor = (int) (Math.random()*20 + 180);
		bcolor = (int) (Math.random()*20 + 40);
		int a = (int) (Math.random()*3);
		if (a < 1){
			heeftHuis = true;
			wilCadeau = true;
		}
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

}
