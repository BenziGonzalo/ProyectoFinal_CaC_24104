package com.ar.spa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/userList")
public class UsuariosServlet extends HttpServlet {

    private UsuariosDAO dao = new UsuariosDAO();

    private ObjectMapper om = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow_Headers", "Content-Type");

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Usuarios usuarios = om.readValue(req.getInputStream(), Usuarios.class);

        Long id = dao.crearUsuario(usuarios);

        String jsonReponse = om.writeValueAsString(id);

        resp.setContentType("application/json");

        resp.getWriter().write(jsonReponse);;

        resp.setStatus(HttpServletResponse.SC_CREATED);

        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        

        super.doGet(req, resp);
    }

    
}
