package sample.models;

public class PersonalTrainer extends Pessoa{

    private Integer amount;

    public PersonalTrainer(String firstName,String lastName,String telephone,Integer numberBI,Integer amount){
        super(firstName,lastName,telephone,numberBI);
        this.amount = amount;
    }
}
