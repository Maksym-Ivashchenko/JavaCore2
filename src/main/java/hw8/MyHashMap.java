package hw8;

import java.io.Serializable;
import java.util.*;

public class MyHashMap<K, V> implements MyMap<K,V>, Cloneable, Serializable {


    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static final int DEFAULT_LENGTH = 16;

    private int arrayLength;

    private int size;

    private float loadFactor;

    private Node<K, V>[] tables;

    public MyHashMap() {
        this(DEFAULT_LENGTH, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int length) {
        this(length, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int length, float loadFactor) {
        if (length <= 0) {
            throw new IllegalArgumentException("Длина инициализации должна быть больше 0");
        }
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Коэффициент нагрузки должен быть больше 0");
        }

        this.arrayLength = length;
        this.loadFactor = loadFactor;
        tables = new Node[length];
    }

    @Override
    public V get(Object key) {
        int index = indexForArray(hash(key), arrayLength);
        Node<K, V> node = tables[index];
        for (Node<K, V> n = node; n != null; n = n.next) {
            if ((key == null && null == n.getKey()) || (key != null && key.equals(n.getKey()))) {
                return n.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hashCode = hash(key);
        int index = indexForArray(hashCode, arrayLength);
        Node<K, V> node = tables[index];
        if (node == null) {
            tables[index] = new Node(key, value, hashCode, null);
        } else {
            for (Node<K, V> n = node; n != null; n = n.next) {
                K nodeKey = n.getKey();
                if ((key == null && null == nodeKey) || (key != null && key.equals(nodeKey))) {
                    V oldValue = n.getValue();
                    n.setValue(value);
                    return oldValue;
                }
                if (n.next == null) {
                    n.next = new Node<>(key, value, hashCode, null);
                    break;
                }
            }
        }
        if (++size > arrayLength * loadFactor) {
            resize();
        }
        return null;
    }

    public void remove(Object key){
        int index = key.hashCode()% tables.length-1;
        tables[index]=null;
        size--;
    }

    @Override
    public void clear() {
        tables = new Node[arrayLength];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (Node<K, V> node : tables) {
            while (node != null) {
                set.add(node);
                node = node.next;
            }
        }
        return set;
    }

    public int hash(Object key) {
        return key == null ? 0 : key.hashCode();
    }

    private int indexForArray(int hashCode, int arrayLength) {
        int index = Math.abs(hashCode) % arrayLength;
        return index;
    }

    private void resize() {
        int newLength = arrayLength * 2;
        Node<K, V>[] newTables = new Node[newLength];
        Set<Map.Entry<K, V>> entrySet = entrySet();
        int newSize = 0;
        for (Map.Entry entry : entrySet) {
            Node<K, V> node = (Node<K, V>) entry;
            node.next = null;
            int index = indexForArray(node.hashCode, arrayLength);
            Node<K, V> indexNode = newTables[index];
            if (indexNode == null) {
                newTables[index] = node;
            } else {
                while (indexNode.next != null) {
                    indexNode = indexNode.next;
                }
                indexNode.next = node;
            }
        }
        tables = newTables;
        arrayLength = newLength;
    }

    class Node<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;
        private int hashCode;

        public Node(K key, V value, int hashCode, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        int i = 1;
        for (Node<K,V> n: tables) {
            if (n != null && i < size) {
                str.append(n.getValue()).append(", ");
                i++;
            }
            if (n != null && i == size)
                str.append(n.getValue());
        }
        str.append("]");
        return str.toString();
    }

    public static void main(String[] args) {
        MyHashMap<Integer,String> myMap = new MyHashMap<>();
        myMap.put(0, "carrot-0");
        myMap.put(1, "carrot-1");
        myMap.put(2, "carrot-2");
        myMap.put(3, "carrot-3");
        myMap.put(4, "carrot-4");

        System.out.println(myMap.get(2));
        System.out.println(myMap.size());
        myMap.remove(2);
        //myMap.clear();
        System.out.println(myMap);
    }
}