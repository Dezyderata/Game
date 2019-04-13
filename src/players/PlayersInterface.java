package players;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SpriteSheet;

public interface PlayersInterface {
	public void moveRight(int delat);
	public void moveLeft(int delat);
	public Animation getCurrentAnimation();
	public int getPosX();
	public int getPosY();
	public void buttonPresedReaction(int key, int delta);
	public void buttonReliceReaction(int key);
}