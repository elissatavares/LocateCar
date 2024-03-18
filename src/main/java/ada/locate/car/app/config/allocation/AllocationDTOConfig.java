package ada.locate.car.app.config.allocation;

import ada.locate.car.DTO.utils.allocation.CreateAllocationDTO;
import ada.locate.car.DTO.utils.allocation.DeleteAllocationDTO;

public record AllocationDTOConfig(
        CreateAllocationDTO create,
        DeleteAllocationDTO delete
) {
}
