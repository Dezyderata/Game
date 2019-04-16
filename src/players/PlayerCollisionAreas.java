package players;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

class PlayerCollisionAreas {
	private Shape right;
	private Shape left;
	private Shape up;
	private Shape down;
	PlayerCollisionAreas(int posX, int posY){
		this.right = new Circle((posX + 100), (posY + 80), 50, 50);
		this.left = new Circle(posX, (posY + 80), 50, 50);
		this.up = new Circle((posX + 50), posY, 50, 50);
		this.down = new Circle((posX + 50), (posY + 113), 50, 50);
	}
	void setPlayerCollisionAreas(int posX, int posY) {
		this.right.setLocation((posX + 100), (posY + 80));
		this.left.setLocation(posX, (posY + 80));
		this.up.setLocation((posX + 50), posY);
		this.down.setLocation((posX + 50), (posY + 113));
	}
	public Shape getRight() {
		return right;
	}
	public Shape getLeft() {
		return left;
	}
	public Shape getUp() {
		return up;
	}
	public Shape getDown() {
		return down;
	}
}
