package br.com.agenda.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.agenda.jdbc.ConnectionFactory;
import br.com.agenda.jdbc.ConnectionFactoryException;
import br.com.agenda.jdbc.InsertException;
import br.com.agenda.jdbc.model.Contact;

public class ContactDAO {
	
	public static void insert(Contact cont) {
		String sql = "insert into "
				+ "Contacts(name, email, address) "
				+ "values(?, ?, ?)";
		
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
			
			stmt.setString(1,cont.getName());
			stmt.setString(2,cont.getEmail());
			stmt.setString(3,cont.getAddress());
			
			stmt.execute();
			stmt.close();
			
			ConnectionFactory.getConnection().close();
			
		} catch(SQLException e) {
			throw new InsertException();
			
		} catch(ConnectionFactoryException e) {
			System.out.println(e);
			
		}
	}

}
