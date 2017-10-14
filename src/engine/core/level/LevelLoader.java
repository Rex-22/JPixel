package engine.core.level;

import engine.components.EntityRenderComponent;
import engine.core.entity.Entity;
import engine.core.Tile.Tile;
import engine.core.Transform;
import engine.gfx.Bitmap;
import org.joml.Vector2f;
import sandbox.entity.EntityCoin;
import sandbox.tile.Tiles;

import java.io.*;
import java.util.*;

public class LevelLoader {

    private String m_LevelName;
    private Bitmap m_LevelImg;

    private List<Tile> m_TileList;
    private List<Entity> m_EntityList;

    private Map<Integer, Tile> m_TileMap;
    private Map<Integer, Entity> m_EntityMap;
    private Map<Integer, LevelData> m_DataMap;


    public LevelLoader(String levelName) {
        this.m_LevelName = levelName;
        this.m_EntityList = new ArrayList<>();
        this.m_TileList = new ArrayList<>();

        m_TileMap = new HashMap<>();
        m_EntityMap = new HashMap<>();
        m_DataMap = new HashMap<>();

        LoadFile();
        m_LevelImg = LoadLevelImage();
    }

    private Bitmap LoadLevelImage() {
        Bitmap result = new Bitmap("level/"+m_LevelName+"/"+m_LevelName+"_img.png");

        return result;
    }

    private void LoadFile(){
        String fileName = "assets/level/"+m_LevelName+"/"+m_LevelName+"_data.txt";

        String line;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(LevelLoader.class.getClassLoader().getResource(fileName).getFile()));

            while((line = bufferedReader.readLine()) != null) {
                if (line.equals("")) continue;
                String[] tokens = line.split("=");

                //We are reading a tile
                if(tokens[0].startsWith("t")){
                    String tileName = tokens[1];
                    String tileColourID = tokens[0].substring(1);

                    Tile tile = Tiles.GetByName(tileName);

                    m_TileList.add(tile);
                    m_TileMap.put(Integer.parseInt(tileColourID), tile);
                }

                //We are reading a entity
                if(tokens[0].startsWith("e")){
                    String entityName = tokens[1];
                    String entityColourID = tokens[0].substring(1);

                    if (entityName.equals("coin")){
                        Entity entity = new EntityCoin(new Transform());
                        entity.GetComponent(EntityRenderComponent.class).SetEnabled(false);

                        m_EntityList.add(entity);
                        m_EntityMap.put(Integer.parseInt(entityColourID), entity);
                    }
                }

                //We are reading a data tag
                if(tokens[0].startsWith("d")){
                    String dataName = tokens[1];
                    String dataColourID = tokens[0].substring(1);

                    m_DataMap.put(Integer.parseInt(dataColourID), LevelData.GetByName(dataName));
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
            if (entity == e) return e;
        }

        return null;
    }

    public Entity GetEntity(String entityName){
        for (Entity e : m_EntityList) {
            if (e.GetName().equals(entityName)) return e;
        }

        return null;
    }

    public Tile GetTile(int rColour) {
        if(m_TileMap.get(rColour) != null) return m_TileMap.get(rColour);
        return Tiles.STONE;
    }

    public Entity GetEntity(int gColour) {
        if(m_EntityMap.get(gColour) != null) return m_EntityMap.get(gColour);
        return new EntityCoin(new Transform(0, 0));
    }

    public LevelData GetData(int bColour){
        if (m_DataMap.get(bColour) != null) return m_DataMap.get(bColour);
        return null;
    }

    public Bitmap GetLevelImg() {
        return m_LevelImg;
    }
}
