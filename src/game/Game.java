package game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import maps.Map1;
import maps.MapsInterface;
import players.Player;
import players.PlayersInterface;

public class Game extends BasicGame {
	private MapsInterface map;
	private PlayersInterface player;
	private int delta;
	private int code;
	private List<Rectangle> listOfObstacles = new ArrayList<>();
	private boolean collision;
	
	
	
	public Game(String title) {
		super(title);
	}
	
	@Override
	public void init(GameContainer container) throws SlickException {
		map = new Map1();
		this.listOfObstacles = map.getCollisionAreas();
		player = new Player();
	}
	
	@Override
	public void render(GameContainer container, Graphics graphic) throws SlickException {
		map.getBackground().draw();
		player.getCurrentAnimation().draw(player.getPosX(), player.getPosY());
		map.getGround();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		code = checkCollision(this.player, this.listOfObstacles);
		player.getCurrentAnimation().draw(player.getPosX(), player.getPosY());
		if(input.isKeyDown(Input.KEY_RIGHT) && code!=1) {player.moveRight(delta);}
		else if(input.isKeyDown(Input.KEY_LEFT) && code!=2) {player.moveLeft(delta);}
		
		if(collision) {
			System.out.println("Collision at x: " +player.getPosX()+" y: "+player.getPosY());
		}
	}
    @Override
    public void keyPressed(int key, char c) {
    	System.out.print("key "+key+" pressed " + c);
    	code = checkCollision(this.player, this.listOfObstacles);
    	this.player.buttonPresedReaction(key, delta, code);

    }
    @Override
    public void keyReleased(int key, char c) {
    	System.out.print("key "+key+" reliest" + c);
    	player.buttonReliceReaction(key);
    }
    private int checkCollision(PlayersInterface player, List<Rectangle> listOfObstacles) {
    	int code = 0;
    	for(Rectangle r : listOfObstacles) {
    		if(player.getRight().intersects(r)){code = 1; break;}
    		else if(player.getLeft().intersects(r)){code = 2; break;}
    		else if(player.getUp().intersects(r)){code = 3; break;}
    		else if(player.getDown().intersects(r)){code = 4; break;}
    	}
    	return code;
    }
    
}
