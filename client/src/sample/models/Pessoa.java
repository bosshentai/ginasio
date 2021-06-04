package sample.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pessoa {
    private  SimpleIntegerProperty id ;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty phoneNumber;
    private final SimpleIntegerProperty numberBI;

    public Pessoa(){
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.phoneNumber = new SimpleStringProperty();
        this.numberBI = new SimpleIntegerProperty();
    }

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

    public void setId(int id) {
        this.id.set(id);
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public void setNumberBI(int numberBI) {
        this.numberBI.set(numberBI);
    }
}