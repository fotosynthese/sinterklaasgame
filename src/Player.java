import java.util.ArrayList;

public class Player {
	private int id;
	private String name;
	ArrayList<Integer> levelProgres = new ArrayList();
	
	public Player(){
		name = "Churchill";
		
		for (int i = 0; i < 16; i++){
			levelProgres.add(1);	
		}
		levelProgres.set(0, 2);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getLevelProgres() {
		return levelProgres;
	}

	public void setLevelProgres(ArrayList<Integer> levelProgres) {
		this.levelProgres = levelProgres;
	}
	
}
