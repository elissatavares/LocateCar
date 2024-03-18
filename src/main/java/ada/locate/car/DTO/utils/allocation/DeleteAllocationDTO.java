package ada.locate.car.DTO.utils.allocation;

import ada.locate.car.DTO.AllocationDTO;
import ada.locate.car.DTO.ClientDTO;
import ada.locate.car.DTO.VehicleDTO;

public class DeleteAllocationDTO {
    public AllocationDTO deleteAllocation(ClientDTO clientDocument, VehicleDTO plateNumberVehicle, String finalDay){
        return new AllocationDTO.Builder()
                .clientDocument(clientDocument)
                .plateNumberVehicle(plateNumberVehicle)
                .localDateTimeRent(finalDay)
                .build();
    }
}
