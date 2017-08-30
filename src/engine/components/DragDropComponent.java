package engine.components;

public class DragDropComponent extends Component {

    private int originX = 0;
    private int originY = 0;

    protected void OnMousePressedEvent(int x, int y, int screenX, int screenY, int button) {
        originX = screenX;
        originY = screenY;
    }

    protected void OnMouseMovedEvent(int x, int y, int screenX, int screenY, boolean dragged) {
        if (dragged) {
            int deltaX = screenX - originX;
            int deltaY = screenY - originY;

            GetParent().GetTransform().GetPosition().add(deltaX, deltaY);

            originX = screenX;
            originY = screenY;
        }
    }
}
