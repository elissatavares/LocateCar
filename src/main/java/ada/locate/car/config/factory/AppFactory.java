package ada.locate.car.config.factory;

import ada.locate.car.config.record.FrontAppConfig;
import ada.locate.car.app.messages.MessagesApp;
import ada.locate.car.frontend.impl.ShowMainMenu;

public class AppFactory {
    public static FrontAppConfig createFrontConfigApp(){
        return new FrontAppConfig( new ShowMainMenu(MessagesApp.MAIN_MENU.get(), MessagesApp.MAIN_OPTIONS_MENU.get()));
    }
}
