package ada.locate.car.app.config.allocation;

import ada.locate.car.core.usecase.CreateAllocation;
import ada.locate.car.core.usecase.ReturnAllocation;

public record AllocationServiceConfig(CreateAllocation create, ReturnAllocation delete) {
}
