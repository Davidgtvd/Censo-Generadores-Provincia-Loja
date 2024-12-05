package com.lojageneradores.censo.rest;

import com.lojageneradores.censo.models.Generador;
import com.lojageneradores.censo.services.GeneradorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/generador")
public class GeneradorResource {

    private GeneradorService generadorService = new GeneradorService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Generador> getAllGeneradores() {
        return generadorService.getAllGeneradores();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGenerador(@PathParam("id") int id) {
        Generador generador = generadorService.getGeneradorById(id);
        if (generador != null) {
            return Response.ok(generador).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Generador no encontrado").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGenerador(Generador generador) {
        generadorService.addGenerador(generador);
        return Response.status(Response.Status.CREATED).entity(generador).build();
    }
}
