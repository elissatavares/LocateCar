package ada.locate.car.infra.dto;

import ada.locate.car.core.model.Client;

public record ClientDTO(String name, String address, String phoneNumber, String email, String flagIdentification, String document, String description) {

    @Override
    public String toString() {
        return "Client: " +
                "Name: " + name +
                ", Address: " + address +
                ", PhoneNumber: " + phoneNumber +
                ", Email: " + email +
                ", Identification: " + flagIdentification +
                ", Document: " + document;
    }



    public static class Builder {
        private String name;
        private String address;
        private String phoneNumber;
        private String email;
        private String flagIdentification;
        private String document;
        private String description;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder document(String document) {
            this.document = document;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public Builder flagIdentification(String flagIdentification) {
            this.flagIdentification = flagIdentification;
            return this;
        }

        public ClientDTO build() {
            return new ClientDTO(name, address, phoneNumber, email, flagIdentification, document, description);
        }
    }

    public static ClientDTO convertClient(Client client){
        return new Builder()
                .name(client.getName())
                .address(client.getAddress())
                .phoneNumber(client.getPhoneNumber())
                .email(client.getEmail())
                .flagIdentification(client.getIdentification())
                .document(client.getDocument())
                .build();
    }

}
