package sopGenerator;

import java.util.HashMap;

/**
 * File:    TEXTAREA.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class TEXTAREA description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class TEXTAREA implements TAG{

    HashMap<String, String> attr;
    String content;

    public TEXTAREA(String content) {
        attr = new HashMap<>();
        this.content = content;
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
        String ret = "<textarea ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += ">";
        ret+=content;
        ret+= "</textarea>\n";
        return ret;
    }
}
