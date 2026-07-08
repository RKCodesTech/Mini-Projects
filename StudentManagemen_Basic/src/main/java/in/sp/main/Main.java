package in.sp.main;
import in.sp.services.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;
import in.sp.config.SpringConfigFile;

public class Main {
	public static void main(String[] args) {
		int rollno;
		String name;
		int marks;
	
ApplicationContext context =new AnnotationConfigApplicationContext(SpringConfigFile.class);
StudentServices services=context.getBean(StudentServices.class);
while(true) {
	System.out.println("To Add Student: write add" );
	System.out.println("To View Students: write view");
	System.out.println("To Search Students: write srch");
	System.out.println("To Delete Students: write dlt");
	System.out.println("To View Students: write view");
	Scanner sc=new Scanner(System.in);
	String choice=sc.nextLine();
	switch(choice) {
	case "add":
		System.out.println("Enter Student name:");
	
		services.addStudent(null)
	}
}
}
}
