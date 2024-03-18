package ada.locate.car.provider.client;

import ada.locate.car.config.record.client.ClientFrontendConfig;

public class ClientInputProviderRead {
    private final ClientFrontendConfig front;

    public ClientInputProviderRead(ClientFrontendConfig front) {
        this.front = front;
    }
    public String optionsRead(){
        return front.optionsRead().execute();
    }
}
