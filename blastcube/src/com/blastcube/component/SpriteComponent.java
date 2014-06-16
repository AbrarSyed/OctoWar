package com.blastcube.component;

import com.badlogic.gdx.graphics.Texture;
import com.blastcube.entity.Entity;

public class SpriteComponent extends Component {

	private Texture texture;
	
	public SpriteComponent(String imageFile) {		
		this.texture = new Texture(imageFile);        
	}
	
	public Texture getTexture() {
		return this.texture;		
	}
	
	public int getWidth() {
		return this.getTexture().getWidth();
	}

	public int getHeight() {
		return this.getTexture().getHeight();
	}
}
