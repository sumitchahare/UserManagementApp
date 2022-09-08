package com.BikkadIT.UserManagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.UserManagement.binding.LoginForm;
import com.BikkadIT.UserManagement.entity.CityMasterEntity;
import com.BikkadIT.UserManagement.entity.CountryMasterEntity;
import com.BikkadIT.UserManagement.entity.StateMasterEntity;
import com.BikkadIT.UserManagement.entity.UserAccountEntity;
import com.BikkadIT.UserManagement.repository.CityRepository;
import com.BikkadIT.UserManagement.repository.CountryRepository;
import com.BikkadIT.UserManagement.repository.StateRepository;
import com.BikkadIT.UserManagement.repository.UserAccountRepository;

@Service
public class UserServiceImpl implements UserServiceI{
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public String loginCheck(LoginForm loginForm) {
		UserAccountEntity userAccountEntity = userAccountRepository.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
		
		if(userAccountEntity != null) {
			if(userAccountEntity.getAccStatus().equals("LOCKED")) {
				return "Your Account is locked";
			}else {
				return "Login Successful. Welcome to Bikkad IT";
			}
		}else {
			return "Creditional Are Invalid";
		}
		
	}

	@Override
	public Map<Integer, String> getCountries() {
		List<CountryMasterEntity> findAll = countryRepository.findAll();
		Map<Integer,String> countryMap=new HashMap<Integer,String>();
		for(CountryMasterEntity u:findAll) {
			countryMap.put(u.getCountryId(), u.getCountryName());
		}
		
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<StateMasterEntity> states = stateRepository.findByCountryId(countryId);
		
		Map<Integer,String> statemap=new HashMap<Integer,String>();
		for(StateMasterEntity u:states) {
			statemap.put(u.getStateId(), u.getStateName());
		}
		return statemap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		List<CityMasterEntity> findByStateId = cityRepository.findByStateId(stateId);
		
		Map<Integer,String> citymap=new HashMap<Integer,String>();
		for(CityMasterEntity u:findByStateId) {
			citymap.put(u.getCityId(), u.getCityName());
		}
		return citymap;
		
	
	}

}
