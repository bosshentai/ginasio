package sample.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pessoa {
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty phoneNumber;
    private final SimpleIntegerProperty numberBI;

    public Pessoa(String firstName,String lastName,String phoneNumber,Integer numberBI){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.numberBI = new SimpleIntegerProperty(numberBI);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName(){
        return lastName.get();
    }

    public String getPhoneNumber(){
        return phoneNumber.get();
    }

    public int getNumberBI() {
        return numberBI.get();
    }
}