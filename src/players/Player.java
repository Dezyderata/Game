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
	static final int gravity = -2;
	private PlayerGraphics playerGraphics;
	private PlayerCollisionAreas collisionAreas;
	private Animation currentAnimation;
	private List<Double> velocity = new ArrayList<>();
	private int posX = 100;
	private int posY = 685;
	private double prevDelta;
	private double deltaT = 0.15;
	private boolean jumping;
	private boolean button = false;
	
	
	public Player() throws SlickException {
		this.playerGraphics = new PlayerGraphics(spritSheetsSize, listOfAnimationPaths);
		this.currentAnimation = this.playerGraphics.getIdleAnimation();
		this.velocity.add(0.0);
		this.velocity.add(0.0);
		this.collisionAreas = new PlayerCollisionAreas(this.posX, this.posY);
	}
	
	@Override
	public void buttonPresedReaction(int key, int delta, int code) {
		System.out.print("x pos = "+posX+ " Y pose "+posY);
		if(code == 0) {
			switch (key) {
	    	case 1:
	    		this.fire(delta);
	    		break;
	    	case 200:
	    		this.button = true;
	    		this.jump(delta, code);
	    		this.jumping = true;
	    		break;
	    	case 205:
	    		this.moveRight(delta);
	    		break;
	    	case 203:
	    		this.moveLeft(delta);
	    		break;
			}
	    }else {
				
	        switch (key) {
	        	case 1:
	        		this.fire(delta);
	        		break;
	        	case 200:
	        		if(code == 4) {
	        			this.velocity.set(1, 0.0);
	        			this.jumping = false;
	        			break;
	        		}
	        		if(code == 3) {
	        			this.velocity.set(1,-0.1);
	        			break;
	        		}
	        	case 205:
	        		if(code == 1) {
	        			this.velocity.set(0,-0.1);
	        			break;
	        		}
	        	case 203:
	        		if(code == 2) {
	        			this.velocity.set(0, 0.1);
	        			break;
	        		}
	        }
	    }	
	}
	@Override
	public void buttonReliceReaction(int key, int delta, int code) {
		if(!this.jumping || code == 4) {
			this.currentAnimation = this.playerGraphics.getIdleAnimation();
			this.backToIdle();
		}else {
			this.jump(delta, code);
		}
	}
	private void countDeltaT(int delta) {
		if((this.deltaT = delta - this.prevDelta)>0.15) {
			System.out.print("delta w p: "+ deltaT);
			this.deltaT = 0.15;
		}
		System.out.println("nowa delta: "+deltaT);
	}
	private void setNewPosition() {
		this.posX = (int) (this.posX + this.deltaT * this.velocity.get(0));
		if(jumping) {
			this.posY = (int) (this.posY + this.deltaT * this.velocity.get(1));
			this.velocity.set(1, (this.velocity.get(1) - gravity*this.deltaT));
		}
		System.out.println("positions:" +this.posX+" y: "+this.posY);
		this.collisionAreas.setPlayerCollisionAreas(this.posX, this.posY);		
		System.out.println("speed at x: "+velocity.get(0)+ " at y: " +velocity.get(1)+ "grav*delta: " +(gravity*this.deltaT));
	}
	@Override
	public void jump(int delta, int code) {
		if(code == 4) {
			System.out.println("kod 4");
			jumping = false;
			this.posY = this.posY -10;
			this.backToIdle();
		}else {
			//Dane na start
			if(velocity.get(1).equals(0.0) && this.button == true) {
				this.currentAnimation = this.playerGraphics.getJumpAnimation();
				this.prevDelta = delta-1;
				velocity.set(1, -30.0);
				System.out.print("x pos = "+posX+ " Y pose "+posY);
				button = false;
			}else if(velocity.get(0) < 0.0){
				this.currentAnimation = this.playerGraphics.getJumpingLeft();
			}else {
				this.currentAnimation = this.playerGraphics.getJumpingRight();
			}
			this.countDeltaT(delta);
			this.setNewPosition();
		}
	}
	private void backToIdle() {
		this.currentAnimation = this.playerGraphics.getIdleAnimation();
		this.velocity.set(0, 0.0);
		this.velocity.set(1, 0.0);
	}
	@Override
	public void moveRight(int delta) {
		this.currentAnimation = this.playerGraphics.getWalkAnimation();
		if(velocity.get(0).equals(0.0)) {
			this.prevDelta = delta-1;
		}
		velocity.set(0, 40.0);
		this.countDeltaT(delta);
		this.setNewPosition();
	}
	@Override
	public void moveLeft(int delta) {
		this.currentAnimation = this.playerGraphics.getWalkLeftAnimation();
		if(velocity.get(0).equals(0.0)) {
			this.prevDelta = delta-1;
		}
		velocity.set(0, -40.0);
		this.countDeltaT(delta);
		this.setNewPosition();
	}
	private void fire(int delta) {
		// TODO Auto-generated method stub
		
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
	public Shape collisionArea(int i) {
		Shape ret = null;
		switch(i){
			case 1:
				ret = this.collisionAreas.getUp();
				break;
			case 2:
				ret = this.collisionAreas.getRight();
				break;
			case 3:
				ret = this.collisionAreas.getDown();
				break;
			case 4:
				ret = this.collisionAreas.getLeft();
				break;
		}
		return ret;
	}
}