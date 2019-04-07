package game;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

import keyboard.Keyboard;
import maps.Map1;
import maps.MapsInterface;
import players.Player;
import players.PlayersInterface;

public class Game extends BasicGame {
	private MapsInterface map;
	private PlayersInterface player;
	private boolean keyDownR = false;
	private boolean keyDownL = false;
	private int delta;
	public Game(String title) {
		super(title);
	}
	
	@Override
	public void init(GameContainer container) throws SlickException {
		map = new Map1();
		player = new Player();

	}
	
	@Override
	public void render(GameContainer container, Graphics graphic) throws SlickException {
		map.getBackground().draw();
		if(keyDownR) {
			player.getWalk().draw(player.getPosX(), player.getPosY());
		}else if(keyDownL) {
			player.getWalkLeft().draw(player.getPosX(), player.getPosY());
		}else {
			player.getIdle().draw(player.getPosX(), player.getPosY());
			
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();		
		if(input.isKeyDown(Input.KEY_RIGHT)) {
			keyDownR = true; 
			player.moveRight(delta);
		} else if(input.isKeyDown(Input.KEY_LEFT)) {
			keyDownL = true;
			player.moveLeft(delta);
		} else {
			keyDownR = false;
			keyDownL = false;
		}
	}
    @Override
    public void keyPressed(int key, char c) {
    	System.out.print("key "+key+" pressed " + c);
    	this.player.butonPresedReaction(key, this.delta);

    }
    @Override
    public void keyReleased(int key, char c) {
    	System.out.print("key "+key+" reliest" + c);
    }
}
