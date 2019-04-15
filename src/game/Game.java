package game;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
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
	private Shape rectangle1;
	private Shape rectangle2;
	private Shape rectangle3;
	private Shape rectangle4;
	private boolean collision;
	
	
	
	public Game(String title) {
		super(title);
	}
	
	@Override
	public void init(GameContainer container) throws SlickException {
		map = new Map1();
		player = new Player();
		rectangle1 = new Rectangle(0, 900, 1900, 100);
		rectangle2  = new Rectangle(600, 800, 700, 200);
		rectangle3  = new Rectangle(800, 500, 400, 100);
		rectangle4  = new Rectangle(1300, 400, 700, 100);
	}
	
	@Override
	public void render(GameContainer container, Graphics graphic) throws SlickException {
		map.getBackground().draw();
		player.getCurrentAnimation().draw(player.getPosX(), player.getPosY());
		map.getGround();
		
		//graphic.fill(rectangle1);
		graphic.setColor(Color.blue);
		//graphic.fill(rectangle2);
		graphic.setColor(Color.orange);
		graphic.fill(rectangle3);
		graphic.setColor(Color.green);
		//graphic.fill(rectangle4);
		graphic.setColor(Color.white);
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		
		player.getCurrentAnimation().draw(player.getPosX(), player.getPosY());
		if(input.isKeyDown(Input.KEY_RIGHT) && !player.getRight().intersects(rectangle2)) {player.moveRight(delta);}
		else if(input.isKeyDown(Input.KEY_LEFT) && !player.getLeft().intersects(rectangle2)) {player.moveLeft(delta);}
		
		if(collision) {
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
