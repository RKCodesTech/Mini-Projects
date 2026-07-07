package in.sp.main;
import in.sp.services.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.sp.config.SpringConfigFile;

public class Main {
	public static void main(String[] args) {
		
	
ApplicationContext context =new AnnotationConfigApplicationContext(SpringConfigFile.class);
StudentServices services=context.getBean(StudentServices.class);
}
}
