package com.loja.censogeneradores.services;

import com.loja.censogeneradores.dao.GeneradorDao;
import com.loja.censogeneradores.models.Generador;
import javax.ws.rs.*;
import java.util.List;

@Path("/generador")
public class GeneradorServices {

    private GeneradorDao generadorDao = new GeneradorDao(); // DAO para interactuar con los generadores

    // Método para agregar un nuevo generador
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Generador agregarGenerador(Generador generador) {
        return generadorDao.agregarGenerador(generador); // Se agrega el generador usando el DAO
    }

    // Método para obtener todos los generadores
    @GET
    @Produces("application/json")
    public List<Generador> obtenerGeneradores() {
        return generadorDao.obtenerTodosLosGeneradores(); // Se obtienen todos los generadores
    }

    // Método para obtener generadores por ID de casa
    @GET
    @Path("/casa/{casaId}")
    @Produces("application/json")
    public List<Generador> obtenerGeneradoresPorCasa(@PathParam("casaId") int casaId) {
        return generadorDao.obtenerGeneradoresPorCasa(casaId); // Se obtienen los generadores para una casa específica
    }

    // Método para actualizar la información de un generador
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Generador actualizarGenerador(@PathParam("id") int id, Generador generador) {
        return generadorDao.actualizarGenerador(id, generador); // Se actualiza el generador en el DAO
    }

    // Método para eliminar un generador por ID
    @DELETE
    @Path("/{id}")
    public void eliminarGenerador(@PathParam("id") int id) {
        generadorDao.eliminarGenerador(id); // Se elimina el generador usando el DAO
    }
}
