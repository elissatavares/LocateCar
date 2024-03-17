package ada.locate.car.service.allocation;

import ada.locate.car.DTO.AllocationDTO;
import ada.locate.car.core.model.Allocation;
import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.CreateAllocation;
import ada.locate.car.core.usecase.ReadClient;
import ada.locate.car.core.usecase.ReadVehicle;
import ada.locate.car.DTO.ClientDTO;
import ada.locate.car.DTO.VehicleDTO;
import ada.locate.car.repository.api.RepositoryClient;
import ada.locate.car.repository.api.RepositoryVehicle;

import java.util.List;

public class CreateAllocationService implements CreateAllocation{
    private final ReadVehicle readVehicleService;
    private final ReadClient readClientService;
    private final RepositoryClient clientRepository;
    private final RepositoryVehicle repositoryVehicle;

    public CreateAllocationService(ReadVehicle vehicleService, ReadClient readClientServide, RepositoryClient clientRepository, RepositoryVehicle repositoryVehicle) {
        this.readVehicleService = vehicleService;
        this.readClientService = readClientServide;
        this.clientRepository = clientRepository;
        this.repositoryVehicle = repositoryVehicle;
    }


    @Override
    public void execute(AllocationDTO allocationDTO) {
        //sempre vai me retorna um unico veiculo, pois estou buscando por placa;
        List<VehicleDTO> vehicleToAllocation =  readVehicleService.execute(allocationDTO.plateNumberVehicle());
        VehicleDTO vehicleDTO = vehicleToAllocation.getFirst();

        Vehicle vehicle = repositoryVehicle.read(vehicleDTO.plateNumber());
        //vai chamar a função do meu service que me retorna o client com o documento que eu especifiquei
        ClientDTO client = readClientService.execute(allocationDTO.clientDocument());
        String[] dataAllocation = allocationDTO.data();
        Allocation allocation = new Allocation(dataAllocation[0], dataAllocation[1], vehicle);
        clientRepository.createAllocation(allocation, client.document());
    }

    @Override
    public List<VehicleDTO> availableVehicles(VehicleDTO vehicleDTO) {
        return readVehicleService.execute(vehicleDTO);
    }
}
