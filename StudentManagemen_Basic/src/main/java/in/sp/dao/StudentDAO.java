package in.sp.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
 
import in.sp.beans.Student;

public class StudentDAO {

    private JdbcTemplate jdbcTemplate; 

    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    } 
 
    // Insert Student
    public int insertStudent(Student student) {
        String sql = "INSERT INTO student VALUES(?,?,?)";
        return jdbcTemplate.update(sql,
                student.getStd_rollno(),
                student.getStd_name(),
                student.getStd_marks());
    }

    // Update Student
    public int updateStudent(Student student) {
        String sql = "UPDATE student SET std_name=?, std_marks=? WHERE std_rollno=?";
        return jdbcTemplate.update(sql,
                student.getStd_name(),
                student.getStd_marks(),
                student.getStd_rollno());
    }

    // Delete Student
    public int deleteStudent(int rollNo) {
        String sql = "DELETE FROM student WHERE std_rollno=?";
        return jdbcTemplate.update(sql, rollNo);
    }

    // Search Student
    public Student searchStudent(int rollNo) {
        String sql = "SELECT * FROM student WHERE std_rollno=?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Student.class),
                rollNo);
    }

    // Display All Students 
    public List<Student> displayStudents() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Student.class));
    }
 
    // Count Total Students
    public int totalStudents() {
        String sql = "SELECT COUNT(*) FROM student";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}