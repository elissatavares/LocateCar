package ada.locate.car.provider.vehicle;

import ada.locate.car.config.record.vehicle.VehicleFrontendConfig;

public class VehicleInputProviderUpdate {
    private final VehicleFrontendConfig front;

    public VehicleInputProviderUpdate(VehicleFrontendConfig front) {
        this.front = front;
    }

    public String showUpdatePlateEntry() {
        return front.showUpdatePlateEntry().execute();
    }

    public String showInputOptionsUpdateVehicle() {
        return front.showInputOptionsUpdateVehicle().execute();
    }

    public String colorUpdate() {
        return front.showUpdateColorEntry().execute();
    }

    public String plateNumberUpdate() {
        return front.showNewPlateNumberEntry().execute();
    }

    public String[] plateColorAndNumber() {
        return front.showColorAndPlateNumberUpdateDataEntry().execute();
    }
}
