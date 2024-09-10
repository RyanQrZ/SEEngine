package com.integrador.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.theirStackAPI.ResponseJSON;
import com.integrador.theirStackAPI.TheirStackAPI;

@RestController
@RequestMapping( "/api/search" )

public class SearchController
{
	@GetMapping
	ResponseJSON searchJob()
	{
		return TheirStackAPI.postRequest();
	}
}
