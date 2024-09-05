package com.silvinomarcelino.workshopmongo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.silvinomarcelino.workshopmongo.domain.User;
import com.silvinomarcelino.workshopmongo.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
