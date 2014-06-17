package com.github.abrarsyed.octowar;

import com.blastcube.Game;
import com.github.abrarsyed.octowar.scenes.TitleScene;

public class OctoWarGame extends Game {	
	
	public OctoWarGame() {
		Game.showScene(new TitleScene());
	}
	
}
