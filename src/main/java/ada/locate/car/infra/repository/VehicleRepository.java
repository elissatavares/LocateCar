package ada.locate.car.infra.repository;

import ada.locate.car.infra.api.Repository;
import ada.locate.car.core.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements Repository<Vehicle> {

    List<Vehicle> vehicleList = new ArrayList<>(10);
    private static VehicleRepository instance;

    private VehicleRepository() {
    }

    public static VehicleRepository getInstance() {
        if (instance == null) {
            instance = new VehicleRepository();
        }
        return instance;
    }


    @Override
    public void create(Vehicle o) {
        vehicleList.add(o);

    }

    @Override
    public Vehicle read(Vehicle key) {
        return null;
    }

    @Override
    public void update(Vehicle o, Vehicle key) {

    }

    @Override
    public void delete(Vehicle o) {

    }

    @Override
    public List<Vehicle> findAllBySpecification(Vehicle o) {
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        return null;
    }
}
