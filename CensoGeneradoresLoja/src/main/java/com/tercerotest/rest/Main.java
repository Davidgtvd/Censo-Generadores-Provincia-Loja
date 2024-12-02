package com.lojageneradores.censo;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import java.io.IOException;
import java.net.URI;

/**
 * Clase principal para el censo de generadores en Loja.
 */
public class Main {
    // Base URI donde el servidor escuchará
    public static final String BASE_URI = "http://localhost:8090/api/";

    /**
     * Inicia el servidor HTTP Grizzly y expone los recursos definidos en la aplicación.
     *
     * @return Servidor HTTP Grizzly.
     */
    public static HttpServer startServer() {
        // Configuración del recurso que escanea el paquete REST
        final ResourceConfig rc = new ResourceConfig().packages("com.lojageneradores.censo.rest");

        // Crear y arrancar un nuevo servidor HTTP en BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Método principal.
     *
     * @param args Argumentos de línea de comandos.
     * @throws IOException En caso de error al iniciar el servidor.
     */
    public static void main(String[] args) throws IOException {
        try {
            final HttpServer server = startServer();
            System.out.println(String.format("Aplicación iniciada en %s\nPresione Enter para detenerla...", BASE_URI));
            System.in.read();
            server.stop();
        } catch (Exception ex) {
            System.out.println("Error al iniciar el servidor: " + ex.getMessage());
        }
    }
}
