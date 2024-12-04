package com.lojageneradores.censo;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Clase principal para el censo de generadores en Loja.
 */
public class Main {
    
    public static final String BASE_URI = "http://localhost:8090/api/";

    /**
     * Inicia el servidor HTTP Grizzly y expone los recursos definidos en la aplicación.
     *
     * @return Servidor HTTP Grizzly.
     */
    public static HttpServer startServer() {
       
        final ResourceConfig rc = new ResourceConfig().packages("com.lojageneradores.censo.rest");

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Método principal.
     *
     * @param args Argumentos de línea de comandos.
     * @throws IOException En caso de error al iniciar el servidor.
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.printf("Aplicación iniciada en %s%nPresione Enter para detenerla...%n", BASE_URI);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Deteniendo el servidor...");
            server.shutdownNow();
        }));

        try {
            System.in.read();
        } catch (IOException e) {
            System.err.println("Error leyendo la entrada: " + e.getMessage());
        } finally {
            server.stop();
            System.out.println("Servidor detenido.");
        }
    }
}
