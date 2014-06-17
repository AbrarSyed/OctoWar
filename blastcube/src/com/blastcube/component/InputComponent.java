package com.blastcube.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.blastcube.component.internal.Action;
import com.blastcube.component.internal.MouseClick;

// Global click handler
public class InputComponent extends Component {

	private final Action<MouseClick> onClickHandler;
	
	public InputComponent(Action<MouseClick> onClick) {
		this.onClickHandler = onClick;		
	}
	
	public void initialize() {
		Gdx.input.setInputProcessor(new InputAdapter() {
		    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		    	// TODO: is this supposed to be inverted?
		        onClickHandler.call(new MouseClick(screenX, screenY));
		        return true; // Click handled~!
		    }
		});
	}
}