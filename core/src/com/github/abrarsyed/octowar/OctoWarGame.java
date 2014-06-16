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
		drawing.addEntity(new Entity(new SpriteComponent("badlogic.jpg")));
	}

	@Override
	public void render () {
		drawing.draw();
	}
}
