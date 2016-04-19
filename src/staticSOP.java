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
        new DOM("Demo", "en") {
            public String header() {
                return "";
            }

            public String body() {
                String body = "";
                DIV navbar = new DIV();
                navbar.addAttr("style", "position: absolute; width: 100vw; z-index: 1;");
                UL unorderedList = new UL();
                unorderedList.addAttr("class", "navbar dark-navy opacity");

                LI link1 = new LI();
                A l1 = new A("Home");
                l1.addAttr("href", "index.html");
                l1.addAttr("class", "grey-hover");
                l1.addAttr("style", "margin-left: 15px");

                LI link2 = new LI();
                A l2 = new A("About");
                l2.addAttr("href", "about.html");
                l2.addAttr("class", "grey-hover grey-active");

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
                block.addAttr("class", "section group");

                DIV col1 = new DIV();
                col1.addAttr("class", "col c-1-1");

                H h1 = new H(1, "My <strong>Projects</strong>.");
                h1.addAttr("class", "text-white");
                h1.addAttr("style", "text-align: center; padding-top: 37px;");
                col1.addElement(h1);

                DIV col14 = new DIV();
                col14.addAttr("class", "col c-1-4");
                IMG p1 = new IMG();
                p1.addAttr("src","http://patrickpistor.com/style/DSCF6386.jpg");
                p1.addAttr("class","port round hover-opacity img-responsive");
                p1.addAttr("style","text-align: center;");
                col14.addElement(p1);

                DIV col15 = new DIV();
                col15.addAttr("class", "col c-1-4");
                IMG p2 = new IMG();
                p2.addAttr("src","http://patrickpistor.com/style/DSCF6802.jpg");
                p2.addAttr("class","port round hover-opacity img-responsive");
                p2.addAttr("style","text-align: center;");
                col15.addElement(p2);

                DIV col16 = new DIV();
                col16.addAttr("class", "col c-1-4");
                IMG p3 = new IMG();
                p3.addAttr("src","http://patrickpistor.com/style/DSCF7081.jpg");
                p3.addAttr("class","port round hover-opacity img-responsive");
                p3.addAttr("style","text-align: center;");
                col16.addElement(p3);

                DIV col17 = new DIV();
                col17.addAttr("class", "col c-1-4");
                IMG p4 = new IMG();
                p4.addAttr("src","http://patrickpistor.com/style/DSCF7071.jpg");
                p4.addAttr("class","port round hover-opacity img-responsive");
                p4.addAttr("style","text-align: center;");
                col17.addElement(p4);

                DIV col18 = new DIV();
                col18.addAttr("class", "col c-1-4");
                IMG p5 = new IMG();
                p5.addAttr("src","http://patrickpistor.com/style/DSCF7081.jpg");
                p5.addAttr("class","port round hover-opacity img-responsive");
                p5.addAttr("style","text-align: center;");
                col18.addElement(p5);

                DIV col19 = new DIV();
                col19.addAttr("class", "col c-1-4");
                IMG p6 = new IMG();
                p6.addAttr("src","http://patrickpistor.com/style/DSCF7766s.jpg");
                p6.addAttr("class","port round hover-opacity img-responsive");
                p6.addAttr("style","text-align: center;");
                col19.addElement(p6);

                DIV col20 = new DIV();
                col20.addAttr("class", "col c-1-4");
                IMG p7 = new IMG();
                p7.addAttr("src","http://patrickpistor.com/style/DSCF7857.jpg");
                p7.addAttr("class","port round hover-opacity img-responsive");
                p7.addAttr("style","text-align: center;");
                col20.addElement(p7);

                DIV col21 = new DIV();
                col21.addAttr("class", "col c-1-4");
                IMG p8 = new IMG();
                p8.addAttr("src","http://patrickpistor.com/style/DSCF8320.jpg");
                p8.addAttr("class","port round hover-opacity img-responsive");
                p8.addAttr("style","text-align: center;");
                col21.addElement(p8);



                block.addElement(col1);
                block.addElement(col14);
                block.addElement(col15);
                block.addElement(col16);
                block.addElement(col17);
                block.addElement(col18);
                block.addElement(col19);
                block.addElement(col20);
                block.addElement(col21);
                background.addElement(block);


                DIV superdiv = new DIV();
                superdiv.addElement(navbar);
                superdiv.addElement(background);

                body += superdiv.getHTML();
                return body;
            }
        }.makeFile("proj.html");
    }
}