package sample.models;

import java.util.ArrayList;

public class Ginasio {

    private String name;

    private ArrayList<PlanoTreino> planoTreinos;


    public Ginasio(){
        this.name = "Ginasio";
    }

    public String getName() {
        return name;
    }

        public void addPlanoTreino(PlanoTreino plano){
        this.planoTreinos.add(plano);
    }
}
