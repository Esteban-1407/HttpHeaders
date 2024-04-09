package com.example.demo.servlets;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "test", value = "/test")
public class test extends HttpServlet {
    // Método que maneja las peticiones GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException{

        // Establece el tipo de contenido de la respuesta como texto HTML
        resp.setContentType("text/html");

        // Obtiene información de la petición HTTP

        // Utilidad: Determinar el método HTTP utilizado en la solicitud
        String metodoHttp = req.getMethod();

        // Utilidad: Identificar la URI del recurso solicitado
        String requestUri = req.getRequestURI();

        // Utilidad: Obtener la URL completa de la solicitud
        String requestUrl = req.getRequestURL().toString();

        // Utilidad: Acceder a recursos dentro del contexto de la aplicación
        String contexPath = req.getContextPath();

        // Utilidad: Identificar la ruta del servlet invocado
        String servletPath = req.getServletPath();

        // Utilidad: Obtener la dirección IP del cliente que realizó la solicitud
        String ipCliente = req.getRemoteAddr();

        // Utilidad: Obtener la dirección IP local del servidor
        String ip = req.getLocalAddr();

        // Utilidad: Obtener el puerto local en el que el servidor está escuchando
        int port = req.getLocalPort();

        // Utilidad: Determinar si la solicitud fue realizada a través de HTTP o HTTPS
        String scheme = req.getScheme();

        // Utilidad: Obtener el nombre del host solicitado
        String host = req.getHeader("host");

        // Construye la URL completa de la solicitud
        String url = scheme + "://" + host + contexPath + servletPath;

        // Construye otra URL incluyendo la dirección IP y el puerto local
        String url2 = scheme + "://" + ip + ":" + port + contexPath + servletPath;

        // Envía la respuesta HTML al cliente
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Cabeceras HTTP Request</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cabeceras HTTP Request!</h1>");
            out.println("<ul>");
            out.println("<li>metodo http: " + metodoHttp + "</li>");
            out.println("<li>request uri: " + requestUri + "</li>");
            out.println("<li>request url: " + requestUrl + "</li>");
            out.println("<li>context path: " + contexPath + "</li>");
            out.println("<li>servlet path: " + servletPath + "</li>");
            out.println("<li>ip local: " + ip + "</li>");
            out.println("<li>ip cliente: " + ipCliente + "</li>");
            out.println("<li>puerto local: " + port + "</li>");
            out.println("<li>scheme: " + scheme + "</li>");
            out.println("<li>host: " + host + "</li>");
            out.println("<li>url: " + url + "</li>");
            out.println("<li>url2: " + url2 + "</li>");

            // Itera sobre todas las cabeceras de la solicitud y las imprime

            // Utilidad: Imprimir cabeceras HTTP adicionales para personalizar respuestas o autenticación de usuario
            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String cabecera = headerNames.nextElement();
                out.println("<li>"+ cabecera + ": " + req.getHeader(cabecera) + "</li>");
            }

            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
