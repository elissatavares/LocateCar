package ada.locate.car.provider.client;

import ada.locate.car.config.record.client.ClientFrontendConfig;

public class ClientInputProviderDelete {
    private final ClientFrontendConfig front;

    public ClientInputProviderDelete(ClientFrontendConfig front) {
        this.front = front;
    }
    public String optionDelete(){
        return front.optionDelete().execute();
    }
}
