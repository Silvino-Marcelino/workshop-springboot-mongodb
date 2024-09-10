package com.silvinomarcelino.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvinomarcelino.workshopmongo.domain.Post;
import com.silvinomarcelino.workshopmongo.services.PostServices;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostServices postServices;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		List<Post> list = postServices.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = postServices.findById(id);
		return ResponseEntity.ok().body(post);
	}
}
