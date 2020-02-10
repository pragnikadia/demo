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

import com.example.demo.dao.AnswerDao;
import com.example.demo.entity.Answer;

@RestController
@RequestMapping("/answer")
public class AnswerController 
{
	@Autowired
	AnswerDao answerdao;
	
	//save
	@PostMapping()
	public Answer createAnswer(@Valid @RequestBody Answer a)
	{
		return answerdao.save(a);
		
	}
	//get all answer
	@GetMapping()
	public List<Answer> getAllAnswer()
	{
		return answerdao.findAll();
	}
	
	//get by employee id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Answer>> getUserById(@PathVariable(value="id") int id)
	{
		Optional<Answer> u= answerdao.findById(id);
		
		if(u==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(u);
		
	}
	//update answer
	@PutMapping("/{id}")
	public ResponseEntity<Answer> updateAnswer(@PathVariable(value="id") int id,@Valid @RequestBody Answer answerdetail )
	{
		Optional<Answer> u= answerdao.findById(id);
		Answer u1=u.get();
		if(u1==null)
		{
			return ResponseEntity.notFound().build();
		}
	
		u1.setAnswer(answerdetail.getAnswer());
		u1.setPostedby(answerdetail.getAnswer());
		
		Answer updateAnswer = answerdao.save(u1);
		return ResponseEntity.ok().body(updateAnswer);
	}
	
	//delete answer
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Answer>> deleteAnswerById(@PathVariable(value="id") int id)
	{
		Optional<Answer> u= answerdao.findById(id);
		
		if(u==null)
		{
			return ResponseEntity.notFound().build();
		}
		answerdao.deleteById(id);
		return ResponseEntity.ok().build();
	}
		
		
	
}
