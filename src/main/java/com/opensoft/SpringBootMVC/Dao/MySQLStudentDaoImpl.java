package com.opensoft.SpringBootMVC.Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.opensoft.SpringBootMVC.Entity.Student;

@Repository
@Qualifier("mysqlData")
public class MySQLStudentDaoImpl implements StudentDao {

	private static Map<Integer, Student> students;

	static {
		students = new HashMap<Integer, Student>() {

			private static final long serialVersionUID = 6901862429490945324L;

			{
				put(1, new Student(1, "Tom Jones", "Music and Art"));
			}
		};
	}

	@Override
	public Collection<Student> getAllStudents() {
		return students.values();
	}

	@Override
	public Student getStudentById(int id) {
		return students.get(id);
	}

	@Override
	public void deleteStudentById(int id) {
		students.remove(id);

	}

	@Override
	public void updateStudent(Student student) {
		Student s = getStudentById(student.getId());
		if (s != null) {
			students.put(student.getId(), student);
		} else
			throw new RuntimeException("No such student was found");

	}

	@Override
	public void insertStudent(Student student) {
		students.put(student.getId(), student);
	}

}
