package students;

import java.util.Scanner;
import java.util.Random;

public class CreateStudent {

	Scanner sc = new Scanner(System.in);
	Random rannum = new Random();

	public Student newStudent() {

		Student student = new Student(null, null, null, 0, null);

		System.out.println("new student name: ");
		student.setName(sc.nextLine());

		System.out.println("new student surname: ");
		student.setLastName(sc.nextLine());

		System.out.println("new student gender male or female: ");
		String studentGender = sc.nextLine();

		if (studentGender.equals("male")) {
			student.setGender(Gender.Male);
		} else if (studentGender.equals("female")) {
			student.setGender(Gender.Female);
		} else {
			System.out.println("");
			System.out.println("incorrect!");
			System.out.println("");
		}

		student.setId(rannum.nextInt(200, 500));
		System.out.println("student report card number " + student.getId() + " has been generated!");
		System.out.println("");

		System.out.println("new student group name: ");
		student.setGroupName(sc.nextLine());

		return student;
	}

	public static void addStudentToGroup(Student student, Group group) {

		try {
			group.addStudent(student);
		} catch (GroupOverflowException e) {
			System.out.println(student.gender.getFilePermissions() + student.getName() + " " + student.getLastName()
					+ " not added,\ngroup " + student.getGroupName() + " is full :(");
		}
	}
}
