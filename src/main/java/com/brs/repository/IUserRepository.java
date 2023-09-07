package com.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brs.entity.Bus;
import com.brs.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer>{


}
