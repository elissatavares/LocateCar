package ada.locate.car.repository.api;

import ada.locate.car.core.model.Vehicle;

import java.util.List;
import java.util.function.Predicate;

public interface RepositoryVehicle extends Repository<Vehicle>{
    List<Vehicle> findAllByPredicate(Predicate<Vehicle> predicate);
}
