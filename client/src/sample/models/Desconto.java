package sample.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Desconto {

    private SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty descrition;
    private final SimpleIntegerProperty amount;


    public Desconto(){
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.descrition = new SimpleStringProperty();
        this.amount = new SimpleIntegerProperty();
    }

    public Desconto(String name,String descrition,int amount){

        this.name = new SimpleStringProperty(name);
        this.descrition = new SimpleStringProperty(descrition);
        this.amount = new SimpleIntegerProperty(amount);
    }

    public void setId(Integer id){ this.id.set(id);}

    public void setName(String name){ this.name.set(name);}

    public void setDescrition(String descrition){ this.descrition.set(descrition);}

    public void setAmount(Integer amount){this.amount.set(amount);}

    public String getName() {
        return name.get();
    }

    public String getDescrition() {
        return descrition.get();
    }

    public int getAmount() {
        return amount.get();
    }
}
