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
        server = Main.startServer();
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testGetCasas() {
        String responseMsg = target.path("casas").request().get(String.class);
        assertEquals("Lista de casas obtenida con éxito", responseMsg);
    }

    @Test
    public void testGetGenerador() {
        String responseMsg = target.path("generadores/1").request().get(String.class);
        assertEquals("Generador encontrado", responseMsg);
    }

    @Test
    public void testCreateCasa() {
        Casa casa = new Casa();
        casa.setDireccion("Calle Ficticia 123");
        casa.setNumeroGeneradores(2);
        String responseMsg = target.path("casas").request()
                .post(javax.ws.rs.client.Entity.entity(casa, javax.ws.rs.core.MediaType.APPLICATION_JSON), String.class);
        assertEquals("Casa creada con éxito", responseMsg);
    }

    @Test
    public void testCreateGenerador() {
        Generador generador = new Generador();
        generador.setTipoEquipo("Generador de emergencia");
        generador.setPotencia(5.0);
        String responseMsg = target.path("generadores").request()
                .post(javax.ws.rs.client.Entity.entity(generador, javax.ws.rs.core.MediaType.APPLICATION_JSON), String.class);
        assertEquals("Generador creado con éxito", responseMsg);
    }
}
