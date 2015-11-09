
public class Paard {
	private int x_positie;
	private int y_positie;
	
	public Paard(){
		x_positie = 2;
		y_positie = 2;
	}
	
	public void move(int a){
		switch(a){
		case 1:
			//Rechts Rechts Boven
			x_positie += 2;
			y_positie += 1;		
			break;
		case 2:
			//Rechts Rechts Onder
			x_positie += 2;
			y_positie -= 1;
			//viablePosition();
			break;
		case 3:
			//Rechts Onder Onder
			x_positie += 1;
			y_positie -= 2;		
			break;
		case 4:
			//Links Onder Onder
			x_positie -= 1;
			y_positie -= 2;		
			break;
		case 5:
			//Links Links Onder
			x_positie -= 2;
			y_positie -= 1;		
			break;
		case 6:
			//Links Links Boven
			x_positie -= 2;
			y_positie += 1;		
			break;
		case 7:
			//Links Boven Boven
			x_positie -= 1;
			y_positie += 2;		
			break;
		case 8:
			//Rechts Rechts Boven
			x_positie += 1;
			y_positie += 2;		
			break;
		default:
			System.out.println("Kan niet!");
		}
	}
	public void moveRechtsRechtsBoven(){
		x_positie += 2;
		y_positie += 1;
	}

	public int getX_positie() {
		return x_positie;
	}

	public void setX_positie(int x_positie) {
		this.x_positie = x_positie;
	}

	public int getY_positie() {
		return y_positie;
	}

	public void setY_positie(int y_positie) {
		this.y_positie = y_positie;
	}
	
}