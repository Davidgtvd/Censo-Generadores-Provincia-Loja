package com.lojageneradores.censo.rest;

import com.lojageneradores.censo.models.Generador;
import com.lojageneradores.censo.services.GeneradorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/generador")
public class GeneradorApi {

    private GeneradorService generadorService = new GeneradorService();  // Instanciamos el servicio que maneja los generadores

    /**
     * Obtener todos los generadores.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Generador> getAllGeneradores() {
        return generadorService.getAllGeneradores();  // Llamamos al servicio para obtener todos los generadores
    }

    /**
     * Obtener un generador por su ID.
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGenerador(@PathParam("id") int id) {
        Generador generador = generadorService.getGeneradorById(id);  // Llamamos al servicio para obtener el generador por ID
        if (generador != null) {
            return Response.ok(generador).build();  // Si existe, devolvemos la respuesta
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Generador no encontrado").build();  // Si no existe
        }
    }

    /**
     * Añadir un nuevo generador.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGenerador(Generador generador) {
        generadorService.addGenerador(generador);  // Llamamos al servicio para agregar el generador
        return Response.status(Response.Status.CREATED).entity(generador).build();  // Devolvemos la respuesta con el código 201
    }
}
