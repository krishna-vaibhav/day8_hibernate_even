package tester;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseManagementImpl;
import pojos.Address;
import pojos.Course;
import pojos.Student;
import pojos.Vehicle;

public class AssignStudentDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter student id");
			int sid = sc.nextInt();
			CourseManagementImpl dao = new CourseManagementImpl();
			Student s = dao.getStudentDetails(sid);
			if (s != null) {
				//valid student id
				// accept phone numbers
				System.out.println("Enter 2 phone numbers");
				String phone1 = sc.next();
				String phone2 = sc.next();
				System.out.println("Enter 1st vehicle details --reg no , model price");
				Vehicle v1 = new Vehicle(sc.next(), sc.next(), sc.nextDouble());
				System.out.println("Enter 2nd vehicle details --reg no , model price");
				Vehicle v2 = new Vehicle(sc.next(), sc.next(), sc.nextDouble());
				s.getPhoneNumbers().add(phone1);
				s.getPhoneNumbers().add(phone2);
				s.getVehicles().add(v1);
				s.getVehicles().add(v2);
				System.out.println(dao.assignStudentDetails(s));
				
			} else
				System.out.println("invalid student id");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
