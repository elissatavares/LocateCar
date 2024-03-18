package ada.locate.car.provider.vehicle;

import ada.locate.car.config.record.vehicle.VehicleFrontendConfig;

public class VehicleInputProviderDelete {
    private final VehicleFrontendConfig front;

    public VehicleInputProviderDelete(VehicleFrontendConfig front) {
        this.front = front;
    }

    public String showExclusionField(){
        return front.showExclusionField().execute();
    }
}
