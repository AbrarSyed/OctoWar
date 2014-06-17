package com.github.abrarsyed.octowar.scenes;

import com.blastcube.Scene;
import com.blastcube.component.SpriteComponent;
import com.blastcube.entity.Entity;

public class CoreGameScene extends Scene {

	public CoreGameScene() {
		this.addEntity(new Entity(new SpriteComponent("images/player.png")));
	}
	
}
