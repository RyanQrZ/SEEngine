package br.com.agenda.servlets;

import java.io.IOException;

import br.com.agenda.jdbc.dao.ContactDAO;
import br.com.agenda.jdbc.model.Contact;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/addcontact"})
public class AddContactServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp)
					throws ServletException, IOException {
		String name, email, address;
		
		// getting parameters
		name = req.getParameter("Name");
		email = req.getParameter("Email");
		address = req.getParameter("Address");
		
		// linking parameters with user object
		Contact cont = new Contact();
		cont.setName(name);
		cont.setEmail(email);
		cont.setAddress(address);
		
		// inserting user
		ContactDAO.insert(cont);
		
		resp.getWriter().println("Contact add successfully");
		
	}

}
