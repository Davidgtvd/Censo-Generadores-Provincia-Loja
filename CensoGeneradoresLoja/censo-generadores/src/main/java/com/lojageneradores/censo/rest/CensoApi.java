package com.example.rest.rest;

import com.example.rest.models.Censo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/censo")
public class CensoApi {

    private static List<Censo> censos = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Censo> getCensos() {
        return censos;
    }

    @GET
    @Path("/{direccion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCenso(@PathParam("direccion") String direccion) {
        return censos.stream()
                .filter(censo -> censo.getDireccion().equalsIgnoreCase(direccion))
                .findFirst()
                .map(censo -> Response.ok(censo).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).entity("Censo no encontrado").build());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCenso(Censo censo) {
        censos.add(censo);
        return Response.status(Response.Status.CREATED).entity(censo).build();
    }

    @DELETE
    @Path("/{direccion}")
    public Response deleteCenso(@PathParam("direccion") String direccion) {
        boolean removed = censos.removeIf(censo -> censo.getDireccion().equalsIgnoreCase(direccion));
        if (removed) {
            return Response.ok("Censo eliminado correctamente").build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Censo no encontrado").build();
    }
}
