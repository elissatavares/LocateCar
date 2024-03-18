package ada.locate.car.provider.client;

import ada.locate.car.config.record.client.ClientFrontendConfig;

public class ClientInputProviderCreate {
    private final ClientFrontendConfig front;

    public ClientInputProviderCreate(ClientFrontendConfig front) {
        this.front = front;
    }
    public String optionCreate(){
        return front.optionCreate().execute();
    }

    public String[] dataClient(){
        return front.dataClient().execute();
    }
}
