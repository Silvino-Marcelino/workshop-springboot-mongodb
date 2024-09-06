package com.silvinomarcelino.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.silvinomarcelino.workshopmongo.domain.User;
import com.silvinomarcelino.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Costa", "maria@gmail.com");
		User joao = new User(null, "Joao Silva", "joao@gmail.com");
		User bob = new User(null, "Bob Brown", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, joao, bob));
		
	}

}
