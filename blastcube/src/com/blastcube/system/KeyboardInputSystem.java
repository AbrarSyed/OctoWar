package com.blastcube.system;

import java.util.Collection;

import com.badlogic.gdx.Gdx;
import com.blastcube.component.internal.KeyboardTouchInputProcessor;
import com.blastcube.entity.Entity;

public class KeyboardInputSystem  {
	
	private Collection<Entity> entities;
	
	public KeyboardInputSystem(Collection<Entity> entities) {
		this.entities = entities;
		Gdx.input.setInputProcessor(
				new KeyboardTouchInputProcessor(this.entities));
	}
}
