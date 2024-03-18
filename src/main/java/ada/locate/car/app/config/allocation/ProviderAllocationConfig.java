package ada.locate.car.app.config.allocation;

import ada.locate.car.provider.allocation.AllocationCreateInputProvider;
import ada.locate.car.provider.allocation.AllocationDeleteInputProvider;

public record ProviderAllocationConfig(
        AllocationCreateInputProvider create,
        AllocationDeleteInputProvider delete
) {
}
