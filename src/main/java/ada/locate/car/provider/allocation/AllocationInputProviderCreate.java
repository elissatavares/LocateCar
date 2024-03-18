package ada.locate.car.provider.allocation;

import ada.locate.car.config.record.allocation.AllocationFrontendConfig;

public class AllocationInputProviderCreate {
    private final AllocationFrontendConfig front;

    public AllocationInputProviderCreate(AllocationFrontendConfig front) {
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
