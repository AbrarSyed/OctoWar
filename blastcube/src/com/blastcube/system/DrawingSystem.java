package com.blastcube.system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.blastcube.component.SpriteComponent;
import com.blastcube.entity.Entity;

import java.util.HashMap;
import java.util.Map;

// Uses data-oriented architecture, meaning, we dissect
// entities and keep drawable components in a contiguous list.
public class DrawingSystem {

    private Map<Entity, SpriteComponent> entitySprites = new HashMap<Entity, SpriteComponent>();
    private SpriteBatch batch;
    private int screenHeight;

    public DrawingSystem(SpriteBatch batch) {
    	this.batch = batch;
    	this.screenHeight = Gdx.graphics.getHeight();
    }
    
    public void initialize(Entity[] entities) {
    	for (Entity e : entities) {
    		this.addEntity(e);
    	}
    }
    
    public void addEntity(Entity e) {
    	this.entitySprites.put(e, e.get(SpriteComponent.class));
    }

    public void draw() {
    	Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();		
				
    	// TODO: order by Z-index
    	for (SpriteComponent s : this.entitySprites.values()) {
    		// Draw y-inverted (Y at the top-left corner)
    		int yPrime = this.screenHeight - s.getHeight();
    		batch.draw(s.getTexture(), 0, yPrime);
    	}
    	
    	batch.end();
    }
}
