package sopGenerator;

import java.util.HashMap;

/**
 * File:    A.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class A description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class A implements TAG{

    HashMap<String, String> attr;
    String content;

    public A(String content) {
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
        String ret = "<a ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += ">";
        ret+=content;
        ret+= "</a>\n";
        return ret;
    }
}
