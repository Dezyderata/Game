package players;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public class Player implements PlayersInterface {
	private final List<String> listOfAnimationPaths = Arrays.asList("data/player1/IDLE.png", "data/player1/WALK.png", "data/player1/WALK_L.png", "data/player1/JUMP.png", "data/player1/jumpR.png", "data/player1/jumpL.png");
	private final int[] spritSheetsSize = {200,217, 200,238, 200,238, 200,248};
	static final int gravity = -6;
	private PlayerGraphics playerGraphics;
	private PlayerCollisionAreas collisionAreas;
	private Animation currentAnimation;
	private List<Double> velocity = new ArrayList<>();
	private int posX = 100;
	private int posY = 685;
	private double deltaT = 0.15;
	private boolean jumping;
	private boolean button = false; 
	private boolean fall = false;
	public Player() throws SlickException {
		this.playerGraphics = new PlayerGraphics(spritSheetsSize, listOfAnimationPaths);
		this.currentAnimation = this.playerGraphics.getIdleAnimation();
		this.velocity.add(0.0);
		this.velocity.add(0.0);
		this.collisionAreas = new PlayerCollisionAreas(this.posX, this.posY);
	}
	
	@Override
	public void buttonPresedReaction(int key, List<Boolean> listOfCollisions) {
		if(!listOfCollisions.contains(true)) {
			switch (key) {
		    	case 200:
		    		this.button = true;
		    		this.jump(listOfCollisions);
		    		this.jumping = true;
		    		break;
		    	case 205:
		    		this.moveRight();
		    		break;
		    	case 203:
		    		this.moveLeft();
		    		break;
				}
	    }else {	
	        switch (key) {
	        	case 200:
	        		if(listOfCollisions.get(1)) {
	        			this.velocity.set(1,-0.1);
	        			break;
	        		}
	        	case 205:
	        		if(listOfCollisions.get(2)) {
	        			this.velocity.set(0,0.0);
	        			break;
	        		}
	        	case 203:
	        		if(listOfCollisions.get(4)) {
	        			this.velocity.set(0, 0.0);
	        			break;
	        		}
	        }
	    }	
	}
	@Override
	public void buttonReliceReaction(int key, List<Boolean> listOfCollisions) {
		if(!this.jumping || listOfCollisions.get(3)) {
			this.currentAnimation = this.playerGraphics.getIdleAnimation();
			this.backToIdle();
		}else {
			this.jump(listOfCollisions);
		}
	}
	private void setNewPosition() {
		this.posX = (int) (this.posX + this.deltaT * this.velocity.get(0));
		if(jumping || fall) {
			this.posY = (int) (this.posY + this.deltaT * this.velocity.get(1));
			this.velocity.set(1, (this.velocity.get(1) - gravity*this.deltaT));
			fall = false;
		}
		this.collisionAreas.setPlayerCollisionAreas(this.posX, this.posY);		
	}
	@Override
	public void fall() {
		this.velocity.set(1, 20.0);
		fall = true;
		this.setNewPosition();
	}
	@Override
	public void jump(List<Boolean> listOfCollisions) {
		if(listOfCollisions.get(3)) {
			jumping = false;
			fall = false;
			this.posY = (int)this.collisionAreas.getListOfCollision().get(0).getY()-210;
			this.collisionAreas.setPlayerCollisionAreas(this.posX, this.posY);
			this.backToIdle();
		}else {
			if(velocity.get(1).equals(0.0) && this.button == true) {
				this.currentAnimation = this.playerGraphics.getJumpAnimation();
				velocity.set(1, -60.0);
				button = false;
			}else if(listOfCollisions.get(1)){
				velocity.set(1, 20.0);
			}else if(velocity.get(0) < 0.0){
				this.currentAnimation = this.playerGraphics.getJumpingLeft();
				if(listOfCollisions.get(4)) {
					velocity.set(0, 2.0);
				}
			}else {
				this.currentAnimation = this.playerGraphics.getJumpingRight();
				if(listOfCollisions.get(2)) {
					velocity.set(0, -2.0);
				}
			}
			this.setNewPosition();
		}
	}
	private void backToIdle() {
		this.currentAnimation = this.playerGraphics.getIdleAnimation();
		this.velocity.set(0, 0.0);
		this.velocity.set(1, 0.0);
	}
	@Override
	public void moveRight() {
		this.currentAnimation = this.playerGraphics.getWalkAnimation();
		velocity.set(0, 40.0);
		this.setNewPosition();
	}
	@Override
	public void moveLeft() {
		this.currentAnimation = this.playerGraphics.getWalkLeftAnimation();
		velocity.set(0, -40.0);
		this.setNewPosition();
	}
	@Override
	public int getPosX() {
		return this.posX;
	}

	@Override
	public int getPosY() {
		return this.posY;
	}
	@Override
	public Animation getCurrentAnimation() {
		return this.currentAnimation;
	}

	@Override
	public boolean isJumping() {
		return this.jumping;
	}
	@Override
	public List<Shape> getListOfCollisionAreas() {
		return this.collisionAreas.getListOfCollision();
	}
}