package players;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SpriteSheet;

public interface PlayersInterface {
	public void moveRight(int delat);
	public void moveLeft(int delat);
	public Animation getIdle();
	public Animation getWalk();
	public Animation getWalkLeft();
	public Animation getJump();
	public int getPosX();
	public int getPosY();
	public void jump(int delta);
	public void fire(int delta);
	public void backToIdle();
	public void butonPresedReaction(int key, int delta);
	public void buttonReliceReaction(int key);
}
