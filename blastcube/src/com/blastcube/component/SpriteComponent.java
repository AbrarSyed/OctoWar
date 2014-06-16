package com.blastcube.component;

import com.badlogic.gdx.graphics.Texture;
import com.blastcube.entity.Entity;

public class SpriteComponent extends Component {

	private Texture texture;
	private int x = 0;
	private int y = 0;
	private int z = 0;
	
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
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
}
