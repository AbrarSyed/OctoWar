package com.blastcube;

import java.util.ArrayList;
import java.util.Collection;

import com.blastcube.entity.Entity;

public class Scene {
	
	private Collection<Entity> entities = new ArrayList<Entity>();

	public void dispose() {
		for (Entity e : this.entities) {
			e.dispose();
		}
		
		this.entities.clear();
	}
	
	public Collection<Entity> getEntities() {
		// need a reference so changes reflect across all systems
		return this.entities; 
	}
	
	public void addEntity(Entity e) {
		this.entities.add(e);		
	}

}
