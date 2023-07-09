import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("PRESS 1 to Add student");
			System.out.println("PRESS 2 to Delete student");
			System.out.println("PRESS 3 to Display student");
			System.out.println("PRESS 4 to exit app");

			int input = Integer.parseInt(br.readLine());
			
			if (input == 1) {
				String name, city, phone;
				System.out.println("\nEnter Student Name");
				name = br.readLine();
				System.out.println("\nEnter Student Phone");
				phone = br.readLine();
				System.out.println("\nEnter Student City");
				city = br.readLine();

				Student student = new Student(name, phone, city);

				boolean ans = StudentDao.insertStudentToDB(student);

				if (ans) {
					System.out.println("Student added Successfully\n\n");
					System.out.println(student);
				} else {
					System.out.println("Something went wrong!!!");
				}

			} else if (input == 2) {
				
				System.out.println("Enter id to delete a Student\n");
				
				int id = Integer.parseInt(br.readLine());
				
				if (StudentDao.deleteStudentToDB(id)) {
					System.out.println("Student Deleted Successfully\n\n");
				} else {
					System.out.println("Something went wrong!!!");
				}
			} else if (input == 3) {
				StudentDao.getStudentToDB();

			} else if (input == 4) {
				break;
			}

		}
		System.out.println("Thank You for using my Application!!!");
	}
}
