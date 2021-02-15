package com.karpen.springRestApi.repository;

import com.karpen.springRestApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
