package sopDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * File:    Row.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class Row description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class Row {

    HashMap<String, String> row;

    public Row(HashMap<String, String> row) {
        this.row = row;
    }

    public String get(Field field){
        return row.get(field.getName());
    }

    public String get(String field){
        return row.get(field);
    }

    public void put(Field field, String value){
        row.put(field.getName(), value);
    }

    public List<String> getFields(){
        return new ArrayList<>(row.keySet());
    }
}
