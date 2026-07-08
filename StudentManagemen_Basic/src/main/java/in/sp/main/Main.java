package in.sp.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.sp.beans.Student;
import in.sp.config.SpringConfigFile;
import in.sp.services.StudentServices;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfigFile.class);

        StudentServices services = context.getBean(StudentServices.class);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n==============================");
            System.out.println(" STUDENT MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Total Students");
            System.out.println("7. Exit");
            System.out.print("Enter Your Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                Student s1 = new Student();

                System.out.print("Enter Roll No : ");
                s1.setStd_rollno(sc.nextInt());

                System.out.print("Enter Name : ");
                s1.setStd_name(sc.next());

                System.out.print("Enter Marks : ");
                s1.setStd_marks(sc.nextInt());

                int insert = services.addStudent(s1);

                if (insert > 0)
                    System.out.println("Student Added Successfully");
                else
                    System.out.println("Student Not Added");

                break;

            case 2:

                List<Student> list = services.displayStudents();

                for (Student s : list) {
                    System.out.println("-----------------------");
                    System.out.println("Roll No : " + s.getStd_rollno());
                    System.out.println("Name    : " + s.getStd_name());
                    System.out.println("Marks   : " + s.getStd_marks());
                }

                break;

            case 3:

                System.out.print("Enter Roll No : ");
                int roll = sc.nextInt();

                Student student = services.searchStudent(roll);

                if (student != null) {
                    System.out.println("Roll No : " + student.getStd_rollno());
                    System.out.println("Name    : " + student.getStd_name());
                    System.out.println("Marks   : " + student.getStd_marks());
                }

                break;

            case 4:

                Student s2 = new Student();

                System.out.print("Enter Roll No : ");
                s2.setStd_rollno(sc.nextInt());

                System.out.print("Enter New Name : ");
                s2.setStd_name(sc.next());

                System.out.print("Enter New Marks : ");
                s2.setStd_marks(sc.nextInt());

                int update = services.updateStudent(s2);

                if (update > 0)
                    System.out.println("Student Updated Successfully");
                else
                    System.out.println("Student Not Updated");

                break;

            case 5:

                System.out.print("Enter Roll No : ");
                int deleteRoll = sc.nextInt();

                int delete = services.deleteStudent(deleteRoll);

                if (delete > 0)
                    System.out.println("Student Deleted Successfully");
                else
                    System.out.println("Student Not Deleted");

                break;

            case 6:

                int total = services.totalStudents();
                System.out.println("Total Students = " + total);

                break;

            case 7:

                System.out.println("Thank You!");
                sc.close();
                System.exit(0);

            default:

                System.out.println("Invalid Choice");

            }
        }
    }
}