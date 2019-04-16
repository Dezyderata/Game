package maps;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Map1 implements MapsInterface{
	private Image background = new Image("data/map/background.png");
	private SpriteSheet ground = new SpriteSheet("data/map/03.png",100, 100);
	private List<Rectangle> collisionsAreasMap1 =  new ArrayList<>();
	public Map1() throws SlickException {
	}
	@Override
	public Image getBackground() {
		return this.background;	
	}
	private List<Rectangle> getMap1() {
		collisionsAreasMap1.add(new Rectangle(0, 900, 1900, 100));
		collisionsAreasMap1.add(new Rectangle(600, 800, 700, 200));
		collisionsAreasMap1.add(new Rectangle(800, 500, 400, 100));
		collisionsAreasMap1.add(new Rectangle(1300, 400, 700, 100));
		return collisionsAreasMap1;
	}
	@Override
	public void getGround() {
		ground.startUse();
		for(int i = 0; i < 19; i++) {
			if(i < 6 || i > 12) {
				ground.getSubImage(5, 0).drawEmbedded(100*i, 900, 100, 100);
				if(i >= 13 ) {
					ground.getSubImage(5, 0).drawEmbedded(100*i, 400, 100, 100);
				}
			}else {
				if(i >= 6 && i <= 12) {
					ground.getSubImage(1, 0).drawEmbedded(100*i, 900, 100, 100);
					ground.getSubImage(5, 0).drawEmbedded(100*i, 800, 100, 100);
				}
				if(i >=8 && i <= 11) {
					ground.getSubImage(5, 0).drawEmbedded(100*i, 500, 100, 100);
				}
			}
		}
		ground.endUse();
	}

	@Override
	public List<Rectangle> getCollisionAreas() {
		return this.getMap1(); 
	}
	
}
