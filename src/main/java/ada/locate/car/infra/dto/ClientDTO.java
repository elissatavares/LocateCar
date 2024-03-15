package ada.locate.car.infra.dto;

import ada.locate.car.core.model.Vehicle;

import java.util.List;

public record ClientDTO(String name, String address, String phoneNumber, String email, String identification) {

    @Override
    public String toString() {
        return "Builder{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", identification='" + identification + '\'' +
                '}';
    }
    public static class Builder {
        private String name;
        private String address;
        private String phoneNumber;
        private String email;
        private String identification;

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

        public Builder identification(String cpf) {
            this.identification = cpf;
            return this;
        }

        public ClientDTO build() {
            return new ClientDTO(name, address, phoneNumber, email, identification);
        }
    }


}
