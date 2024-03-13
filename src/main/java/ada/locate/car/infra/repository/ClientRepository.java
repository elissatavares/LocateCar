package ada.locate.car.infra.repository;

import ada.locate.car.infra.api.Repository;

import java.util.*;

public class ClientRepository implements Repository<Object> {
    private static final Map<Class<?>, Set<Object>> OBJECTS = new HashMap<>();
    private static ClientRepository instance;

    private ClientRepository() {
    }

    public static synchronized ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepository();
        }
        return instance;
    }

    @Override
    public void create(Object o) {
        Set<Object> objects = collectionOfObjects(o.getClass());
        objects.add(o);
    }

    @Override
    public Object read(Object key) {
        return null; // Não implementado
    }

    @Override
    public void update(Object o, Object key) {
        // Não implementado
    }

    @Override
    public void delete(Object o) {
        // Não implementado
    }

    @Override
    public List<Object> findAll() {
        List<Object> allObjects = new ArrayList<>();
        for (Set<Object> objects : OBJECTS.values()) {
            allObjects.addAll(objects);
        }
        return allObjects;
    }

    @Override
    public List<Object> findAllBySpecification(Object o) {
        // Não implementado
        return null;
    }

    private Set<Object> collectionOfObjects(Class<?> clazz) {
        Set<Object> objects = OBJECTS.get(clazz);
        if (objects == null) {
            objects = new HashSet<>();
            OBJECTS.put(clazz, objects);
        }
        return objects;
    }
}

