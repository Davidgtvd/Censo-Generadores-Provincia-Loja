package com.tercerotest.rest;

import java.util.HashMap;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tercerotest.controller.tda.list.LinkedList;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
/*
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
*/
import java.io.FileInputStream;
import com.tercerotest.controller.dao.services.EquipoServices;
import com.tercerotest.controller.dao.services.MarcaServices;
import com.tercerotest.controller.dao.services.PersonaServices;

@Path("device")
public class EquipoApi {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        HashMap map = new HashMap<>();
        EquipoServices ps = new EquipoServices();
        map.put("msg", "OK");
        // TODO
        // map.put("data", ps.listAll().toArray());
        try {
            map.put("data", ps.listShowAll());
            if (ps.listAll().isEmpty()) {
                map.put("data", new Object[] {});
            }

        } catch (Exception e) {
            map.put("data", new Object[] {});
            System.out.println("Error "+e);
            // TODO: handle exception
        }
        return Response.ok(map).build();
    }

    @Path("/listType")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getType() {
        HashMap map = new HashMap<>();
        EquipoServices ps = new EquipoServices();
        map.put("msg", "OK");
        map.put("data", ps.getTiposEquipos());
        return Response.ok(map).build();
    }

    /*
     * @Path("/list/search/{texto}")
     * 
     * @GET
     * 
     * @Produces(MediaType.APPLICATION_JSON)
     * public Response getName(@PathParam("texto") String texto) {
     * HashMap map = new HashMap<>();
     * EquipoServices ps = new EquipoServices();
     * map.put("msg", "OK");
     * LinkedList lsita = ps.buscar_apellidos(texto);
     * map.put("data", lsita.toArray());
     * if (lsita.isEmpty()) {
     * map.put("data", new Object[] {});
     * }
     * 
     * return Response.ok(map).build();
     * }
     */
    @Path("/list/order/{attribute}/{type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrder(@PathParam("attribute") String attribute, @PathParam("type") Integer type) {
        HashMap map = new HashMap<>();
        EquipoServices ps = new EquipoServices();
        map.put("msg", "OK");
        // pd.order_object(LinkedList.ASC, "apellidos")
        try {
            LinkedList lsita = ps.order_object(type, attribute);
            map.put("data", lsita.toArray());
            if (lsita.isEmpty()) {
                map.put("data", new Object[] {});
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return Response.ok(map).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") Integer id) {
        HashMap map = new HashMap<>();
        EquipoServices ps = new EquipoServices();
        try {
            ps.setEquipo(ps.get(id));
        } catch (Exception e) {
            // TODO: handle exception
        }
        map.put("msg", "OK");
        map.put("data", ps.getEquipo());
        if (ps.getEquipo().getId() == null) {
            map.put("data", "No existe la Equipo con ese identificador");
            return Response.status(Status.BAD_REQUEST).entity(map).build();
        }
        return Response.ok(map).build();
    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap map) {
        // TODO
        // VALIDATION ---- BAD REQUEST
        HashMap res = new HashMap<>();
        Gson g = new Gson();
        String a = g.toJson(map);

        try {
            if (map.get("person") != null && map.get("brand") != null) {
                PersonaServices personaServices = new PersonaServices();
                personaServices.setPersona(personaServices.get(Integer.parseInt(map.get("person").toString())));
                MarcaServices marcaServices = new MarcaServices();
                marcaServices.setMarca(marcaServices.get(Integer.parseInt(map.get("brand").toString())));
                if (personaServices.getPersona().getId() != null && marcaServices.getMarca().getId() != null) {
                    EquipoServices ps = new EquipoServices();
                    ps.getEquipo().setCaracteristica(map.get("caracteristicas").toString());
                    ps.getEquipo().setModelo(map.get("modelo").toString());
                    ps.getEquipo().setTipo(ps.getTipoEquipo(map.get("tipo").toString()));
                    ps.getEquipo().setId_marca(marcaServices.getMarca().getId());
                    ps.getEquipo().setId_persona(personaServices.getPersona().getId());
                    ps.getEquipo().setEstado(true);
                    ps.save();
                    res.put("msg", "OK");
                    res.put("data", "Equipo registrada correctamente");
                    return Response.ok(res).build();
                } else {
                    res.put("msg", "Error");
                    res.put("data", "La persona o la marca no existen");
                    return Response.status(Status.BAD_REQUEST).entity(res).build();
                }

            } else {
                res.put("msg", "Error");
                res.put("data", "Faltan datos");
                return Response.status(Status.BAD_REQUEST).entity(res).build();
            }

            /*
             * } else {
             * res.put("msg", "Error");
             * // res.put("msg", "ERROR");
             * res.put("data", errors.toArray());
             * return Response.status(Status.BAD_REQUEST).entity(res).build();
             * }
             */

        } catch (Exception e) {
            System.out.println("Error en sav data " + e.toString());
            res.put("msg", "Error");
            // res.put("msg", "ERROR");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
            // TODO: handle exception
        }

    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(HashMap map) {
        // TODO
        // VALIDATION ---- BAD REQUEST

        HashMap res = new HashMap<>();

        try {

            /*
             * ObjectMapper mapper = new ObjectMapper();
             * JsonNode jsonNodeMap = mapper.convertValue(map, JsonNode.class);
             * 
             * JsonSchemaFactory factory =
             * JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
             * JsonSchema schema = factory.getSchema(new
             * FileInputStream("media/validation/person_v.json"));
             * System.out.println(schema.toString());
             * java.util.Set<ValidationMessage> errors = schema.validate(jsonNodeMap);
             * if (errors.isEmpty()) {
             */
            EquipoServices ps = new EquipoServices();
            ps.setEquipo(ps.get(Integer.parseInt(map.get("id").toString())));
            if (ps.getEquipo().getId() == null) {
                res.put("msg", "Error");
                res.put("data", "El equipo no existen");
                return Response.status(Status.BAD_REQUEST).entity(res).build();
            } else {
                if (map.get("person") != null && map.get("brand") != null) {
                    PersonaServices personaServices = new PersonaServices();
                    personaServices.setPersona(personaServices.get(Integer.parseInt(map.get("person").toString())));
                    MarcaServices marcaServices = new MarcaServices();
                    marcaServices.setMarca(marcaServices.get(Integer.parseInt(map.get("brand").toString())));
                    if (personaServices.getPersona().getId() != null && marcaServices.getMarca().getId() != null) {
                        // EquipoServices ps = new EquipoServices();
                        ps.getEquipo().setCaracteristica(map.get("caracteristicas").toString());
                        ps.getEquipo().setModelo(map.get("modelo").toString());
                        ps.getEquipo().setTipo(ps.getTipoEquipo(map.get("tipo").toString()));
                        ps.getEquipo().setId_marca(marcaServices.getMarca().getId());
                        ps.getEquipo().setId_persona(personaServices.getPersona().getId());
                        // ps.getEquipo().setNombre(map.get(("nombre")).toString());

                        // ps.getEquipo().setIdentificacion(map.get("identificacion").toString());
                        ps.update();
                        res.put("msg", "OK");
                        res.put("data", "Equipo editada correctamente");
                        return Response.ok(res).build();
                    } else {
                        res.put("msg", "Error");
                        res.put("data", "La persona o la marca no existen");
                        return Response.status(Status.BAD_REQUEST).entity(res).build();
                    }

                } else {
                    res.put("msg", "Error");
                    res.put("data", "Faltan datos");
                    return Response.status(Status.BAD_REQUEST).entity(res).build();
                }
            }

            /*
             * } else {
             * res.put("msg", "Error");
             * // res.put("msg", "ERROR");
             * res.put("data", errors.toArray());
             * return Response.status(Status.BAD_REQUEST).entity(res).build();
             * }
             */

        } catch (Exception e) {
            System.out.println("Error en sav data " + e.toString());
            res.put("msg", "Error");
            // res.put("msg", "ERROR");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
            // TODO: handle exception
        }

    }

}
