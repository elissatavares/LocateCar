package ada.locate.car.infra.provider.data.vehicle;

import ada.locate.car.app.config.vehicle.FrontVehicleConfig;

public class VehicleUpdateInputProvider {
    private final FrontVehicleConfig front;

    public VehicleUpdateInputProvider(FrontVehicleConfig front) {
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
