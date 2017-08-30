package engine.gfx;

import engine.core.event.Event;
import engine.ui.UIComponent;

import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GuiLayer extends Layer {

    private List<UIComponent> m_UIComponents;

    public GuiLayer() {
        super(1);
        this.m_UIComponents = new CopyOnWriteArrayList<>();
    }

    @Override
    public void OnRender(Graphics g) {
        for (Iterator<UIComponent> iterator = m_UIComponents.iterator(); iterator.hasNext(); ) {
            UIComponent comp = iterator.next();
            if (comp.IsVisible())
                comp.MasterRender(g, GetCamera());
        }
    }

    @Override
    public void OnUpdate(float delta) {
        for (Iterator<UIComponent> iterator = m_UIComponents.iterator(); iterator.hasNext(); ) {
            UIComponent comp = iterator.next();
            comp.MasterUpdate(delta);
        }
    }

    @Override
    public void OnEvent(Event event) {
        for (Iterator<UIComponent> iterator = m_UIComponents.iterator(); iterator.hasNext(); ) {
            UIComponent comp = iterator.next();
            comp.MasterEvent(event);
        }
    }

    public void Add(UIComponent object) {
        m_UIComponents.add(object);
    }

    public void Add(UIComponent... uiComponents) {
        for (UIComponent component : uiComponents) {
            Add(component);
        }
    }
}
