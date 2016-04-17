package sopGenerator;

import java.util.HashMap;

/**
 * File:    P.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class P description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class P implements TAG{

    HashMap<String, String> attr;
    String content;

    public P(String content) {
        attr = new HashMap<>();
        this.content = content;
    }


    public void addAttr(String attribute, String value){
        if(attr.keySet().contains(attr))
            return;
        attr.put(attribute, value);
    }

    public void addContent(String content){
        this.content += content;
    }

    public String getHTML(){
        String ret = "<p ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += ">";
        ret+=content;
        ret+= "</p>\n";
        return ret;
    }
}
