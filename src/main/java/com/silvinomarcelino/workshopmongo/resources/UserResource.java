package com.silvinomarcelino.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvinomarcelino.workshopmongo.domain.User;
import com.silvinomarcelino.workshopmongo.dto.UserDTO;
import com.silvinomarcelino.workshopmongo.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserServices services;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = services.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); // EXPRESSAO LAMBDA PARA CONVERTER USER PARA USERDTO(DATA TRANSFER OBJECT)
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = services.findById(id);	
		UserDTO objDTO = new UserDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
}
