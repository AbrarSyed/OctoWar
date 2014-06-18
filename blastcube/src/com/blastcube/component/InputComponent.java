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
	
	public void onClick(MouseClick click) {
		this.onClickHandler.call(click);
	}
}