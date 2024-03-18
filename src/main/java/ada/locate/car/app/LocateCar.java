package ada.locate.car.app;

import ada.locate.car.config.factory.impl.AllocationFactoryConfig;
import ada.locate.car.config.factory.impl.AppFactoryConfig;
import ada.locate.car.config.factory.impl.ClientFactoryConfig;
import ada.locate.car.config.factory.impl.VehicleFactoryConfig;
import ada.locate.car.config.record.FrontAppConfig;

import ada.locate.car.app.menu.Menu;

public class LocateCar {
    public static void run() {
        VehicleFactoryConfig vehicleFactoryConfig = new VehicleFactoryConfig();
        ClientFactoryConfig clientFactoryConfig = new ClientFactoryConfig();
        AllocationFactoryConfig allocationFactoryConfig = new AllocationFactoryConfig(vehicleFactoryConfig, clientFactoryConfig);

        Menu clientMenu = clientFactoryConfig.getClientMenu();
        Menu vehicleMenu = vehicleFactoryConfig.getVehicleMenu();
        Menu allocation = allocationFactoryConfig.getAllocationMenu();
        AppFactoryConfig appFactoryConfig = new AppFactoryConfig();

        FrontAppConfig frontApp = appFactoryConfig.getFrontApp();


        String option;
        do {
            //main menu
            //recebe de quem se trata a edição
            option = frontApp.showMainMenu().execute();

            if (!option.isEmpty()) {
                //direciona para o menu com as opções específicas de Client, Vehicle ou Alocation
                switch (option) {
                    case "Client" -> clientMenu.run();
                    case "Vehicle" -> vehicleMenu.run();
                    case "Location Vehicle" ->
                        allocation.run();
                }
            }
        } while (!option.isEmpty());
    }
}
