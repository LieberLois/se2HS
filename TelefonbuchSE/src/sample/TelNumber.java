package sample;

public class TelNumber {
    private final String firstName;
    private final String lastName;
    private final String number;

    // für JavaFX: StringProperties

    public TelNumber(String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }
}
