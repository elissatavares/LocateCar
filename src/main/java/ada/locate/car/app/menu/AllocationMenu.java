package ada.locate.car.app.menu;

import ada.locate.car.app.config.allocation.AllocationMenuConfig;

public class AllocationMenu implements Menu {

    private final AllocationMenuConfig config;

    public AllocationMenu(AllocationMenuConfig config) {
        this.config = config;
    }

    @Override
    public void run() {
        String option = config.provider().create().optionAllocation();
        if (option.isEmpty()) {
            return;
        }
        switch (option.toLowerCase().trim()) {
            case "rent vehicle" -> config.controller().rentVehicle().execute();
            case "return rented vehicle"   -> config.controller().returnRentedVehicle().execute();
        }
    }
}
