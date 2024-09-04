package com.integrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "USERS" )

public class User
{
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long ID;
	
	@Column( nullable = false, length = 150, name = "FIRST_NAME" )
	private String first_name;
	
	@Column( nullable = false, length = 150, name = "LAST_NAME" )
	private String last_name;
	
	@Column( nullable = false, length = 100, name = "ACCOUNT_NAME" )
	private String accountName;

	@Column( nullable = false, length = 100, unique = true )
	private String email;
	
	@Column( nullable = false, length = 100 )
	private String password;
	
	User( String f_name, String l_name, String ac_name, String email, String pass )
	{
		this.first_name = f_name;
		this.last_name = l_name;
		this.accountName = ac_name;
		this.email = email;
		this.password = pass;
	}// end User
	
	User(){}

	public Long getID() {
		return ID;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
