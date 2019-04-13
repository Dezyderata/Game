package game;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
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
	//private TiledMap tiledMap;
	
	public Game(String title) {
		super(title);
	}
	
	@Override
	public void init(GameContainer container) throws SlickException {
		map = new Map1();
		player = new Player();
		//tiledMap = new TiledMap("data/map/mapTitles/jeden19X10.tmx");


	}
	
	@Override
	public void render(GameContainer container, Graphics graphic) throws SlickException {
		map.getBackground().draw();
		//tiledMap.render(0, 0);
		player.getCurrentAnimation().draw(player.getPosX(), player.getPosY());
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		map.getBackground().draw();
		player.getCurrentAnimation().draw(player.getPosX(), player.getPosY());
		if(input.isKeyDown(Input.KEY_RIGHT)) {player.moveRight(delta);}
		else if(input.isKeyDown(Input.KEY_LEFT)) {player.moveLeft(delta);}
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
