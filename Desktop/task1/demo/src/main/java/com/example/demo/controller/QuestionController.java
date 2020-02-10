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

import com.example.demo.dao.QuestionDao;
import com.example.demo.entity.Question;


@RestController
@RequestMapping("/question")
public class QuestionController 
{
	@Autowired
	QuestionDao questiondao;
	
	//save
	@PostMapping()
	public Question createAnswer(@Valid @RequestBody Question q)
	{
		return questiondao.save(q);
		
	}
	
	//getall
	@GetMapping
	public List<Question> getAllQuestion()
	{
		return questiondao.findall();
		
	}
	
	//get by id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable(value="id") int id)
	{
		Optional<Question> u= questiondao.findById(id);
		
		if(u==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(u);
		
	}
	
	//update question
		@PutMapping("/{id}")
		public ResponseEntity<Question> updateQuestion(@PathVariable(value="id") int id,@Valid @RequestBody Question questiondetail )
		{
			Optional<Question> q=questiondao.findById(id);
			Question q1=q.get();
			if(q1==null)
			{
				return ResponseEntity.notFound().build();
			}
			q1.setQuestion(questiondetail.getQuestion());
			Question updateQuestion = questiondao.save(q1);
			return ResponseEntity.ok().body(updateQuestion);
			
		}
		
		//delete question
		@DeleteMapping("/{id}")
		public ResponseEntity<Optional<Question>> deleteQuestionById(@PathVariable(value="id") int id)
		{
			Optional<Question> u= questiondao.findById(id);
			
			if(u==null)
			{
				return ResponseEntity.notFound().build();
			}
			questiondao.deleteById(id);
			return ResponseEntity.ok().build();
		}
	
}
