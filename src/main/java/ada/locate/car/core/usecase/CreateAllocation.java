package ada.locate.car.core.usecase;

import ada.locate.car.infra.dto.ClientDTO;
import ada.locate.car.infra.dto.VehicleDTO;

import java.util.List;

public interface CreateAllocation {
    void create(VehicleDTO vehicleDTO, ClientDTO clientDTO);
    List<VehicleDTO> availableVehicles(VehicleDTO vehicleDTO);
}
