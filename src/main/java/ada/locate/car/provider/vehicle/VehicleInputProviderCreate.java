package ada.locate.car.provider.vehicle;

import ada.locate.car.config.record.vehicle.VehicleFrontendConfig;

public class VehicleInputProviderCreate {
    private final VehicleFrontendConfig front;

    public VehicleInputProviderCreate(VehicleFrontendConfig front) {
        this.front = front;
    }
    public String[] showDataVehicleEntry(){
        return front.showDataVehicleEntry().execute();
    }
    public String showInputOptionsModel(){
        return front.showInputOptionsModel().execute();
    }
}
