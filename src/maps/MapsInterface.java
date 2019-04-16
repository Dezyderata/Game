package maps;

import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public interface MapsInterface {
	public Image getBackground();
	public void getGround();
	public List<Rectangle> getCollisionAreas();
}
