package sopDatabase;

import sopGenerator.Form;

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

    List<Field> fields;
    String name;

    public Table(Form form, String name) {
        this.name = name;
        this.fields = form.getAllFields();
        createTable();
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
