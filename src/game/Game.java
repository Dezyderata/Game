package game;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.tiled.TiledMap;

import keyboard.Keyboard;
import maps.Map1;
import maps.MapsInterface;
import players.Player;
import players.PlayersInterface;

public class Game extends BasicGame {
	private MapsInterface map;
	private PlayersInterface player;
	private int delta;
	private SpriteSheet tileSet;
	private Shape circle;
	private Shape rectangle;
	private boolean collision;
	
	
	
	public Game(String title) {
		super(title);
	}
	
	@Override
	public void init(GameContainer container) throws SlickException {
		map = new Map1();
		player = new Player();
		tileSet = map.getGround();
		circle = new Circle(player.getPosX(), player.getPosY(), 100, 100);
		rectangle = new Rectangle(600, 800, 900, 200);
		


	}
	
	@Override
	public void render(GameContainer container, Graphics graphic) throws SlickException {
		map.getBackground().draw();
		player.getCurrentAnimation().draw(player.getPosX(), player.getPosY());
		tileSet.startUse();
		for(int i = 0; i < 19; i++) {
			if(i < 6 || i > 15) {
				tileSet.getSubImage(5, 0).drawEmbedded(100*i, 900, 100, 100);
			}else {
				if(i >= 6 && i <= 15) {
					tileSet.getSubImage(1, 0).drawEmbedded(100*i, 900, 100, 100);
					tileSet.getSubImage(5, 0).drawEmbedded(100*i, 800, 100, 100);
				}
			}
		}
		tileSet.endUse();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		circle.setCenterX((float)(player.getPosX())+100);
		circle.setCenterY((float)player.getPosY()+100);
		
		player.getCurrentAnimation().draw(player.getPosX(), player.getPosY());
		if(input.isKeyDown(Input.KEY_RIGHT) && collision == false) {player.moveRight(delta);}
		else if(input.isKeyDown(Input.KEY_LEFT) && collision == false) {player.moveLeft(delta);}
		
		collision = circle.intersects(rectangle);
		if(collision) {
		//	player.stop();
			System.out.println("Collision at x: " +player.getPosX()+" y: "+player.getPosY());
		}
	}
    @Override
    public void keyPressed(int key, char c) {
    	System.out.print("key "+key+" pressed " + c);
    	this.player.buttonPresedReaction(key, this.delta);

    }
    @Override
    public void keyReleased(int key, char c) {
    	System.out.print("key "+key+" reliest" + c);
    	player.buttonReliceReaction(key);
    }
}
