package ada.locate.car.service.allocation;

import ada.locate.car.controller.api.Controller;
import ada.locate.car.core.usecase.CreateAllocation;
import ada.locate.car.core.usecase.ReadVehicle;
import ada.locate.car.infra.dto.ClientDTO;
import ada.locate.car.infra.dto.VehicleDTO;

import java.util.List;

public class CreateAllocationService implements CreateAllocation{
    private final ReadVehicle readVehicles;

    public CreateAllocationService(ReadVehicle readVehicles) {
        this.readVehicles = readVehicles;
    }


    @Override
    public void create(VehicleDTO vehicleDTO) {
        List<VehicleDTO> vehicleDTOList = readVehicles.execute(vehicleDTO);
    }

    public List<VehicleDTO> vehicleDTOList(){

    }

    public ClientDTO readClient(){}

}
