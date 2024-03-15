package ada.locate.car.infra.api;


import java.util.List;
import java.util.function.Predicate;

public interface Repository<T>  {

    void create(T o);

    T read(String key);

    void update(T o, T key);

    void delete(T o);

    List<T> findAll();

    List<T> findAllByPredicate(Predicate<T> predicate);
}