package com.silvinomarcelino.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.silvinomarcelino.workshopmongo.domain.Post;
import com.silvinomarcelino.workshopmongo.domain.User;
import com.silvinomarcelino.workshopmongo.dto.AuthorDTO;
import com.silvinomarcelino.workshopmongo.repository.PostRepository;
import com.silvinomarcelino.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Costa", "maria@gmail.com");
		User joao = new User(null, "Joao Silva", "joao@gmail.com");
		User bob = new User(null, "Bob Brown", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, joao, bob)); // PRIMEIRO SALVANDO DEPOIS INSTANCIANDO O AUTHORDTO
		
		Post post1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
	}

}
