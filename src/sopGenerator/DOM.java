package sopGenerator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * File:    DOM.java
 * Package: sopGenerator
 * Project: sopMVC
 * <p>
 * Class DOM description.
 *
 * @author Orens Xhagolli
 * @version 4/17/2016
 */
public abstract class DOM {

    private String HTMLBuilder;

    public DOM(String title, String lang) {
        HTMLBuilder = "<!DOCTYPE html>\n<html lang=\""+lang+"\">\n<head>\n";
        HTMLBuilder += "<title>"+title+"</title>\n";
        HTMLBuilder += "<meta charset=\"UTF-8\" />";
        HTMLBuilder += header();
        HTMLBuilder += "<link rel='Stylesheet' type='text/css' href='https://" +
                "raw.githubusercontent.com/oxhagolli/sopMVC/master/public/" +
                "style.css' />";
        HTMLBuilder += "</head>\n<body>\n";
        HTMLBuilder += body();
        HTMLBuilder += "</body>\n</html>\n";
    }

    public abstract String header();

    public abstract String body();

    public void makeFile(String filename){
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            writer.println(HTMLBuilder);
            writer.close();
        }
        catch (IOException e){
            System.err.println("Error opening file!");
        }
    }
}
