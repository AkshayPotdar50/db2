package com.sprint.three.intro.javaVersions;

// Java18Features.java

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.IOException;

public class Java18Features {

    public static void main(String[] args) throws IOException {

        // 1. Simple Web Server (JEP 408) – A minimal web server for development use
        // Starts a simple HTTP server, serves static files from the current directory
        System.out.println("Running a simple web server on port 8000...");
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", (HttpExchange exchange) -> {
            String response = "Hello, Java 18!";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });
        server.start();

        // 2. UTF-8 as the default Charset
        System.out.println("Default charset is now UTF-8.");
        System.out.println("Current Charset: " + Charset.defaultCharset());

        // 3. Vector API (Incubator) – To simplify working with vectors in Java (not demoed here)

        // 4. Javadoc snippets (@snippet)
        // Javadoc snippets allow embedding code snippets within Javadoc comments (not visible in this code)

        // 5. Foreign Function & Memory API (Incubator) – For native memory access (not demoed here)
        System.out.println("Java 18 also introduces experimental APIs for foreign functions and memory.");
    }
}
