import sopGenerator.*;

/**
 * File:    staticSOP.java
 * Package: PACKAGE_NAME
 * Project: sopMVC
 * <p>
 * Class staticSOP description.
 *
 * @author Orens Xhagolli
 * @version 4/17/2016
 */
public class staticSOP {

    public static void main(String[] args) {
        new DOM("Title", "en"){
            public String header(){
                String header = "";

                //TODO: FILL THIS
                //EXAMPLE:
                LINK link = new LINK(
                        "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css");
                link.addAttr("crossorigin", "anon");
                header += link.getHTML();


                return header;
            }

            public String body(){
                String body = "";

                //TODO: FILL THIS
                //EXAMPLE:
                //NOTE: getHTML is recursive so you only need to call it
                //on the outermost element.
                P para = new P("ASDEFJK;");
                DIV div = new DIV();
                div.addElement(para);

                DIV superdiv = new DIV();
                superdiv.addElement(div);
                body += superdiv.getHTML();
                return body;
            }
        }.makeFile("index.html");
    }
}
