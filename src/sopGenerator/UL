package sopGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * File:    DIV.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class DIV description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class UL implements TAG {

    private HashMap<String, String> attr;
    private List<TAG> elements;

    public UL() {
        attr = new HashMap<>();
        elements = new ArrayList<>();
    }

    public void addAttr(String attr, String value){
        this.attr.put(attr, value);
    }

    public void addElement(TAG element){
        elements.add(element);
    }

    public String getHTML(){
        String ret = "<UL ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += ">";
        for(TAG elem: elements){
            ret += elem.getHTML();
        }
        ret+= "</UL>\n";
        return ret;
    }
}
