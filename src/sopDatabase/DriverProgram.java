package sopDatabase;

import sopGenerator.Form;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * File:    DriverProgram.java
 * Package: sopDatabase
 * Project: sopMVC
 * <p>
 * Class DriverProgram description.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class DriverProgram {

    public static void main(String[] args) {
        Form f = new Form();
        f.addField("fname","varchar", 30);
        f.addField("lname", "varchar", 30);
        f.addField("email", "varchar", 30);
        Table t = new Table(f, "names_test");
        HashMap<String, String> hm = new HashMap<>();

        List<Row> list = t.get("email", "oxx6096@rit.edu");
        System.out.println(list);
    }
}
