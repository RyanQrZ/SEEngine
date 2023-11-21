package br.com.agenda.jdbc;

import java.sql.SQLException;

public class ConnectionFactoryException extends RuntimeException {
	
	public ConnectionFactoryException(SQLException e) {
		super("Some thing went wrong in connection");
	}

}
