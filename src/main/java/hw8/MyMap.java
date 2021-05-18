package hw8;

import java.util.Map;
import java.util.Set;

public interface MyMap<K,V> {
    public V get(Object key);
    public V put(K key, V value);
    public void clear();
    public int size();
    public Set<Map.Entry<K, V>> entrySet();


}
