package com.silvinomarcelino.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.silvinomarcelino.workshopmongo.domain.Post;
import com.silvinomarcelino.workshopmongo.domain.User;
import com.silvinomarcelino.workshopmongo.dto.AuthorDTO;
import com.silvinomarcelino.workshopmongo.dto.CommentDTO;
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Costa", "maria@gmail.com");
		User joao = new User(null, "Joao Silva", "joao@gmail.com");
		User bob = new User(null, "Bob Brown", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, joao, bob)); // PRIMEIRO SALVANDO DEPOIS INSTANCIANDO O AUTHORDTO
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(bob));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(joao));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
