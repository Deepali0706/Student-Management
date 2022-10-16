import java.io.IOException;
import java.util.Scanner;

import com.student_manage.Student;
import com.student_manage.StudentDao;
public class Start {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("PRESS 1 to ADD STUDENT");
			System.out.println("PRESS 2 to DELETE STUDENT");
			System.out.println("PRESS 3 to DISPLAY STUDENT");
			System.out.println("PRESS 4 to EXIT App");
			int c=sc.nextInt();
			
			if(c==1) {
				//add student..
				System.out.println("Enter User Name :");
				String name=sc.next();
				
				System.out.println("Enter User Phone :");
				String phone=sc.next();
				
				System.out.println("Enter User city :");
				String city=sc.next();
				
				//create student object to store student
				Student st= new Student(name,phone,city);
				boolean answer=StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is added successfully....");
				}
				else {
					System.out.println("Something went wrong Try Again....!");
				}
				System.out.println(st);
			}
			else if(c==2) {
				//delete student
				System.out.println("Enter Student ID to Delete :");
				int userId=sc.nextInt();
				boolean f= StudentDao.deleteStudent(userId);
				 
				if(f) {
					System.out.println("Deleted......");
				}else {
					System.out.println("Something went wrong....");
				}
				
				
			}
			else if(c==3) {
				//display student
				StudentDao.showAllStudent();
			}
			else if(c==4) {
				//exit
				break;
			}
			else {
				
			}
		}
		System.out.println("Thankyou for Using My Application");
		System.out.println("See you soon...");

	}

}
