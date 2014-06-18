package com.blastcube;

import java.util.ArrayList;
import java.util.Collection;

import com.badlogic.gdx.ApplicationAdapter;
import com.blastcube.entity.Entity;
import com.blastcube.system.DrawingSystem;
import com.blastcube.system.InputSystem;

// Extend this class for your game. It's a swappable extension.
// You will get (eventually) free stuff like scaling up/down
// in the right aspect ratio, to fit your device screen.
public abstract class Game  extends ApplicationAdapter {
	
	private DrawingSystem drawingSystem;
	private InputSystem inputSystem;
	
	private Collection<Entity> entities = new ArrayList<Entity>();
	private Scene currentScene = null;
	private static Game instance;
	
	public Game() {
		instance = this;
	}
	
	@Override
	public void create() {
		// Drawing system is a special case; it doesn't retain the
		// original entity list, but instead, dissects it ...
		this.drawingSystem = new DrawingSystem(this.entities);
		this.inputSystem = new InputSystem(this.entities);
	}

	@Override
	public void render() {
		this.drawingSystem.draw();
	}
	
	public static void showScene(Scene s) {
		instance.show(s);
	}
	
	public void show(Scene s) {
		this.entities.clear();
		
		if (currentScene != null) {
			currentScene.dispose();
		}
		
		currentScene = s;
		this.entities.addAll(s.getEntities());
		
		// Special case: doesn't keep a real reference to entities
		// (because of caching). Tell it to reinitialize.
		if (this.drawingSystem != null) {
			this.drawingSystem.initialize(this.entities);
		}
	}
	
	protected void addEntity(Entity e) {
		this.entities.add(e);
		// No worries if null, the drawing system constructor adds it.
		if (this.drawingSystem != null) {
			this.drawingSystem.addedEntity(e);
		}
	}
}
