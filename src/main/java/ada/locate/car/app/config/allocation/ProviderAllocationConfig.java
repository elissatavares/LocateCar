package ada.locate.car.app.config.allocation;

import ada.locate.car.infra.provider.data.allocation.AllocationCreateInputProvider;

public record ProviderAllocationConfig(
        AllocationCreateInputProvider create
) {
}
