package sopGenerator;

import java.util.HashMap;

/**
 * File:    META.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class META description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class META implements TAG{

    HashMap<String, String> attr;

    public META() {
        attr = new HashMap<>();
    }

    public META(String chst){
        attr = new HashMap<>();
        addAttr("charset", chst);
    }

    public void addAttr(String attribute, String value){
        if(attr.keySet().contains(attribute))
            return;
        attr.put(attribute, value);
    }

    public String getHTML(){
        String ret = "<meta ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += "/>\n";
        return ret;
    }
}
