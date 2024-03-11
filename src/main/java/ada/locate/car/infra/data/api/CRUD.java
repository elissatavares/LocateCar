package ada.locate.car.infra.data.api;

import java.util.List;

public interface CRUD<T> {

    void create(T o);

    T read(T key);

    void update(T o, T key);

    void delete(T o);

    List<T> findAll();
}
