package ada.locate.car.provider.client;

import ada.locate.car.app.config.client.FrontClientConfig;

public class ClientMenuInputProvider {
    private final FrontClientConfig front;

    public ClientMenuInputProvider(FrontClientConfig front) {
        this.front = front;
    }

    public String optionsClient(){
        return front.optionsClient().execute();
    }
}
