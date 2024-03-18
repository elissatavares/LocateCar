package ada.locate.car.provider.allocation;

import ada.locate.car.app.config.allocation.FrontAllocationConfig;

public class AllocationCreateInputProvider {
    private final FrontAllocationConfig front;

    public AllocationCreateInputProvider(FrontAllocationConfig front) {
        this.front = front;
    }

    public String typeClient() {
        return front.clientTypeCreate().execute();
    }

    public String plateNumber() {
        return front.plateNumberCreate().execute();
    }

    public String[] dataAllocation() {
        return front.dataAllocation().execute();
    }

    public String optionAllocation() {
        return front.optionsAllocation().execute();
    }
}
