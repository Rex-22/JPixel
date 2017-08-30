package engine.ui;

import engine.components.DragDropComponent;
import org.joml.Vector2i;

import java.awt.*;

public class UILabel extends UIComponent {

    private String  m_Text;
    private Font    m_Font;

    public UILabel(Vector2i position, String text, Font font) {
        super(position);
        this.m_Text = text;
        this.m_Font = font;

        GetBoundingBox().setSize(font.getSize() / 2 * text.length(), font.getSize());

        AddComponent(new DragDropComponent());
    }

    public UILabel(Vector2i position, String text) {
        this(position, text, new Font("Verdan", Font.PLAIN, 20));
    }

    @Override
    public void OnRender(Graphics2D g) {
        g.setFont(m_Font);
        g.setColor(Color.WHITE);
        g.drawString(m_Text, GetPosition().x, GetPosition().y + m_Font.getSize());

        g.setColor(Color.BLUE);
        g.draw(GetBoundingBox());
    }


    public Font GetFont() {
        return m_Font;
    }

    public String GetText() {
        return m_Text;
    }

    public void SetText(String text) {
        this.m_Text = text;
    }

    public void SetFont(Font font) {
        this.m_Font = font;
    }
}
