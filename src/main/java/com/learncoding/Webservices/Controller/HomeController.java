package com.learncoding.Webservices.Controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learncoding.Webservices.Model.Home;
import com.learncoding.Webservices.Repository.HomeRepository;

@CrossOrigin("*")
	@RestController
	@RequestMapping("/home")
	public class HomeController {
		@Autowired
		HomeRepository homeRepository;
		
		@GetMapping
		@RequestMapping("/getDetail/{id}")
		public Optional<Home> getValue(@PathVariable int id){
			return homeRepository.findById(id);
			}

		@GetMapping
		@RequestMapping("/getDetails")
		public List<Home> getValue() { 
			return homeRepository.findAll();
			
		}

		@PostMapping
		@RequestMapping("/postDetails")
		public String postValue(@RequestBody Home home){
		homeRepository.save(home);
			return "posted detail";
		}
			@PutMapping
			@RequestMapping("/putDetail/{id}")
			public String putValue(@RequestBody Home home, @PathVariable int id ) {
				homeRepository.save(home);
				return"updated";
				
			}
			@DeleteMapping
			@RequestMapping("/deleteDetail/{id}")
			public void deleteValue(@PathVariable int id) {
			  homeRepository.deleteById(id);
				//return "deleted detail";
			}
			
		
}
