package sample.models;

import sample.data.Datasource;

import java.util.ArrayList;

public class Gym {

    //private static Cliente clients = new Cliente();
    private ArrayList<Cliente> clients = new ArrayList<Cliente>();


    public boolean addClient(String firstName, String lastName, String phoneNumber,String numberBI){

        if(verifyClient( numberBI)){
         //   System.out.println("Client exist in the system");
            return false;
        }else{
          //  System.out.println("Client dont existe in the system");
            Datasource.getInstance().registerClient(firstName,lastName,phoneNumber,Integer.parseInt(numberBI));
            return true;
        }
    }


    public boolean verifyClient(String numberBI){
         Integer number =   Integer.parseInt(numberBI);
        System.out.println(" This test is the number is exist ");
        return Datasource.getInstance().queryClientNumberBI().contains(number);
    }
}
