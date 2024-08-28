package com.integrador.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	}
	
	@PostMapping
	public void create( @RequestBody User newUser )
	{
		data.save( newUser );
	}
}
