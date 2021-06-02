package sample.models;

import javafx.beans.property.SimpleIntegerProperty;

public class PersonalTrainer extends Pessoa{

    private final SimpleIntegerProperty amount;

    public PersonalTrainer(String firstName,String lastName,String telephone,Integer numberBI,Integer amount){
        super(firstName,lastName,telephone,numberBI);
        this.amount = new SimpleIntegerProperty(amount);
    }

}
