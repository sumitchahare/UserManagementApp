package com.BikkadIT.UserManagement.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.UserManagement.entity.CityMasterEntity;

@Repository
public interface CityRepository extends JpaRepository<CityMasterEntity, Serializable> {

	public List<CityMasterEntity> findByStateId(Integer stateId);
}
