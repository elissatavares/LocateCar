package ada.locate.car.provider.client;

import ada.locate.car.config.record.client.ClientFrontendConfig;

public class ClientInputProviderDocument {
    private final ClientFrontendConfig front;

    public ClientInputProviderDocument(ClientFrontendConfig front) {
        this.front = front;
    }
    public String document(String type){
        return type.equalsIgnoreCase("CPF") ? front.CPFentry().execute() : front.CNPJentry().execute();
    }
}
