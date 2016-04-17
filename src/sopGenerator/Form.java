package sopGenerator;

import sopDatabase.Field;

import java.util.ArrayList;
import java.util.HashMap;
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
public abstract class Form implements TAG{

    List<Field> fields;
    HashMap<String, String> attr;
    String content;

    public Form() {
        this.fields = new ArrayList<>();
        attr = new HashMap<>();
    }

    public List<Field> getAllFields(){
        return fields;
    }

    public void addInput(String name, String type, String value){

    }

    public void addField(String name, String type){
        fields.add(new Field(name, type, false));
    }

    public void addField(String name, String type, boolean unique){
        fields.add(new Field(name, type, unique));
    }

    public abstract void submit();
}
