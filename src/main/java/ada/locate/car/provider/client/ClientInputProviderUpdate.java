package ada.locate.car.provider.client;

import ada.locate.car.config.record.client.ClientFrontendConfig;

public class ClientInputProviderUpdate {
    private final ClientFrontendConfig front;

    public ClientInputProviderUpdate(ClientFrontendConfig front) {
        this.front = front;
    }
    public String typeClientUpdate(){
        return front.updateCPForCNPJ().execute();
    }
    public String optionsUpdate(){
        return front.optionsUpdate().execute();
    }
    public String nameUpdate(){
        return front.updateName().execute();
    }
    public String addressUpdate(){
        return front.updateAddress().execute();
    }

    public String phoneNumberUpdate(){
        return front.updatePhoneNumber().execute();
    }
    public String emailUpdate(){
        return front.updateEmail().execute();
    }
}
