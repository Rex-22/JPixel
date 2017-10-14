package engine.core.level;

import engine.core.GameObject;
import engine.gfx.Layer;

import java.util.ArrayList;
import java.util.List;

public class Level extends Layer {

    private List<GameObject> m_LevelObjects;
    private String m_LevelName;

    public Level(String levelName) {
        this.m_LevelObjects = new ArrayList<>();
        this.m_LevelName = levelName;

        LoadLevel();
    }

    public void Add(GameObject object){
        this.m_LevelObjects.add(object);
    }

    public void Remove(GameObject object){
        this.m_LevelObjects.remove(object);
    }


    /**
     * Util method to load a level
     */
    private void LoadLevel(){
        LevelLoader loader = new LevelLoader(this, m_LevelName);
    }

}
