package com.opensoft.SpringBootMVC.Dao;

import java.util.Collection;

import com.opensoft.SpringBootMVC.Entity.Student;

public interface StudentDao {

	Collection<Student> getAllStudents();

	Student getStudentById(int id);

	void deleteStudentById(int id);

	void updateStudent(Student student);

	void insertStudent(Student student);

}