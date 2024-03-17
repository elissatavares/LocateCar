package ada.locate.car.infra.provider.data.allocation;

import ada.locate.car.app.config.allocation.FrontAllocationConfig;

public class AllocationCreateInputProvider {
    private final FrontAllocationConfig front;

    public AllocationCreateInputProvider(FrontAllocationConfig front) {
        this.front = front;
    }

    public String typeCleint(){
        return front.clientType().execute();
    }
    public String numberPlate(){
        return front.plateNumber().execute();
    }

    public String[] dataAllocation(){
        return front.dataAllocation().execute();
    }
    public String optionAllocation(){
        return front.optionsAllocation().execute();
    }
}
