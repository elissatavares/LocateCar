package ada.locate.car.config.record.allocation;

import ada.locate.car.core.usecase.allocation.CreateAllocation;
import ada.locate.car.core.usecase.allocation.ReturnAllocation;

public record AllocationServiceConfig(CreateAllocation create, ReturnAllocation delete) {
}
