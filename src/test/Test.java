package test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import game.Game;
import maps.Map1;
import maps.MapsInterface;
import players.Player;
import players.PlayersInterface;

public class Test {	
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Game("Setup test"));
		app.setDisplayMode(1900, 1000, false);
		app.start();
		
	}
}
