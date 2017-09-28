package com.opensoft.SpringBootMVC.Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.opensoft.SpringBootMVC.Entity.Student;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {

	private static Map<Integer, Student> students;

	static {
		students = new HashMap<Integer, Student>() {

			private static final long serialVersionUID = 1613884809212671402L;

			{
				put(1, new Student(1, "Graeme", "Computer Science"));
				put(2, new Student(2, "Kyle", "Sports"));
				put(3, new Student(3, "Angela", "Photography"));
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
