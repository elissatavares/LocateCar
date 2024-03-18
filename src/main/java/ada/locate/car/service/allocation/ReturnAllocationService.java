package ada.locate.car.service.allocation;

import ada.locate.car.DTO.AllocationDTO;
import ada.locate.car.DTO.ClientDTO;
import ada.locate.car.core.model.Allocation;
import ada.locate.car.core.usecase.client.ReadClient;
import ada.locate.car.core.usecase.allocation.ReturnAllocation;
import ada.locate.car.repository.api.RepositoryClient;

import java.util.List;
import java.util.Optional;

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
        Optional<Allocation> allocation = clientRepository.findAllocation(allocationList, allocationDTO.plateNumberVehicle().plateNumber());
        clientRepository.returnAllocation(allocation.get(), allocationDTO.clientDocument().document());
    }
    @Override
    public List<AllocationDTO> getAllAllocations(ClientDTO clientDTO){
        //vericar se o client existe
        ClientDTO client = readClientService.execute(clientDTO);
        List<Allocation> allocationList = clientRepository.findAllAllocation(client.document());
        return AllocationDTO.convertToDTO(allocationList);
    }

    @Override
    public double allocationValue(AllocationDTO allocationDTO) {
        ClientDTO client = readClientService.execute(allocationDTO.clientDocument());
        List<Allocation> allocationList = clientRepository.findAllAllocation(allocationDTO.clientDocument().document());
        Optional<Allocation> allocation = clientRepository.findAllocation(allocationList, allocationDTO.plateNumberVehicle().plateNumber());
        return allocation.get().allocationValue(allocationDTO.localDateTime(), allocationDTO.clientDocument().flagIdentification(), allocation.get().getVehicle().getModel());
    }

}
