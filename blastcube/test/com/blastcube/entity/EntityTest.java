package com.blastcube.entity;

import com.blastcube.component.Component;
import com.blastcube.component.internal.Action;

import org.junit.Assert;
import org.junit.Test;

public class EntityTest {

    @Test
    public void hasReturnsTrueIfHasComponent() {
        Entity e = new Entity();
        e.add(new StringComponent("one"));
        Assert.assertTrue(e.has(StringComponent.class));
        Assert.assertFalse(e.has(System.class));
    }

    @Test
    public void constructorAddsComponentsAndSetsParent() {
        Entity e = new Entity();
        e.add(new StringComponent("one"));

        Assert.assertTrue(e.has(StringComponent.class));
        Assert.assertFalse(e.has(System.class));
    }

    @Test
    public void getGetsAddedComponent()
    {
        Entity e = new Entity();
        e.add(new StringComponent("pass"));

        StringComponent actual = e.get(StringComponent.class);
        Assert.assertEquals("pass", actual.value);
    }

    @Test
    public void getThrowsIfComponentDoesntExist() {
        Entity e = new Entity();
        try {
            e.get(StringComponent.class);
            Assert.fail("Expected exception wasn't thrown");
        } catch (Exception x) { }
    }

    @Test
    public void receiveEventSendsEventToAllComponents() {
        Entity e = new Entity();

        Component c1 = new StringComponent("stringz");
        Component c2 = new IntComponent(17);
        // It's off to work we go ...
        e.add(c1);
        e.add(c2);

        final StringComponent eventsSeen = new StringComponent("");
        e.add(c1);
        e.add(c2);

        c1.bind("Test", new Action() {
            @Override
            public void call(Object data) {
                eventsSeen.value += "1";
            }
        });

        c2.bind("Test", new Action() {
            @Override
            public void call(Object data) {
                eventsSeen.value += "2";
            }
        });

        e.receiveEvent("Test");

        Assert.assertTrue(eventsSeen.value.equals("12") || eventsSeen.value.equals("21"));
    }

    private class StringComponent extends Component {

        private String value = "";

        public StringComponent(String value) {
            this.value = value;
        }
    }

    private class IntComponent extends Component {

        private int value = 0;

        public IntComponent(int value) {
            this.value = value;
        }
    }

}
