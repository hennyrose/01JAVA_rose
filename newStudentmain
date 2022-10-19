package students;

public class Main {

	public static void main(String[] args) {

		Student student1 = new Student("Damian", "Grey", Gender.Male, 1, "Main");
		Student student2 = new Student("Bruce", "Wayne", Gender.Male, 2, "Main");
		Student student3 = new Student("Zoe", "Fisher", Gender.Female, 3, "Main");
		Student student4 = new Student("Samuel", "Geroni", Gender.Male, 4, "Main");
		Student student5 = new Student("Salvador", "Dali", Gender.Male, 5, "Main");
		Student student6 = new Student("Agatha", "May", Gender.Female, 6, "Main");
		Student student7 = new Student("Jacob", "Frye", Gender.Male, 7, "Main");
		Student student8 = new Student("Maria", "Corleone", Gender.Female, 8, "Main");
		Student student9 = new Student("Julia", "Louis", Gender.Female, 9, "Main");
		Student student10 = new Student("Ken", "Karson", Gender.Male, 10, "Main");
		Student student11 = new Student("Christian", "Bale", Gender.Male, 11, "Main");

		Group group1 = new Group();

		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
			group1.addStudent(student6);
			group1.addStudent(student7);
			group1.addStudent(student8);
			group1.addStudent(student9);
			group1.addStudent(student10);
			group1.addStudent(student11);

		} catch (GroupOverflowException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
		System.out.println();

		try {
			System.out.println(group1.searchStudentByLastName("Frye"));
			System.out.println();
			System.out.println(group1.searchStudentByLastName(student11.getLastName()));

		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}

		group1.removeStudentByID(746);
		group1.removeStudentByID(258);
		group1.removeStudentByID(491); 
		
		System.out.println();
		System.out.println("new student:");
		System.out.println();
		Student student12 = new CreateStudent().newStudent();
		CreateStudent.addStudentToGroup(student12, group1);

		System.out.println();
		System.out.println("student info:");
		System.out.println();
		System.out.println(student12);

		System.out.println();
		System.out.println("sort the students by the last name,\nstudent list");

		group1.sortStudentsByLastName();

		System.out.println();
		System.out.println(group1);
	}
}
