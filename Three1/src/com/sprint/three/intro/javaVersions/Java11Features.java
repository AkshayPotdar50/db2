package com.sprint.three.intro.javaVersions;

// Java11Features.java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Stream;

public class Java11Features {

    public static void main(String[] args) throws Exception {

        // 1. New String methods
        String str = "  Java 11 is cool  ";
        System.out.println("isBlank: " + "   ".isBlank()); // true
        System.out.println("strip: '" + str.strip() + "'"); // trims leading & trailing whitespace
        System.out.println("stripLeading: '" + str.stripLeading() + "'");
        System.out.println("stripTrailing: '" + str.stripTrailing() + "'");
        System.out.println("repeat: " + "Java ".repeat(3)); // Java Java Java

        // 2. String.lines() - Returns a Stream of lines
        String multiline = "Java\nPython\nC++";
        System.out.println("Lines:");
        multiline.lines().forEach(System.out::println);

        // 3. HttpClient (standardized, replaces HttpURLConnection)
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://httpbin.org/get"))
                .build();

        System.out.println("Sending HTTP request...");
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response code: " + response.statusCode());
        System.out.println("Response body: " + response.body().substring(0, 100) + "...");

        // 4. Local var for lambda parameters (helps with annotations)
        Stream.of("Java", "11").forEach((var x) -> System.out.println("Item: " + x));

        // 5. Removal of Java EE and CORBA modules - internal change, not demoed here
        System.out.println("Java EE modules removed from JDK (e.g., javax.xml.bind).");
    }
}

