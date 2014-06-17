package com.blastcube.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.blastcube.component.SpriteComponent;
import com.blastcube.entity.Entity;

// Uses data-oriented architecture, meaning, we dissect
// entities and keep drawable components in a contiguous list.
public class DrawingSystem {

    private Map<Entity, SpriteComponent> entitySprites = new HashMap<Entity, SpriteComponent>();
    private List<SpriteComponent> spriteCache = new ArrayList<SpriteComponent>();
    private SpriteBatch batch;
    private int screenHeight;

    public DrawingSystem(Collection<Entity> entities) {
    	this.batch = new SpriteBatch();
    	this.screenHeight = Gdx.graphics.getHeight();
    	
    	for (Entity e : entities) {
			// Initialize all the sprites, etc. now that libGDX is ready.
    		if (e.has(SpriteComponent.class)) {
    			e.get(SpriteComponent.class).initialize();
    		}
    		this.addedEntity(e);
    	}    
    }
    
    // Hey, we added an entity. Cache it appropriately.
    public void addedEntity(Entity e) {
    	this.entitySprites.put(e, e.get(SpriteComponent.class));
    	this.sortAndCacheSprites();
    }

	public void draw() {
    	Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();		
				
    	// TODO: order by Z-index
    	for (SpriteComponent s : this.spriteCache) {
    		// Draw y-inverted (Y at the top-left corner)
    		int yPrime = this.screenHeight - s.getHeight() - s.getY();
    		batch.draw(s.getTexture(), s.getX(), yPrime);
    	}
    	
    	batch.end();
    }
	
	// Sort them by Z, and keep them contiguous.
	private void sortAndCacheSprites() {
		// This conversion is expensive, but gets us a sorted list.
		// TODO: pass in the new entity and re-sort just that guy.
		this.spriteCache = new ArrayList<SpriteComponent>(this.entitySprites.values());
    	Collections.sort(this.spriteCache, new Comparator<SpriteComponent>() {
    	     public int compare(SpriteComponent o1, SpriteComponent o2) {
    	    	 int z1 = o1.getZ();
    	    	 int z2 = o2.getZ();
    	    	 
    	         if(z1 == z2) {
    	             return 0;
    	         } else {
    	        	 return z1 < z2 ? -1 : 1;
    	         }
    	     }
    	});
	}
}
