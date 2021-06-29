package sample.models;

import sample.data.Datasource;


public class Gym {


    public boolean addClient(Cliente cliente) {

        if (verifyClient(cliente.getNumberBI())) {

            return false;
        } else {

            Datasource.getInstance().registerClient(cliente.getFirstName(), cliente.getLastName(), cliente.getPhoneNumber(), cliente.getNumberBI());
            return true;
        }
    }


    public boolean addDesconto(Desconto desconto){
        return false;
    }

    public boolean verifyClient(Integer numberBI) {
        return Datasource.getInstance().queryClientNumberBI().contains(numberBI);
    }
}
