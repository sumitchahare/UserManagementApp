package com.BikkadIT.UserManagement.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.UserManagement.entity.UserAccountEntity;

import lombok.Data;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Serializable> {

   public UserAccountEntity findByEmailAndPassword(String email, String password);
   
}
