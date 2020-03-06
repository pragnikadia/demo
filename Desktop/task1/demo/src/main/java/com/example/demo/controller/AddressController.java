package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AddressDao;
import com.example.demo.entity.Address;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressDao addressdao;

	// save
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Address createaddress(@Valid @RequestBody Address a) {
		return addressdao.save(a);

	}

	// get
	@GetMapping
	public List<Address> getAllAddress() {
		return addressdao.findAll();
	}

	// getByID
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Address>> getUserById(@PathVariable(value = "id") int id) {
		Optional<Address> u = addressdao.findById(id);

		if (u == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(u);

	}

	// update address
	@PutMapping("/{id}")
	public ResponseEntity<Address> updateUser(@PathVariable(value = "id") int id,
			@Valid @RequestBody Address addressdetail) {
		Optional<Address> u = addressdao.findById(id);
		Address a1 = u.get();
		if (a1 == null) {
			return ResponseEntity.notFound().build();
		}

		a1.setAddress(addressdetail.getAddress());
		a1.setCity(addressdetail.getCity());
		a1.setState(addressdetail.getState());
		a1.setZip(addressdetail.getZip());

		Address updateAddress = addressdao.save(a1);
		return ResponseEntity.ok().body(updateAddress);
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Address>> deleteUserById(@PathVariable(value = "id") int id) {
		Optional<Address> u = addressdao.findById(id);

		if (u == null) {
			return ResponseEntity.notFound().build();
		}
		addressdao.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
