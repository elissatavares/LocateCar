package ada.locate.car.infra.provider.data.vehicle;

import ada.locate.car.app.config.vehicle.FrontVehicleConfig;

public class VehicleMenuInputProvider {
    private final FrontVehicleConfig front;

    public VehicleMenuInputProvider(FrontVehicleConfig front) {
        this.front = front;
    }
    public String showInputOptionsVehicle(){
        return front.showInputOptionsVehicle().execute();
    }
}
