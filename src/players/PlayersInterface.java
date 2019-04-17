package players;

import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Shape;

public interface PlayersInterface {
	public void moveRight();
	public void moveLeft();
	public Animation getCurrentAnimation();
	public int getPosX();
	public int getPosY();
	public void buttonPresedReaction(int key, List<Boolean> listOfCollisions);
	public void buttonReliceReaction(int key, List<Boolean> listOfCollisions);
	public List<Shape> getListOfCollisionAreas();
	public boolean isJumping();
	public void jump(List<Boolean> listOfCollisions);
	public void fall();
}
