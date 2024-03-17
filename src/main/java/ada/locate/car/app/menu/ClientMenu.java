package ada.locate.car.app.menu;

import ada.locate.car.app.config.client.ClientMenuConfig;

public class ClientMenu implements Menu {

    private final ClientMenuConfig config;

    public ClientMenu(ClientMenuConfig config) {
        this.config = config;
    }


    @Override
    public void run() {
        String option = config.front().optionsClient().execute();

        if (option.isEmpty()) {
            return;
        }

        switch (option.toLowerCase().trim()) {
            case "create" -> config.controller().create().execute();
            case "read" -> config.controller().read().execute();
            case "update" -> config.controller().update().execute();
            case "delete" -> config.controller().delete().execute();
        }
    }
}

