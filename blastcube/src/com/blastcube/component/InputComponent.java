package com.blastcube.component;

import com.blastcube.component.internal.Action;
import com.blastcube.component.internal.MouseClick;

// Click handler. This class is too smart: if it detects
// that the parent entity has a sprite component, it
// becomes a click handler for that sprite. If it doesn't,
// it remains a global click handler.
public class InputComponent extends Component {

	private final Action<MouseClick> onClickHandler;	
	private SpriteComponent bounds = null;
	
	public InputComponent(Action<MouseClick> onClick) {
		this.onClickHandler = onClick;		
	}
	
	public void onClick(MouseClick click) {
		if (this.bounds == null) {
			this.onClickHandler.call(click);
		} else {
			// TODO: transform screen-space to game-space 
			int x = click.getX();
			int y = click.getY();
			if (x >= this.bounds.getX() &&
					x <= this.bounds.getX() + this.bounds.getWidth() &&
					y >= this.bounds.getY() &&
					y <= this.bounds.getY() + this.bounds.getHeight()) {
				// TODO: pass in sprite-space coordinates?
				this.onClickHandler.call(click);
			}
		}
	}
	
	public void initialize() {
		// Check for a sprite
		if (this.parent.has(SpriteComponent.class)) {
			this.bounds = this.parent.get(SpriteComponent.class);
		}
	}
	
	public boolean getIsGlobal() {
		return this.bounds == null;
	}
}