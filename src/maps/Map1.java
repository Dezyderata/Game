package maps;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Map1 implements MapsInterface{
	private Image background = new Image("data/map/background.png");
	private SpriteSheet ground = new SpriteSheet("data/map/03.png",100, 100);
	private Image map;
	public Map1() throws SlickException {
	}
	
	@Override
	public Image getBackground() {
		return this.background;
	}
	public SpriteSheet getGround() {
		return this.ground;
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
