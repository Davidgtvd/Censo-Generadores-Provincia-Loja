/*
*Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.config;

/**
 *
 * @author david
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.censogeneradoresloja.controllers.CensoServlet;
import com.censogeneradoresloja.controllers.EstadisticasServlet;

public class WebConfig {

    public void configure(ServletContextHandler context) throws ServletException {
       
        context.addServlet(CensoServlet.class, "/censo");

        context.addServlet(EstadisticasServlet.class, "/estadisticas");

        System.out.println("Configuración web completada.");
    }
}