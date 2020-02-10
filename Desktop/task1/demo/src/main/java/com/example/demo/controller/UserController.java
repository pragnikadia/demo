package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.user;

@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	UserDao userdao;
	
	//save user
	@PostMapping()
	public user createUser(@Valid @RequestBody user u)
	{
		return userdao.save(u);
		
	}
	
	//get all user
	@GetMapping()
	public List<user> getAllUser()
	{
		return userdao.findAll();
		
	}
	
	//get by employee id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<user>> getUserById(@PathVariable(value="id") Long id)
	{
		Optional<user> u= userdao.findById(id);
		
		if(u==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(u);
		
	}
	
	//update user
	@PutMapping("/{id}")
	public ResponseEntity<user> updateUser(@PathVariable(value="id") Long id,@Valid @RequestBody user userdetail )
	{
		Optional<user> u= userdao.findById(id);
		user u1=u.get();
		if(u1==null)
		{
			return ResponseEntity.notFound().build();
		}
		
		u1.setName(userdetail.getName());
		u1.setContact_no(userdetail.getContact_no());
		u1.setEmail(userdetail.getEmail());
		
		user updateUser = userdao.save(u1);
		return ResponseEntity.ok().body(updateUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<user>> deleteUserById(@PathVariable(value="id") Long id)
	{
		Optional<user> u= userdao.findById(id);
		
		if(u==null)
		{
			return ResponseEntity.notFound().build();
		}
		userdao.deleteById(id);
		return ResponseEntity.ok().build();
	}

	
	
	
}
