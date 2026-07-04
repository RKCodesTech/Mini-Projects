package in.sp.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDAO {
private JdbcTemplate jdbcTemplate;
public  StudentDAO(JdbcTemplate jdbcTemplate){
	this.jdbcTemplate=jdbcTemplate;
}
}
