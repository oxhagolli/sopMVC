package sopGenerator;

import java.util.HashMap;

/**
 * File:    INPUT.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class INPUT description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class INPUT implements TAG{

    HashMap<String, String> attr;
    String content;

    public INPUT(String content) {
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
        String ret = "<input ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += ">";
        ret+=content;
        ret+= "</input>\n";
        return ret;
    }
}
