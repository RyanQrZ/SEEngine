package com.integrador.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integrador.model.User;

public interface UserJPA extends JpaRepository<User, Long>
{

}
