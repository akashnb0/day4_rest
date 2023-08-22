package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class ApiService {
	@Autowired
	StudentRepo r;
	public Student saveinfo(Student s)
	{
		return r.save(s);
	}
	public List<Student> savedetails(List<Student> s)
	{
		return (List<Student>) r.saveAll(s);
	}
	public List<Student> showinfo()
	{
		return r.findAll();
	}
	//get by id
	public Optional<Student> showbyid(int id)
	{
		return r.findById(id);
	}
	public Student changeinfo(Student s)
	{
		return r.saveAndFlush(s);
	}
	//put by id
	public String updateinfobyid(int id, Student s)
	{
		r.saveAndFlush(s);
		if(r.existsById(id))
		{
			return "Updated";
		}
		else
		{
			return "Enter valid id";
		}
	}
	//delete by id
	public void deleteid(int id)
	{
		r.deleteById(id);
	}
}
