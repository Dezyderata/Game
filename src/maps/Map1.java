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
	private Image thorns = new Image("data/map/thorns1.png");
	private SpriteSheet ground = new SpriteSheet("data/map/03.png",100, 100);


	public Map1() throws SlickException {
	}
	@Override
	public Image getBackground() {
		return this.background;	
	}

	@Override
	public void getGround(int page) {
		if(page == 1) {
			this.useGroundMap1Page1();
		}else {
			this.useGroundMap1Page2();
		}
	}
	private void useGroundMap1Page2() {
		ground.startUse();
		for(int i = 0; i < 19; i++) {
			if(i < 6) {
				if(i < 3){
					ground.getSubImage(5, 0).drawEmbedded(100*i, 400, 100, 100);
				}
				ground.getSubImage(5, 0).drawEmbedded(100*i, 900, 100, 100);
			}
			if(i >= 8) {
				ground.getSubImage(1, 0).drawEmbedded(100*i, 900, 100, 100);
				ground.getSubImage(5, 0).drawEmbedded(100*i, 800, 100, 100);
				if(i >= 10 && i < 16) {
					ground.getSubImage(5, 0).drawEmbedded(100*i, 500, 100, 100);
				}
			}
		}
		ground.endUse();
		thorns.draw(600, 962);
	}
	private void useGroundMap1Page1() {
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
				if(i >=8 && i <= 10) {
					ground.getSubImage(5, 0).drawEmbedded(100*i, 500, 100, 100);
				}
			}
		}
		ground.endUse();
	}
	@Override
	public List<Rectangle> getCollisionAreas(int page) {
		if(page == 1) {
			return this.getCollisionAreasMap1Page1();
		}
		return this.getCollisionAreasMap1Page2();
	}
	private List<Rectangle> getCollisionAreasMap1Page2(){
		List<Rectangle> collisionAreasMap1Page2 = new ArrayList<>();
		collisionAreasMap1Page2.add(new Rectangle(3800, 0, 1, 1000));
		collisionAreasMap1Page2.add(new Rectangle(1900, 0, 1900, 1));
		collisionAreasMap1Page2.add(new Rectangle(1900, 900, 600, 100));
		collisionAreasMap1Page2.add(new Rectangle(2700, 800, 1100, 200));
		collisionAreasMap1Page2.add(new Rectangle(1900, 400, 300, 100));
		collisionAreasMap1Page2.add(new Rectangle(2900, 500, 600, 100));
		collisionAreasMap1Page2.add(new Rectangle(2500, 972, 200, 50));
		return collisionAreasMap1Page2;
	}
	private List<Rectangle> getCollisionAreasMap1Page1() {
		List<Rectangle> collisionAreasMap1Page1 = new ArrayList<>();
		collisionAreasMap1Page1.add(new Rectangle(0, 0, 1, 1000));
		collisionAreasMap1Page1.add(new Rectangle(0, 0, 1900, 1));
		collisionAreasMap1Page1.add(new Rectangle(0, 900, 2000, 100));
		collisionAreasMap1Page1.add(new Rectangle(600, 800, 700, 200));
		collisionAreasMap1Page1.add(new Rectangle(800, 500, 300, 100));
		collisionAreasMap1Page1.add(new Rectangle(1300, 400, 700, 100));
		return collisionAreasMap1Page1;
	}	
}
