package com.blastcube.component.internal;

import java.util.ArrayList;
import java.util.Collection;

import com.badlogic.gdx.InputProcessor;
import com.blastcube.component.InputComponent;
import com.blastcube.component.KeyboardInputComponent;
import com.blastcube.entity.Entity;

public class KeyboardTouchInputProcessor implements InputProcessor {
	
	private Collection<Entity> entities;

	public KeyboardTouchInputProcessor(Collection<Entity> entities) {
		this.entities = entities;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		String key = keycodeToString(keycode);
		
		// Prevent concurrent modification by activating the event
		// handlers outside of this loop. (Otherwise, if one of them
		// triggers a scene change, we'll fail.)
		Collection<KeyboardInputComponent> targets = new ArrayList<KeyboardInputComponent>();
        
		for (Entity e : this.entities) {
        	if (e.has(KeyboardInputComponent.class)) {
        		targets.add(e.get(KeyboardInputComponent.class));
        	}
        }
        
        for (KeyboardInputComponent i : targets) {
        	i.onKey(key);
        }
        
        return true; // Key handled~!
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	// TODO: Auto-generated method stub
		return false;
    }
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO: is this supposed to be inverted?
		
        MouseClick event = new MouseClick(screenX, screenY);
		// Prevent concurrent modification by activating the event
		// handlers outside of this loop. (Otherwise, if one of them
		// triggers a scene change, we'll fail.)
		Collection<InputComponent> targets = new ArrayList<InputComponent>();
        
		for (Entity e : this.entities) {
        	if (e.has(InputComponent.class)) {
        		targets.add(e.get(InputComponent.class));
        	}
        }
        
        for (InputComponent i : targets) {
        	i.onClick(event);
        }
        
        return true; // Click handled~!
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private String keycodeToString(int keyCode) {
		switch (keyCode) {
		case 19:
			return "up";
		case 22:
			return "right";
		case 20:
			return "down";
		case 21:
			return "left";
		case 62:
			return "space";
		default:
			return String.valueOf(keyCode);
		}
	}
}
