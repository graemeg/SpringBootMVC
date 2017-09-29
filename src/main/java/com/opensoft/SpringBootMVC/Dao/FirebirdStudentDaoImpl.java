package com.opensoft.SpringBootMVC.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.opensoft.SpringBootMVC.Entity.Student;

@Repository
@Qualifier("firebird")
public class FirebirdStudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final RowMapper<Student> rowMapper = new RowMapper<Student>() {

		@Override
		public Student mapRow(ResultSet resultSet, int i) throws SQLException {
			Student student = new Student();
			student.setId(resultSet.getInt("id"));
			student.setName(resultSet.getString("name"));
			student.setCourse(resultSet.getString("course"));
			return student;
		}

	};

	@Override
	public Collection<Student> getAllStudents() {
		final String sql = "select id, name, course from students";
		final List<Student> studentList = jdbcTemplate.query(sql, rowMapper);
		return studentList;
	}

	@Override
	public Student getStudentById(int id) {
		final String sql = "select id, name, course from students where id = ?";
		Student s = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return s;
	}

	@Override
	public void deleteStudentById(int id) {

	}

	@Override
	public void updateStudent(Student student) {

	}

	@Override
	public void insertStudent(Student student) {

	}

}
