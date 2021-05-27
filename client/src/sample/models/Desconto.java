package sample.models;

public class Desconto {
    private int id;
    private String name;
    private String descrition;
    private float amount;



    public Desconto(int id,String name,String descrition,float amount){
        this.id = id;
        this.name = name;
        this.descrition =descrition;
        this.amount = amount;
    }
}
