package sample.data;


import sample.models.Desconto;
import sample.models.PersonalTrainer;
import sample.models.PlanoTreino;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    protected static final String DB_NAME = "ginasio.db";
    protected static final String PATCH = "./src/";
    protected static final String CONNECTION_STRING = "jdbc:sqlite:" + PATCH + DB_NAME;

    private static final String TABLE_PLANOTREINO = "planoTreino";
    private static final String COLUMN_PLANOTREINO_ID = "_id";
    private static final String COLUMN_PLANOTREINO_NAME = "name";
    private static final String COLUMN_PLANOTREINO_DESCRITION = "descrition";
    private static final String COLUMN_PLANOTREINO_AMOUNT = "amount";
    private static final int INDEX_PLANOTREINO_ID = 1;
    private static final int INDEX_PLANOTREINO_NAME = 2;
    private static final int INDEX_PLANOTREINO_DESCRITION = 3;
    private static final int INDEX_PLANOTREINO_AMOUNT = 4;

    private static final String TABLE_DESCONTO = "desconto";
    private static final String COLUMN_DESCONTO_ID = "_id";
    private static final String COLUMN_DESCONTO_NAME = "name";
    private static final String COLUMN_DESCONTO_DESCRITION = "descrition";
    private static final String COLUMN_DESCONTO_AMOUNT = "amount";
    private static final int INDEX_DESCONTO_ID = 1;
    private static final int INDEX_DESCONTO_NAME = 2;
    private static final int INDEX_DESCONTO_DESCRITION = 3;
    private static final int INDEX_DESCONTO_AMOUNT = 4;

    private static final String TABLE_PERSONALTRAINER = "personalTrainer";
    public static final String COLUMN_PERSONALTRAINER_ID = "_id";
    public static final String COLUMN_PERSONALTRAINER_FIRSTNAME = "firstName";
    public static final String COLUMN_PERSONALTRAINER_LASTNAME = "lastName";
    public static final String COLUMN_PERSONALTRAINER_PHONENUMBER = "phoneNumber";
    public static final String COLUMN_PERSONALTRAINER_NUMBERBI = "numberBI";
    public static final String COLUMN_PERSONALTRAINER_AMOUNT = "amount";
    private static final int INDEX_PERSONALTRAINER_ID = 1;
    private static final int INDEX_PERSONALTRAINER_FIRSTNAME = 2;
    private static final int INDEX_PERSONALTRAINER_LASTNAME = 3;
    private static final int INDEX_PERSONALTRAINNER_PHONENUMBER = 4;
    private static final int INDEX_PERSONALTRAINER_NUMBERBI = 5;
    public static final int INDEX_PERSONALTRAINER_AMOUNT = 6;


    public static final String TABLE_CLIENT = "client";
    public static final String COLUMN_CLIENT_ID = "_id";
    public static final String COLUMN_CLIENT_FIRSTNAME = "firstName";
    public static final String COLUMN_CLIENT_LASTNAME = "lastName";
    public static final String COLUMN_CLIENT_PHONENUMBER = "phoneNumber";
    public static final String COLMUN_CLIENT_NUMBERBI = "numberBI";


    public static final String INSERT_PLANOTREINO = "INSERT INTO " + TABLE_PLANOTREINO +
            " (" + COLUMN_PLANOTREINO_NAME + "," + COLUMN_PLANOTREINO_DESCRITION + ","
            + COLUMN_PLANOTREINO_AMOUNT + ") VALUES (?,?,?);";

    public static final String INSERT_DESCONTO = "INSERT INTO " + TABLE_DESCONTO +
            " (" + COLUMN_DESCONTO_NAME + ", " + COLUMN_DESCONTO_DESCRITION + " ,"
            + COLUMN_DESCONTO_AMOUNT + ") VALUES (?,?,?);";

    public static final String INSERT_PERSONALTRAINER = "INSERT INTO " + TABLE_PERSONALTRAINER +
            "( " + COLUMN_PERSONALTRAINER_FIRSTNAME + "," + COLUMN_PERSONALTRAINER_LASTNAME + ","
            + COLUMN_PERSONALTRAINER_PHONENUMBER + ", " + COLUMN_PERSONALTRAINER_NUMBERBI + ","
            + COLUMN_PERSONALTRAINER_AMOUNT + ") VALUES (?,?,?,?,?)";


    public static final String INSERT_CLIENT = "INSERT INTO " + TABLE_CLIENT +
            " (" + COLUMN_CLIENT_FIRSTNAME + "," + COLUMN_CLIENT_LASTNAME + ","
            + COLUMN_CLIENT_PHONENUMBER + "," + COLMUN_CLIENT_NUMBERBI + ") VALUES(?,?,?,?)";

    private PreparedStatement insertPlanoTreino;
    private PreparedStatement insertDesconto;
    private PreparedStatement insertPersonalTrainer;
    private PreparedStatement insertClient;


    protected Connection conn;

    protected static Datasource instance = new Datasource();

    protected Datasource() {

    }

    public static Datasource getInstance() {
        return instance;
    }

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            insertPlanoTreino = conn.prepareStatement(INSERT_PLANOTREINO);
            insertDesconto = conn.prepareStatement(INSERT_DESCONTO);
            insertPersonalTrainer = conn.prepareStatement(INSERT_PERSONALTRAINER);
            insertClient = conn.prepareStatement(INSERT_CLIENT);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {

            if(insertClient != null){
                insertClient.close();
            }

            if (insertPersonalTrainer != null) {
                insertPersonalTrainer.close();
            }

            if (insertDesconto != null) {
                insertDesconto.close();
            }

            if (insertPlanoTreino != null) {
                insertPlanoTreino.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Coudn't close connection" + e.getMessage());
        }
    }


    public List<PersonalTrainer> queryPersonalTrainer() {

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_PERSONALTRAINER);

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {


            List<PersonalTrainer> personalTrainers = new ArrayList<>();


            while (results.next()) {
                PersonalTrainer personalTrainer = new PersonalTrainer();
                personalTrainer.setId(results.getInt(INDEX_PERSONALTRAINER_ID));
                personalTrainer.setFirstName(results.getString(INDEX_PERSONALTRAINER_FIRSTNAME));
                personalTrainer.setLastName(results.getString(INDEX_PERSONALTRAINER_LASTNAME));
                personalTrainer.setPhoneNumber(results.getString(INDEX_PERSONALTRAINNER_PHONENUMBER));
                personalTrainer.setNumberBI(results.getInt(INDEX_PERSONALTRAINER_NUMBERBI));
                personalTrainer.setAmount(results.getInt(INDEX_PERSONALTRAINER_AMOUNT));

                personalTrainers.add(personalTrainer);

            }


            return personalTrainers;
        } catch (SQLException e) {
            System.out.println(" Query failed " + e.getMessage());
            return null;
        }
    }

    public List<Desconto> queryDesconto() {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_DESCONTO);

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<Desconto> descontos = new ArrayList<>();

            while (results.next()) {
                Desconto desconto = new Desconto();
                desconto.setId(results.getInt(INDEX_DESCONTO_ID));
                desconto.setName(results.getString(INDEX_DESCONTO_NAME));
                desconto.setDescrition(results.getString(INDEX_DESCONTO_DESCRITION));
                desconto.setAmount(results.getInt(INDEX_DESCONTO_AMOUNT));
                descontos.add(desconto);
            }

            return descontos;
        } catch (SQLException e) {
            System.out.println(" Query failed " + e.getMessage());
            return null;
        }
    }

    public List<PlanoTreino> queryPlanoTreino() {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_PLANOTREINO);

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<PlanoTreino> planoTreinos = new ArrayList<>();

            while (results.next()) {
                PlanoTreino planoTreino = new PlanoTreino();
                planoTreino.setId(results.getInt(INDEX_PLANOTREINO_ID));
                planoTreino.setName(results.getString(INDEX_PLANOTREINO_NAME));
                planoTreino.setDescrition(results.getString(INDEX_PLANOTREINO_DESCRITION));
                planoTreino.setAmount(results.getInt(INDEX_PLANOTREINO_AMOUNT));
                planoTreinos.add(planoTreino);
            }
            return planoTreinos;

        } catch (SQLException e) {
            System.out.println(" Query failed " + e.getMessage());
            return null;
        }
    }

    public void registerPersonalTrainer(String firstName, String lastName, String phoneNumber, int numberBI, int amount) {
        try {
            conn.setAutoCommit(false);
            insertPersonalTrainer.setString(1, firstName);
            insertPersonalTrainer.setString(2, lastName);
            insertPersonalTrainer.setString(3, phoneNumber);
            insertPersonalTrainer.setInt(4, numberBI);
            insertPersonalTrainer.setInt(5, amount);

            int affectedRows = insertPersonalTrainer.executeUpdate();
            if (affectedRows == 1) {
                conn.commit();
            } else {
                throw new SQLException(" Insert PersonalTrainer failed");
            }

        } catch (SQLException e) {
            System.out.println(" insert PersonalTrainer" + e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println("is bad to get here" + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Reseting default commit behavior");
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldnt reset the autocommit" + e.getMessage());
            }
        }

    }

    public void registerPlanoTreino(String name, String descrition, int amount) {
        try {
            conn.setAutoCommit(false);
            insertPlanoTreino.setString(1, name);
            insertPlanoTreino.setString(2, descrition);
            insertPlanoTreino.setInt(3, amount);

            int affectedRows = insertPlanoTreino.executeUpdate();

            if (affectedRows == 1) {
                conn.commit();
            } else {
                throw new SQLException(" Insert PlanoTreino failed");
            }

        } catch (SQLException e) {
            System.out.println("insert planoTreino: " + e.getMessage());

            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println(" is bad to get here " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Reseting default commit behavior");
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println(" Coudnt reset auto-commit! " + e.getMessage());
            }
        }
    }

    public void registerDesconto(String name, String descrition, int amount) {
        try {
            conn.setAutoCommit(false);
            insertDesconto.setString(1, name);
            insertDesconto.setString(2, descrition);
            insertDesconto.setInt(3, amount);

            int affectedRows = insertDesconto.executeUpdate();

            if (affectedRows == 1) {
                conn.commit();
            } else {
                throw new SQLException(" Insert Desconto failed!");
            }
        } catch (SQLException e) {
            System.out.println(" Insert desconto: " + e.getMessage());

            try {
                System.out.println("performing rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println(" is bad to get here " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Reseting default commit behavior");
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("couldnt default auto-commit" + e.getMessage());
            }
        }
    }


    public void registerClient(String firstName,String lastName,String phoneNumber,int numberBI){
        try{
            conn.setAutoCommit(false);
            insertClient.setString(1,firstName);
            insertClient.setString(2,lastName);
            insertClient.setString(3,phoneNumber);
            insertClient.setInt(4,numberBI);

            int affectedRows = insertClient.executeUpdate();
            if(affectedRows == 1){
                conn.commit();
            }
        }catch(SQLException e){
            System.out.println(" insert client: " + e.getMessage());
            try{
                System.out.println("performing rollback");
                conn.rollback();
            }catch(SQLException e2){
                System.out.println(" is bad to get here " + e2.getMessage());
            }
        }finally{
            try{
                System.out.println("Reseting default commit behavior");
                conn.setAutoCommit(true);
            }catch(SQLException e)
            {
                System.out.println("couldnt default auto-commit " + e.getMessage());
            }
        }
    }

}
