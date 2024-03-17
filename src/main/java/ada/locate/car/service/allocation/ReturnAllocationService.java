package ada.locate.car.service.allocation;

import ada.locate.car.DTO.AllocationDTO;
import ada.locate.car.DTO.ClientDTO;
import ada.locate.car.core.model.Allocation;
import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.ReadClient;
import ada.locate.car.core.usecase.ReturnAllocation;
import ada.locate.car.repository.api.RepositoryClient;

import java.util.List;

public class ReturnAllocationService implements ReturnAllocation {
    private final RepositoryClient clientRepository;
    private final ReadClient readClientService;

    public ReturnAllocationService(RepositoryClient clientRepository, ReadClient readClientService) {
        this.clientRepository = clientRepository;
        this.readClientService = readClientService;
    }

    @Override
    public void execute(AllocationDTO allocationDTO) {
        ClientDTO client = readClientService.execute(allocationDTO.clientDocument());
        List<Allocation> allocationList = clientRepository.findAllAllocation(allocationDTO.clientDocument().document());
        Allocation allocation = clientRepository.findAllocation(allocationList, allocationDTO.plateNumberVehicle().plateNumber());
        clientRepository.returnAllocation(allocation, allocationDTO.clientDocument().document());
    }
    public List<AllocationDTO> getAllAllocations(ClientDTO clientDTO){
        ClientDTO client = readClientService.execute(clientDTO);
        List<Allocation> allocationList = clientRepository.findAllAllocation(client.document());
        return AllocationDTO.convertToDTO(allocationList);
    }
}
