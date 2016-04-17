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

    private String name, type;
    private boolean unique;
    private int maxlength;

    public Field(String name, String type, boolean unique, int maxlength) {
        this.name = name;
        this.type = type;
        this.unique = unique;
        this.maxlength = maxlength;
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

    public int getLength(){
        return maxlength;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Field))
            return false;
        if (obj == this)
            return true;
        if (this.name.equals(((Field) obj).name) &&
                this.type.equals(((Field) obj).type))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + type.hashCode();
    }
}
