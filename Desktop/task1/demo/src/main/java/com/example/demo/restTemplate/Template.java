package com.example.demo.restTemplate;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapp")
public class Template {

	@Autowired
	Services services;

	String authentication_type = "Basic ";
	String key = "cHJhZ25pa2FkaWFnZ3BAZ21haWwuY29tOnN5NGtsa2pybjg=";

	// get all people
	@RequestMapping(value = "/people")
	public String getPeople() {
		return services.getPeople();
	}

	// get single person
	@RequestMapping(value = "/people/{id}")
	public String getPersonById(@PathVariable("id") String id) {
		return services.getPersonById(id);
	}

	// create a person
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public String createPerson(@RequestBody String s) {
		return services.createPerson(s);
	}

	// delete a person
	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public String deletePerson(@PathVariable("id") String id) {
		return services.deletePerson(id);
	}

	// Get all version
	@RequestMapping(value = "/node/version/{id}")
	public String getAllVersionOfNode(@PathVariable("id") String id) {
		return services.getAllVersionOfNode(id);
	}

	// get information of one version
	@RequestMapping(value = "/node/version/{id}/{id2}")
	public String getVersionInfo(@PathVariable("id") String id, @PathVariable("id2") String id2) {
		return services.getVersionInfo(id, id2);
	}

	// Delete a version
	@RequestMapping(value = "/node/version/{id}/{id2}", method = RequestMethod.DELETE)
	public String deleteVersion(@PathVariable("id") String id, @PathVariable("id2") String id2) {
		return services.deleteVersion(id, id2);
	}

	// revert a version
	@RequestMapping(value = "/node/version/revert/{id}/{id2}", method = RequestMethod.POST)
	public String revertVersion(@RequestBody String s, @PathVariable("id") String id, @PathVariable("id2") String id2) {
		return services.revertVersion(s, id, id2);
	}

	// get all share links
	@RequestMapping(value = "/node/shareLinks")
	public String getShareLink() {
		return services.getShareLink();
	}

	// create a share link of node
	@RequestMapping(value = "/node/shareLinks", method = RequestMethod.POST)
	public String createShareLink(@RequestBody String s) {
		return services.createShareLink(s);
	}

	// delete a share link
	@RequestMapping(value = "/node/shareLinks/{id}", method = RequestMethod.DELETE)
	public String deleteShareLink(@PathVariable("id") String id) {
		return services.deleteShareLink(id);
	}

	// get a node(document)
	@RequestMapping(value = "/node/{id}")
	public String getNodeId(@PathVariable("id") String id) {
		return services.getNodeId(id);
	}

	// get children of node
	@RequestMapping(value = "/node/children/{id}")
	public String getChildrenOfNode(@PathVariable("id") String id) {
		return services.getChildrenOfNode(id);
	}

	// delete a node
	@RequestMapping(value = "/node/{id}", method = RequestMethod.DELETE)
	public String deleteNode(@PathVariable("id") String id) {
		return services.deleteNode(id);
	}

	// get content of node
	@RequestMapping(value = "/node/content/{id}")
	public String getContentOfNode(@PathVariable("id") String id) {
		return services.getContentOfNode(id);
	}

	// move file from one folder to another
	@RequestMapping(value = "/node/move/{id}", method = RequestMethod.POST)
	public String moveFile(@PathVariable("id") String id, @RequestBody String s) {
		return services.moveFile(id, s);
	}

	// get favorite documents
	@RequestMapping(value = "/node/favorites/{id}")
	public String getFavorites(@PathVariable("id") String id) {
		return services.getFavorites(id);
	}

	// create document favorite
	@RequestMapping(value = "/node/favorites/{id}", method = RequestMethod.POST)
	public String createFavorites(@PathVariable("id") String id, @RequestBody String s) {
		return services.createFavorites(id, s);
	}

	// remove from favorites
	@RequestMapping(value = "/person/{id}/{id2}", method = RequestMethod.DELETE)
	public String deleteFavorites(@PathVariable("id") String id, @PathVariable("id2") String id2) {
		return services.deleteFavorites(id, id2);
	}

}
