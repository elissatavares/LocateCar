package ada.locate.car.provider.vehicle;

import ada.locate.car.config.record.vehicle.VehicleFrontendConfig;

public class VehicleInputProviderRead {
    private final VehicleFrontendConfig front;

    public VehicleInputProviderRead(VehicleFrontendConfig config) {
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
