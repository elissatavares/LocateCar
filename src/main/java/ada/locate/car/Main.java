package ada.locate.car;

import ada.locate.car.controller.impl.client.CreateClientCNPJ;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.controller.impl.vehicle.CreateVehicle;

public class Main {
    public static void main(String[] args) {
        Controller createVehicle = new CreateVehicle();
        Controller createClientCNPJ = new CreateClientCNPJ();

        createVehicle.execute();
        createClientCNPJ.execute();

        System.out.println("Hello world!");
    }
}