package test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import game.Game;

public class Test {	
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Game("Setup test"));
		app.setDisplayMode(1900, 1000, false);
		app.start();
		
	}
}
