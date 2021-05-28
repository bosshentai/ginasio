package sample.models;

public class PlanoTreino {


    private String name;
    private String descrition;
    private float amount;

    public PlanoTreino(String name,String descrition){
        this.name = name;
        this.descrition = descrition;
    }

    public PlanoTreino(String name,String descrition,float amount){

        this.name = name;
        this.descrition = descrition;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getDescrition() {
        return descrition;
    }

    public float getAmount() {
        return amount;
    }
}
