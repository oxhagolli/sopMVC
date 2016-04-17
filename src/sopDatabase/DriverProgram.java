package sopDatabase;

import sopGenerator.Form;

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
        Table t = new Table(new Form() {
            @Override
            public void submit() {
                return;
            }

            @Override
            public void addAttr(String attribute, String value) {
                return;
            }

            @Override
            public String getHTML() {
                return null;
            }
        },
        "Mytbl");
        t.connectDB();
    }
}
