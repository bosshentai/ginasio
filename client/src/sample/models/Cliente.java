package sample.models;

public class Cliente extends Pessoa {
    private PlanoTreino planoTreino;
    private Desconto  desconto;

    public Cliente(String firstName, String lastName, String telephone, Integer numberBI) {
        super(firstName, lastName, telephone, numberBI);
    }
}
