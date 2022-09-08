package com.BikkadIT.UserManagement.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.UserManagement.entity.StateMasterEntity;

@Repository
public interface StateRepository extends JpaRepository<StateMasterEntity, Serializable> {

	public List<StateMasterEntity> findByCountryId(Integer countryId);
}
