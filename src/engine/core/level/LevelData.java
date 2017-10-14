package engine.core.level;

public enum LevelData {

    SPAWN_POINT("spawn_point");

    String m_DataName;

    LevelData(String name) {
        m_DataName = name;
    }

    public String GetName(){
        return m_DataName;
    }

    public static LevelData GetByName(String name){
        for (LevelData ld : LevelData.values()) {
            if (ld.m_DataName.equals(name)) return ld;
        }

        return null;
    }
}
