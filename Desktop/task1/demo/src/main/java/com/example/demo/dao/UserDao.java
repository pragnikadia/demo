package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.user;
import com.example.demo.repository.UserRepository;

@Service
public class UserDao 
{
	@Autowired
	UserRepository userrepository; 
	
	
	//save user
	public user save(user u)
	{
		return userrepository.save(u);
	}
	
	//get all user
	public List<user> findAll()
	{
		return userrepository.findAll();
		
	}
	
	//get one user
	public Optional<user> findById(Long id)
	{
		return userrepository.findById(id);
		
	}
	
	//delete one user
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		userrepository.deleteById(id);
		
	}
}
