package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> storege = new HashMap<>();

    @Override
    public void add(T model) {
        if (findById(model.getId()) == null) {
            storege.put(model.getId(), model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
        return storege.replace(id, findById(id), model);
    }

    @Override
    public void delete(String id) {
        storege.remove(id);
    }

    @Override
    public T findById(String id) {
        return storege.get(id);
    }
}
