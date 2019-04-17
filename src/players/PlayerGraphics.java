package players;

import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

final class PlayerGraphics {
	private Animation idleAnimation;
	private Animation walkAnimation;
	private Animation walkLeftAnimation;
	private Animation jumpAnimation;
	private Animation jumpingRight;
	private Animation jumpingLeft;
	
	PlayerGraphics(int[] spritSheetsSize, List<String> listOfAnimationAndImagesPaths) throws SlickException{
		this.idleAnimation = new Animation(new SpriteSheet(listOfAnimationAndImagesPaths.get(0), spritSheetsSize[0], spritSheetsSize[1]),100 );
		this.walkAnimation = new Animation(new SpriteSheet(listOfAnimationAndImagesPaths.get(1), spritSheetsSize[2], spritSheetsSize[3]), 100);
		this.walkLeftAnimation = new Animation(new SpriteSheet(listOfAnimationAndImagesPaths.get(2), spritSheetsSize[4], spritSheetsSize[5]), 100);
		this.jumpAnimation = new Animation(new SpriteSheet(listOfAnimationAndImagesPaths.get(3), spritSheetsSize[6], spritSheetsSize[7]), 100);
		this.jumpingRight = new Animation(new SpriteSheet(listOfAnimationAndImagesPaths.get(4), spritSheetsSize[6], spritSheetsSize[7]), 100);
		this.jumpingLeft = new Animation(new SpriteSheet(listOfAnimationAndImagesPaths.get(5), spritSheetsSize[6], spritSheetsSize[7]), 100);
	}
	Animation getIdleAnimation() {
		return idleAnimation;
	}
	Animation getWalkAnimation() {
		return walkAnimation;
	}
	Animation getWalkLeftAnimation() {
		return walkLeftAnimation;
	}
	Animation getJumpAnimation() {
		return jumpAnimation;
	}
	Animation getJumpingRight() {
		return jumpingRight;
	}
	Animation getJumpingLeft() {
		return jumpingLeft;
	}
}
