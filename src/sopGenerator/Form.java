package sopGenerator;

import sopDatabase.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * File:    Form.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class Form description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public abstract class Form {

    List<Field> fields;

    public Form() {
        this.fields = new ArrayList<>();
    }

    public List<Field> getAllFields(){
        return fields;
    }

    public void addField(String name, String type){
        fields.add(new Field(name, type, false));
    }

    public void addField(String name, String type, boolean unique){
        fields.add(new Field(name, type, unique));
    }

    public abstract void submit();
}
