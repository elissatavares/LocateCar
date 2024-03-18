package ada.locate.car.repository.api;


import java.util.List;
import java.util.Optional;

public interface Repository<T>  {

    boolean create(T o);

    Optional<T> read(String key);

    boolean update(T o, T key);

    boolean delete(T o);

    List<T> findAll();

}