package com.rochiyat.spring.boot.jwt.postgresql.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

	@GetMapping("/job-list")
	@PreAuthorize("hasRole('ADMIN')")
	public Object getJobList() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
		String response = restTemplate.getForObject(url, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		Object jsonObject = objectMapper.readValue(response, Object.class);

		return jsonObject;
	}

	@GetMapping("/job/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Object getJobById(@PathVariable String id) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions/"+ id;
		String response = restTemplate.getForObject(url, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		Object jsonObject = objectMapper.readValue(response, Object.class);

		return jsonObject;
	}
}
