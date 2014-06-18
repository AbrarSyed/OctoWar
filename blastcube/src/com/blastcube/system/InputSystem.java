package com.blastcube.system;

import java.util.ArrayList;
import java.util.Collection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.blastcube.component.InputComponent;
import com.blastcube.component.internal.MouseClick;
import com.blastcube.entity.Entity;

public class InputSystem {	
	
	private final Collection<Entity> allEntities;
	
	public InputSystem(Collection<Entity> entities) {
		this.allEntities = entities;
		Gdx.input.setInputProcessor(new InputAdapter() {
		    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		    	// TODO: is this supposed to be inverted?
		        MouseClick event = new MouseClick(screenX, screenY);
				// Prevent concurrent modification by activating the event
				// handlers outside of this loop. (Otherwise, if one of them
				// triggers a scene change, we'll fail.)
				Collection<InputComponent> targets = new ArrayList<InputComponent>();
		        
				for (Entity e : allEntities) {
		        	if (e.has(InputComponent.class)) {
		        		targets.add(e.get(InputComponent.class));
		        	}
		        }
		        
		        for (InputComponent i : targets) {
		        	i.onClick(event);
		        }
		        
		        return true; // Click handled~!
		    }
		});
		
		this.initialize();
	}
	
	public void initialize() {
		for (Entity e : allEntities) {
        	if (e.has(InputComponent.class)) {
        		e.get(InputComponent.class).initialize();
        	}
        }
	}
}
