package com.example.demo.entity;

import javax.persistence.Entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Question 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int question_id;
	String question;
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="qid")  
	List<Answer> answer;

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
	
}
