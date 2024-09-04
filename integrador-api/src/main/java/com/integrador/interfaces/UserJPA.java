package com.integrador.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integrador.model.User;

public interface UserJPA extends JpaRepository<User, Long>
{
	List<User> findByaccountName( String account );
}
