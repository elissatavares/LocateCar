package ada.locate.car.infra.provider.data.client;

import ada.locate.car.app.config.client.FrontClientConfig;

public class ClientInputDocument {
    private final FrontClientConfig front;

    public ClientInputDocument(FrontClientConfig front) {
        this.front = front;
    }
    public String document(String type){
        return type.equalsIgnoreCase("CPF") ? front.CPFentry().execute() : front.CNPJentry().execute();
    }
}
