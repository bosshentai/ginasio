package sample.models;



public class PlanoTreino {


    private String name;
    private String descrition;
    private int  amount;

    public PlanoTreino(String name, String descrition, int amount){
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

    public int getAmount() {
        return amount;
    }
}
