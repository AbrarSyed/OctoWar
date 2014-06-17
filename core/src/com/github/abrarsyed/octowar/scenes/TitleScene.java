package com.github.abrarsyed.octowar.scenes;

import com.blastcube.Game;
import com.blastcube.Scene;
import com.blastcube.component.InputComponent;
import com.blastcube.component.SpriteComponent;
import com.blastcube.component.internal.Action;
import com.blastcube.component.internal.MouseClick;
import com.blastcube.entity.Entity;

public class TitleScene extends Scene {

	public TitleScene() {
		this.addEntity(new Entity(
			new SpriteComponent("images/octowar.jpg"),
			new InputComponent(new Action<MouseClick>() {
				@Override
				public void call(MouseClick data) {
					Game.showScene(new CoreGameScene());
				}
			})
		));
	}
	
}
