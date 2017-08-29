package engine.components;

import engine.core.Camera;
import engine.gfx.Window;

public class CameraFollowComponent extends Component {

    private Camera m_Camera;

    public CameraFollowComponent(Camera camera) {
        this.m_Camera = camera;
    }

    @Override
    public void Init() {
        CenterOnPlayer();
    }

    @Override
    public void OnUpdate(float delta) {
       CenterOnPlayer();
    }

    private void CenterOnPlayer(){
        m_Camera.SetPosition(
                m_Parent.GetTransform().GetX() - (Window.GetWidth() / 2),
                m_Parent.GetTransform().GetY() - (Window.GetHeight() / 2));
    }
}
