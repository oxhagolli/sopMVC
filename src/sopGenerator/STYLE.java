package sopGenerator;

import java.util.HashMap;

/**
 * File:    STYLE.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class STYLE description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class STYLE implements TAG{

    HashMap<String, String> attr;
    String content;

    public STYLE() {
        attr = new HashMap<>();
        addAttr("type", "text/css");
    }

    public void addAttr(String attribute, String value){
        if(attr.keySet().contains(attribute))
            return;
        attr.put(attribute, value);
    }

    public void addContent(String content){
        this.content += content;
    }

    public String getHTML(){
        String ret = "<style ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += ">";
        ret+=content;
        ret+= "</style>\n";
        return ret;
    }
}
