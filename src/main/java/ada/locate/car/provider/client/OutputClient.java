package ada.locate.car.provider.client;

import ada.locate.car.config.record.client.ClientFrontendConfig;

public class OutputClient {
    private final ClientFrontendConfig front;

    public OutputClient(ClientFrontendConfig front) {
        this.front = front;
    }

    public void details(String details){
        front.read().execute(details);
    }
    public void createdSuccessfully(String details){
        front.createdSuccessfully().execute(details);
    }

    public void deletedSuccessfully(String details){
        front.deletedSuccessfully().execute(details);
    }
    public void updatedSuccessfully(String details){
        front.updatedSuccessfully().execute(details);
    }
}
