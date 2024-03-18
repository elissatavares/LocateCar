package ada.locate.car.core.usecase;

import ada.locate.car.DTO.AllocationDTO;
import ada.locate.car.DTO.ClientDTO;

import java.util.List;

public interface ReturnAllocation {
    void execute(AllocationDTO allocationDTO);
    List<AllocationDTO> getAllAllocations(ClientDTO clientDTO);
    double allocationValue(AllocationDTO allocationDTO);
}
