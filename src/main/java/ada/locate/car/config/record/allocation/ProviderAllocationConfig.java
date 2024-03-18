package ada.locate.car.config.record.allocation;

import ada.locate.car.provider.allocation.AllocationInputProviderCreate;
import ada.locate.car.provider.allocation.AllocationInputProviderDelete;

public record ProviderAllocationConfig(
        AllocationInputProviderCreate create,
        AllocationInputProviderDelete delete
) {
}
