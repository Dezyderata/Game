package players;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

class PlayerCollisionAreas {
	private List<Shape> listOfCollisionAreas = new ArrayList<>();
	PlayerCollisionAreas(int posX, int posY){
		
		this.listOfCollisionAreas.add(new Rectangle((posX+20), (posY + 185), 140, 30));
		this.listOfCollisionAreas.add(new Rectangle((posX+20), (posY+15), 150, 50));
		this.listOfCollisionAreas.add(new Rectangle((posX + 120), (posY+20), 50, 190));
		this.listOfCollisionAreas.add(new Rectangle((posX + 20), (posY + 190), 130, 10));
		this.listOfCollisionAreas.add(new Rectangle((posX + 10), (posY + 20), 50, 190));
	}
	void setPlayerCollisionAreas(int posX, int posY) {	
		Shape ground = new Rectangle((posX+20), (posY + 185), 140, 30);
		Shape up = new Rectangle((posX+20), (posY+15), 150, 50);
 		Shape right = new Rectangle((posX + 120), (posY+20), 50, 190);
 		Shape down = new Rectangle((posX + 20), (posY + 190), 130, 10);
		Shape left = new Rectangle((posX + 10), (posY + 20), 50, 190);
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
