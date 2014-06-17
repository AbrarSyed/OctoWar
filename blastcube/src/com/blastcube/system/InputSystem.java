package com.blastcube.system;

import java.util.Collection;

import com.blastcube.component.InputComponent;
import com.blastcube.entity.Entity;

public class InputSystem {

	public InputSystem(Collection<Entity> entities) {
		for (Entity e : entities) {
			// Move this into the input system
			if (e.has(InputComponent.class)) {
				e.get(InputComponent.class).initialize();
			}
		}
	}
	
}
