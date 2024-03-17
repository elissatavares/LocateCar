package ada.locate.car.provider.client;

import ada.locate.car.app.config.client.FrontClientConfig;

public class ClientReadInputProvider {
    private final FrontClientConfig front;

    public ClientReadInputProvider(FrontClientConfig front) {
        this.front = front;
    }
    public String optionsRead(){
        return front.optionsRead().execute();
    }
}
