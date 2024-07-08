package com.ar.spa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String URL = "jdbc:mysql://localhost:3306/cacspa_grupo10";
	private static final String USER = "root";
	private static final String PASS = "";
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	
	static {
		
		try {
			
			Class.forName(CONTROLADOR);
		}
		catch (ClassNotFoundException e) {

			System.out.println("Error de conección");
			e.printStackTrace();
		}
	}
	
	public Connection conectar() {
		
		Connection conexion = null;
		
		try {

			conexion = DriverManager.getConnection(URL, USER, PASS);
		}
		catch (Exception e) {
			
			System.out.println("Error");
			e.printStackTrace();
		}
		
		return conexion;
	}
}
