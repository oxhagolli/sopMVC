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
    String content;

    public IMG(String content) {
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
        String ret = "<img ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += ">";
        ret+=content;
        ret+= "</img>\n";
        return ret;
    }
}
