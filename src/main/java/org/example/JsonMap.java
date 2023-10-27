package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class JsonMap implements Map<String, Object> {

    private static final int OFFSET = 1;
    private static final int DEFAULT_CAPACITY = OFFSET << 4;
    private static final String DOT_REGEX = "\\.";
    private static final String REGEX_ARRAY_BRACKETS = "^\\[\\d+]?";

    private final Map<String, Object> map;

    public JsonMap() {
        this(DEFAULT_CAPACITY);
    }

    public JsonMap(Map<String, Object> m) {
        this.map = new HashMap<>(m);
    }

    public JsonMap(int initialCapacity) {
        this.map = new HashMap<>(initialCapacity);
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return this.map.get(key);
    }

    @Override
    public Object put(String key, Object value) {
        return this.map.put(key, value);
    }

    @Override
    public Object remove(java.lang.Object key) {
        return this.map.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        this.map.putAll(m);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public Set<String> keySet() {
        return this.map.keySet();
    }

    @Override
    public Collection<Object> values() {
        return this.map.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public <T> Optional<T> get(String targetPath, Class<T> clazz) {
        if (null == targetPath || targetPath.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(clazz.cast(getObjFromMap(this.map, targetPath.split(DOT_REGEX), 0)));
    }

    @SuppressWarnings("unchecked")
    private Object getObjFromMap(Object object, String[] targetPath, int currIndex) {
        if (object instanceof Map) {
            if (((Map<String, Object>) object).containsKey(targetPath[currIndex])) {
                return currIndex == targetPath.length - OFFSET ?
                        ((Map<String, Object>) object).get(targetPath[currIndex]) :
                        getObjFromMap(((Map<String, Object>) object).get(targetPath[currIndex]), targetPath, currIndex + OFFSET);
            }
        } else if (object instanceof List && targetPath[currIndex].matches(REGEX_ARRAY_BRACKETS)) {
            int elementIndex = Integer.parseInt(targetPath[currIndex].substring(OFFSET, targetPath[currIndex].length() - OFFSET));
            if (elementIndex < ((List<Object>) object).size()) {
                return currIndex == targetPath.length - OFFSET ?
                        ((List<Object>) object).get(elementIndex) :
                        getObjFromMap(((List<Object>) object).get(elementIndex), targetPath, currIndex + OFFSET);
            }
        }
        return null;
    }
}
