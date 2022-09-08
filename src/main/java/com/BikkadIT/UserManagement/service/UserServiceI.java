package com.BikkadIT.UserManagement.service;

import java.util.List;
import java.util.Map;

import com.BikkadIT.UserManagement.binding.LoginForm;
import com.BikkadIT.UserManagement.entity.CountryMasterEntity;

public interface UserServiceI {

	public String loginCheck(LoginForm loginForm);
	
	public Map<Integer, String> getCountries();

	public Map<Integer, String>getStates(Integer countryId);

	public Map<Integer, String> getCities(Integer stateId);
}
