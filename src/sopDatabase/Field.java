package sopDatabase;

/**
 * File:    Field.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class Field description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class Field {

    String name, type;
    boolean unique;

    public Field(String name, String type, boolean unique) {
        this.name = name;
        this.type = type;
        this.unique = unique;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isUnique(){
        return unique;
    }
}
