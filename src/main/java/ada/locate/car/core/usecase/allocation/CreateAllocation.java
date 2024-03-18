package ada.locate.car.core.usecase.allocation;

import ada.locate.car.DTO.AllocationDTO;
import ada.locate.car.DTO.VehicleDTO;

import java.util.List;

public interface CreateAllocation {
    void execute(AllocationDTO allocationDTO);
    List<VehicleDTO> availableVehicles(VehicleDTO vehicleDTO);
}
