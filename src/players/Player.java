package players;

import java.util.Vector;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Player implements PlayersInterface {
	private static final int gravity = -2;
	private Vector<Integer> velocity = new Vector<>();
	private int posX = 100;
	private int posY = 700;
	private int prevDelta;
	private double deltaT = 0.15;
	private Animation idleAnimation;
	private Animation walkAnimation;
	private Animation walkLeftAnimation;
	private Animation jumpAnimation;
	private Animation fire;
	public Player() throws SlickException {
		this.idleAnimation = new Animation(new SpriteSheet("data/player1/IDLE.png", 200,217), 100);
		//this.idleAnimation.setPingPong(true);
		this.walkAnimation = new Animation(new SpriteSheet("data/player1/WALK.png", 200,238), 100);
		//this.walkAnimation.setPingPong(true);
		this.walkLeftAnimation = new Animation(new SpriteSheet("data/player1/WALK_L.png", 200,238), 100);
		//this.walkLeftAnimation.setPingPong(true);
		this.jumpAnimation = new Animation(new SpriteSheet("data/player1/JUMP.png", 200,248), 100);
		//this.jumpAnimation.setPingPong(true);
		this.velocity.add(0);
		this.velocity.add(0);
	}
	public void butonPresedReaction(int key, int delta) {
        switch (key) {
        	case 1:
        		this.fire(delta);
        		break;
        	case 200:
        		this.jump(delta);	
        		break;
        }
	}
	public void buttonReliceReaction(int key) {
		this.backToIdle();
	}
	private void countDeltaT(int delta) {
		if((this.deltaT = delta - this.prevDelta)>0.15) {
			this.deltaT = 0.15;
		}
	}
	private void setNewPosition() {
		this.posX = (int) (this.posX + this.deltaT * this.velocity.get(0));
		this.posY = (int) (this.posY + this.deltaT * this.velocity.get(1));
		this.velocity.setElementAt((int) (this.velocity.elementAt(1)+gravity*this.deltaT), 1);
	}
	
	@Override
	public void moveRight(int delta) {
		velocity.setElementAt(40, 0);
		this.countDeltaT(delta);
		this.setNewPosition();
	}
	@Override
	public void moveLeft(int delta) {
		velocity.setElementAt(-40, 0);
		this.countDeltaT(delta);
		this.setNewPosition();
	}
	@Override
	public void jump(int delta) {
		if(velocity.elementAt(1).equals(0)) {
			velocity.setElementAt(-20, 1);
		}
		this.countDeltaT(delta);
		this.setNewPosition();
	}
	@Override
	public void fire(int delta) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void backToIdle() {
		this.velocity.setElementAt(0, 0);
		this.velocity.setElementAt(0, 1);
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
	public Animation getJump() {
		return this.jumpAnimation;
	}
	@Override
	public Animation getIdle() {
		return this.idleAnimation;
	}
	@Override
	public Animation getWalk() {
		return this.walkAnimation;
	}
	@Override
	public Animation getWalkLeft() {
		return this.walkLeftAnimation;
	}
}