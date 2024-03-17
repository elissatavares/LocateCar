package ada.locate.car.infra.provider.data.client;

import ada.locate.car.app.config.client.FrontClientConfig;

public class ClientCreateInputProvider {
    private final FrontClientConfig front;

    public ClientCreateInputProvider(FrontClientConfig front) {
        this.front = front;
    }
    public String optionCreate(){
        return front.optionCreate().execute();
    }

    public String[] dataClient(){
        return front.dataClient().execute();
    }
}
