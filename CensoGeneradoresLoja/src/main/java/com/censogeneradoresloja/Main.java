/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja;

/**
 *
 * @author david
 */
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.censogeneradoresloja.controllers.GeneradorController;
import com.censogeneradoresloja.controllers.UsuarioController;
import com.censogeneradoresloja.controllers.TransaccionController;
import com.censogeneradoresloja.controllers.EstadisticasController;
import com.censogeneradoresloja.config.WebConfig;
import com.censogeneradoresloja.dao.GeneradorDAO; 
import com.censogeneradoresloja.dao.UsuarioDAO; 
import com.censogeneradoresloja.dao.TransaccionDAO; 
import com.censogeneradoresloja.services.TransaccionService; 
import com.censogeneradoresloja.services.EstadisticasService; 
import com.censogeneradoresloja.config.ApplicationConfig; 

public class Main {
    public static void main(String[] args) {
        try {
           
            Server server = new Server(8080);

            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");

            WebConfig webConfig = new WebConfig();
            webConfig.configure(context);

            ApplicationConfig appConfig = new ApplicationConfig();
            GeneradorDAO generadorDAO = new GeneradorDAO();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            TransaccionDAO transaccionDAO = new TransaccionDAO();
            TransaccionService transaccionService = new TransaccionService(transaccionDAO);
            EstadisticasService estadisticasService = appConfig.estadisticasService();

            GeneradorController generadorController = appConfig.generadorController();
            UsuarioController usuarioController = appConfig.usuarioController();
            TransaccionController transaccionController = new TransaccionController(transaccionService);
            EstadisticasController estadisticasController = new EstadisticasController(generadorController, usuarioController, estadisticasService);

            server.setHandler(context);

            
            server.start();
            System.out.println("Servidor iniciado en http://localhost:8080");
            server.join(); 

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}