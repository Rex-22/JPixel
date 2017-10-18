package ruben.jpixel.engine.component;

import ruben.jpixel.engine.core.CoreEngine;
import ruben.jpixel.engine.graphics.Camera;

public class CameraFollowComponent extends Component {

    private Camera camera;

    public CameraFollowComponent(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void update(float delta) {
        camera.setPosition(
                (parent.getPosition().x - CoreEngine.WIDTH / 2),
                (parent.getPosition().y - CoreEngine.HEIGHT / 2));
    }
}
