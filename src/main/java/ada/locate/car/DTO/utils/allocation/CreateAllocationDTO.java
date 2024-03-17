package ada.locate.car.DTO.utils.allocation;

import ada.locate.car.DTO.AllocationDTO;
import ada.locate.car.DTO.ClientDTO;
import ada.locate.car.DTO.VehicleDTO;

public class CreateAllocationDTO {
    public AllocationDTO createAllocation(String[] dataAllocation, ClientDTO clientDocument, VehicleDTO plateNumberVehicle){
        return new AllocationDTO(clientDocument, plateNumberVehicle, dataAllocation);
    }
}
