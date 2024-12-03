package com.loja.censogeneradores.services;

import com.loja.censogeneradores.dao.CasaDao;
import com.loja.censogeneradores.models.Casa;
import javax.ws.rs.*;
import java.util.List;

@Path("/casa")
public class CasaServices {

    private CasaDao casaDao = new CasaDao(); // DAO para interactuar con las casas

    // Método para agregar una nueva casa
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Casa agregarCasa(Casa casa) {
        return casaDao.agregarCasa(casa); // Se agrega la casa usando el DAO
    }

    // Método para obtener todas las casas
    @GET
    @Produces("application/json")
    public List<Casa> obtenerCasas() {
        return casaDao.obtenerTodasLasCasas(); // Se obtienen todas las casas
    }

    // Método para obtener una casa específica por ID
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Casa obtenerCasaPorId(@PathParam("id") int id) {
        return casaDao.obtenerCasaPorId(id); // Se obtiene la casa por su ID
    }

    // Método para actualizar la información de una casa
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Casa actualizarCasa(@PathParam("id") int id, Casa casa) {
        return casaDao.actualizarCasa(id, casa); // Se actualiza la casa en el DAO
    }

    // Método para eliminar una casa por ID
    @DELETE
    @Path("/{id}")
    public void eliminarCasa(@PathParam("id") int id) {
        casaDao.eliminarCasa(id); // Se elimina la casa usando el DAO
    }
}
