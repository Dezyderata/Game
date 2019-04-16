package players;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Shape;

public interface PlayersInterface {
	public void moveRight(int delat);
	public void moveLeft(int delat);
	public Animation getCurrentAnimation();
	public int getPosX();
	public int getPosY();
	public void buttonPresedReaction(int key, int delta, int code);
	public void buttonReliceReaction(int key, int delta, int code);
	public Shape collisionArea(int i);
	public boolean isJumping();
	public void jump(int delta, int code);
}
