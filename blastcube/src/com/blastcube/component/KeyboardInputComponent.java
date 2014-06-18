package com.blastcube.component;

import com.blastcube.component.internal.Action;
import com.blastcube.component.internal.Component;

public class KeyboardInputComponent extends Component {

	private final Action<String> onKeyHandler;	
	
	public KeyboardInputComponent(Action<String> onKeyPress) {
		this.onKeyHandler = onKeyPress;		
	}
	
	public void onKey(String key) {
		this.onKeyHandler.call(key);
	}
}
