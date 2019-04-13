package maps;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Map1 implements MapsInterface{
	private Image background = new Image("data/map/background.png");
	//private Image ground = new Image("data/map/midle.png");
	//private SpriteSheet water;
	//private Image groundBegin = new Image("data/map/left.png");
	//private Image groundEnd = new Image("data/map/right.png");
	public Map1() throws SlickException {
	}
	
	@Override
	public Image getBackground() {
		return this.background;
	}
	
	
	
	
	/*public Image getGround() {
		return ground;
	}

	public SpriteSheet getWater() {
		return water;
	}

	public Image getGroundBegin() {
		return groundBegin;
	}

	public Image getGroundEnd() {
		return groundEnd;
	}
	
	
	*/
	
}
