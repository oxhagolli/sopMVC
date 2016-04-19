package sopGenerator;

import java.util.HashMap;

/**
 * File:    IMG.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class IMG description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class IMG implements TAG{

    HashMap<String, String> attr;

    public IMG() {
        attr = new HashMap<>();
    }


    public void addAttr(String attribute, String value){
        if(attr.keySet().contains(attribute))
            return;
        attr.put(attribute, value);
    }


    public String getHTML(){
        String ret = "<img ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += " />";
        return ret;
    }
}
