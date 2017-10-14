package engine.core.level;

import engine.components.Component;
import engine.core.GameObject;
import engine.core.Tile.Tile;
import engine.core.entity.Entity;
import engine.core.entity.SimpleEntity;
import engine.gfx.Layer;
import engine.gfx.SimpleLayer;
import sandbox.entity.EntityPlayer;
import sandbox.tile.SimpleTile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level extends SimpleLayer {

    private String m_LevelName;

    private EntityPlayer m_Player;

    private int m_Width;
    private int m_Height;

    public Level(String levelName, EntityPlayer player) {
        this.m_LevelName = levelName;
        this.m_Player = player;

        Add(player);

        LoadLevel();
    }

    /**
     * Util method to load a level
     */
    private void LoadLevel(){
        LevelLoader loader = new LevelLoader(m_LevelName);

        m_Width = loader.GetLevelImg().GetWidth();
        m_Height = loader.GetLevelImg().GetHeight();

        for (int y = 0; y < m_Height; y++) {
            for (int x = 0; x < m_Width; x++) {
                int col = loader.GetLevelImg().GetImage().getRGB(x, y);

                int tile    = (col >> 16) & 0xFF;
                int entity  = (col >> 8) & 0xFF;
                int data    = col & 0xFF;

                Tile tileToAdd= new SimpleTile(loader.GetTile(tile));
                Entity entityToAdd = new SimpleEntity(loader.GetEntity(entity));

                tileToAdd.GetTransform().SetPosition(x, y);
                entityToAdd.GetTransform().SetPosition(x, y, true);

                Add(tileToAdd);
                Add(entityToAdd);

                if (loader.GetData(data) == LevelData.SPAWN_POINT){
                    m_Player.GetTransform().SetPosition(x, y, true);


//                    x * m_Player.GetTransform().GetSize().x,
//                            y * m_Player.GetTransform().GetSize().y
                }
            }
        }
    }

}
