package ada.locate.car.infra.dto;

public record ClientDTO(Long id, String name, String address, String phoneNumber, String email, String flagIdentification, String document) {

    @Override
    public String toString() {
        return "Builder{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", identification='" + flagIdentification + '\'' +
                '}';
    }
    public static class Builder {
        private Long id;
        private String name;
        private String address;
        private String phoneNumber;
        private String email;
        private String flagIdentification;
        private String document;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

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

        public Builder flagIdentification(String flagIdentification) {
            this.flagIdentification = flagIdentification;
            return this;
        }

        public ClientDTO build() {
            return new ClientDTO(id, name, address, phoneNumber, email, flagIdentification, document);
        }
    }
}
