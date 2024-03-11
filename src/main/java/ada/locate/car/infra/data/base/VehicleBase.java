package ada.locate.car.infra.data.base;

import ada.locate.car.infra.data.api.CRUD;
import ada.locate.car.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleBase implements CRUD<Vehicle> {

    List<Vehicle> vehicleList = new ArrayList<>(10);
    private static VehicleBase instance;

    private VehicleBase() {
    }

    public static VehicleBase getInstance() {
        // Lazy initialization: create the instance if it doesn't exist yet
        if (instance == null) {
            instance = new VehicleBase();
        }
        return instance;
    }

    @Override
    public void create(Vehicle o) {

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
