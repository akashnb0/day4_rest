package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService apser;
	@PostMapping("post")
	public Student adding(@RequestBody Student s)
	{
		return apser.saveinfo(s);
	}
	@GetMapping("get")
	public List<Student> showing()
	{
		return apser.showinfo();
	}
	//show by id
	@GetMapping("getbyid/{id}")
	public Optional<Student> showid(@PathVariable int id)
	{
		return apser.showbyid(id);
	}
	@PutMapping("put")
	public Student modify(@RequestBody Student s)
	{
		return apser.changeinfo(s);
	}
	
	//put by id
	@PutMapping("putbyid/{id}")
	public String modifybyid(@PathVariable int id, @RequestBody Student s)
	{
		return apser.updateinfobyid(id, s);
	}
	
	@DeleteMapping("deletebyid/{id}")
	public void deletemyid(@PathVariable int id)
	{
		apser.deleteid(id);
	}
}
