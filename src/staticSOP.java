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
                String header = "Portfolio - Demo";

                //TODO: FILL THIS
                //EXAMPLE:
                LINK link = new LINK(
                        "http://patrickpistor.com/style/style.css");
                header += link.getHTML();


                return header;
            }

            public String body(){
                String body = "";

                //TODO: FILL THIS
                //EXAMPLE:
                //NOTE: getHTML is recursive so you only need to call it
                //on the outermost element.
                DIV navbar = new DIV();
                navbar.addAttr("style", "position: absolute; width: 100vw; z-index: 1;");
                UL unorderedList = new UL();
                unorderedList.addAttr("class", "navbar dark-navy opacity");

                LI link1 = new LI();
                A l1 = new A("Home");
                l1.addAttr("href", "index.html");
                l1.addAttr("class", "grey-active grey-hover");
                l1.addAttr("style", "margin-left: 15px");

                LI link2 = new LI();
                A l2 = new A("About");
                l2.addAttr("href", "about.html");
                l2.addAttr("class", "grey-hover");

                LI link3 = new LI();
                A l3 = new A("Projects");
                l3.addAttr("href", "proj.html");
                l3.addAttr("class", "grey-hover");

                LI link4 = new LI();
                A l4 = new A("Contact");
                l4.addAttr("href", "contact.html");
                l4.addAttr("class", "grey-hover");

                link1.addElement(l1);
                link2.addElement(l2);
                link3.addElement(l3);
                link4.addElement(l4);

                unorderedList.addElement(link1);
                unorderedList.addElement(link2);
                unorderedList.addElement(link3);
                unorderedList.addElement(link4);

                navbar.addElement(unorderedList);

                DIV background = new DIV();
                background.addAttr("class", "fixed-bg a-o");
                background.addAttr("style", "background-image: linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)),url('http://patrickpistor.com/style/DSCF7028.jpg');");

                DIV block = new DIV();
                block.addAttr("class", "center-block");

                H h1 = new H(1, "Hello, and welcome to my <strong>Portfolio</strong>.");
                h1.addAttr("class", "text-white");
                block.addElement(h1);
                background.addElement(block);

                DIV superdiv = new DIV();
                superdiv.addElement(navbar);
                superdiv.addElement(background);

                body += superdiv.getHTML();
                return body;
            }
        }.makeFile("index.html");
    }
}
