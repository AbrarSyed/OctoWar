package com.blastcube.entity;

import com.blastcube.component.Component;
import com.google.common.collect.MutableClassToInstanceMap;

public class Entity {

    private MutableClassToInstanceMap<Component> components = MutableClassToInstanceMap.create();

    public Entity(Component... components) {
       for (Component c : components) {
    	   c.setParent(this);
           this.add(c);
        }
    }

    public Entity add(Component component)
    {
        this.components.put(component.getClass(), component);
        return this;
    }

    public <T extends Component> T get(Class<T> type)
    {
        if (!this.has(type)) {
            throw new RuntimeException(String.format("Entity %s doesn't have a component of type %s", this, type));
        }
        return components.getInstance(type);
    }

    public <T> boolean has(Class<T> type) {
        return this.components.containsKey(type);
    }

    public void receiveEvent(String eventName) {
        this.receiveEvent(eventName, null);
    }

    public void receiveEvent(String eventName, Object data) {
        for (Component c : this.components.values())  {
            c.receiveEvent(eventName,  data);
        }
    }
    
    public void dispose() {
    	for (Component c : this.components.values()) {
    		c.dispose();
    	}
    }
}
