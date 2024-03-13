package ada.locate.car.core.model;

public class Client {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Client(String name, String address, String phoneNumber, String email, String identification) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private enum Model {
        CPF("Client with CPF"),
        CNPJ("Client with CNPJ");

        private String description;

        Model(String description) {
            this.description = description;
        }

        public String get() {
            return description;
        }

        private static String allModels() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Client.Model model : Client.Model.values()) {
                stringBuilder.append(model.description).append("\n");
            }
            return stringBuilder.toString();
        }

    }

    public static String getModels(){
        return Client.Model.allModels();
    }
}
