package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import maps.Map1;
import maps.MapsInterface;
import players.Player;
import players.PlayersInterface;

public class Game extends BasicGame {
	private MapsInterface map;
	private PlayersInterface player;
	private List<Rectangle> listOfObstacles = new ArrayList<>();
	private List<Boolean> listOfCollisions = new ArrayList<Boolean>(Arrays.asList(new Boolean[5]));
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
		if(player.getPosX() < 1900) {
			map.getGround(1);
			this.listOfObstacles = map.getCollisionAreas(1);
			player.getCurrentAnimation().draw(player.getPosX(), player.getPosY());
		}else {
			map.getGround(2);
			this.listOfObstacles = map.getCollisionAreas(2);
			player.getCurrentAnimation().draw(player.getPosX()-1900, player.getPosY());			
		}
		for(Shape s : this.listOfObstacles) {
			graphic.draw(new Rectangle(s.getX()-1900,s.getY(),s.getWidth(), s.getHeight()));
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		this.checkCollision(this.player, this.listOfObstacles);
		if(this.listOfCollisions.get(0) && !player.isJumping()) {
			player.fall();
		}
		if(player.isJumping()) {
			player.jump(this.listOfCollisions);
		}
		if(input.isKeyDown(Input.KEY_RIGHT) && !this.listOfCollisions.get(2)) {player.moveRight();}
		else if(input.isKeyDown(Input.KEY_LEFT) && !this.listOfCollisions.get(4)) {player.moveLeft();}
	}
    @Override
    public void keyPressed(int key, char c) {
    	this.checkCollision(this.player, this.listOfObstacles);
    	this.player.buttonPresedReaction(key, this.listOfCollisions);

    }
    @Override
    public void keyReleased(int key, char c) {
    	player.buttonReliceReaction(key, this.listOfCollisions);
    }
    private void checkCollision(PlayersInterface player, List<Rectangle> listOfObstacles) {
    	Collections.fill(this.listOfCollisions, false);
    	this.listOfCollisions.set(0, true);
    	for(Shape shape : player.getListOfCollisionAreas()) {
    		for(Rectangle r : listOfObstacles) {
				if(shape.intersects(r)){
	    			int i;
					if((i = player.getListOfCollisionAreas().indexOf(shape)) > 0) {
						this.listOfCollisions.set(i, true);
						break;
					}else{
						this.listOfCollisions.set(0, false);
					}
    			}
    		}
    	}
    }
    
}
