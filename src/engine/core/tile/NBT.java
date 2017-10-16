package engine.core.tile;

public interface NBT<K, T> {

    void AddTag(Object value);

    T GetTagCompound(K name);

}
