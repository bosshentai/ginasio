package sample.models;

public class PlanoTreino {

    private int id;
    private String name;
    private String descrition;
    private float amount;
    private int count = 1;

    public PlanoTreino(int id,String name,String descrition,float amount){
        this.id = id;
        this.name = name;
        this.descrition = descrition;
        this.amount = amount;
    }


}