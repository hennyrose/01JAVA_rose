package students;

import java.util.Arrays;
import java.util.Comparator;

public class Group {

	private String groupName;
	private Student[] students;

	public Group() {
		super();
		students = new Student[10];
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	public void addStudent(Student student) throws GroupOverflowException {

		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				System.out.println(student.gender.getFilePermissions() + student.getName() + " " + student.getLastName()
						+ " added in a group " + student.getGroupName() + "!");
				return;
			}
		}

		throw new GroupOverflowException(student.gender.getFilePermissions() + student.getName() + " "
				+ student.getLastName() + " not added,\ngroup " + student.getGroupName() + " is full :(");
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {

		for (int j = 0; j < students.length; j++) {
			if (students[j] != null) {
				if (students[j].getLastName() == lastName) {
					return students[j];
				}
			}
		}
		throw new StudentNotFoundException("student can't be found,\nor hasn't been added in a group yet :(");
	}

	public boolean removeStudentByID(int id) {

		for (int k = 0; k < students.length; k++) {
			if (students[k] != null) {
				if (students[k].getId() == id) {
					students[k] = null;
					System.out.println("student by the report card " + id + " kicked out");
					return true;
				}
			}
		}
		System.out.println("student by the report card " + id + " не найден :(");
		return false;
	}

	public void sortStudentsByLastName() {
		Arrays.sort(students, Comparator.nullsFirst(new StudentsLastNameComparator()));
	}

	@Override
	public String toString() {
		String listOfStudents = "";
		String[] arrayOfStudents = new String[10];

		for (int i = 0; i < arrayOfStudents.length; i++) {
			if (students[i] != null)
				arrayOfStudents[i] = students[i].getLastName() + " " + students[i].getName();
			else
				arrayOfStudents[i] = "";
		}

		Arrays.sort(arrayOfStudents);
		for (int i = 0; i < arrayOfStudents.length; i++) {
			if (arrayOfStudents[i] != "") {
				listOfStudents += arrayOfStudents[i] + "\n";
			}
		}

		return listOfStudents;
	}
}
