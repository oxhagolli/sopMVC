package sopGenerator;

import java.util.HashMap;

/**
 * File:    H.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class H description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class H implements TAG{
    HashMap<String, String> attr;
    String content;
    int i;

    public H(int i, String content) {
        attr = new HashMap<>();
        this.content = content;
        this.i = i;
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
        String ret = "<h" + i + " ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += ">";
        ret+=content;
        ret+= "</h"+i+">\n";
        return ret;
    }
}
