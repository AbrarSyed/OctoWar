package com.blastcube;

import java.util.ArrayList;
import java.util.Collection;

import com.badlogic.gdx.ApplicationAdapter;
import com.blastcube.entity.Entity;
import com.blastcube.system.DrawingSystem;

// Extend this class for your game. It's a swappable extension.
// You will get (eventually) free stuff like scaling up/down
// in the right aspect ratio, to fit your device screen.
public abstract class Game  extends ApplicationAdapter {
	
	private DrawingSystem drawing;
	private Collection<Entity> entities = new ArrayList<Entity>();
	
	@Override
	public void create() {
		this.drawing = new DrawingSystem(this.entities);
	}

	@Override
	public void render() {
		this.drawing.draw();
	}		
	
	protected void addEntity(Entity e) {
		this.entities.add(e);
		if (this.drawing != null) {
			this.drawing.addedEntity(e);
		}
	}
}
