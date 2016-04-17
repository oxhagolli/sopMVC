import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
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
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(host, 80), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    public static class MyHandler implements HttpHandler{
        public void handle(HttpExchange t) throws IOException{
            Scanner scanner = new Scanner(new FileReader("index.html"));
            String response = "";
            while(scanner.hasNextLine())
                response += scanner.nextLine()+"\n";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.flush();
            os.close();
        }
    }

    private static void usage() {
        System.err.println("Usage: java DayTimeServer <host>");
        System.exit(1);
    }
}
