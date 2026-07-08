package in.sp.services;
import in.sp.dao.*;
import in.sp.beans.*;
import java.util.List;
public class StudentServices {
	private StudentDAO studentdao;
	public StudentServices(StudentDAO studentdao) {
		this.studentdao=studentdao;
	}
	public int addStudent(Student student) {
		return studentdao.insertStudent(student);
		
	}
	public int updateStudent(Student student) {
		return studentdao.updateStudent(student);
		
	}
	public int deleteStudent(int rollno) {
		return studentdao.deleteStudent(rollno);
		
	}
	public Student searchStudent(int rollno) {
		return studentdao.searchStudent(rollno);
		
	}
	public int totalStudents() {
	    return studentdao.totalStudents();
	}
	public List<Student> displayStudents(){
		return studentdao.displayStudents();
	}

}
