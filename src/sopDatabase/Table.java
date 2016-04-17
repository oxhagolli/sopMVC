package sopDatabase;

import sopGenerator.Form;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * File:    Table.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class Table description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class Table {


    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://sopmvc.cfjoojz4a6p9.us-west-2" +
            ".rds.amazonaws.com:3306/sop";
    //  Database credentials
    static final String USER = "sopMVC";
    static final String PASS = "sopmvcsopmvc";
    List<Field> fields;
    String name;

    public Table(Form form, String name) {
        this.name = name;
        this.fields = form.getAllFields();
        createTable();
    }

    public void connectDB() {

        java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();


            String unique = "";

            String fields[] = null;
            boolean boolVal = false;
            String type = "";
            StringBuilder builderSQL = new StringBuilder();
            StringBuilder constraints = new StringBuilder();


            String sql = "CREATE TABLE " + this.name + "(id INTEGER not NULL " +
                    "AUTO_INCREMENT ";
            builderSQL.append(sql);
            for (Field fieldname : this.fields) {
                builderSQL.append(", " + fieldname.getName() + " " + fieldname
                        .getType() + ",");
                if (fieldname.isUnique()) {
                    if (unique != null) {
                        constraints.append("CONSTRAINT constraint_name UNIQUE" +
                                " (fieldname");
                    } else {
                        constraints.append(",fieldname");
                    }
                }
                // table
            }
            constraints.append(", PRIMARY KEY (id)");//execute this to create the
            constraints.append(");");

            builderSQL.append(constraints);
            stmt.executeUpdate(new String(builderSQL));
            System.out.println("Created table in given database...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");


    }

    private void createTable(){
        //TODO: Create a table by iterating through all the fields
        //      fields = A list of class Field
        //               class Field has getName() and getType()
        //      primaryKey = the primary key FIELD for the table.
    }

    public void put(Row newRow){
        //TODO: Put the row information of the table.
        //      Row contains a get(Field field) method which returns a String
        for(Field field: newRow.getFields()){
            String value = newRow.get(field);
        }
    }

    //NOT DONE YET
    public List<Row> get(Field field, String value){

        return new ArrayList<>();
    }

    public void update(Field unique,
                       String uniqueValue,
                       Field field,
                       String newValue){

    }
}
