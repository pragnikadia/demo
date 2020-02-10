package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;

@Repository
public class AddressDao
{
	@Autowired
	AddressRepository addressrepository;
	
	//save
	public Address save(Address u)
	{
		return addressrepository.save(u);
	}
	
	//get
	public List<Address> findAll()
	{
		return addressrepository.findAll();
		
	}
	
	//getById
	public Optional<Address> findById(int id)
	{
		return addressrepository.findById(id);
	}
	
	//delete
	public void deleteById(int id)
	{
		addressrepository.deleteById(id);
	}
	
}
