package ada.locate.car.provider.client;

import ada.locate.car.app.config.client.FrontClientConfig;

public class OutputClient {
    private final FrontClientConfig front;

    public OutputClient(FrontClientConfig front) {
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
