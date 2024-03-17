package ada.locate.car.infra.provider.data.client;

import ada.locate.car.app.config.client.FrontClientConfig;

public class ClientDeleteInputProvider {
    private final FrontClientConfig front;

    public ClientDeleteInputProvider(FrontClientConfig front) {
        this.front = front;
    }
    public String optionDelete(){
        return front.optionDelete().execute();
    }
}
