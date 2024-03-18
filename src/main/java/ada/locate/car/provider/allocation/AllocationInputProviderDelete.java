package ada.locate.car.provider.allocation;

import ada.locate.car.config.record.allocation.AllocationFrontendConfig;

public class AllocationInputProviderDelete {
    private final AllocationFrontendConfig front;

    public AllocationInputProviderDelete(AllocationFrontendConfig front) {
        this.front = front;
    }

    public String typeClient() {
        return front.clientTypeDelete().execute();
    }

    public String plateNumber() {
        return front.plateNumberDelete().execute();
    }

    public void details(String details) {
        front.allocationDetails().execute(details);
    }
    public String finalDay(){
        return front.finalDay().execute();
    }

    public void displaysTotalAmount(String details){
        front.finalValue().execute(details);
    }
}
