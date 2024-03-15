package ada.locate.car.core.model;

public class Client {
    private static Long lastClientId = 0L;
    private Long id;
    private String flagIdentification;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String document;

    public Client(String name, String address, String phoneNumber, String email, String flagIdentification, String document) {
        this.id = generateNextId();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.flagIdentification = flagIdentification;
        this.document = document;
    }


    public Long getId() {
        return id;
    }

    private Long generateNextId() {
        return ++lastClientId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentification() {
        return flagIdentification;
    }

    public void setIdentification(String identification) {
        this.flagIdentification = identification;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                "identification='" + flagIdentification + '\'' +
                '}';
    }

    private enum Model {
        CPF("CPF"),
        CNPJ("CNPJ");

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
