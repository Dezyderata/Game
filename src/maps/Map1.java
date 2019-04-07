package maps;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Map1 implements MapsInterface{
	private Image background;
	private SpriteSheet ground;
	private SpriteSheet mountain1;
	private SpriteSheet mountain2;
	private SpriteSheet water;
	private SpriteSheet groundBegin;
	private SpriteSheet endGround;
	public Map1() throws SlickException {
		this.background = new Image("data/background.png");
	}
	public Image getBackground() {
		return background;
	}
	public void setBackground(Image background) {
		this.background = background;
	}
	public SpriteSheet getGround() {
		return ground;
	}
	public void setGround(SpriteSheet ground) {
		this.ground = ground;
	}
	public SpriteSheet getMountain1() {
		return mountain1;
	}
	public void setMountain1(SpriteSheet mountain1) {
		this.mountain1 = mountain1;
	}
	public SpriteSheet getMountain2() {
		return mountain2;
	}
	public void setMountain2(SpriteSheet mountain2) {
		this.mountain2 = mountain2;
	}
	public SpriteSheet getWater() {
		return water;
	}
	public void setWater(SpriteSheet water) {
		this.water = water;
	}
	public SpriteSheet getGroundBegin() {
		return groundBegin;
	}
	public void setGroundBegin(SpriteSheet groundBegin) {
		this.groundBegin = groundBegin;
	}
	public SpriteSheet getEndGround() {
		return endGround;
	}
	public void setEndGround(SpriteSheet endGround) {
		this.endGround = endGround;
	}

}
