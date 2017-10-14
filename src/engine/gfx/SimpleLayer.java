package engine.gfx;

import engine.core.GameObject;
import engine.core.event.Event;

import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SimpleLayer extends Layer {

    private List<GameObject> m_GameObjects;

    public SimpleLayer() {
        super(0);
        this.m_GameObjects = new CopyOnWriteArrayList<>();
    }

    @Override
    public void OnRender(Graphics g) {
        for (Iterator<GameObject> iterator = m_GameObjects.iterator(); iterator.hasNext(); ) {
            GameObject object = iterator.next();
            object.MasterRender(g, GetCamera());
        }
    }

    @Override
    public void OnUpdate(float delta) {
        for (Iterator<GameObject> iterator = m_GameObjects.iterator(); iterator.hasNext(); ) {
            GameObject object = iterator.next();
            object.MasterUpdate(delta);
        }
    }

    @Override
    public void OnEvent(Event event) {
        for (Iterator<GameObject> iterator = m_GameObjects.iterator(); iterator.hasNext(); ) {
            GameObject object = iterator.next();
            object.MasterEvent(event);
        }
    }

    public void Add(GameObject object) {
        m_GameObjects.add(object);
    }

    public void Add(GameObject... objects){
        for (GameObject object: objects) {
            Add(object);
        }
    }
}
