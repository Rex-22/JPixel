package engine.core.Tile;

public interface NBT<K, T> {

    void AddTag(Object value);

    T GetTagCompound(K name);

}
