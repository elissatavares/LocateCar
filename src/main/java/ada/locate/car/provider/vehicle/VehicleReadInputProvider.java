package ada.locate.car.provider.vehicle;

import ada.locate.car.app.config.vehicle.FrontVehicleConfig;

public class VehicleReadInputProvider {
    private final FrontVehicleConfig front;

    public VehicleReadInputProvider(FrontVehicleConfig config) {
        this.front = config;
    }

    public String searchModel() {
        return front.showInputOptionsInsertModelFilter().execute();
    }

    public String searchPlate() {
        return front.showFilterPlateEntry().execute();
    }

    public String searchColor() {
        return front.showFilterColorEntry().execute();
    }
    public String showInputOptionsReadVehicle(){
        return front.showInputOptionsReadVehicle().execute();
    }

}
