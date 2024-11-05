package com.tercerotest.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

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
import com.tercerotest.controller.dao.services.OrderServices;
import com.tercerotest.controller.dao.services.PersonaServices;

@Path("sell")
public class OrderApi {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        HashMap map = new HashMap<>();
        OrderServices ps = new OrderServices();
        map.put("msg", "OK");
        map.put("data", ps.listAll().toArray());
        if (ps.listAll().isEmpty()) {
            map.put("data", new Object[] {});
        }

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
     * OrderServices ps = new OrderServices();
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
        OrderServices ps = new OrderServices();
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
        OrderServices ps = new OrderServices();
        try {
            ps.setOrder(ps.get(id));
        } catch (Exception e) {
            // TODO: handle exception
        }
        map.put("msg", "OK");
        map.put("data", ps.getOrder());
        if (ps.getOrder().getId() == null) {
            map.put("data", "No existe la Order con ese identificador");
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
        System.out.println("******* " + a);
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
            if (map.get("person") != null && map.get("details") != null) {
                PersonaServices personaServices = new PersonaServices();
                personaServices.setPersona(personaServices.get(Integer.parseInt(map.get("person").toString())));
                if (personaServices.getPersona().getId() != null) {
                    OrderServices ps = new OrderServices();
                    ps.getOrder().setFecha(new Date());
                    ps.getOrder().setId_persona(personaServices.getPersona().getId());
                    ps.getOrder().setNro_order(UUID.randomUUID().toString());
                    ps.getOrder().setIva(Float.parseFloat(map.get("iva").toString()));
                    ps.getOrder().setSubtotal(Float.parseFloat(map.get("subtotal").toString()));
                    ps.getOrder().setTotal(Float.parseFloat(map.get("total").toString()));
                    ps.save();
                    
                    res.put("msg", "OK");
                    res.put("data", "Order registrada correctamente");
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

}
