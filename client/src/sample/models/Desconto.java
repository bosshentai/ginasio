package sample.models;

public class Desconto {

    private final String name;
    private final String descrition;
    private final int amount;



    public Desconto(String name,String descrition,int amount){

        this.name = name;
        this.descrition =descrition;
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
