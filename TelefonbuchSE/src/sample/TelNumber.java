package sample;

import javafx.beans.property.SimpleStringProperty;

public class TelNumber {
        private final SimpleStringProperty lastName = new SimpleStringProperty();
        private final SimpleStringProperty  firstName = new SimpleStringProperty();
        private final SimpleStringProperty  number = new SimpleStringProperty();
        private boolean isNew = true;

        public TelNumber() {
            this.lastName.set("...");
            this.firstName.set("...");
            this.number.set("...");
            isNew = true;
        }

        public TelNumber(String lastName, String firstName, String number) {
            this.lastName.set(lastName);
            this.firstName.set(firstName);
            this.number.set(number);
            isNew = false;
        }

        public TelNumber(TelNumber telNumber){
            this.lastName.set(telNumber.getLastName());
            this.firstName.set(telNumber.getFirstName());
            this.number.set(telNumber.getNumber());
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String value) {
            lastName.set(value);
            isNew = false;
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String value) {
            firstName.set(value);
            isNew = false;
        }

        public String getNumber() {
            return number.get();
        }

        public void setNumber(String value) {
            number.set(value);
            isNew = false;
        }

        public boolean isNew() {
            return isNew;
        }
}