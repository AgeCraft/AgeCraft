package org.agecraft.core.registry;

import java.util.*;

import org.agecraft.AgeCraft;

public class Registry<T extends RegistryObject> implements Iterable<T> {

    public String name;
    private ArrayList<T> idToObject;
    private HashMap<String, T> nameToObject;

    public Registry(String name, int initialSize) {
        this.name = name;
        idToObject = new ArrayList<T>(initialSize);
        nameToObject = new HashMap<String, T>(initialSize);
    }

    public T get(int id) {
        return idToObject.get(id);
    }

    public T get(String name) {
        return nameToObject.get(name);
    }

    public int getID(String name) {
        return get(name).id;
    }

    public String getName(int id) {
        return get(id).name;
    }

    public Collection<String> names() {
        return nameToObject.keySet();
    }

    public Collection<T> values() {
        return idToObject;
    }

    @Override
    public Iterator<T> iterator() {
        return idToObject.iterator();
    }

    public int size() {
        return idToObject.size();
    }

    public void register(T value) {
        if (value.id < idToObject.size() && idToObject.get(value.id) != null) {
            AgeCraft.log.warn("[" + name + "] Overriding " + idToObject.get(value.id).name + " with " + value.name + " at " + value.id);
        }
        while (idToObject.size() <= value.id) {
            idToObject.add(null);
        }
        idToObject.set(value.id, value);
        nameToObject.put(value.name, value);
    }

    public void register(T... values) {
        for (int i = 0; i < values.length; i++) {
            register(values[i]);
        }
    }

    public void setAll(List<T> list) {
        clear();
        idToObject.addAll(list);
        nameToObject.clear();
        for (T obj : list) {
            nameToObject.put(obj.name, obj);
        }
    }

    public void setAll(Map<String, T> map) {
        clear();
        idToObject.addAll(map.values());
        nameToObject.putAll(map);
    }


    public void clear() {
        idToObject.clear();
        nameToObject.clear();
    }
}
