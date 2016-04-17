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
public class Form implements TAG{

    HashMap<String, Field> fields;
    HashMap<String, String> attr;
    String content;

    public Form() {
        this.fields = new HashMap<>();
        attr = new HashMap<>();
    }

    public List<Field> getAllFields(){
        return new ArrayList<Field>(fields.values());
    }

    public void addInput(String name, String type, String value){
        content += "\t<input name=\""+name+"\" + type=\""+type+
                "\" value="+value+"/>\n";
    }

    public void addField(String name, String type, int maxlength){
        fields.put(name, new Field(name, type, false, maxlength));
    }

    public void addField(String name, String type, boolean unique, int maxlength){
        fields.put(name, new Field(name, type, unique, maxlength));
    }

    public Field getField(String name){
        return fields.get(name);
    }

    public void addAttr(String attribute, String value){
        if(attr.keySet().contains(attribute))
            return;
        attr.put(attribute, value);
    }

    public String getHTML(){
        String ret = "<form ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += ">\n";
        ret += content;
        ret += "<form/>\n";
        return ret;
    }
}
