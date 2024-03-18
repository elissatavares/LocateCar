package ada.locate.car.provider.client;

import ada.locate.car.config.record.client.ClientFrontendConfig;

public class ClientInputProviderMenu {
    private final ClientFrontendConfig front;

    public ClientInputProviderMenu(ClientFrontendConfig front) {
        this.front = front;
    }

    public String optionsClient(){
        return front.optionsClient().execute();
    }
}
