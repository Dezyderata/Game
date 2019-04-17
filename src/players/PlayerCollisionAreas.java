package players;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

class PlayerCollisionAreas {
	private List<Shape> listOfCollisionAreas = new ArrayList<>();
	PlayerCollisionAreas(int posX, int posY){
		this.listOfCollisionAreas.add(new Circle((posX + 100), (posY + 180), 40, 40));
		this.listOfCollisionAreas.add(new Circle((posX + 100), (posY+60), 50, 50));
		this.listOfCollisionAreas.add(new Circle((posX + 120), (posY + 120), 50, 50));
		this.listOfCollisionAreas.add(new Circle((posX + 100), (posY + 195), 20, 20));
		this.listOfCollisionAreas.add(new Circle((posX + 40), (posY + 120), 50, 50));
	}
	void setPlayerCollisionAreas(int posX, int posY) {	
		Shape ground = new Circle((posX + 100), (posY + 180), 40, 40);
		Shape up = new Circle((posX + 100), (posY+60), 50, 50);
 		Shape right = new Circle((posX + 120), (posY + 120), 50, 50);
 		Shape down = new Circle((posX + 100), (posY + 195), 20, 20);
		Shape left = new Circle((posX + 40), (posY + 120), 50, 50);
		this.listOfCollisionAreas.set(0, ground);
		this.listOfCollisionAreas.set(1, up);
		this.listOfCollisionAreas.set(2, right);
		this.listOfCollisionAreas.set(3, down);
		this.listOfCollisionAreas.set(4, left);
	}
	public List<Shape> getListOfCollision(){
		return listOfCollisionAreas;
	}
}
