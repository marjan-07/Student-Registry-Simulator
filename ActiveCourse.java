import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * @author Marjan Ahmed
 */
// Active University Course

public class ActiveCourse extends Course 
{
	private ArrayList<Student> students;
	private String semester;


	// Add a constructor method with appropriate parameters
	// should call super class constructor to initialize inherited variables
	// make sure to *copy* students array list being passed in into new arraylist of students
	// create Grade objects for each Student object and add to grades arraylist. Set grade to 0
	// see class Registry to see how an ActiveCourse object is created and used
	public ActiveCourse(String name, String code, String description, String format, String semester, ArrayList<Student> students) 
	{
		super(name, code, description, format);
		this.semester = semester;
		this.students = new ArrayList<>(students);
		
	}

	public String getSemester() 
	{
		return semester;
	}

	// Prints the students in this course  (name and student id)
	public void printClassList() 
	{
		for (Student student: students) 
		{
			System.out.println(student);
		}
	}

	// Prints the grade of each student in this course (along with name and student id)
	//
	public void printGrades() 
	{
		for (Student student: students) 
		{
			final CreditCourse credc = student.getCreditCourse(getCode());
			if (credc != null) System.out.println(student + " Grade: " + credc.getGrade());
		}
	}

	// Returns the numeric grade in this course for this student
	// If student not found in course, return 0
	public double getGrade(String id) 
	{
		// Search the student's list of credit courses to find the course code that matches this active course
		// see class Student method getGrade()
		// return the grade stored in the credit course object
		for (Student student: students) 
		{
			if (student.getId().equals(id)) 
			{
				final CreditCourse creditCourse = student.getCreditCourse(getCode());
				// The following line is a shortcut for writing the following code
				// if (creditCourse != null) {
				// return creditCourse.getGrade();}
				// else { return 0;}
				// I found this shortcut on google :)
				return creditCourse != null ? creditCourse.getGrade() : 0; 
			}
		}
		return 0;
	}

	// Returns a String containing the course information as well as the semester and the number of students
	// enrolled in the course
	// must override method in the superclass Course and use super class method getDescription()
	public String getDescription() 
	{
		return super.getDescription() + " " + semester + " Enrolment: " + students.size();
	}

	
	 // Expel the student with id from this course.
	 // @param id
	 
	public boolean removeStudentById(String id) 
	{
		// This is a lambda expression and basically the -> separates the parameter on the left
		// from the implementation on the right
		// I found this with a lot of googling too :)
		return students.removeIf(student -> student.getId().equals(id));
	}

	 // Method to find the student by id
	 // @param id
	 // @return the student with id 
	 
	public Student findStudentById(String id) 
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

	 // Method to add student to active course
	 // Enroll student in course while ensuring they aren't already enrolled
	 // @param student
	 
	public void addStudent(Student student) 
	{
		if (!students.contains(student)) 
		{
			students.add(student);
		}
	}

	// Sort the students in the course by name using the Collections.sort() method with appropriate arguments
	// Make use of a private Comparator class below
	public void sortByName() 
	{
		students.sort(new NameComparator());
	}

	// Fill in the class so that this class implement the Comparator interface
	// This class is used to compare two Student objects based on student name
	private class NameComparator implements Comparator<Student> 
	{
		// Override a method in the sub class 
		public int compare(Student studentOne, Student studentTwo) 
		{
			return studentOne.getName().compareTo(studentTwo.getName());
		}
	}

	// Sort the students in the course by student id using the Collections.sort() method with appropriate arguments
	// Make use of a private Comparator class below
	public void sortById() 
	{
		students.sort(new IdComparator());
	}

	// Fill in the class so that this class implement the Comparator interface
	// This class is used to compare two Student objects based on student id
	private class IdComparator implements Comparator<Student> 
	{
		// Override a method in the sub class 
		public int compare(Student student1, Student student2) 
		{
			return student1.getId().compareTo(student2.getId());
		}
	}
}
