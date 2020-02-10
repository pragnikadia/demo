package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Answer;
import com.example.demo.repository.AnswerRepository;

@Service
public class AnswerDao {
	@Autowired
	AnswerRepository answerrepository;
	
	//save
	public Answer save(Answer a)
	{
		return answerrepository.save(a);
	}
	
	//getall
	public List<Answer> findAll()
	{
		return answerrepository.findAll();
	}
	
	//getById
	public Optional<Answer> findById(int id)
	{
		return answerrepository.findById(id);
	}
	
	//delete
	public void deleteById(int id)
	{
		answerrepository.deleteById(id);
	}
	

}
