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
	
	private DrawingSystem drawingSystem;
	private Collection<Entity> entities = new ArrayList<Entity>();
	private Scene currentScene = null;
	private static Game instance;
	
	public Game() {
		instance = this;
	}
	
	@Override
	public void create() {
		this.drawingSystem = new DrawingSystem(this.entities);
	}

	@Override
	public void render() {
		this.drawingSystem.draw();
	}
	
	public static void showScene(Scene s) {
		instance.show(s);
	}
	
	public void show(Scene s) {
		if (currentScene != null) {
			currentScene.dispose();
		}
		
		currentScene = s;
		this.entities.addAll(s.getEntities());
	}
	
	protected void addEntity(Entity e) {
		this.entities.add(e);
		// No worries if null, the drawing system constructor adds it.
		if (this.drawingSystem != null) {
			this.drawingSystem.addedEntity(e);
		}
	}
}
