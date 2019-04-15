package players;

import java.util.Vector;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Circle;

public class Player implements PlayersInterface {
	private static final int gravity = -2;
	private Vector<Integer> velocity = new Vector<>();
	private int posX = 100;
	private int posY = 685;
	private int prevDelta;
	private double deltaT = 0.15;
	private Animation idleAnimation = new Animation(new SpriteSheet("data/player1/IDLE.png", 200,217), 100);
	private Animation walkAnimation = new Animation(new SpriteSheet("data/player1/WALK.png", 200,238), 100);
	private Animation walkLeftAnimation = new Animation(new SpriteSheet("data/player1/WALK_L.png", 200,238), 100);
	private Animation jumpAnimation = new Animation(new SpriteSheet("data/player1/JUMP.png", 200,248), 100);
	private Animation fire;
	private Animation currentAnimation;
	private Shape right;
	private Shape left;
	private Shape up;
	private Shape down;
	
	
	public Player() throws SlickException {
		this.currentAnimation = this.idleAnimation;
		this.velocity.add(0);
		this.velocity.add(0);
		this.right = new Circle((this.posX + 100), (this.posY + 80), 50, 50);
		this.left = new Circle(this.posX, (this.posY + 80), 50, 50);
		this.up = new Circle((this.posX + 50), this.posY, 50, 50);
		this.down = new Circle((this.posX + 50), (this.posY + 113), 50, 50);
	}
	
	@Override
	public void buttonPresedReaction(int key, int delta) {
		System.out.print("x pos = "+posX+ " Y pose "+posY);
        switch (key) {
        	case 1:
        		this.fire(delta);
        		break;
        	case 200:
        		this.jump(delta);
        		break;
        	case 205:
        		this.moveRight(delta);
        		break;
        	case 203:
        		this.moveLeft(delta);
        		break;
        }
	}
	@Override
	public void buttonReliceReaction(int key) {
		this.currentAnimation = this.idleAnimation;
		this.backToIdle();
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
		this.posY = (int) (this.posY + this.deltaT * this.velocity.get(1));
		this.right.setLocation((this.posX + 100), (this.posY + 80));
		this.left.setLocation(this.posX, (this.posY + 80));
		this.up.setLocation((this.posX + 50), this.posY);
		this.down.setLocation((this.posX + 50), (this.posY + 113));
		System.out.print("x pos = "+posX+ " Y pose "+posY);
		this.velocity.setElementAt((int) (this.velocity.elementAt(1)+gravity*this.deltaT), 1);
	}
	private void jump(int delta) {
		this.currentAnimation = this.jumpAnimation;
		//Dane na start
		if((int)velocity.elementAt(1) == 0) {
			this.prevDelta = delta-1;
			velocity.setElementAt(-20, 1);
			System.out.print("x pos = "+posX+ " Y pose "+posY);
		}
		this.countDeltaT(delta);
		this.setNewPosition();
	}
	private void backToIdle() {
		this.velocity.setElementAt(0, 0);
		this.velocity.setElementAt(0, 1);
	}
	@Override
	public void moveRight(int delta) {
		this.currentAnimation = this.walkAnimation;
		if((int)velocity.elementAt(0) == 0) {
			this.prevDelta = delta-1;
		}
		velocity.setElementAt(40, 0);
		this.countDeltaT(delta);
		this.setNewPosition();
	}
	@Override
	public void moveLeft(int delta) {
		this.currentAnimation = this.walkLeftAnimation;
		if((int)velocity.elementAt(0) == 0) {
			this.prevDelta = delta-1;
		}
		velocity.setElementAt(-40, 0);
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
	public Shape getRight() {
		return right;
	}

	@Override
	public Shape getLeft() {
		return this.left;
	}

	@Override
	public Shape getUp() {
		return this.up;
	}

	@Override
	public Shape getDown() {
		return this.down;
	}
}