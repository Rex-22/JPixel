package engine.core.level;

import engine.core.Entity;
import engine.core.Tile.Tile;
import engine.core.Transform;
import sandbox.entity.EntityCoin;
import sandbox.tile.Tiles;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelLoader {

    private String m_LevelName;
    private List<Tile> m_TileList;
    private List<Entity> m_EntityList;

    private Map<Integer, Tile> m_TileMap;
    private Map<Integer, Entity> m_EntityMap;
    private Map<Integer, String> m_DataMap;

    private Level m_TargetLevel;

    public LevelLoader(Level level, String levelName) {
        this.m_LevelName = levelName;
        this.m_EntityList = new ArrayList<>();
        this.m_TileList = new ArrayList<>();

        m_TileMap = new HashMap<>();
        m_EntityMap = new HashMap<>();
        m_DataMap = new HashMap<>();

        m_TargetLevel = level;

        LoadFile();
    }

    private void LoadFile(){
        String fileName = "assets/level/"+m_LevelName+"/"+m_LevelName+"_data.txt";

        String line;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(LevelLoader.class.getClassLoader().getResource(fileName).getFile()));

            while((line = bufferedReader.readLine()) != null) {
                if (line.equals("tile")) {
                    
                }
                else if (line.equals("entity")) {

                }
                else if (line.equals("data")){

                }
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public String GetLevelName() {
        return m_LevelName;
    }

    public List<Entity> GetEntityList() {
        return m_EntityList;
    }

    public List<Tile> GetTileList() {
        return m_TileList;
    }

    public boolean HasTile(Tile tile){
        for (Tile t : m_TileList) {
            if (t == null) return false;

            if (tile.equals(t)){
                return true;
            }
        }

        return false;
    }

    public Tile GetTile(Tile tile){
        for (Tile t : m_TileList) {
            if (tile.GetName().equals(t.GetName())) return t;
        }

        return Tiles.STONE;
    }

    public Tile GetTile(String tileName){
        for (Tile t : m_TileList) {
            if (t.GetName().equals(tileName)) return t;
        }

        return Tiles.STONE;
    }


    public boolean HasEntity(Entity entity){
        for (Entity e : m_EntityList) {
            if (e == null) return false;

            if (entity.equals(e)){
                return true;
            }
        }

        return false;
    }

    public Entity GetEntity(Entity entity){
        for (Entity e : m_EntityList) {
//            if (e.GetName().equals(entityName)) return e;
        }

        return null;
    }

    public Entity GetEntity(String entityName){
        for (Entity e : m_EntityList) {
//            if (e.GetName().equals(entityName)) return e;
        }

        return null;
    }

    private Tile GetTile(int rColour) {
        if(m_TileMap.get(rColour) != null) return m_TileMap.get(rColour);
        return Tiles.STONE;
    }

    private Entity GetEntity(int gColour) {
        if(m_EntityMap.get(gColour) != null) return m_EntityMap.get(gColour);
        return new EntityCoin(new Transform(0, 0));
    }
}
