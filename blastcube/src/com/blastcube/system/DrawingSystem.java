package com.blastcube.system;

import com.blastcube.component.SpriteComponent;
import com.blastcube.entity.Entity;

import java.util.HashMap;
import java.util.Map;

// Uses data-oriented architecture, meaning, we dissect
// entities and keep drawable components in a contiguous list.
public class DrawingSystem {

    private Map<Entity, SpriteComponent> entitySprites = new HashMap<Entity, SpriteComponent>();

    public void initialize(Entity[] entities) {

    }

}
