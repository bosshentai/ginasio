package sample.models;

import javafx.beans.property.SimpleIntegerProperty;

public class PersonalTrainer extends Pessoa{

    private final SimpleIntegerProperty amount;

    public PersonalTrainer(){

        this.amount = new SimpleIntegerProperty();
    }

    public PersonalTrainer(String firstName,String lastName,String telephone,Integer numberBI,Integer amount){
        super(firstName,lastName,telephone,numberBI);
        this.amount = new SimpleIntegerProperty(amount);
    }

    public int getAmount() {
        return amount.get();
    }

    public void setAmount(int amount) {
        this.amount.set(amount);
    }
}
