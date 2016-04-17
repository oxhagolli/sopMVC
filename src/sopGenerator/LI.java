package sopGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * File:    LI.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class LI description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class LI implements TAG {

    private HashMap<String, String> attr;
    private List<TAG> elements;

    public LI() {
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
        String ret = "<LI ";
        for(String str: attr.keySet()){
            ret += str + "=\"" + attr.get(str) + "\" ";
        }
        ret += ">";
        for(TAG elem: elements){
            ret += elem.getHTML();
        }
        ret+= "</LI>\n";
        return ret;
    }
}
