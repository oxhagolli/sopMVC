/**
 * File:    sopMVC.java
 * Package: ---
 * Project: sopMVC
 * <p>
 * Class sopMVC contains basic framework methods.
 *
 * @author Orens Xhagolli
 * @version 4/16/2016
 */
public class sopMVC {

    public static void main(String[] args) {
        if(args.length < 1){
            usage();
        }

    }

    public static void usage(){
        System.err.println("usage: java sopMVC action [options...]");
        System.err.println("For help run: java sopMVC help");
        System.exit(1);
    }
}
