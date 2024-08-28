package com.integrador.model;

import com.integrador.services.IdNumber;

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
	
	@Column( nullable = false, length = 150 )
	private String name;
	
	@Column( nullable = false, length = 11 )
	private IdNumber personalID;
	
	User( String str, IdNumber id )
	{
		this.personalID = id;
		this.name = str;		
	}
	
	public String getName() { return this.name; }
}
