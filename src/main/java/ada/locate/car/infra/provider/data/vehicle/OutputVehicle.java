package ada.locate.car.infra.provider.data.vehicle;

import ada.locate.car.app.config.vehicle.FrontVehicleConfig;

public class OutputVehicle {
    private final FrontVehicleConfig front;

    public OutputVehicle(FrontVehicleConfig front) {
        this.front = front;
    }

    public void details(String details){
        front.readVehicle().execute(details);
    }
}
