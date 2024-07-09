package com.example.USER;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserprofileService {
	
	@Autowired
	private UserprofileRepository userprofileRepository;
	
	public List<User> getAllUserprofiles(){
		return userprofileRepository.findAll();
	}
	
	public Optional<User> getUserprofileById(Long id){
		return userprofileRepository.findById(id);
	}
	
	public User createUserProfile(User userProfile) {
		return userprofileRepository.save(userProfile);
	}
	
	public User updateUserProfile(Long id, User userProfile) {
		if(userprofileRepository.existsById(id)) {
			userProfile.setId(id);
			return userprofileRepository.save(userProfile);
		}
		else
		{
			throw new RuntimeException("User not found with id :"+id);
		}
	}
	
	public void deleteUserprofile(Long id) {
		userprofileRepository.deleteById(id);
	}


}

