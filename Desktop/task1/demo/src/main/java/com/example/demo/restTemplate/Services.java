package com.example.demo.restTemplate;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class Services {

	@Autowired
	RestTemplate restTemplate;

	String authentication_type = "Basic ";
	String key = "cHJhZ25pa2FkaWFnZ3BAZ21haWwuY29tOnN5NGtsa2pybjg=";

	// get all people
	public String getPeople() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authentication_type + key);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate
				.exchange("https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/people",
						HttpMethod.GET, entity, String.class)
				.getBody();
	}

	// get person by id
	public String getPersonById(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authentication_type + key);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(
				"https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/people/" + id,
				HttpMethod.GET, entity, String.class).getBody();
	}

	// create a person
	public String createPerson(@RequestBody String s) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authentication_type + key);
		HttpEntity<String> entity = new HttpEntity<String>(s, headers);

		return restTemplate.exchange(
				"https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/people" + "",
				HttpMethod.POST, entity, String.class).getBody();
	}

	// delete a person
	public String deletePerson(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authentication_type + key);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate
				.exchange("https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/people/"
						+ id + "/avatar", HttpMethod.DELETE, entity, String.class)
				.getBody();
	}

	// get all version of node
	public String getAllVersionOfNode(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authentication_type + key);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate
				.exchange("https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/nodes/"
						+ id + "/versions", HttpMethod.GET, entity, String.class)
				.getBody();
	}

	// get version information
	public String getVersionInfo(@PathVariable("id") String id, @PathVariable("id2") String id2) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authentication_type + key);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate
				.exchange("https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/nodes/"
						+ id + "/versions/" + id2, HttpMethod.GET, entity, String.class)
				.getBody();
	}

	// delete a version
	public String deleteVersion(@PathVariable("id") String id, @PathVariable("id2") String id2) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authentication_type + key);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate
				.exchange("https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/nodes/"
						+ id + "/versions/" + id2, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}

	// revert a version
	public String revertVersion(@RequestBody String s, @PathVariable("id") String id, @PathVariable("id2") String id2) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authentication_type + key);
		HttpEntity<String> entity = new HttpEntity<String>(s, headers);

		return restTemplate
				.exchange("https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/nodes/"
						+ id + "/versions/" + id2 + "/revert" + "", HttpMethod.POST, entity, String.class)
				.getBody();
	}

	// get share link
	public String getShareLink() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authentication_type + key);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(
				"https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/shared-links" + "",
				HttpMethod.GET, entity, String.class).getBody();
	}

	// create a share link
	public String createShareLink(@RequestBody String s) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authentication_type + key);
		HttpEntity<String> entity = new HttpEntity<String>(s, headers);

		return restTemplate.exchange(
				"https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/shared-links" + "",
				HttpMethod.POST, entity, String.class).getBody();
	}

	// delete a share link
	public String deleteShareLink(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authentication_type + key);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange(
				"https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/shared-links/"
						+ id,
				HttpMethod.DELETE, entity, String.class).getBody();
	}

	// get node id
	public String getNodeId(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authentication_type + key);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(
				"https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/nodes/" + id,
				HttpMethod.GET, entity, String.class).getBody();
	}

	// get children of node
	public String getChildrenOfNode(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authentication_type + key);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate
				.exchange("https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/nodes/"
						+ id + "/children", HttpMethod.GET, entity, String.class)
				.getBody();
	}

	// delete a node
	public String deleteNode(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authentication_type + key);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange(
				"https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/nodes/" + id,
				HttpMethod.DELETE, entity, String.class).getBody();
	}

	// get content of node
	public String getContentOfNode(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authentication_type + key);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate
				.exchange("https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/nodes/"
						+ id + "/content", HttpMethod.GET, entity, String.class)
				.getBody();
	}

	// move file
	public String moveFile(@PathVariable("id") String id, @RequestBody String s) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authentication_type + key);
		HttpEntity<String> entity = new HttpEntity<String>(s, headers);

		return restTemplate
				.exchange("https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/nodes/"
						+ id + "/move" + "", HttpMethod.POST, entity, String.class)
				.getBody();
	}

	// get favorites
	public String getFavorites(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authentication_type + key);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate
				.exchange("https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/people/"
						+ id + "/favorites", HttpMethod.GET, entity, String.class)
				.getBody();
	}

	// create favorite
	public String createFavorites(@PathVariable("id") String id, @RequestBody String s) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authentication_type + key);
		HttpEntity<String> entity = new HttpEntity<String>(s, headers);

		return restTemplate
				.exchange("https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/people/"
						+ id + "/favorites" + "", HttpMethod.POST, entity, String.class)
				.getBody();
	}

	// delete favorite
	public String deleteFavorites(@PathVariable("id") String id, @PathVariable("id2") String id2) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authentication_type + key);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate
				.exchange("https://xh2gnr.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1/people/"
						+ id + "/favorites/" + id2, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}
}
