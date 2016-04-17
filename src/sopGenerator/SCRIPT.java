package sopGenerator;

import java.util.HashMap;

/**
 * File:    SCRIPT.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class SCRIPT description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class SCRIPT implements TAG{

    HashMap<String, String> attr;
    String content;

    public SCRIPT() {
        attr = new HashMap<>();
    }

    public SCRIPT(String source){
        addAttr("type", "text/javascript");
        addAttr("src", source);
    }

    public void addAttr(String attribute, String value){
        if(attr.keySet().contains(attribute))
            return;
        attr.put(attribute, value);
    }

    public void addContent(String content){
        this.content = content;
    }

    public String getHTML(){
        String ret = "<script ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += ">";
        ret+=content;
        return ret;
    }
}
