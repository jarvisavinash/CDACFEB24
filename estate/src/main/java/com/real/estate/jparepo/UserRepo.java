package com.real.estate.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.real.estate.model.User;



public interface UserRepo extends JpaRepository <User, Long> {

}
