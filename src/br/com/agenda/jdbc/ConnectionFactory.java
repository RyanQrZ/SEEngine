package br.com.agenda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			String url = "jdbc:mariadb://localhost:3306/agenda";
			String dbuser = "root";
			String pwd = "674673";
			
			return DriverManager.getConnection(url, dbuser, pwd);
			
		} catch(SQLException e) {
			throw new ConnectionFactoryException(e);
			
		}
		
	}

}
