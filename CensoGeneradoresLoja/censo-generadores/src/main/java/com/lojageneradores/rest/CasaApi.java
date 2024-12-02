package com.lojageneradores.censo.rest;

import com.lojageneradores.censo.models.Casa;
import com.lojageneradores.censo.services.CasaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/casa")
public class CasaApi {

    private CasaService casaService = new CasaService();  // Instanciamos el servicio que maneja las casas

    /**
     * Obtener todas las casas.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Casa> getAllCasas() {
        return casaService.getAllCasas();  // Llamamos al servicio que obtiene las casas
    }

    /**
     * Obtener una casa por su ID.
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCasa(@PathParam("id") int id) {
        Casa casa = casaService.getCasaById(id);  // Llamamos al servicio para obtener la casa por ID
        if (casa != null) {
            return Response.ok(casa).build();  // Si la casa existe, devolvemos la respuesta
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Casa no encontrada").build();  // Si no existe
        }
    }

    /**
     * Añadir una nueva casa.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCasa(Casa casa) {
        casaService.addCasa(casa);  // Llamamos al servicio para agregar la casa
        return Response.status(Response.Status.CREATED).entity(casa).build();  // Devolvemos la respuesta con el código 201
    }
}
