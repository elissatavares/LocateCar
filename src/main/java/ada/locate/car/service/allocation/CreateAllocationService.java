package ada.locate.car.service.allocation;

import ada.locate.car.core.model.Client;
import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.CreateAllocation;
import ada.locate.car.core.usecase.ReadClient;
import ada.locate.car.core.usecase.ReadVehicle;
import ada.locate.car.infra.dto.ClientDTO;
import ada.locate.car.infra.dto.VehicleDTO;

import java.util.List;

public class CreateAllocationService implements CreateAllocation{
    private final ReadVehicle readVehicleService;
    private final ReadClient readClientService;

    public CreateAllocationService(ReadVehicle vehicleService, ReadClient readClientServide) {
        this.readVehicleService = vehicleService;
        this.readClientService = readClientServide;
    }


    @Override
    public void create(VehicleDTO vehicleDTO, ClientDTO clientDTO) {
        //sempre vai me retorna um unico veiculo, pois estou buscando por placa;
        Vehicle vehicleToAllocation = (Vehicle) readVehicleService.execute(vehicleDTO);
        //vai chamar a função do meu service que me retorna o client com o documento que eu especifiquei
        ClientDTO client = readClientService.execute(clientDTO);
        Client clientConverted = ClientDTO.convertClientDTOToClient(client);
    }

    @Override
    public List<VehicleDTO> availableVehicles(VehicleDTO vehicleDTO) {
        return readVehicleService.execute(vehicleDTO);
    }
}
