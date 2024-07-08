package com.ar.spa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {

    public Long crearUsuario(Usuarios usuario){

        Conexion conexion = new Conexion();

        Statement stm = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String crear = "INSERT INTO Usuarios(id_usuarios, nombre, apellido, email, pass, fecha_nac, pais) VALUES(?,?,?,?,?,?,?)";
    
        Connection cn = conexion.conectar();

        try {
            pstm = cn.prepareStatement(crear);

            pstm.setInt(1, usuario.getId_usuarios());
            pstm.setString(2, usuario.getNombre());
            pstm.setString(3, usuario.getApellido());
            pstm.setString(4, usuario.getEmail());
            pstm.setString(5, usuario.getPass());
            pstm.setString(6, usuario.getFecha_nac());
            pstm.setString(7, usuario.getPais());

            pstm.executeUpdate();

        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return null;
    }

    public List<Usuarios> obtenerUsuario(){
        
        Conexion conexion = new Conexion();

        List<Usuarios> userList = new ArrayList<>();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        String crear = "SELECT * FROM Usuarios";
    
        Connection cn = conexion.conectar();

        try{
            pstm = cn.prepareStatement(crear);
            rs = pstm.executeQuery();

            while(rs.next()){

                //id_usuarios, nombre, apellido, email, pass, fecha_nac, pais

                int id = rs.getInt("id_usuarios");
                String nom = rs.getString("nombre");
                String ape = rs.getString("apellido");
                String email = rs.getString("email");
                String pass = rs.getString("pass");
                String fnac = rs.getString("fecha_nac");
                String pais = rs.getString("pais");

                Usuarios usuarios = new Usuarios(id, nom, ape, email, pass, fnac, pais);

                userList.add(usuarios);
            }
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
        return userList;
    }
}
