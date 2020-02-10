package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;

@Service
public class QuestionDao 
{

	@Autowired
	QuestionRepository questionrepository;
	
	//save
	public Question save(Question q)
	{
		return questionrepository.save(q);
		
	}
	
	//get all
	public List<Question> findall()
	{
		return questionrepository.findAll();
	}
	//get one 
	public Optional<Question> findById(int id)
	{
		return questionrepository.findById(id);
		
	}
	
	//deleted by id
	public void deleteById(int id)
	{
		questionrepository.deleteById(id);
	}
	
	
}
