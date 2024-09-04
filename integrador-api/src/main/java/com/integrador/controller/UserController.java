package com.integrador.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.interfaces.UserJPA;
import com.integrador.model.User;

@RestController
@RequestMapping( "/api/user" )

public class UserController
{
	private final UserJPA data;
	
	UserController( UserJPA repository )
	{
		this.data = repository;
	}// end UserController
	
	@PostMapping @ResponseStatus( code = HttpStatus.CREATED )
	void create( @RequestBody User newUser )
	{
		data.save( newUser );
	}
	
	@GetMapping( "{account}" )
	List<User> searchForUsers( @PathVariable String account )
	{
		return data.findByaccountName( account );
	}
}
