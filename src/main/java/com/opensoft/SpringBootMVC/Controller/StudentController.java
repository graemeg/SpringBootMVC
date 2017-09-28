package com.opensoft.SpringBootMVC.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opensoft.SpringBootMVC.Entity.Student;
import com.opensoft.SpringBootMVC.Service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public Collection<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") int id) {
		Student s = studentService.getStudentById(id);
		if (s == null) {
			throw new RuntimeException("No student exists with that ID");
		} else
			return s;
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public void deleteStudentById(@PathVariable("id") int id) {
		studentService.deleteStudentById(id);
	}

	@RequestMapping(value = "/students", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertStudent(@RequestBody Student student) {
		studentService.insertStudent(student);
	}

}
