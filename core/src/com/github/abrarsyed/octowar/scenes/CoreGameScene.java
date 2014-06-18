package com.github.abrarsyed.octowar.scenes;

import com.blastcube.Scene;
import com.blastcube.component.KeyboardInputComponent;
import com.blastcube.component.SpriteComponent;
import com.blastcube.component.internal.Action;
import com.blastcube.entity.Entity;

public class CoreGameScene extends Scene {

	public CoreGameScene() {
		final int MOVEMENT_INCREMENT = 32;
		
		final Entity me = new Entity(new SpriteComponent("images/player.png"));
		me.add(new KeyboardInputComponent(new Action<String>() {
			@Override
			public void call(String key) {
				SpriteComponent s = me.get(SpriteComponent.class);
				if (key == "left") {
					s.setX(s.getX() - MOVEMENT_INCREMENT);
				} else if (key == "right") {
					s.setX(s.getX() + MOVEMENT_INCREMENT);
				} else if (key == "up") {
					s.setY(s.getY() - MOVEMENT_INCREMENT);
				} else if (key == "down") {
					s.setY(s.getY() + MOVEMENT_INCREMENT);
				}
			}
		}));
		this.addEntity(me);
	}
	
}
