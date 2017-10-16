package engine.core.level;

import engine.components.CollisionComponent;
import engine.components.EntityRenderComponent;
import engine.core.Transform;
import engine.core.entity.Entity;
import engine.core.tile.Tile;
import engine.gfx.SimpleLayer;
import sandbox.Textures;
import sandbox.entity.EntityCoin;
import sandbox.entity.EntityPlayer;
import sandbox.tile.SimpleTile;

import java.util.ArrayList;
import java.util.List;

public class Level extends SimpleLayer {

    private String m_LevelName;

    private EntityPlayer m_Player;

    private List<EntityCoin> coins;

    private int m_Width;
    private int m_Height;

    public Level(String levelName, EntityPlayer player) {
        this.m_LevelName = levelName;
        this.m_Player = player;

        coins = new ArrayList<>();

        LoadLevel();

        Add(player);
    }

    /**
     * Util method to load a level
     */
    private void LoadLevel() {
        LevelLoader loader = new LevelLoader(m_LevelName);

        m_Width = loader.GetLevelImg().GetWidth();
        m_Height = loader.GetLevelImg().GetHeight();

//        m_TileArray = new Tile[m_Width * m_Height];
//        m_EntityArray = new Entity[m_Width * m_Height];

        for (int y = 0; y < m_Height; y++) {
            for (int x = 0; x < m_Width; x++) {

                Add(new SimpleTile(new Transform(x, y), Textures.DIRT, "test"));

                if (x == 2) {

                    EntityCoin coin = new EntityCoin(new Transform(x, y));
                    coin.SetGridAligned(true);
                    coins.add(coin);
                    Add(coin);
                }

//                int col = loader.GetLevelImg().GetImage().getRGB(x, y);
//
//                int tile = (col >> 16) & 0xFF;
//                int entity = (col >> 8) & 0xFF;
//                int data = col & 0xFF;
//
//
//                m_TileArray[x + y * m_Width] = loader.GetTile(tile);
//                m_TileArray[x + y * m_Width].GetTransform().SetPosition(x, y);
//                Add(m_TileArray[x + y * m_Width]);
//
//                if (entity != 0) {
//                    m_EntityArray[x + y * m_Width] = loader.GetEntity(entity);
//                    m_EntityArray[x + y * m_Width].GetTransform().SetPosition(x, y);
//                    Add(m_EntityArray[x + y * m_Width]);
//                }
//
//
//                if (loader.GetData(data) == LevelData.SPAWN_POINT){}
////                    m_Player.GetTransform().SetPosition(x, y);
//
            }
        }
    }

    @Override
    public void OnUpdate(float delta) {
        super.OnUpdate(delta);

        for (int i = 0; i < coins.size(); i++) {
            if (m_Player.GetComponent(CollisionComponent.class).Intersects(coins.get(i))){
                coins.get(i).GetComponent(EntityRenderComponent.class).SetEnabled(false);
//                break;
            }
        }
    }
}
