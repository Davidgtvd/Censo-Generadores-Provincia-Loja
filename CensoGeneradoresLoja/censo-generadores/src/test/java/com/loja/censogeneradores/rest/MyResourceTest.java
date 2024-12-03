package com.lojageneradores.censo.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // Inicia el servidor de la aplicación
        server = Main.startServer();
        // Crea un cliente para hacer peticiones a la API
        Client c = ClientBuilder.newClient();

        // Configura la URL base para las peticiones
        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        // Detiene el servidor después de las pruebas
        server.stop();
    }

    /**
     * Test para obtener una lista de casas desde el endpoint REST.
     */
    @Test
    public void testGetCasas() {
        // Realiza una solicitud GET a la ruta /casas
        String responseMsg = target.path("casas").request().get(String.class);
        
        // Asegura que el mensaje sea lo que esperas (puedes cambiar este mensaje)
        assertEquals("Lista de casas obtenida con éxito", responseMsg);
    }

    /**
     * Test para obtener un generador desde el endpoint REST.
     */
    @Test
    public void testGetGenerador() {
        // Realiza una solicitud GET a la ruta /generadores/{id}
        // Cambia el id al generador que quieras probar
        String responseMsg = target.path("generadores/1").request().get(String.class);
        
        // Asegura que el generador con id 1 se haya encontrado
        assertEquals("Generador encontrado", responseMsg);
    }

    /**
     * Test para crear una casa a través del endpoint REST.
     */
    @Test
    public void testCreateCasa() {
        // Suponiendo que tienes un objeto Casa para enviar
        Casa casa = new Casa();
        casa.setDireccion("Calle Ficticia 123");
        casa.setNumeroGeneradores(2); // Cambia estos valores según tu modelo
        
        // Enviar la solicitud POST a /casas con un cuerpo JSON
        String responseMsg = target.path("casas").request().post(javax.ws.rs.client.Entity.entity(casa, javax.ws.rs.core.MediaType.APPLICATION_JSON), String.class);
        
        // Asegura que la casa fue creada correctamente
        assertEquals("Casa creada con éxito", responseMsg);
    }

    /**
     * Test para crear un generador a través del endpoint REST.
     */
    @Test
    public void testCreateGenerador() {
        // Suponiendo que tienes un objeto Generador para enviar
        Generador generador = new Generador();
        generador.setTipoEquipo("Generador de emergencia");
        generador.setPotencia(5.0); // Cambia estos valores según tu modelo
        
        // Enviar la solicitud POST a /generadores con un cuerpo JSON
        String responseMsg = target.path("generadores").request().post(javax.ws.rs.client.Entity.entity(generador, javax.ws.rs.core.MediaType.APPLICATION_JSON), String.class);
        
        // Asegura que el generador fue creado correctamente
        assertEquals("Generador creado con éxito", responseMsg);
    }
}
