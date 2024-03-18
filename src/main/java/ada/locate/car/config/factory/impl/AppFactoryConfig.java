package ada.locate.car.config.factory.impl;

import ada.locate.car.config.factory.AppFactory;
import ada.locate.car.config.record.FrontAppConfig;

public class AppFactoryConfig {
    private final FrontAppConfig frontApp;
    public AppFactoryConfig() {
        frontApp = AppFactory.createFrontConfigApp();
    }

    public FrontAppConfig getFrontApp() {
        return frontApp;
    }
}
