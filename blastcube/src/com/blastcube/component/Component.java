package com.blastcube.component;

import com.blastcube.entity.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class Component {

    private Entity parent;
    private Map<String, Collection<Action>> eventHandlers = new HashMap<String, Collection<Action>>();
    
    public void bind(String eventName, Action callback) {
        if (!this.hasAnyHandlersFor(eventName)) {
            this.eventHandlers.put(eventName, new ArrayList<Action>());
        }

        this.eventHandlers.get(eventName).add(callback);
    }

    public void receiveEvent(String eventName, Object data) {
        if (this.hasAnyHandlersFor(eventName)) {
            Collection<Action> handlers = this.eventHandlers.get(eventName);
            for (Action handler : handlers) {
                handler.call(data);
            }
        }
    }

    private boolean hasAnyHandlersFor(String eventName) {
        return this.eventHandlers.containsKey(eventName);
    }

	public void setParent(Entity entity) {
		this.parent = entity;
	}
}
