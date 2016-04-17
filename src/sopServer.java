import java.io.BufferedOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * File:    sopServer.java
 * Package: PACKAGE_NAME
 * Project: sopMVC
 * <p>
 * Class sopServer description.
 *
 * @author Orens Xhagolli
 * @version 4/17/2016
 */
public class sopServer {

    public static void main
            (String[] args)
            throws Exception {
        if (args.length != 1) usage();
        String host = args[0];
        ServerSocket serversocket = new ServerSocket();
        serversocket.bind(new InetSocketAddress(host, 80));
        for (; ; ) {
            Socket s = serversocket.accept();
            new Thread(() -> {
                try (Scanner scanner = new Scanner(s.getInputStream());
                     BufferedOutputStream out = new BufferedOutputStream(s
                             .getOutputStream())) {
                    while (scanner.hasNextLine())
                        System.out.println(scanner.nextLine());
                    out.write(Byte.parseByte("HTTP/1.1 200 OK"));
                    out.flush();
                    out.write(Byte.parseByte("Date: "+ new Date().toString()));
                    out.flush();
                } catch (Exception exc) {
                    exc.printStackTrace(System.err);
                }
            });
        }
    }


    private static void usage() {
        System.err.println("Usage: java DayTimeServer <host>");
        System.exit(1);
    }
}
