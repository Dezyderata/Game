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
	
}
