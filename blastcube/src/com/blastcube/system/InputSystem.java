package com.blastcube.system;

import java.util.Collection;

import com.badlogic.gdx.Gdx;
import com.blastcube.component.InputComponent;
import com.blastcube.component.internal.KeyboardTouchInputProcessor;
import com.blastcube.entity.Entity;

public class InputSystem {	
	
	private final Collection<Entity> entities;
	
	public InputSystem(Collection<Entity> entities) {
		this.entities = entities;
		Gdx.input.setInputProcessor(
				new KeyboardTouchInputProcessor(entities));
		
		this.initialize();
	}
	
	public void initialize() {
		for (Entity e : entities) {
        	if (e.has(InputComponent.class)) {
        		e.get(InputComponent.class).initialize();
        	}
        }
	}
}
