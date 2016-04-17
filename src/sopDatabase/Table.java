package sopDatabase;

import sopGenerator.Form;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://sopmvc.cfjoojz4a6p9.us-west-2" +
            ".rds.amazonaws.com:3306/sop";
    //  Database credentials
    private static final String USER = "sopMVC";
    private static final String PASS = "sopmvcsopmvc";
    private List<Field> fields;
    private String name;

    private java.sql.Connection conn = null;
    private java.sql.Statement stmt = null;

    public Table(Form form, String name) {
        this.name = name;
        this.fields = form.getAllFields();
        createTable();
    }

    private void createTable(){
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
            StringBuilder builderSQL = new StringBuilder();
            StringBuilder constraints = new StringBuilder();

            builderSQL
                    .append("CREATE TABLE if not exists ")
                    .append(this.name)
                    .append("(id INTEGER not NULL AUTO_INCREMENT ");
            for (Field fieldname : this.fields) {
                builderSQL
                        .append(", ")
                        .append(fieldname.getName())
                        .append(" ")
                        .append(fieldname.getType())
                        .append(" (")
                        .append(fieldname.getLength())
                        .append(")");
                if (fieldname.isUnique()) {
                    if (unique.length() < 1) {
                        constraints.append("CONSTRAINT constraint_name UNIQUE" +
                                " (fieldname");
                    } else {
                        constraints.append(",fieldname");
                    }
                }
            }
            constraints.append(", PRIMARY KEY (id)");
            constraints.append(");");

            builderSQL.append(constraints);
            stmt.executeUpdate(new String(builderSQL));
            System.out.println("Created table in given database...");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }

    public void put(Row newRow){
        StringBuilder insertStatement = new StringBuilder();
        insertStatement.append("Insert into ").append(this.name).append(" (");
        StringBuilder cols = new StringBuilder();
        StringBuilder vals = new StringBuilder();


        for(String field: newRow.getFields()){
            String value = newRow.get(field);
            if (!(cols.length() < 1)) {
                cols.append(",").append(field);
            }  else {
                cols.append(field);
            }

            if (!(vals.length() < 1)) {
                vals.append(",").append("\"").append(value).append("\"");
            }
            else {
                vals.append("(").append("\"").append(value).append("\"");
            }
        }
        cols.append(") VALUES");

        vals.append(");");

        insertStatement.append(cols);
        insertStatement.append(vals);

        try {
            stmt.executeUpdate(new String(insertStatement));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    //NOT DONE YET
    public List<Row> get(String field, String value){
        List<Row> results = new ArrayList<>();

        try {
            String qry = "select * from "+name+" where "+field + "='" + value+"';";
            ResultSet resultSet = stmt.executeQuery(qry);

            java.sql.ResultSetMetaData rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Row row = new Row(new HashMap<>());
                for (int i = 1; i<=rsmd.getColumnCount();i++) {
                    Field f = new Field(
                            rsmd.getColumnName(i),
                            rsmd.getColumnTypeName(i),
                            false,
                            256);
                    row.put(f, resultSet.getString(f.getName()));
                }
                results.add(row);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return results;
    }

    public void update(Field unique,
                       String uniqueValue,
                       Field field,
                       String newValue){

    }
}
