package in.sp.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import in.sp.beans.Student;

public class StudentDAO {
private JdbcTemplate jdbcTemplate;
public  StudentDAO(JdbcTemplate jdbcTemplate){
	this.jdbcTemplate=jdbcTemplate;
}
public int insertStudent(Student student) {
	String sql= "INSERT INTO STUDENT VALUES(?,?,?)";
	return jdbcTemplate.update(sql,student.getStd_rollno() ,student.getStd_name(),student.getStd_marks());
}
}
