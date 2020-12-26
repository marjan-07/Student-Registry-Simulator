import java.util.ArrayList;
/**
 * @author Marjan Ahmed
 */
public class Registry 
{
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<ActiveCourse> courses = new ArrayList<ActiveCourse>();

	public Registry() 
	{
		// Add some students
		// in A2 we will read from a file
		Student s1 = new Student("JohnOliver", "34562");
		Student s2 = new Student("HarryWindsor", "38467");
		Student s3 = new Student("SophieBrown", "98345");
		Student s4 = new Student("FaisalQuereshi", "57643");
		Student s5 = new Student("GenghisKhan", "25347");
		Student s6 = new Student("SherryTu", "46532");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);
		// sort the students alphabetically - see class Student

		ArrayList<Student> list = new ArrayList<Student>();

		// Add some active courses with students
		String courseName = "Computer Science II";
		String courseCode = "CPS209";
		String descr = "Learn how to write complex programs!";
		String format = "3Lec 2Lab";
		list.add(s2);
		list.add(s3);
		list.add(s4);
		courses.add(new ActiveCourse(courseName, courseCode, descr, format, "W2020", list));
		// Add course to student list of courses
		s2.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s3.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s4.addCourse(courseName, courseCode, descr, format, "W2020", 0);

		// CPS511
		list.clear();
		courseName = "Computer Graphics";
		courseCode = "CPS511";
		descr = "Learn how to write cool graphics programs";
		format = "3Lec";
		list.add(s1);
		list.add(s5);
		list.add(s6);
		courses.add(new ActiveCourse(courseName, courseCode, descr, format, "F2020", list));
		s1.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s5.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s6.addCourse(courseName, courseCode, descr, format, "W2020", 0);

		// CPS643
		list.clear();
		courseName = "Virtual Reality";
		courseCode = "CPS643";
		descr = "Learn how to write extremely cool virtual reality programs";
		format = "3Lec 2Lab";
		list.add(s1);
		list.add(s2);
		list.add(s4);
		list.add(s6);
		courses.add(new ActiveCourse(courseName, courseCode, descr, format, "W2020", list));
		s1.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s2.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s4.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s6.addCourse(courseName, courseCode, descr, format, "W2020", 0);

	}

	 // A private method to check if a student is in the registry used later to ensure no duplicate students
	 // @param id
	 // @return the student with the id if it exists;
	 // null otherwise
	private Student findStudentById(String id) 
	{
		for (Student student: students) 
		{
			if (student.getId().equals(id))
			{
				return student;
			}
		}
		return null;
	}

	// Add new student to the registry (students arraylist above)
	public boolean addNewStudent(String name, String id) 
	{
		// Create a new student object
		// check to ensure student is not already in registry
		// if not, add them and return true, otherwise return false
		// make use of equals method in class Student
		if (findStudentById(id) == null) 
		{
			Student student = new Student(name, id);
			students.add(student);
			return true;
		} 
		else
		{
			return false;
		}
	}

	// Remove student from registry
	public boolean removeStudent(String studentId) 
	{
		for (ActiveCourse course: courses) course.removeStudentById(studentId);
		// If found, remove this student and return true
		return students.removeIf(student -> student.getId().equals(studentId));
	}

	// Print all registered students
	public void printAllStudents() 
	{
		for (int i = 0; i < students.size(); i++) 
		{
			System.out.println("ID: " + students.get(i).getId() + " Name: " + students.get(i).getName());
		}
	}

	// Given a studentId and a course code, add student to the active course
	public void addCourse(String studentId, String courseCode) 
	{
		// Find student object in registry (i.e. students arraylist)
		// Check if student has already taken this course in the past Hint: look at their credit course list
		// If not, then find the active course in courses array list using course code
		// If active course found then check to see if student already enrolled in this course
		// If not already enrolled
		//   add student to the active course
		//   add course to student list of credit courses with initial grade of 0
		final Student student = findStudentById(studentId);
		if (student != null) 
		{
			// if no credit course of the student is the given course code
			if (student.getCreditCourse(courseCode) == null) 
			{
				for (ActiveCourse activec: courses) 
				{
					if (activec.getCode().equalsIgnoreCase(courseCode)) 
					{
						activec.addStudent(student);
						student.addCourse(activec.getName(), activec.getCode(), activec.getDescr(), activec.getFormat(), activec.getSemester(), 0);
					}
				}
			}
		}
	}

	// Given a studentId and a course code, drop student from the active course
	public void dropCourse(String studentId, String courseCode) 
	{
		// Find the active course
		// Find the student in the list of students for this course
		// If student found:
		//   remove the student from the active course
		//   remove the credit course from the student's list of credit courses
		for (ActiveCourse activec: courses) 
		{
			if (activec.getCode().equalsIgnoreCase(courseCode)) 
			{
				if (activec.removeStudentById(studentId)) 
				{
					// if the student is enrolled in the course 
					final Student student = findStudentById(studentId);
					if (student != null) 
					{
						// remove credit course 
						student.removeActiveCourse(courseCode);
					}
				}
			}
		}
	}

	// Print all active courses
	public void printActiveCourses() 
	{
		for (ActiveCourse activec: courses) 
		{
			System.out.println(activec.getDescription());
			System.out.println();
		}
	}

	// Print the list of students in an active course
	public void printClassList(String courseCode) 
	{
		for (ActiveCourse activec: courses) 
		{
			if (activec.getCode().equalsIgnoreCase(courseCode)) activec.printClassList();
		}
	}

	// Given a course code, find course and sort class list by student name
	public void sortCourseByName(String courseCode) 
	{
		for (ActiveCourse activec: courses) 
		{
			if (activec.getCode().equalsIgnoreCase(courseCode)) activec.sortByName();
		}
	}

	// Given a course code, find course and sort class list by student name
	public void sortCourseById(String courseCode) 
	{
		for (ActiveCourse activec: courses) 
		{
			if (activec.getCode().equalsIgnoreCase(courseCode)) activec.sortById();
		}
	}

	// Given a course code, find course and print student names and grades
	public void printGrades(String courseCode) 
	{
		for (ActiveCourse activec: courses) 
		{
			if (activec.getCode().equalsIgnoreCase(courseCode)) activec.printGrades();
		}
	}

	// Given a studentId, print all active courses of student
	public void printStudentCourses(String studentId) 
	{
		final Student student = findStudentById(studentId);
		if (student != null)
		{
			student.printActiveCourses();
		}
	}

	// Given a studentId, print all completed courses and grades of student
	public void printStudentTranscript(String studentId) 
	{
		final Student student = findStudentById(studentId);
		if (student != null)
		{
			student.printTranscript();
		}
	}

	// Given a course code, student id and numeric grade
	// set the final grade of the student
	public void setFinalGrade(String courseCode, String studentId, double grade) 
	{
		// find the active course
		// If found, find the student in class list
		// then search student credit course list in student object and find course
		// set the grade in credit course and set credit course inactive
		for (ActiveCourse ac: courses) 
		{
			if (ac.getCode().equalsIgnoreCase(courseCode)) 
			{
				final Student student = ac.findStudentById(studentId);
				if (student != null) 
				{
					student.setFinalGrade(ac.getCode(), grade);
				}
			}
		}
	}
}
