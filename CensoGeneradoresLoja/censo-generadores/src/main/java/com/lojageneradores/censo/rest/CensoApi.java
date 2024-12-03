package com.lojageneradores.censo.rest;

import com.lojageneradores.censo.models.Censo;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Recurso REST para manejar los censos de generadores en las casas.
 */
@Path("/censo")
public class CensoApi {

    // Almacenamiento temporal de los censos (esto debe ser reemplazado por una base de datos real)
    private static List<Censo> censos = new ArrayList<>();

    /**
     * Obtener todos los censos.
     *
     * @return Lista de censos
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Censo> getCensos() {
        return censos;
    }

    /**
     * Obtener un censo por la dirección.
     *
     * @param direccion Dirección de la casa
     * @return Censo encontrado
     */
    @GET
    @Path("/{direccion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCenso(@PathParam("direccion") String direccion) {
        for (Censo censo : censos) {
            if (censo.getDireccion().equalsIgnoreCase(direccion)) {
                return Response.ok(censo).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Censo no encontrado").build();
    }

    /**
     * Registrar un nuevo censo.
     *
     * @param censo Datos del censo a registrar
     * @return Respuesta con el estado de la operación
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCenso(Censo censo) {
        censos.add(censo);
        return Response.status(Response.Status.CREATED).entity(censo).build();
    }

    /**
     * Eliminar un censo por la dirección.
     *
     * @param direccion Dirección de la casa a eliminar
     * @return Respuesta con el estado de la operación
     */
    @DELETE
    @Path("/{direccion}")
    public Response deleteCenso(@PathParam("direccion") String direccion) {
        for (Censo censo : censos) {
            if (censo.getDireccion().equalsIgnoreCase(direccion)) {
                censos.remove(censo);
                return Response.ok().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Censo no encontrado").build();
    }
}
