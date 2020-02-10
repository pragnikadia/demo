package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Answer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int answer_id;
	String answer;
	String postedby;
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPostedby() {
		return postedby;
	}
	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}
	
}
