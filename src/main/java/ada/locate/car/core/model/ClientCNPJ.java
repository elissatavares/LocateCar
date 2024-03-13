package ada.locate.car.core.model;

import ada.locate.car.core.model.Client;

public class ClientCNPJ {
    private Client client;
    private String cnpj;

    public ClientCNPJ(String name, String address, String phoneNumber, String email, String cnpj) {
        this.client = new Client(name, address, phoneNumber, email);
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "ClientCNPJ{" +
                "client=" + client +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
