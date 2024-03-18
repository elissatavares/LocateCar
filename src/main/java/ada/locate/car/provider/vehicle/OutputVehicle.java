package ada.locate.car.provider.vehicle;

import ada.locate.car.config.record.vehicle.VehicleFrontendConfig;

public class OutputVehicle {
    private final VehicleFrontendConfig front;

    public OutputVehicle(VehicleFrontendConfig front) {
        this.front = front;
    }

    public void details(String details){
        front.readVehicle().execute(details);
    }
}
