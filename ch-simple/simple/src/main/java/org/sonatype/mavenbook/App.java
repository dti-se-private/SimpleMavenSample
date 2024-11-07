package org.sonatype.mavenbook;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.UUID;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        UUID uuid = UUID.randomUUID();

        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = "Hello from the server! (Check!!) UUID:" + uuid;
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        server.start();
        System.out.println("Server started on port 8000");
    }
}
