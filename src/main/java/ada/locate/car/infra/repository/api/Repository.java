package ada.locate.car.infra.repository.api;

import ada.locate.car.infra.data.api.CRUD;

import java.util.List;

public interface Repository<T> extends CRUD<T> {
    List<T> findAllBySpecification(T o);
}
