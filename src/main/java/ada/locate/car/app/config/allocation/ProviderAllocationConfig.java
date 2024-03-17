package ada.locate.car.app.config.allocation;

import ada.locate.car.provider.allocation.AllocationCreateInputProvider;

public record ProviderAllocationConfig(
        AllocationCreateInputProvider create
) {
}
