package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.ReadVehicle;
import ada.locate.car.infra.api.Repository;
import ada.locate.car.infra.dto.VehicleDTO;

import java.util.ArrayList;
import java.util.List;

public class ReadVehicleService implements ReadVehicle {
    private final Repository<Vehicle> repository;

    public ReadVehicleService(Repository<Vehicle> repository) {
        this.repository = repository;
    }

    @Override
    public List<VehicleDTO> read(VehicleDTO vehicleDTO) {
        return new ArrayList<>();
    }
}
