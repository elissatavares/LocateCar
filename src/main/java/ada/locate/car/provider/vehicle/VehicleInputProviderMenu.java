package ada.locate.car.provider.vehicle;

import ada.locate.car.config.record.vehicle.VehicleFrontendConfig;

public class VehicleInputProviderMenu {
    private final VehicleFrontendConfig front;

    public VehicleInputProviderMenu(VehicleFrontendConfig front) {
        this.front = front;
    }
    public String showInputOptionsVehicle(){
        return front.showInputOptionsVehicle().execute();
    }
}
