package com.github.abrarsyed.octowar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.blastcube.component.SpriteComponent;
import com.blastcube.entity.Entity;
import com.blastcube.system.DrawingSystem;

public class OctoWarGame extends ApplicationAdapter {
	
	private DrawingSystem drawing;
	
	@Override
	public void create () {
		drawing = new DrawingSystem(new SpriteBatch());
		addSprite("badlogic.jpg", 32, 16, 10);		
		addSprite("bear.png", 32, 32, 1);
	}

	@Override
	public void render () {
		drawing.draw();
	}
	
	// Delete this, it's for testing.
	private void addSprite(String fileName, int x, int y, int z) {
		SpriteComponent s = new SpriteComponent(fileName);
		s.setX(x);
		s.setY(y);		
		s.setZ(z);
		drawing.addEntity(new Entity(s));
	}
}
