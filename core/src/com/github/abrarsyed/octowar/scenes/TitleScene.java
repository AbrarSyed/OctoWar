package com.github.abrarsyed.octowar.scenes;

import com.blastcube.Scene;
import com.blastcube.component.SpriteComponent;
import com.blastcube.entity.Entity;

public class TitleScene extends Scene {

	public TitleScene() {
		this.addEntity(new Entity(
			new SpriteComponent("images/octowar.jpg")
		));
	}
	
}
