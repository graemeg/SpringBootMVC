package com.opensoft.SpringBootMVC.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.opensoft.SpringBootMVC.Dao.StudentDao;
import com.opensoft.SpringBootMVC.Entity.Student;

@Service
public class StudentService {

	@Autowired
	@Qualifier("firebird")
	private StudentDao studentDao;

	public Collection<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	public void deleteStudentById(int id) {
		studentDao.deleteStudentById(id);
	}

	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

	public void insertStudent(Student student) {
		studentDao.insertStudent(student);
	}
}
