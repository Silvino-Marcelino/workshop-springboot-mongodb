package com.silvinomarcelino.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silvinomarcelino.workshopmongo.domain.Post;
import com.silvinomarcelino.workshopmongo.repository.PostRepository;
import com.silvinomarcelino.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostServices {

	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Post nao encontrado!"));
	}
}
