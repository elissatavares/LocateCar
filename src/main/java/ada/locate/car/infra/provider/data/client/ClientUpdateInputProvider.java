package ada.locate.car.infra.provider.data.client;

import ada.locate.car.app.config.client.FrontClientConfig;

public class ClientUpdateInputProvider {
    private final FrontClientConfig front;

    public ClientUpdateInputProvider(FrontClientConfig front) {
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
