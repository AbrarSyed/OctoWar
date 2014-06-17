package com.github.abrarsyed.octowar;

import com.blastcube.Game;
import com.blastcube.component.SpriteComponent;
import com.blastcube.entity.Entity;
import com.blastcube.system.DrawingSystem;

public class OctoWarGame extends Game {
		
	public OctoWarGame() {
		addSprite("badlogic.jpg", 32, 16, 10);
		// Added last but drawn underneath
		addSprite("bear.png", -10, -10, 1);		
	}
	
	// Delete this, it's for testing.
	private void addSprite(String fileName, int x, int y, int z) {
		SpriteComponent s = new SpriteComponent(fileName);
		s.setX(x);
		s.setY(y);		
		s.setZ(z);
		this.addEntity(new Entity(s));
	}
}
