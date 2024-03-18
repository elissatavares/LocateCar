package ada.locate.car.provider.vehicle;

import ada.locate.car.app.config.vehicle.FrontVehicleConfig;

public class VehicleDeleteInputProvider {
    private final FrontVehicleConfig front;

    public VehicleDeleteInputProvider(FrontVehicleConfig front) {
        this.front = front;
    }

    public String showExclusionField(){
        return front.showExclusionField().execute();
    }
}
