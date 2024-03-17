package ada.locate.car.infra.provider.data.vehicle;

import ada.locate.car.app.config.vehicle.FrontVehicleConfig;

public class VehicleCreateInputProvider {
    private final FrontVehicleConfig front;

    public VehicleCreateInputProvider(FrontVehicleConfig front) {
        this.front = front;
    }
    public String[] showDataVehicleEntry(){
        return front.showDataVehicleEntry().execute();
    }
    public String showInputOptionsModel(){
        return front.showInputOptionsModel().execute();
    }
}
