package com.lojageneradores.censo.rest;

import com.lojageneradores.censo.models.Casa;
import com.lojageneradores.censo.services.CasaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/casa")
public class CasaResource {

    private CasaService casaService = new CasaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Casa> getAllCasas() {
        return casaService.getAllCasas();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCasa(@PathParam("id") int id) {
        Casa casa = casaService.getCasaById(id);
        if (casa != null) {
            return Response.ok(casa).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Casa no encontrada").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCasa(Casa casa) {
        casaService.addCasa(casa);
        return Response.status(Response.Status.CREATED).entity(casa).build();
    }
}
