package sopGenerator;

import java.util.HashMap;

/**
 * File:    LINK.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class LINK description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class LINK implements TAG {

    HashMap<String, String> attr;
    public LINK() {
        attr = new HashMap<>();
    }

    public LINK(String source){
        attr = new HashMap<>();
        addAttr("rel", "stylesheet");
        addAttr("type", "text/css");
        addAttr("href", source);
    }

    public void addAttr(String attribute, String value){
        if(attr.keySet().contains(attribute))
            return;
        attr.put(attribute, value);
    }

    public String getHTML(){
        String ret = "<link ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += "/>\n";
        return ret;
    }
}
