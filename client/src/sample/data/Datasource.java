package sample.data;



import java.sql.*;

public class Datasource {
    protected static final String DB_NAME = "ginasio.db";
    protected static final String PATCH = "./src/";
    protected static final String CONNECTION_STRING = "jdbc:sqlite:" + PATCH + DB_NAME;

    private static final String TABLE_PLANOTREINO = "planoTreino";
    private static final String COLUMN_PLANOTREINO_NAME = "name";
    private static final String COLUMN_PLANOTREINO_DESCRITION = "descrition";
    private static final String COLUMN_PLANOTREINO_AMOUNT = "amount";

    public static final String INSERT_PLANOTREINO = "INSERT INTO " + TABLE_PLANOTREINO +
            " (" + COLUMN_PLANOTREINO_NAME + "," + COLUMN_PLANOTREINO_DESCRITION + ","
            + COLUMN_PLANOTREINO_AMOUNT + ") VALUES (?,?,?);";

    private PreparedStatement insertPlanoTreino;

    protected Connection conn;

    protected static Datasource instance = new Datasource();

    protected Datasource(){

    }

    public static Datasource getInstance(){
        return instance;
    }

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            insertPlanoTreino = conn.prepareStatement(INSERT_PLANOTREINO);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {

            if(insertPlanoTreino != null){
                insertPlanoTreino.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Coudn't close connection" + e.getMessage());
        }
    }


    public void registerPlanoTreino(String name,String descrition,int amount) {
      try{
        conn.setAutoCommit(false);
        insertPlanoTreino.setString(1,name);
        insertPlanoTreino.setString(2,descrition);
        insertPlanoTreino.setInt(3,amount);

        int affectedRows = insertPlanoTreino.executeUpdate();

        if(affectedRows ==1){
            conn.commit();
        }else{
        throw new SQLException(" Insert PlanoTreino failed");
        }

      }catch (SQLException e){
          System.out.println("insert planoTreino: " + e.getMessage());

          try {
              System.out.println("Performing rollback");
              conn.rollback();
          }catch (SQLException e2){
              System.out.println(" is bad to get here " + e2.getMessage());
          }
      }finally {
          try {
              System.out.println("Reseting default commit behavior");
              conn.setAutoCommit(true);
          }catch (SQLException e){
              System.out.println(" Coudnt reset auto-commit! " + e.getMessage());
          }
      }
    }
}
